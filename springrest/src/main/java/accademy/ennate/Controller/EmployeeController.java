package accademy.ennate.Controller;

import accademy.ennate.entity.Employee;
import accademy.ennate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = "employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping(path = "ping")
    public String ping(){
        return "pong";
    }
    @GetMapping(path = "",produces = "application/json")
    public List<Employee> findAll(){
     return service.findAll();
    }
    @GetMapping(path = "{id}",produces = "application/json")
    public Employee findOne(@PathVariable("id") String empId){
        return service.findOne(empId);
    }
    @PostMapping(path="",consumes = "application/json",produces = "application/json")
    public Employee create(@RequestBody Employee employee){
        return service.create(employee);
    }
    @PutMapping(path = "{id}",consumes = "application/json",produces = "application/json")
    public Employee update(@PathVariable("id") String empId, @RequestBody Employee employee){
        return service.update(empId,employee);
    }
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") String empId){
        service.delete(empId);
    }

    @GetMapping(path = "/email{emailId}",produces = "application/json")
    public Employee findByEmail(@PathVariable("emailId") String email){
        return service.findByEmail(email);

    }
}