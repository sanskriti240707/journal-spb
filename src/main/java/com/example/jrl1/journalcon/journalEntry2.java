package com.example.jrl1.journalcon;

import com.example.jrl1.entity.journalentry;
import com.example.jrl1.service.jrlservice;
import org.apache.coyote.Request;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class journalEntry2 {
    @Autowired
    private jrlservice journalservice;



    @GetMapping
    public List<journalentry>getAll(){
        return journalservice.getAll();
    }
    @PostMapping
    public journalentry createEntry(@RequestBody journalentry  entry){
        entry.setDate(LocalDateTime.now());
        journalservice.saveentry(entry);
        return entry;
    }
    @GetMapping("id/{myId}")
    public journalentry getjournalentryById(@PathVariable ObjectId myId){
        return journalservice.findById(myId).orElse(null);

    }

    @DeleteMapping ("id/{myId}")
    public boolean deletejournalentryById(@PathVariable ObjectId myId){
      journalservice.deleteById(myId);
      return true;
    }
    @PutMapping ("id/{myId}")
    public journalentry updatejournalentryById(@PathVariable ObjectId myId,@RequestBody journalentry newentry){

        journalentry old = journalservice.findById(myId).orElse(null);
        if(old != null){
            old.setTitle(newentry.getTitle() != null && !newentry.getTitle().equals("") ? newentry.getTitle() : old.getTitle());
            old.setContent(newentry.getContent() != null && !newentry.equals("") ? newentry.getContent() : old.getContent());
        }
        journalservice.saveentry(old);
        return old;
    }
}

