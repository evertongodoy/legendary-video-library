package br.senac.sp.library.database.impl;


import br.senac.sp.library.database.mapper.VideoDataBaseMapper;
import br.senac.sp.library.database.repository.LegendaryVideoRepository;
import br.senac.sp.library.models.LegendaryVideoModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import br.senac.sp.library.database.LegendaryVideoDataBase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegendaryVideoDataBaseImpl implements LegendaryVideoDataBase {

    private static final Logger logger = LogManager.getLogger(LegendaryVideoDataBaseImpl.class);

    private final LegendaryVideoRepository legendaryVideoRepository;

    public LegendaryVideoDataBaseImpl(LegendaryVideoRepository legendaryVideoRepository) {
        this.legendaryVideoRepository = legendaryVideoRepository;
    }

    @Override
    public List<LegendaryVideoModel> recuperarTodos() {
        logger.info("[LegendaryVideoDataBaseImpl]-[recuperarTodos] - Recuperando todos os filmes!");
        var entities = legendaryVideoRepository.findAll();
        return VideoDataBaseMapper.INSTANCE.listEntityToListModel(entities);
    }

}