package io.ngshop.catalog.dto;

import io.ngshop.catalog.groups.OnCreate;
import io.ngshop.catalog.groups.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    @NotNull(message = "id cannot be null",groups = OnCreate.class)
    @NotNull(message = "id most be null",groups = OnUpdate.class)
    private String id;
    private String name;
    private String description;
    private Double price;
    private String summary;
    private String imageFile;
    private String brandId;
    private String typeId;

}
