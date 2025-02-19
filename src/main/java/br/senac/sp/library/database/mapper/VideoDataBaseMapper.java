package br.senac.sp.library.database.mapper;

import br.senac.sp.library.database.entity.LegendaryVideoEntity;
import br.senac.sp.library.models.LegendaryVideoModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VideoDataBaseMapper {

    VideoDataBaseMapper INSTANCE = Mappers.getMapper(VideoDataBaseMapper.class);

//    LegendaryVideoModel entityToModel(LegendaryVideoEntity entity);
//    LegendaryVideoEntity modelToEntity(LegendaryVideoModel model);
    List<LegendaryVideoModel> listEntityToListModel(List<LegendaryVideoEntity> entities);
//    List<LegendaryVideoEntity> listModelToListEntity(List<LegendaryVideoModel> models);

}