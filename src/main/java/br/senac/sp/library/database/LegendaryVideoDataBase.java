package br.senac.sp.library.database;

import br.senac.sp.library.models.LegendaryVideoModel;

import java.util.List;

public interface LegendaryVideoDataBase {

    List<LegendaryVideoModel> recuperarTodos();
}
