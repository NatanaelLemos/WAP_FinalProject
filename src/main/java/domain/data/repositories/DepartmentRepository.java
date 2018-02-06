package domain.data.repositories;

import domain.data.IRepository;
import domain.data.RepositoryBase;
import domain.entities.*;

public class DepartmentRepository extends RepositoryBase<Department> implements IRepository<Department> {
    public DepartmentRepository() {
        super(Department.class);
    }
}
