package peaksoft.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;
import peaksoft.dao.CourseDao;

public class CourseDaoImpl implements CourseDao {

    EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();

    @Override
    public int countStudentsFromCourse(Long courseId) {
        int count = 0;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            count =entityManager
                    .createQuery("select count(s.id) from Student s inner join s.courses sc where sc.id= :courseId", Long.class)
                    .setParameter("courseId", courseId)
                    .getSingleResult().intValue();
            entityManager.getTransaction().commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }

        return count;
    }
}
