package com.Flipkart.ReadtAPI.Controller;

import com.Flipkart.ReadtAPI.Entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Journal")
public class journslEntryController {

      private Map<Long,JournalEntry> JournalEntries=new HashMap<>();
      @GetMapping
      public List<JournalEntry> getAll(){
           return new ArrayList<>(JournalEntries.values());
      }

     @PostMapping
     public boolean create(@RequestBody JournalEntry Myentry){
           JournalEntries.put(Myentry.getId(), Myentry);
           return true;
      }

      @GetMapping("/Id/{myId}")
      public JournalEntry getByid(@PathVariable Long myId){
         return JournalEntries.get(myId);
      }

    @DeleteMapping ("/Id/{myId}")
    public JournalEntry DeleteByid(@PathVariable Long myId){
        return JournalEntries.remove(myId);
    }

    @PutMapping("Id/{id}")
    public JournalEntry updatebyid(@PathVariable Long id, @RequestBody JournalEntry Myentry){
          return JournalEntries.put(id,Myentry);
    }
}
