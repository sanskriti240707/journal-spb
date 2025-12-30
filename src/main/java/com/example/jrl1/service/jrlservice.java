package com.example.jrl1.service;

import com.example.jrl1.entity.journalentry;
import com.example.jrl1.repository.joutnalrepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class jrlservice {
    @Autowired
    private joutnalrepo journalrepo;
    public void saveentry(journalentry Journalentry){
        journalrepo.save(Journalentry);
    }

    public List<journalentry> getAll(){
        return journalrepo.findAll();
    }

    public Optional<journalentry> findById(ObjectId id){
        return journalrepo.findById(id);
    }

    public void deleteById(ObjectId id){
        journalrepo.deleteById(id);
    }
}
