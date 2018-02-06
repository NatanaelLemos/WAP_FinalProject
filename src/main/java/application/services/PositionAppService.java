package application.services;

import domain.data.repositories.PositionRepository;
import domain.entities.Position;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PositionAppService {

    private PositionRepository repo = new PositionRepository();

    public List<Position> getPositions(int from, int to) {
        return repo.getAll().stream()
                .skip(from)
                .limit(to)
                .collect(Collectors.toList());
    }

    public int count(){
        return repo.getAll().size();
    }

    public void create(String name, String description, Boolean openPosition) {
        Position p = new Position();
        p.setName(name);
        p.setDescription(description);
        p.setOpenPosition(openPosition);
        repo.add(p);
    }
}
