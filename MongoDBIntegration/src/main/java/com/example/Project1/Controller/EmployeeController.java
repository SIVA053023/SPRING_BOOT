package com.example.Project1.Controller;

import com.example.Project1.Services.EmployeeService;
import com.example.Project1.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employees> getAll() {
        return service.getAll();
    }

    @PostMapping
    public boolean create(@RequestBody Employees emp) {
        service.saveEntry(emp);
        return true;
    }

    @GetMapping("/Id/{myid}")
    public Employees getEmp(@PathVariable Integer myid) {
        return service.getbyId(myid).orElse(null);
    }


    @DeleteMapping("Id/{myid}")
    public boolean delete(@PathVariable Integer myid) {
        service.del(myid);
        return true;
    }

    @PutMapping("/Id/{myid}")
    public Employees Updating(@PathVariable Integer myid, @RequestBody Employees newone) {

        Employees emp = service.getbyId(myid).orElse(null);
        if (emp != null) {
            emp.setSalary(newone.getSalary() != null && !newone.equals("") ? newone.getSalary() : emp.getSalary());
            emp.setCompany(newone.getCompany() != null && !newone.equals("") ? newone.getCompany() : emp.getCompany());
        }
        service.saveEntry(emp);
        return emp;

    }
}
