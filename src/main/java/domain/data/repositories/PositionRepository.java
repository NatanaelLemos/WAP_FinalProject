package domain.data.repositories;

import domain.data.IRepository;
import domain.data.RepositoryBase;
import domain.entities.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PositionRepository extends RepositoryBase<Position> implements IRepository<Position> {

    private static List<Position> listInstance;

    public PositionRepository() {
        super(Position.class);

        if(listInstance == null){
            listInstance = createFakeList();
        }
    }

    private List<Position> createFakeList() {
        List<Position> list = new ArrayList<>();

        list.add(createFakePosition(1, "Developer", "Developers developers developers", true));
        list.add(createFakePosition(2, "Manager", "Manages projects", false));
        list.add(createFakePosition(3, "Some new position", "Some new position", true));
        list.add(createFakePosition(4, "Developer", "Developers developers developers", true));
        list.add(createFakePosition(5, "Manager", "Manages projects", false));
        list.add(createFakePosition(6, "Some new position", "Some new position", true));
        list.add(createFakePosition(7, "Developer", "Developers developers developers", true));
        list.add(createFakePosition(8, "Manager", "Manages projects", false));
        list.add(createFakePosition(9, "Some new position", "Some new position", true));
        list.add(createFakePosition(10, "Developer", "Developers developers developers", true));
        list.add(createFakePosition(11, "Manager", "Manages projects", false));
        list.add(createFakePosition(12, "Some new position", "Some new position", true));
        list.add(createFakePosition(13, "Developer", "Developers developers developers", true));
        list.add(createFakePosition(14, "Manager", "Manages projects", false));
        list.add(createFakePosition(15, "Some new position", "Some new position", true));
        list.add(createFakePosition(16, "Developer", "Developers developers developers", true));
        list.add(createFakePosition(17, "Manager", "Manages projects", false));
        list.add(createFakePosition(18, "Some new position", "Some new position", true));
        list.add(createFakePosition(19, "Developer", "Developers developers developers", true));
        list.add(createFakePosition(20, "Manager", "Manages projects", false));
        list.add(createFakePosition(21, "Some new position", "Some new position", true));
        list.add(createFakePosition(22, "Developer", "Developers developers developers", true));
        list.add(createFakePosition(23, "Manager", "Manages projects", false));
        list.add(createFakePosition(24, "Some new position", "Some new position", true));
        list.add(createFakePosition(25, "Developer", "Developers developers developers", true));
        list.add(createFakePosition(26, "Manager", "Manages projects", false));
        list.add(createFakePosition(27, "Some new position", "Some new position", true));

        return list;
    }

    private Position createFakePosition(int id, String name, String description, boolean openPos) {
        Position p = new Position();
        p.setId(id);
        p.setName(name);
        p.setDescription(description);
        p.setOpenPosition(openPos);
        return p;
    }

    @Override
    public Position get(int id) {
        Optional<Position> pos = listInstance.stream().filter(p -> p.getId() == id).findFirst();
        return pos.orElse(null);
    }

    @Override
    public List<Position> getAll() {
        return new ArrayList<>(listInstance);
    }

    @Override
    public void add(Position position) {
        Optional<Position> pos = listInstance.stream().sorted(Comparator.comparing(Position::getId).reversed()).findFirst();
        position.setId((pos.isPresent() ? pos.get().getId() : 0) + 1);
        listInstance.add(position);
    }
}
