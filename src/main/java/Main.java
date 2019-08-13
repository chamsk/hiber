import entities.*;
import enums.Days;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


            //ONE TO ONE
//            OTOAddress address = new OTOAddress("lenina");
//            OTOPerson person = new OTOPerson("Vasya",address);
//
//            session.persist(address);
//            session.persist(person);


            //ONE TO MANY

            OTMPerson person = new OTMPerson("bill");
            List<OTMAddress> addresses = new ArrayList<>();
            addresses.add(new OTMAddress("UDMurtskaya"));
            addresses.add(new OTMAddress("Ryavazanava"));
            person.setAddresses(addresses);

            
            session.persist(person);
            session.persist(addresses);

            session.getTransaction().commit();
            session.close();
        }

    }
}
