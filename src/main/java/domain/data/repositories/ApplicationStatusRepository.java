package domain.data.repositories;

import domain.data.IRepository;
import domain.data.RepositoryBase;
import domain.entities.*;

public class ApplicationStatusRepository extends RepositoryBase<ApplicationStatus> implements IRepository<ApplicationStatus> {
    public ApplicationStatusRepository() {
        super(ApplicationStatus.class);
    }
}
