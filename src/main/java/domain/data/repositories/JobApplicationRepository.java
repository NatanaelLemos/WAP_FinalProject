package domain.data.repositories;

import domain.data.IRepository;
import domain.data.RepositoryBase;
import domain.entities.*;

public class JobApplicationRepository extends RepositoryBase<JobApplication> implements IRepository<JobApplication> {
    public JobApplicationRepository() {
        super(JobApplication.class);
    }
}
