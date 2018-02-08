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

    public List<Position> getPositionByStatus(boolean status){
        return repo.getAll().stream().filter(position -> position.getOpenPosition().booleanValue()==status).collect(Collectors.toList());
    }

    public void create(String name, String description, Boolean openPosition) {
        Position p = new Position();
        p.setName(name);
        p.setDescription(description);
        p.setOpenPosition(openPosition);
        repo.add(p);
    }

    public void delete(int positionId) {
        Position p = repo.get(positionId);
        repo.delete(p);
    }

    public Position getPosition(int id) {
        return repo.get(id);
    }

    public void edit(int id, String name, String description, Boolean openPosition) {
        Position p = getPosition(id);
        p.setName(name);
        p.setDescription(description);
        p.setOpenPosition(openPosition);
        repo.update(p);
    }
}
