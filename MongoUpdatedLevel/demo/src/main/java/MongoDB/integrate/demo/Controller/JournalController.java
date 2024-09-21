package MongoDB.integrate.demo.Controller;

import MongoDB.integrate.demo.Entries.JournalEntry;
import MongoDB.integrate.demo.Services.JournalServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalServices service;

    @GetMapping
    public List<JournalEntry> getAll(){
        return service.getAll();
    }

    @GetMapping("/{myid}")
    public JournalEntry getbyid(@PathVariable ObjectId myid){
        return service.FindByid(myid).orElse(null);
    }

    @PostMapping
    public String create(@RequestBody JournalEntry journal){
        service.SaveEntry(journal);
        return "Entry created successfully";
    }
    @PutMapping("/id/{myid}")
    public String update(@RequestBody JournalEntry j,@PathVariable ObjectId myid){
        JournalEntry old=service.FindByid(myid).orElse(null);
        if(old != null && j != null){
            old.setTitle(j.getTitle() !=null &&  !j.equals("") ? j.getTitle():old.getTitle());
            old.setContent(j.getContent() !=null && !j.equals("") ? j.getContent() : old.getContent());
              service.SaveEntry(old);
        }
         return "UPdated successfully";

    }

    @DeleteMapping("/{myid}")
    public String delete(@PathVariable ObjectId myid){
       service.del(myid);
       return "deleted successfully";

    }
}
