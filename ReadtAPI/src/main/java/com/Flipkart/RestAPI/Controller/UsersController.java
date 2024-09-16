package com.Flipkart.RestAPI.Controller;

//import com.Flipkart.RestAPI.Entity.JournalEntry;
import com.Flipkart.RestAPI.Entity.Users;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    private Map<Integer, Users> users=new HashMap<>();

    @GetMapping
    public List<Users> getAll(){
        return new ArrayList<>(users.values());
    }

    @GetMapping("/Id/{myid}")                            // for getting the specific user details by eid
    public Users Findbyeid(@PathVariable Integer myid){
        return users.get(myid);
    }

    @PostMapping                                             // for to myid a new User
    public boolean CreateUser(@RequestBody Users myid){
         users.put(myid.getEid(), myid);
         return true;
    }

    @PutMapping("/Id/{myid}")                                   // for updating the existed user
    public Users Updating(@RequestBody Users myuser,@PathVariable Integer myid){
       return  users.put(myid,myuser);
    }

    @DeleteMapping("/{id}")                                       // For deleting the userdata
    public Users deleting(@PathVariable Integer id){
       return users.remove(id);
    }



}
