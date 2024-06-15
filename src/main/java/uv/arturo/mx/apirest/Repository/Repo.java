package uv.arturo.mx.apirest.Repository;

import org.springframework.stereotype.Repository;

import uv.arturo.mx.apirest.Domain.TheData;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface Repo extends MongoRepository <TheData, ObjectId> {
    Optional<TheData> findByTitle(String title);
    TheData findById(int id);
}
