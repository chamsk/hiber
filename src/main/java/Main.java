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



//            session.save( new Student("Alex", Days.FRIDAY,new Date()));
//            Student load = session.load(Student.class,4);//поиск по id, если ид не найден выкинет objectnotfoundException
//            Student get = session.get(Student.class,4);//если ид не найдет, вернет null

//            Student fry = new Student("Fry", Days.MONDAY,new Date());
//            fry.setAddress(new Address("lenina",1));
//
//            session.save(fry);


//           // ONE TO ONE

//            OTOAddress address = new OTOAddress("lenina");
//            OTOPerson person = new OTOPerson("Vasya",address);
//
//            session.persist(address);
//            session.persist(person);



//            //ONE TO MANY
//
//            OTMAddress address = new OTMAddress("Compilicionna9");
//            OTMAddress address2 = new OTMAddress("Compilicionna0");
//            OTMPerson otmperson = new OTMPerson("bill");
//            address.setPerson(otmperson);
//            address2.setPerson(otmperson);
//            List<OTMAddress> addresses = new ArrayList<>();
//            addresses.add(address);
//            addresses.add(address2);
//            otmperson.setAddresses(addresses);
//
//
//            session.persist(otmperson);
//            session.persist(address);
//            session.persist(address2);
//





            //MANY TO MANY

            MTMPerson person = new MTMPerson("Ivan",17);
            MTMPerson person1 = new MTMPerson("Shisha",24);

            MTMAddress address = new MTMAddress(16,"timStreet");
            MTMAddress address1 = new MTMAddress(9,"timStreet");
            MTMAddress address2 = new MTMAddress(1,"timStreet");
            MTMAddress address3 = new MTMAddress(11,"timStreet");
            List<MTMAddress> list = new ArrayList<MTMAddress>();
            list.add(address);
            list.add(address1);
            List<MTMAddress> list1 = new ArrayList<MTMAddress>();
            list1.add(address2);
            list1.add(address3);
            person.setList(list);
            person1.setList(list1);
            List<MTMPerson> personList = new ArrayList<>();
            personList.add(person);
            List<MTMPerson> personList1 = new ArrayList<>();
            personList1.add(person1);
            address.setPerson(personList);
            address1.setPerson(personList);
            address2.setPerson(personList1);
            address3.setPerson(personList1);

            session.persist(person);
            session.persist(person1);
            session.persist(address);
            session.persist(address1);
            session.persist(address2);
            session.persist(address3);



            //LOAD
            MTMPerson mtmPerson = session.load(MTMPerson.class,25);
            List<MTMAddress> addresses = mtmPerson.getList();


            session.getTransaction().commit();
            session.close();
        }

    }
}
