package domain.data.repositories;

import domain.data.IRepository;
import domain.data.RepositoryBase;
import domain.entities.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PositionRepository extends RepositoryBase<Position> implements IRepository<Position> {

    public static List<Position> listInstance;

    public PositionRepository() {
        super(Position.class);

        if(listInstance == null){
            listInstance = createFakeList();
        }
    }

    private List<Position> createFakeList() {
        List<Position> list = new ArrayList<>();

        list.add(createFakePosition(1, "Developer", "Java Angular Dev", true));
        list.add(createFakePosition(2, "Manager", "Manages projects", false));
        list.add(createFakePosition(3, "Designer", "Designer", true));

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
    public  List<Position> getAll() {
        return new ArrayList<>(listInstance);
    }

    @Override
    public void add(Position position) {
        Optional<Position> pos = listInstance.stream().sorted(Comparator.comparing(Position::getId).reversed()).findFirst();
        position.setId((pos.isPresent() ? pos.get().getId() : 0) + 1);
        listInstance.add(position);
    }

    @Override
    public void delete(Position position) {
        listInstance.remove(position);
    }
}
