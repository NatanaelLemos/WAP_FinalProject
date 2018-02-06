package application.services;

import domain.data.repositories.ApplicantRepository;
import domain.data.repositories.JobApplicationRepository;
import domain.data.repositories.PositionRepository;
import domain.entities.Applicant;
import domain.entities.ApplicationStatus;
import domain.entities.JobApplication;
import domain.entities.Position;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ApplicationAppService {

    private PositionRepository positionRepo = new PositionRepository();
    private JobApplicationRepository applicationRepo = new JobApplicationRepository();
    private ApplicantRepository applicantRepo = new ApplicantRepository();

    public List<Position> getOpenPositions(int from, int to) {
        return positionRepo.getAll().stream()
                .filter(Position::getOpenPosition)
                .skip(from)
                .limit(to)
                .collect(Collectors.toList());
    }

    public int count() {
        return positionRepo.getAll().size();
    }

    public int countOpenPositions() {
        return (int) positionRepo.getAll().stream()
                .filter(Position::getOpenPosition).count();
    }

    public void apply(int positionId, int userId){
        Position position = positionRepo.get(positionId);
        Applicant applicant = applicantRepo.get(userId);

        //Make the relationship manually
        JobApplication a = new JobApplication();
        a.setPosition(position);
        a.setApplicant(applicant);
        a.setStatus(new ApplicationStatus());

        position.setOpenPosition(true);
        applicant.getApplication().add(a);

        applicationRepo.add(a);
    }

    public ApplicationStatus getApplicationStatus(int positionId, int userId) {
        Optional<JobApplication> application = applicationRepo.getAll().stream()
                .filter(a ->
                        a.getPosition().getId() == positionId &&
                        a.getApplicant().getId() == userId
                ).findFirst();

        if(!application.isPresent()){
            return null;
        }

        return application.get().getStatus();
    }
}
