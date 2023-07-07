package ra.demo.service;
import org.springframework.stereotype.Service;
import ra.demo.model.Employee;


import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceIMPL implements EmployeeServices {
    List<Employee> listEmp=new ArrayList<>();
    @Override
    public List<Employee> getAllEmployee() {
        return listEmp;
    }

    @Override
    public Employee save(Employee employee) {
     listEmp.add(employee);
return employee;
    }

    @Override
    public Employee getById(int id) {
        for (int i = 0; i <= listEmp.size(); i++) {
            if (listEmp.get(i).getId()==id){
           return listEmp.get(i);
            }
        }
        return null;
    }

    @Override
    public Employee deleteViaId(Employee employee) {
        if (employee.getId()==getById(employee.getId()).getId()){
            listEmp.remove(employee);
        }
        return null;
    }
}
