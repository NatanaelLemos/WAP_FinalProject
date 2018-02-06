package domain.data.repositories;

import domain.data.IRepository;
import domain.data.RepositoryBase;
import domain.entities.*;

public class ApplicantRepository extends RepositoryBase<Applicant> implements IRepository<Applicant> {
    public ApplicantRepository() {
        super(Applicant.class);
    }
}
