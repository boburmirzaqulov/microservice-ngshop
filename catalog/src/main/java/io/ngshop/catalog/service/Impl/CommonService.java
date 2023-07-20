package io.ngshop.catalog.service.Impl;

import io.ngshop.catalog.exception.WrongObjectIdException;
import org.bson.types.ObjectId;

public class CommonService {
    public static ObjectId checkObjectId(String id){
        if (id.length() == 24){
            return new ObjectId(id);
        }
        throw new WrongObjectIdException("Wrong id");
    }
}
