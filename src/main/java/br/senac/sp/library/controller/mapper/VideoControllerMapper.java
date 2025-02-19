package br.senac.sp.library.controller.mapper;

import br.senac.sp.library.controller.request.LegendaryVideoRequest;
import br.senac.sp.library.models.LegendaryVideoModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VideoControllerMapper {

    VideoControllerMapper INSTANCE = Mappers.getMapper(VideoControllerMapper.class);

    LegendaryVideoModel requestToModel(LegendaryVideoRequest request);

}