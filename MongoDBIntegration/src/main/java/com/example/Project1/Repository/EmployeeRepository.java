package com.example.Project1.Repository;

import com.example.Project1.entity.Employees;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employees,Integer> {


}