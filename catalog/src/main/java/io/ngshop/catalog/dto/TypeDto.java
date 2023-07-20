package io.ngshop.catalog.dto;

import lombok.*;
import org.bson.types.ObjectId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeDto {
    private String  id;
    private String name;
}
