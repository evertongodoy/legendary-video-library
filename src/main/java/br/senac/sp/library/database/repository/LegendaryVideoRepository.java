package br.senac.sp.library.database.repository;

import br.senac.sp.library.database.entity.LegendaryVideoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LegendaryVideoRepository extends MongoRepository<LegendaryVideoEntity, String> {
}
