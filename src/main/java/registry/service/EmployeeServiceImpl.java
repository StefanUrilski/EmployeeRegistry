package registry.service;

import org.modelmapper.ModelMapper;
import registry.domain.entities.Employee;
import registry.domain.models.service.EmployeeServiceModel;
import registry.domain.models.service.EmployeeSpendingServiceModel;
import registry.repository.EmployeeRepository;
import registry.util.ValidationUtil;
import registry.util.ValidationUtilImpl;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {
    private ValidationUtil validationUtil;

    private ModelMapper modelMapper;
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl() {
        this.validationUtil = new ValidationUtilImpl();
    }

    @Inject
    public EmployeeServiceImpl(ModelMapper modelMapper,
                               EmployeeRepository employeeRepository) {
        this();
        this.modelMapper = modelMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public boolean save(EmployeeServiceModel employeeRegister) {
        if (! validationUtil.validate(employeeRegister)) { return false; }

        try {
            employeeRepository.save(modelMapper.map(employeeRegister, Employee.class));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean removeEmployeeById(String id) {
        try {
            employeeRepository.remove(id);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<EmployeeServiceModel> findAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeSpendingServiceModel getSpending() {
        EmployeeSpendingServiceModel spending = new EmployeeSpendingServiceModel();

        spending.setAverageSalary(employeeRepository.findAverageSalary());
        spending.setTotalMoneyNeeded(employeeRepository.findAllMoneyNeeded());

        return spending;
    }
}
