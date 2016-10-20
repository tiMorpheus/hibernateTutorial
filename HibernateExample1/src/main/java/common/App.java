package common;

import common.model.User;
import common.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class App {

    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        User user = new User();

        user.setUserId(1);
        user.setUsername("Tymur");
        user.setCreatedBy("system");
        user.setCreatedDate(new Date());

        session.save(user);
        session.getTransaction().commit();
    }
}
