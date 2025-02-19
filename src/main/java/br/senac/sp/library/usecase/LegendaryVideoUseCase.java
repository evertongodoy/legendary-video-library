package br.senac.sp.library.usecase;

import br.senac.sp.library.models.LegendaryVideoModel;

import java.util.List;

public interface LegendaryVideoUseCase {

    List<LegendaryVideoModel> recuperarTodos();
}
