package uv.arturo.mx.apirest.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "data")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TheData {
    @Id
    private ObjectId id;
    private String title;
    private String body;
}
