package io.ngshop.catalog.dto;

import lombok.*;
import org.bson.types.ObjectId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeDto {
    private ObjectId id;
    private String name;
}
