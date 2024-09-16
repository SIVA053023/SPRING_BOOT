package com.example.Project1.Services;

import com.example.Project1.Repository.EmployeeRepository;
import com.example.Project1.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository emp;

    //THIS METHOD IS FOR TO SAVE THE EMPLOYEES
    public void saveEntry(Employees Employees){
       emp.save(Employees);
    }

    // THIS METHOD IS FOR THE READING THE ALL EMPLOYEES
    public List<Employees> getAll(){
          return emp.findAll();
    }

    // THIS IS FOR THE GETTING SPECIFIC EMPLOYEE BY USING ID
    public Optional<Employees> getbyId(Integer id){
        return emp.findById(id);
    }

    // THIS METHOD IS FOR TO DELETE THE EMPLOYEE BY USING ID
    public void del(Integer id){
         emp.deleteById(id);
    }

    //


}
