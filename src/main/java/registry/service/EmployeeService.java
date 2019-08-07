package registry.service;

import registry.domain.models.service.EmployeeServiceModel;
import registry.domain.models.service.EmployeeSpendingServiceModel;

import java.util.List;

public interface EmployeeService {

    boolean save(EmployeeServiceModel employeeRegister);

    boolean removeEmployeeById(String id);

    List<EmployeeServiceModel> findAllEmployees();

    EmployeeSpendingServiceModel getSpending();
}
