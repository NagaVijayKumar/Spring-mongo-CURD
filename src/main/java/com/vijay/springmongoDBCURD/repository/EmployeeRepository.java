package com.vijay.springmongoDBCURD.repository;

import com.vijay.springmongoDBCURD.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long>{

}