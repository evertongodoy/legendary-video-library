package br.senac.sp.library.controller.kafka.consumer;

import br.senac.sp.library.models.KafkaMessageLegendaryVideoModel;
import br.senac.sp.library.usecase.LegendaryVideoUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class ConsumerMessage {

    private static final Logger logger = LogManager.getLogger(ConsumerMessage.class);

    private final LegendaryVideoUseCase legendaryVideoUseCase;

    public ConsumerMessage(LegendaryVideoUseCase legendaryVideoUseCase){
        this.legendaryVideoUseCase = legendaryVideoUseCase;
    }

    @KafkaListener(topics = "solicita-videos-library", groupId = "video-consumer-group")
//    @KafkaListener(
//            topicPartitions = @TopicPartition(
//                    topic = "solicita-videos-library"//,
//                    //partitions = { "0" }  // somente partição 0
//            ),
//            groupId = "video-consumer-group"
//    )
    public void consumirMensagem(ConsumerRecord<String, String> consumerRecordVideos,
                                 Acknowledgment ack) {
        logger.info("[ConsumerMessage]-[consumirMensagem] - Mensagem recebida: {}", consumerRecordVideos.value());
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            logger.info("[ConsumerMessage]-[consumirMensagem] - Convertendo JSON para objeto KafkaMessageLegendaryVideoModel");
            var data = objectMapper.readValue(consumerRecordVideos.value(), KafkaMessageLegendaryVideoModel.class);

            String value = consumerRecordVideos.value();
            System.out.println(value);

            if("listar-videos".equalsIgnoreCase(data.getAcao())){
                logger.info("[ConsumerMessage]-[consumirMensagem] - Recupera todos os filmes");
                var legendaryVideoModels = legendaryVideoUseCase.recuperarTodos();
                logger.info("[ConsumerMessage]-[consumirMensagem] - Publicando no topico {}", data.getTopico());
                legendaryVideoUseCase.publicarListaVideos(legendaryVideoModels);
            }else {
                logger.warn("[ConsumerMessage]-[consumirMensagem] - Acao nao localizada: {}", data.getAcao());
            }
            logger.info("[ConsumerMessage]-[consumirMensagem] - Confirmando o processamento para o Kafka remover da fila");
            ack.acknowledge();
        } catch (Exception e) {
            logger.error("[ConsumerMessage]-[consumirMensagem] - Erro ao desserializar JSON {}", e.getMessage());
        }
    }

}