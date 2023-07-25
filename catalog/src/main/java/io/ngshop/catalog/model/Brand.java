package io.ngshop.catalog.model;

import io.ngshop.catalog.groups.OnCreate;
import io.ngshop.catalog.groups.OnUpdate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    @Id
    @NotNull(message = "id cannot be null",groups = OnUpdate.class)
    @Null(message = "id must be null",groups = OnCreate.class)
    private ObjectId id;
    @NotNull(message = "name must be null")
    private String name;

}
