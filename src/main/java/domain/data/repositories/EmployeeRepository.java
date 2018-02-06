package domain.data.repositories;

import domain.data.IRepository;
import domain.data.RepositoryBase;
import domain.entities.*;

public class EmployeeRepository extends RepositoryBase<Employee> implements IRepository<Employee> {
    public EmployeeRepository() {
        super(Employee.class);
    }
}
