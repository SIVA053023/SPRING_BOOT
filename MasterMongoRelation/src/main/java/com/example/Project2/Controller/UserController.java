

package com.example.Project2.Controller;

import com.example.Project2.Services.UserServices;
import com.example.Project2.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/u")
public class    UserController {

    @Autowired
    private UserServices service;

    @GetMapping
    public ResponseEntity<List<Users>> getAll() {
        try {
            List<Users> users = service.getALl();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    //    @GetMapping("/Id/{myid}")
//    public ResponseEntity<Optional<Users>> findbyID(@PathVariable Integer myid){
//        try {
//            Optional<Users> one = service.getByid(myid);
//            if (one != null) {
//                return new ResponseEntity<>(one, HttpStatus.OK);
//
//            }
//            else {
//                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
//            }
//        }catch (Exception e) {
//           return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
//        }
//
//    }
    @GetMapping("/Id/{myid}")
    public ResponseEntity<Users> findByID(@PathVariable Integer myid) {
        try {
            // Assuming service.getByid(myid) returns a Users object or null if not found
            Users user = service.getByid(myid).orElse(null);

            return new ResponseEntity<>(user, HttpStatus.OK);

        } catch (Exception e) {
            // Handle any other exceptions with HTTP 500 INTERNAL SERVER ERROR
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public String create(@RequestBody Users u) {
        service.SaveEntry(u);
        return "user created succcessfully";
    }

    @PutMapping("/id/{myid}")

    public String update(@RequestBody Users newUser, @PathVariable Integer myid) {
        Users old = service.getByid(myid).orElse(null);
        if (old != null && newUser != null) {
            old.setUsername(newUser.getUsername() != null && newUser.equals("") ? newUser.getUsername() : old.getUsername());
            old.setCompany(newUser.getCompany() != null && newUser.equals("") ? newUser.getCompany() : old.getCompany());
            service.SaveEntry(old);

        }
        return "User updated successfully";

    }

    @DeleteMapping("/{myid}")
    public String delete(@PathVariable Integer myid) {
        service.del(myid);
        return "deleted successfully";
    }


}


