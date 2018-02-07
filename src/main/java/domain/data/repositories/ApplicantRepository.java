package domain.data.repositories;

import domain.data.IRepository;
import domain.data.RepositoryBase;
import domain.entities.*;

import java.time.DateTimeException;
import java.util.*;

public class ApplicantRepository extends RepositoryBase<Applicant> implements IRepository<Applicant> {

    private static List<Applicant> instanceList;

    public ApplicantRepository() {
        super(Applicant.class);

        if(instanceList == null){
            instanceList = new ArrayList<>();
            instanceList.add(createFakeApplicant(1, "John Doe", "johndoe@email.test", new Date()));
        }
    }

    private Applicant createFakeApplicant(int id, String name, String email, Date birthdate) {
        Applicant a = new Applicant();
        a.setId(id);
        a.setName(name);
        a.setEmail(email);
        a.setBirthdate(birthdate);
        return a;
    }

    @Override
    public Applicant get(int id) {
        Optional<Applicant> a = instanceList.stream().filter(l -> l.getId() == id).findFirst();
        return a.orElse(null);
    }

    @Override
    public void add(Applicant applicant) {
        Optional<Applicant> a = instanceList.stream().sorted(Comparator.comparing(Applicant::getId).reversed()).findFirst();
        applicant.setId((a.map(Applicant::getId).orElse(0)) + 1);
        instanceList.add(applicant);
    }
}
