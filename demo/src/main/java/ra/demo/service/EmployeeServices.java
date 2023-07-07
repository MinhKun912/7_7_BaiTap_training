package ra.demo.service;
import ra.demo.model.Employee;

import java.util.List;
public interface EmployeeServices {
    List<Employee> getAllEmployee();
    Employee save(Employee employee);
    Employee getById(int id);
    Employee deleteViaId(Employee employee);
}
