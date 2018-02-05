package domain.data;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RepositoryBase<TEntity> implements IRepository<TEntity> {
    private Class<TEntity> type;

    protected RepositoryBase(Class<TEntity> type){
        this.type = type;
    }

    @Override
    public TEntity get(int id) {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        return entityManager.find(type, id);
    }

    @Override
    public List<TEntity> getAll() {
        EntityManager entityManager = HibernateUtils.getEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TEntity> cq = cb.createQuery(type);
        Root<TEntity> rootEntry = cq.from(type);
        CriteriaQuery<TEntity> all = cq.select(rootEntry);
        TypedQuery<TEntity> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public void add(TEntity entity) {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }



    @Override
    public void delete(TEntity entity) {
        EntityManager entityManager = HibernateUtils.getEntityManager();

        if(!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }

        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public TEntity update(TEntity entity) {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }
}
