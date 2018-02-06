package domain.data;

import java.util.List;

public class RepositoryBase<TEntity> implements IRepository<TEntity> {
    private Class<TEntity> type;

    protected RepositoryBase(Class<TEntity> type){
        this.type = type;
    }

    @Override
    public TEntity get(int id) {
        return null;
    }

    @Override
    public List<TEntity> getAll() {
        return null;
    }

    @Override
    public void add(TEntity entity) {
    }

    @Override
    public void delete(TEntity entity) {
    }

    public TEntity update(TEntity entity) {
        return null;
    }
}
