package registry.web.mbeans;

import org.modelmapper.ModelMapper;
import registry.domain.models.binding.EmployeeRegisterBindingModel;
import registry.domain.models.service.EmployeeServiceModel;
import registry.service.EmployeeService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named(value = "employeeReg")
@RequestScoped
public class EmployeeRegisterBeen {
    private EmployeeRegisterBindingModel registerBindingModel;

    private ModelMapper modelMapper;
    private EmployeeService employeeService;

    public EmployeeRegisterBeen() {
        registerBindingModel = new EmployeeRegisterBindingModel();
    }

    @Inject
    public EmployeeRegisterBeen(ModelMapper modelMapper,
                                EmployeeService employeeService) {
        this();
        this.modelMapper = modelMapper;
        this.employeeService = employeeService;
    }

    public EmployeeRegisterBindingModel getRegisterBindingModel() {
        return registerBindingModel;
    }

    public void setRegisterBindingModel(EmployeeRegisterBindingModel registerBindingModel) {
        this.registerBindingModel = registerBindingModel;
    }

    public void register() throws IOException {
        employeeService.save(modelMapper.map(registerBindingModel, EmployeeServiceModel.class));

        FacesContext.getCurrentInstance().getExternalContext().redirect("/");
    }
}
