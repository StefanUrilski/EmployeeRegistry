package registry.repository;

import registry.domain.entities.Employee;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EntityManager entityManager;

    @Inject
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }

    @Override
    public Employee findById(String id) {
        entityManager.getTransaction().begin();
        Employee employee = entityManager
                .createQuery("select e from Employee as e where e.id = :id", Employee.class)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.getTransaction().commit();

        return employee;
    }

    @Override
    public List<Employee> findAll() {
        entityManager.getTransaction().begin();
        List<Employee> allEmployees = entityManager
                .createQuery("select e from Employee as e", Employee.class)
                .getResultList();
        entityManager.getTransaction().commit();

        return allEmployees;
    }

    @Override
    public void remove(String id) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Employee as e where e.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public Object findAverageSalary() {
        entityManager.getTransaction().begin();
        Object averageSalary = entityManager
                .createQuery("select avg(e.salary) from Employee as e")
                .getSingleResult();
        entityManager.getTransaction().commit();

        return averageSalary;
    }

    @Override
    public Object findAllMoneyNeeded() {
        entityManager.getTransaction().begin();
        Object allMoney = entityManager
                .createQuery("select sum(e.salary) from Employee as e")
                .getSingleResult();
        entityManager.getTransaction().commit();

        return allMoney;
    }
}
