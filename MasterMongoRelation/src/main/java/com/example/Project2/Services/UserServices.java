//package com.example.Project2.Services;
//
//import com.example.Project2.Repository.UserRepository;
//import com.example.Project2.entity.Users;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class UserServices {
//    @Autowired
//    private UserRepository user;
//
//  public List<Users> getAll(){                             //Here also we Return the user details
//      return user.findAll();
//  }
//
//  public Optional<Users> findById(Integer Id){            // bUt here we return the user details
//      return user.findById(Id);
//    }
//
//  public void saveEntry(Users UsersEntry){                    // we  return  anything while we are saving the entry
//      user.save(UsersEntry);
//  }
//
//  public void del(Integer id){
//      user.deleteById(id);
//  }
//
//}
package com.example.Project2.Services;

import com.example.Project2.Repository.UserRepository;
import com.example.Project2.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository user;

    public List<Users> getAll() {
        return user.findAll();
    }

    public Optional<Users> findById(Integer id) {
        return user.findById(id);
    }

    public void saveEntry(Users userEntry) {
        user.save(userEntry);
    }

    public void del(Integer id) {
        user.deleteById(id);
    }
}

