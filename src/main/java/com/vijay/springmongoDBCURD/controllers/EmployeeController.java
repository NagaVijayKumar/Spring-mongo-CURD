package com.vijay.springmongoDBCURD.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {


    // Create
    @PostMapping(path = "employees")
    public String CreateEmployee(){
        return "Employee Created Successfully";
    }

    //Update
    @PutMapping(path = "/employees/{id}")
    public String updateEmployee(){
        return "Employee updated Successfully";
    }

    // Read
    @GetMapping(path = "/employees")
    public String getAllEmployees(){
        return "All Employee Details";
    }

    @GetMapping(path = "/employees/{id}")
    public String getEmployee(){
        return "Single Employee";
    }

    //Delete
    @DeleteMapping(path = "/employees/{id}")
    public String deleteEmployee(){
        return "Employee Deleted Successfully";
    }
}
