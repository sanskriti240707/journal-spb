package com.example.jrl1.journalcon;

import com.example.jrl1.entity.journalentry;
import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class journal {

       private Map<Long,journalentry>journalentries= new HashMap<>();


    @GetMapping
               public List<journalentry>getAll(){
           return new  ArrayList<>(journalentries.values());}
@PostMapping
        public boolean createEntry(@RequestBody journalentry  entry){
journalentries.put(entry.getId(),entry);
return true;
           }
           @GetMapping("id/{myId}")
    public journalentry getjournalentryById(@PathVariable Long myId){
        return journalentries.get(myId);
           }

    @DeleteMapping ("id/{myId}")
    public journalentry deletejournalentryById(@PathVariable Long myId){
        return journalentries.remove(myId);
    }
    @PutMapping ("id/{myId}")
    public journalentry updatejournalentryById(@PathVariable Long myId,@RequestBody journalentry myentry){
        return journalentries.put(myId,myentry);}
   }


