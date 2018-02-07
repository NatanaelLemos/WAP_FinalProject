package web.viewmodels;

import domain.entities.JobApplication;

public class JobApplicationViewModel {
    private int id;
    private String position;
    private String applicant;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static JobApplicationViewModel fromModel(JobApplication application){
        JobApplicationViewModel vm = new JobApplicationViewModel();
        vm.setId(application.getId());
        vm.setApplicant(application.getApplicant().getName());
        vm.setPosition(application.getPosition().getName());
        vm.setStatus(application.getStatus().getName());
        return vm;
    }
}
