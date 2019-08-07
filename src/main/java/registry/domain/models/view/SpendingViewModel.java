package registry.domain.models.view;

import java.math.BigDecimal;

public class SpendingViewModel {

    private BigDecimal averageSalary;
    private BigDecimal totalMoneyNeeded;

    public BigDecimal getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(BigDecimal averageSalary) {
        this.averageSalary = averageSalary;
    }

    public BigDecimal getTotalMoneyNeeded() {
        return totalMoneyNeeded;
    }

    public void setTotalMoneyNeeded(BigDecimal totalMoneyNeeded) {
        this.totalMoneyNeeded = totalMoneyNeeded;
    }
}
