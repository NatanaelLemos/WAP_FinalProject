package domain.data.repositories;

import domain.data.IRepository;
import domain.data.RepositoryBase;
import domain.entities.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class JobApplicationRepository extends RepositoryBase<JobApplication> implements IRepository<JobApplication> {

    private static volatile List<JobApplication> listInstance;

    public JobApplicationRepository() {
        super(JobApplication.class);

        if(listInstance == null){
            listInstance = new ArrayList<>();
        }
    }

    @Override
    public void add(JobApplication jobApplication) {
        Optional<JobApplication> app = listInstance.stream().sorted(Comparator.comparing(JobApplication::getId).reversed()).findFirst();
        jobApplication.setId((app.isPresent() ? app.get().getId() : 0) + 1);
        listInstance.add(jobApplication);
    }

    @Override
    public List<JobApplication> getAll() {
        return listInstance;
    }

    @Override
    public JobApplication get(int id) {
        Optional<JobApplication> ap =listInstance.stream().filter(a -> a.getId() == id).findFirst();
        return ap.orElse(null);
    }
}
