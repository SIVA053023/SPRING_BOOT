package MongoDB.integrate.demo.Controller;


import MongoDB.integrate.demo.Entries.UserEntry;
import MongoDB.integrate.demo.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices services;

    @GetMapping
    public List<UserEntry> getAllusers(){
        return services.getAll();

    }
    @PostMapping
    public String create(@RequestBody UserEntry u){
        services.SaveEntry(u);
        return "user created successfully";
    }

    @PutMapping("/{username}")
    public ResponseEntity<?>updateduser(@RequestBody UserEntry user,@PathVariable String  username){
      UserEntry Userindb=services.findByUsername(username);
      if(Userindb != null){
          Userindb.setUsername(user.getUsername());
          Userindb.setPassword(user.getPassword());
          services.SaveEntry(Userindb);
      }
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
