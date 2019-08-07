package registry.repository;

import registry.domain.entities.Employee;

public interface EmployeeRepository extends GenericRepository<Employee, String> {

    void remove(String id);

    Object findAverageSalary();

    Object findAllMoneyNeeded();

}
