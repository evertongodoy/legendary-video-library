package br.senac.sp.library.controller.kafka.consumer;

import br.senac.sp.library.models.KafkaMessageLegendaryVideoModel;
import br.senac.sp.library.usecase.LegendaryVideoUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class ConsumerMessage {

    private final LegendaryVideoUseCase legendaryVideoUseCase;

    public ConsumerMessage(LegendaryVideoUseCase legendaryVideoUseCase){
        this.legendaryVideoUseCase = legendaryVideoUseCase;
    }

    @KafkaListener(topics = "solicita-videos-library", groupId = "video-consumer-group")
    public void consumirMensagem(ConsumerRecord<String, String> consumerRecordVideos,
                                 Acknowledgment ack) {
        System.out.println("Mensagem recebida do Kafka:");
        System.out.println("Key: " + consumerRecordVideos.key());
        System.out.println("JSON: " + consumerRecordVideos.value());

        // Se quiser processar o JSON como um objeto:
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            var data = objectMapper.readValue(consumerRecordVideos.value(), KafkaMessageLegendaryVideoModel.class);
            System.out.println("dados: " + data);
            // Aqui você pode processar a mensagem, salvar no banco, etc.
            var legendaryVideoModels = legendaryVideoUseCase.recuperarTodos();
            legendaryVideoUseCase.publicarListaVideos(legendaryVideoModels);
            // Importante: Confirmar o processamento para o Kafka remover da fila
            ack.acknowledge();
        } catch (Exception e) {
            System.err.println("Erro ao desserializar JSON: " + e.getMessage());
        }
    }

}