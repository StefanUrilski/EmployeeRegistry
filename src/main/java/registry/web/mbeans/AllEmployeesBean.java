package registry.web.mbeans;

import org.modelmapper.ModelMapper;
import registry.domain.models.view.EmployeeViewModel;
import registry.service.EmployeeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class AllEmployeesBean {

    private List<EmployeeViewModel> allEmployees;

    private ModelMapper modelMapper;
    private EmployeeService employeeService;

    public AllEmployeesBean() {
    }

    @Inject
    public AllEmployeesBean(ModelMapper modelMapper,
                            EmployeeService employeeService) {
        this.modelMapper = modelMapper;
        this.employeeService = employeeService;
        this.allEmployees = this.employeeService.findAllEmployees()
                .stream()
                .map(employee -> this.modelMapper.map(employee, EmployeeViewModel.class))
                .collect(Collectors.toList());
    }

    public List<EmployeeViewModel> getEmployees() {
        return allEmployees;
    }

    public void setEmployees(List<EmployeeViewModel> employees) {
        this.allEmployees = employees;
    }

}
