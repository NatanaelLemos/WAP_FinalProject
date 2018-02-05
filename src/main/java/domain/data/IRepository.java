package domain.data;

import java.util.List;

public interface IRepository<TEntity> {
    List<TEntity> getAll();
    void add(TEntity entity);
    void delete(TEntity entity);
    TEntity get(int id);
    TEntity update(TEntity entity);
}
