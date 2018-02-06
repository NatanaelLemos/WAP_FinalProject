package domain.data.repositories;

import domain.data.IRepository;
import domain.data.RepositoryBase;
import domain.entities.*;

public class PositionRepository extends RepositoryBase<Position> implements IRepository<Position> {
    public PositionRepository() {
        super(Position.class);
    }
}
