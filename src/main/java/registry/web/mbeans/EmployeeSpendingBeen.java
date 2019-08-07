package registry.web.mbeans;

import org.modelmapper.ModelMapper;
import registry.domain.models.view.SpendingViewModel;
import registry.service.EmployeeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "spending")
@RequestScoped
public class EmployeeSpendingBeen {

    private SpendingViewModel spendingViewModel;

    private ModelMapper modelMapper;
    private EmployeeService employeeService;

    public EmployeeSpendingBeen() {
    }

    @Inject
    public EmployeeSpendingBeen(ModelMapper modelMapper,
                                EmployeeService employeeService) {
        this.modelMapper = modelMapper;
        this.employeeService = employeeService;
        this.spendingViewModel = this.modelMapper
                .map(this.employeeService.getSpending(), SpendingViewModel.class);
    }

    public SpendingViewModel getSpendingViewModel() {
        return spendingViewModel;
    }

    public void setSpendingViewModel(SpendingViewModel spendingViewModel) {
        this.spendingViewModel = spendingViewModel;
    }
}
