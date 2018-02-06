package web.viewmodels;

import domain.entities.ApplicationStatus;

public class ApplicationStatusViewModel {
    private boolean applied;

    public boolean isApplied() {
        return applied;
    }

    public void setApplied(boolean applied) {
        this.applied = applied;
    }

    public static ApplicationStatusViewModel fromModel(ApplicationStatus status) {
        ApplicationStatusViewModel vm = new ApplicationStatusViewModel();

        if(status == null){
            vm.setApplied(false);
        }else{
            vm.setApplied(true);
        }

        return vm;
    }
}
