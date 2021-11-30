package com.vijay.springmongoDBCURD.controllers;

import com.vijay.springmongoDBCURD.exception.ResourceNotFoundException;
import com.vijay.springmongoDBCURD.models.Employee;
import com.vijay.springmongoDBCURD.repository.EmployeeRepository;
import com.vijay.springmongoDBCURD.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;


    // Create
    @PostMapping(path = "employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        employee.setId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
        return employeeRepository.save(employee);
    }

    //Update
    @PutMapping(path = "/employees/{id}")
    public ResponseEntity < Employee > updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                      @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: "+employeeId));

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Read
    @GetMapping(path = "/employees")
    public List< Employee > getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping(path = "/employees/{id}")
    public ResponseEntity < Employee > getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: "+employeeId));

        return ResponseEntity.ok().body(employee);
    }

    //Delete
    @DeleteMapping(path = "/employees/{id}")
    public String deleteEmployee(){
        return "Employee Deleted Successfully";
    }
}
