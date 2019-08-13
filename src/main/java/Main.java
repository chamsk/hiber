import entities.Address;
import entities.OTOAddress;
import entities.OTOPerson;
import entities.Student;
import enums.Days;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

/**
 * Created by Kor on 06.08.2019.
 */
public class Main {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try(SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            //session.save( new Student("Alex", Days.FRIDAY,new Date()));
//            Student load = session.load(Student.class,4);//поиск по id, если ид не найден выкинет objectnotfoundException
//            Student get = session.get(Student.class,4);//если ид не найдет, вернет null

//            Student fry = new Student("Fry", Days.MONDAY,new Date());
//            fry.setAddress(new Address("lenina",1));

           // session.save(fry);


            OTOAddress address = new OTOAddress("lenina");
            OTOPerson person = new OTOPerson("Vasya",address);

            session.persist(address);
            session.persist(person);

            session.getTransaction().commit();
            session.close();
        }

    }
}
