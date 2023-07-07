package ra.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.demo.dto.RequestEmployee;
import ra.demo.model.Employee;
import ra.demo.service.EmployeeServiceIMPL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeServiceIMPL serviceIMPL;

    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> list = serviceIMPL.getAllEmployee();

        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody Employee employee) {
        List<Employee> list = serviceIMPL.getAllEmployee();
        Employee employee1 = new Employee();
        employee1.setId((long) (list.size() + 1));
        employee1.setName(employee.getName());
        employee1.setDepartment(employee.getDepartment());
        employee1.setEmail(employee.getEmail());
        employee1.setRoles(employee.getRoles());
        serviceIMPL.save(employee1);
        return new ResponseEntity<>(employee1, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") int id, @RequestBody RequestEmployee employee) {
        Employee uEmp = serviceIMPL.getById(id);
        if (uEmp.getId() == id) {
            uEmp.setName(employee.getName());
            uEmp.setEmail(employee.getEmail());
            uEmp.setDepartment(employee.getDepartment());
            serviceIMPL.save(uEmp);
            return new ResponseEntity<>(uEmp, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("employee/{id}")
    public ResponseEntity<Employee> delete(@PathVariable("id") int id) {
        Employee delete = serviceIMPL.getById(id);
        if (delete.getId() == id) {
            serviceIMPL.deleteViaId(delete);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
