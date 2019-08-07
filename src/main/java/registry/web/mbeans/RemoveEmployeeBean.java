package registry.web.mbeans;

import registry.service.EmployeeService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named(value = "removeEmployee")
@RequestScoped
public class RemoveEmployeeBean {

    private EmployeeService employeeService;

    public RemoveEmployeeBean() {
    }

    @Inject
    public RemoveEmployeeBean(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void remove(String id) throws IOException {
        employeeService.removeEmployeeById(id);

        FacesContext.getCurrentInstance().getExternalContext().redirect("/");
    }
}
