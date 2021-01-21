package productweb;

import hibernate.HibernateUtils;
import org.hibernate.Session;
import productweb.LaptopEntity.LaptopEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Session hibernateSession = null;
        try {
            hibernateSession = HibernateUtils
                    .buildSessionFactory()
                    .openSession();
            hibernateSession.beginTransaction();

            /* Insert some laptops */
            for (int i = 0; i <= 10; i++) {
                LaptopEntity laptop = new LaptopEntity();
                laptop.setName("SomeBook" + i);
                laptop.setPrice(10F * i);
                hibernateSession.save(laptop);
            }


            CriteriaBuilder builder = hibernateSession.getCriteriaBuilder();
            CriteriaQuery<LaptopEntity> criteria = builder.createQuery(LaptopEntity.class);
            criteria.from(LaptopEntity.class);
            List<LaptopEntity> laptops = hibernateSession.createQuery(criteria).getResultList();

            laptops.forEach((r) ->  {
                System.out.println(
                        "r: " + r.getId() +
                                " name:" + r.getName() +
                                " price:" + r.getPrice()
                );
            });

            hibernateSession.getTransaction().commit();
        } catch(Exception sqlException) {
            if (null != hibernateSession.getTransaction()) {
                hibernateSession.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (hibernateSession != null) {
                hibernateSession.close();
            }
        }
    }
}
