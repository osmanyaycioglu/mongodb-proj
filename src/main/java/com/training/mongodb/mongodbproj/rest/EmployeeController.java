package com.training.mongodb.mongodbproj.rest;

import com.training.mongodb.mongodbproj.entities.Comment;
import com.training.mongodb.mongodbproj.entities.Employee;
import com.training.mongodb.mongodbproj.entities.ICommentDao;
import com.training.mongodb.mongodbproj.entities.IEmployeeDao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeDao employeeDao;

    @Autowired
    private ICommentDao commentDao;

    @GetMapping("/getAll")
    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }

    @PostMapping("/add")
    public String addEmployee(@Valid @RequestBody Employee employee) {
        List<Comment> commentsLoc = employee.getComments();
        commentDao.saveAll(commentsLoc);
        employeeDao.save(employee);
        return "OK";
    }

    @GetMapping("/agg/weight/{we}")
    public List<Employee> aggEmployeesWeight(@PathVariable("we") Integer weight) {
        return employeeDao.aggregateEmployeeWeight(weight);
    }
}
