

package com.example.Project2.Controller;

import com.example.Project2.Services.UserServices;
import com.example.Project2.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices service;

    @GetMapping
   public List<Users> getAll(){
        return service.getAll();
    }

    @GetMapping("/Id/{myId}")
    public Users findById(@PathVariable Integer myId){
        return service.findById(myId).orElse(null);
    }

    @PostMapping
    public boolean create(@RequestBody Users u){
        service.saveEntry(u);
        return true;
    }

    @PutMapping("/Id/{id}")
    public Users update(@RequestBody Users u,@PathVariable Integer id){
       Users old=service.findById(id).orElse(null);
       if(old !=null && u != null){

           old.setUsername(u.getUsername() !=null && !u.equals("") ? u.getUsername():old.getUsername());
           old.setLocation(u.getUsername() !=null && !u.equals("") ? u.getLocation():old.getLocation());
           service.saveEntry(old);
       }

       return old;
    }
 @DeleteMapping("/Id/{id}")
  public String delete(@PathVariable Integer id) {
    service.del(id);
    return "Deleted user with ID: " + id;
}

}

//package com.example.Project2.Controller;
//
//import com.example.Project2.Services.UserServices;
//import com.example.Project2.entity.Users;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    @Autowired
//    private UserServices service;
//
//    @GetMapping
//    public List<Users> getAll() {
//        return service.getAll();
//    }
//
//    @GetMapping("/Id/{myId}")
//    public Users findById(@PathVariable Integer myId) {
//        return service.findById(myId).orElse(null);
//    }
//
//    @PostMapping
//    public Users create(@RequestBody Users u) {
//        service.saveEntry(u);
//        return u;  // Return the created user instead of a boolean
//    }
//
//    @PutMapping("/Id/{id}")
//    public Users update(@RequestBody Users u, @PathVariable Integer id) {
//        Users old = service.findById(id).orElse(null);
//        if (old != null && u != null) {
//            old.setUsername(u.getUsername() != null && !u.getUsername().equals("") ? u.getUsername() : old.getUsername());
//            old.setLocation(u.getLocation() != null && !u.getLocation().equals("") ? u.getLocation() : old.getLocation());
//            service.saveEntry(old);
//        }
//        return old;
//    }
//
//    @DeleteMapping("/Id/{id}")
//    public String delete(@PathVariable Integer id) {
//        service.del(id);
//        return "Deleted user with ID: " + id;
//    }
//}
//
