package domain.data.repositories;

import domain.data.IRepository;
import domain.data.RepositoryBase;
import domain.entities.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HumanResourcesOfficerRepository extends RepositoryBase<HumanResourcesOfficer> implements IRepository<HumanResourcesOfficer> {

    private static List<HumanResourcesOfficer> list;

    public HumanResourcesOfficerRepository() {
        super(HumanResourcesOfficer.class);

        if(list == null){
            list = new ArrayList<>();
            list.add(createFakeOfficer());
        }
    }

    private HumanResourcesOfficer createFakeOfficer() {
        HumanResourcesOfficer o = new HumanResourcesOfficer();
        o.setBirthdate(new Date());
        o.setEmail("officer@email.com");
        o.setName("Officer");
        return o;
    }

    @Override
    public List<HumanResourcesOfficer> getAll() {
        return list;
    }
}
