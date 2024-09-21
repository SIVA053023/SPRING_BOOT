package MongoDB.integrate.demo.Services;

import MongoDB.integrate.demo.Entries.JournalEntry;
import MongoDB.integrate.demo.Repository.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class JournalServices {

    @Autowired
    private JournalRepository journalRepository;

    // For getting the All entris
    public List<JournalEntry> getAll(){
        return journalRepository.findAll();
    }


   // for to Save the Entry
    public void SaveEntry(JournalEntry j){
        journalRepository.save(j);
    }

    // for to delete the entry by id
    public String del(ObjectId entry){
        journalRepository.deleteById(entry);
        return "deleted successfull";
    }

      // for to find the entry by id
   public Optional<JournalEntry> FindByid(ObjectId id){
        return journalRepository.findById(id);
   }

}
