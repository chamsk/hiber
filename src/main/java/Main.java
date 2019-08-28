import entities.*;
import enums.Days;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

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






            //            //MANY TO MANY

//
//            MTMPerson person = new MTMPerson("vova",13);
//            MTMPerson person1 = new MTMPerson("grisha",20);
//
//            MTMAddress address = new MTMAddress(16,"timStreet");
//            MTMAddress address1 = new MTMAddress(9,"timStreet");
//            MTMAddress address2 = new MTMAddress(1,"timStreet");
//            MTMAddress address3 = new MTMAddress(11,"timStreet");
//            List<MTMAddress> list = new ArrayList<MTMAddress>();
//            list.add(address);
//            list.add(address1);
//            List<MTMAddress> list1 = new ArrayList<MTMAddress>();
//            list1.add(address2);
//            list1.add(address3);
//            person.setList(list);
//            person1.setList(list1);
//            List<MTMPerson> personList = new ArrayList<>();
//            personList.add(person);
//            List<MTMPerson> personList1 = new ArrayList<>();
//            personList1.add(person1);
//            address.setPerson(personList);
//            address1.setPerson(personList);
//            address2.setPerson(personList1);
//            address3.setPerson(personList1);
//
//            session.persist(person);
//            session.persist(person1);
//            session.persist(address);
//            session.persist(address1);
//            session.persist(address2);
//            session.persist(address3);


//
//            //LOAD
//            MTMPerson mtmPerson = session.load(MTMPerson.class,25);
//            List<MTMAddress> addresses = mtmPerson.getList();





            //HQL

//            Query query = session.createQuery("from MTMPerson where id = 1");
//            MTMPerson person = (MTMPerson) query.uniqueResult();
//            System.out.println(person.getName());

//            Query query = session.createQuery("from MTMPerson ");
//            List<MTMPerson> persons = query.list();
//            for (MTMPerson p:persons) {
//                System.out.println(p.getName());
//            }

//            Query query = session.createQuery("from MTMPerson p order by p.age");
//            List<MTMPerson> persons = query.list();
//            for (MTMPerson p:persons) {
//                System.out.print(p.getName() + " ");
//                System.out.println(p.getAge());
//            }
//
//            Query query = session.createQuery("select p.age from MTMPerson p group by p.age having p.age = 222");
//            List<MTMPerson> persons = query.list();
//            for (MTMPerson p:persons) {
//                System.out.print(p.getName() + " ");
//                System.out.println(p.getAge());
//            }




            //CRUD
            //session.createQuery("insert into MTMPerson (age,name) select p.age+7 ,concat(p.name,'ww') from MTMPerson p where p.id = 2").executeUpdate();
            //session.save(fry);
            // session.createQuery("update MTMPerson p set p.age = 99 where p.id=1").executeUpdate();
            //session.createQuery("delete MTMPerson p where p.age = 13").executeUpdate();


            //NATIVE SQL
//            NativeQuery nativeQuery = session.createNativeQuery("select * from MTMPerson");
//            List<Object[]> list = nativeQuery.getResultList();
//            for (Object[] objects:list
//                 ) {
//                int i = (int)objects[0];
//                int age = (int)objects[1];
//                String name = (String)objects[2];
//                System.out.println(i + " " + age + " " + name);
//            }

//            NativeQuery nativeQuery = session.createNativeQuery("select * from MTMPerson",MTMPerson.class);
//            List<MTMPerson> list = nativeQuery.getResultList();
//            for (MTMPerson p:list
//                 ) {
//                System.out.println(p.getAge() + " " + p.getName());
//            }



           // Query query = session.createQuery("select MTMPerson from MTMPerson p left join MTMAddress a on(p.age = a.id)");






            session.getTransaction().commit();
            session.close();
        }

    }
}
