package br.senac.sp.library.controller.response;

import br.senac.sp.library.models.LegendaryVideoModel;

import java.util.List;

public class LegendaryVideoResponse {

    private List<LegendaryVideoModel> legendaryVideos;

    public List<LegendaryVideoModel> getLegendaryVideos() {
        return legendaryVideos;
    }

    public LegendaryVideoResponse setLegendaryVideos(List<LegendaryVideoModel> legendaryVideos) {
        this.legendaryVideos = legendaryVideos;
        return this;
    }
    
}