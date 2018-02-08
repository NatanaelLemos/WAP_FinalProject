package application.services;

import domain.data.repositories.ApplicantRepository;
import domain.data.repositories.EmployeeRepository;
import domain.data.repositories.HumanResourcesOfficerRepository;
import domain.entities.*;

public class LoginAppService {
    private ApplicantRepository applicantRepository;
    private EmployeeRepository employeeRepository;
    private HumanResourcesOfficerRepository humanResourcesOfficerRepository;

    public LoginAppService() {
        try {
            applicantRepository = new ApplicantRepository();
        } catch (Exception e) {
        }
        try {
            employeeRepository = new EmployeeRepository();
        } catch (Exception e) {
        }
        try {
            humanResourcesOfficerRepository = new HumanResourcesOfficerRepository();
        } catch (Exception e) {
        }
    }

    public Applicant getApplicantByEmail(String email) {
        try {
            return applicantRepository.getAll().stream()
                    .filter(a -> a.getEmail().equals(email))
                    .findFirst().orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    public Employee getEmployeeByEmail(String email) {
        try {
            return employeeRepository.getAll().stream()
                    .filter(a -> a.getEmail().equals(email))
                    .findFirst().orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    public HumanResourcesOfficer getOfficerByEmail(String email) {
        try {
            return humanResourcesOfficerRepository.getAll().stream()
                    .filter(a -> a.getEmail().equals(email))
                    .findFirst().orElse(null);
        } catch (Exception e) {
            return null;
        }
    }
}
