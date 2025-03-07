package br.senac.sp.library.usecase.impl;

import br.senac.sp.library.database.LegendaryVideoDataBase;
import br.senac.sp.library.models.LegendaryVideoModel;
import br.senac.sp.library.usecase.LegendaryVideoUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LegendaryVideoUseCaseImpl implements LegendaryVideoUseCase {

    private static final Logger logger = LogManager.getLogger(LegendaryVideoUseCaseImpl.class);

    private final LegendaryVideoDataBase legendaryVideoDataBase;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public LegendaryVideoUseCaseImpl(LegendaryVideoDataBase legendaryVideoDataBase,
                                     KafkaTemplate<String, String> kafkaTemplate,
                                     ObjectMapper objectMapper) {
        this.legendaryVideoDataBase = legendaryVideoDataBase;
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<LegendaryVideoModel> recuperarTodos() {
        logger.info("[LegendaryVideoUseCaseImpl]-[recuperarTodos] - Recuperando todos os filmes!");
        return legendaryVideoDataBase.recuperarTodos();
    }

    @Override
    public void publicarListaVideos(final List<LegendaryVideoModel> legendaryVideos) {

        var key = UUID.randomUUID().toString();

        try {
            logger.info("[LegendaryVideoUseCaseImpl]-[publicarListaVideos] - Convertendo para JSON");
            var json = objectMapper.writeValueAsString(legendaryVideos);

            logger.info("[LegendaryVideoUseCaseImpl]-[publicarListaVideos] - Criar ProducerRecord com chave e valor JSON");
            ProducerRecord<String, String> record = new ProducerRecord<>("devolve-videos-library", key, json);

            logger.info("[LegendaryVideoUseCaseImpl]-[publicarListaVideos] - Enviar mensagem para o Kafka");
            kafkaTemplate.send(record).whenComplete((result, ex) -> {
                if (ex == null) {
                    logger.info("[LegendaryVideoUseCaseImpl]-[publicarListaVideos] - Sucesso, mensagem {} enviada no topico {}",
                            json, "devolve-videos-library");
                } else {
                    logger.error("[LegendaryVideoUseCaseImpl]-[publicarListaVideos] - Problemas ao enviar mensagem {}", ex.getMessage());
                }
            });

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


}