package codejava.dao;

import codejava.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.TypedQuery;
import java.util.List;

@PropertySource("classpath:db.properties")
@Repository
public class CarDaoImp implements codejava.dao.CarDao {

    @Autowired
    private Environment env;

    private final SessionFactory sessionFactory;

    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("value")
    public List<Car> listCars(int counter) {
        int resultCount = Integer.parseInt(env.getProperty("db.maxCount"));
        System.out.println(resultCount);
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("FROM Car");
        if (counter < resultCount){
            resultCount=counter;
        }
        query.setMaxResults(resultCount);
        return query.getResultList();
    }

}
