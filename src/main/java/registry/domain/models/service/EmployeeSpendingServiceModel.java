package registry.domain.models.service;

public class EmployeeSpendingServiceModel {

    private Object averageSalary;
    private Object totalMoneyNeeded;

    public Object getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(Object averageSalary) {
        this.averageSalary = averageSalary;
    }

    public Object getTotalMoneyNeeded() {
        return totalMoneyNeeded;
    }

    public void setTotalMoneyNeeded(Object totalMoneyNeeded) {
        this.totalMoneyNeeded = totalMoneyNeeded;
    }
}
