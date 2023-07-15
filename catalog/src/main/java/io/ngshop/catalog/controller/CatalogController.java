package io.ngshop.catalog.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @GetMapping("/test")
    public String working() {
        return this.getClass().getName() + " working";
    }
    @GetMapping("/mongo")
    public ResponseEntity<List<Test>> mongoDb() {
        return ResponseEntity.ok(mongoTemplate.findAll(Test.class));
    }
    class Test {
        private ObjectId id;
        private String test;
        private Integer umumanboshqachcleara;

        public Test(ObjectId id, String test, Integer umumanboshqacha) {
            this.id = id;
            this.test = test;
            this.umumanboshqacha = umumanboshqacha;
        }

        public ObjectId getId() {
            return id;
        }

        public void setId(ObjectId id) {
            this.id = id;
        }

        public String getTest() {
            return test;
        }

        public void setTest(String test) {
            this.test = test;
        }

        public Integer getUmumanboshqacha() {
            return umumanboshqacha;
        }

        public void setUmumanboshqacha(Integer umumanboshqacha) {
            this.umumanboshqacha = umumanboshqacha;
        }
    }
}
