package web.viewmodels;

import domain.entities.Position;

public class PositionViewModel {
    private int id;
    private String name;
    private String description;
    private String openPosition;

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

    public String getOpenPosition() {
        return openPosition;
    }

    public void setOpenPosition(String openPosition) {
        this.openPosition = openPosition;
    }

    public static PositionViewModel fromModel(Position p) {
        PositionViewModel vm = new PositionViewModel();
        vm.setId(p.getId());
        vm.setDescription(p.getDescription());
        vm.setName(p.getName());
        vm.setOpenPosition(p.getOpenPosition() ? "Open" : "");

        return vm;
    }
}