package domain.data.repositories;

import domain.data.IRepository;
import domain.data.RepositoryBase;
import domain.entities.*;

public class HumanResourcesOfficerRepository extends RepositoryBase<HumanResourcesOfficer> implements IRepository<HumanResourcesOfficer> {
    public HumanResourcesOfficerRepository() {
        super(HumanResourcesOfficer.class);
    }
}
