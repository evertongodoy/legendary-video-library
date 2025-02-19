package br.senac.sp.library.usecase.impl;

import br.senac.sp.library.database.LegendaryVideoDataBase;
import br.senac.sp.library.models.LegendaryVideoModel;
import br.senac.sp.library.usecase.LegendaryVideoUseCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegendaryVideoUseCaseImpl implements LegendaryVideoUseCase {

    private static final Logger logger = LogManager.getLogger(LegendaryVideoUseCaseImpl.class);

    private final LegendaryVideoDataBase legendaryVideoDataBase;

    public LegendaryVideoUseCaseImpl(LegendaryVideoDataBase legendaryVideoDataBase) {
        this.legendaryVideoDataBase = legendaryVideoDataBase;
    }

    @Override
    public List<LegendaryVideoModel> recuperarTodos() {
        logger.info("[LegendaryVideoUseCaseImpl]-[recuperarTodos] - Recuperando todos os filmes!");
        return legendaryVideoDataBase.recuperarTodos();
    }

}