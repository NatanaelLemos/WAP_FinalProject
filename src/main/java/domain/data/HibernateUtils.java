package domain.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

class HibernateUtils {
    @PersistenceContext
    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        if(needNewInstance()){
            synchronized (HibernateUtils.class) { //Double check if the sessionFactory is null (thread safe)
                if(needNewInstance()){
                    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "WAP_Final" );
                    entityManager = emfactory.createEntityManager();
                }
            }
        }

        return entityManager;
    }

    private static boolean needNewInstance() {
        return  entityManager == null || (!entityManager.isOpen());
    }
}
