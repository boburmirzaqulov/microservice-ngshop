package io.ngshop.catalog.dto;

import io.ngshop.catalog.groups.OnCreate;
import io.ngshop.catalog.groups.OnUpdate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeDTO {
    @NotNull(groups = OnUpdate.class, message = "id cannot be null")
    @Null(groups = OnCreate.class, message = "id most be null")
    private String id;
    @NotNull(message = "id cannot be null")
    private String name;
}
