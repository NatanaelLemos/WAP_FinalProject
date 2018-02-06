package web.viewmodels;

import domain.entities.Position;

public class PositionViewModel {
    private int id;
    private String name;
    private String description;
    private Boolean isOpenPosition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getOpenPosition() {
        return isOpenPosition;
    }

    public void setOpenPosition(Boolean openPosition) {
        isOpenPosition = openPosition;
    }

    public static PositionViewModel fromModel(Position p) {
        PositionViewModel vm = new PositionViewModel();
        vm.setId(p.getId());
        vm.setDescription(p.getDescription());
        vm.setName(p.getName());
        vm.setOpenPosition(p.getOpenPosition());

        return vm;
    }
}