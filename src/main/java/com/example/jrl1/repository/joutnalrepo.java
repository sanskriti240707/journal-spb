package com.example.jrl1.repository;
import com.example.jrl1.entity.journalentry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface joutnalrepo extends MongoRepository <journalentry, ObjectId>{
}
