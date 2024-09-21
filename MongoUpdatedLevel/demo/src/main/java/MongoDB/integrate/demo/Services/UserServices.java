package MongoDB.integrate.demo.Services;


import MongoDB.integrate.demo.Entries.UserEntry;

import MongoDB.integrate.demo.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServices {

    @Autowired
    private UserRepository user;

    // For getting the All entris
    public List<UserEntry> getAll(){
        return user.findAll();
    }


   // for to Save the Entry
    public void SaveEntry(UserEntry j){
        user.save(j);
    }

    // for to delete the entry by id
    public String del(ObjectId entry){
       user .deleteById(entry);
        return "deleted successfull";
    }

      // for to find the entry by id
   public Optional<UserEntry> FindByid(ObjectId id){
        return user.findById(id);
   }

   public UserEntry findByUsername(String username){
        return user.findByUsername(username);
   }

}
