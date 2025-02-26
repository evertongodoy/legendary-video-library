package br.senac.sp.library.controller;

import br.senac.sp.library.controller.response.LegendaryVideoResponse;
import br.senac.sp.library.usecase.LegendaryVideoUseCase;
import br.senac.sp.security.tokens.annotation.EscopoNecessario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "videos")
public class LegendaryVideoController {

    private static final Logger logger = LogManager.getLogger(LegendaryVideoController.class);

    private final LegendaryVideoUseCase legendaryVideoUseCase;

    public LegendaryVideoController(LegendaryVideoUseCase legendaryVideoUseCase) {
        this.legendaryVideoUseCase = legendaryVideoUseCase;
    }

    @EscopoNecessario({"listar-filmes"})
    @GetMapping(value = "/recuperar/todos")
    public ResponseEntity<LegendaryVideoResponse> recuperarTodos() {
        logger.info("[LegendaryVideoController]-[recuperarTodos] - Recuperando todos os filmes!");
        var legendaryVideoModels = legendaryVideoUseCase.recuperarTodos();
        return ResponseEntity.ok(
                new LegendaryVideoResponse().setLegendaryVideos(legendaryVideoModels));
    }

}
