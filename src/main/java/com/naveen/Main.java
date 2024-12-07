package com.naveen;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;


/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sf = configuration.buildSessionFactory();

        Session session = sf.openSession();

        try {

            System.out.println("=== Emp name == nav1 ====");

            Criteria criteria = session.createCriteria(Customer.class);
            criteria.add(Restrictions.eq("name", "nav1"));
            List<Customer> customers =  criteria.list();
            for (Customer customer: customers){
                System.out.println(customer);
            }

            System.out.println("=======Greater than 3+++=======");

            Criteria criteria1 = session.createCriteria(Customer.class);
            criteria1.add(Restrictions.gt("id", 3));
            List<Customer> employee1 = criteria1.list();
            for (Customer customer: employee1){
                System.out.println(customer);
            }

            System.out.println("=========Less than 4===========");


            Criteria criteria2 = session.createCriteria(Customer.class);
            criteria2.add(Restrictions.lt("id", 3));
            List<Customer>  customers2 = criteria2.list();
            for (Customer customer: customers2){
                System.out.println(customer);
            }

            System.out.println("===== list b/w 1,3");

            Criteria criteria3 = session.createCriteria(Customer.class);
            criteria3.add(Restrictions.between("id", 1, 3));
            List<Customer> customers3 = criteria3.list();
            for (Customer customer: customers3){
                System.out.println(customer);
            }


        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }

        finally {
            sf.close();
            sf.close();
        }

    }
}
