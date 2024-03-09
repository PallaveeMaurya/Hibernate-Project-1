package in.pwskills.nitin.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.pwskills.nitin.entity.Employee;

public class TestApp {

	public static void main(String[] args) {
		 
		Employee emp= new Employee();
		emp.setId(10);
		emp.setName("Sachin");
		emp.setAge(49);
		emp.setAddress("MI");
		
		//Activate the HIBERNATE software
		Configuration configuration=new Configuration();
		
		//load hibernate.cfg.xml file into configuration object
		configuration.configure();
		
		//Build sessionFactory object using configuration object
		//[load driver, establish connection, create PreparedStatement]
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		
		//To perform operation(task) create one session object using sessionFactory
		Session session=sessionFactory.openSession();
		
		//Begin the transaction w.r.t particular session
		Transaction transaction= session.beginTransaction();
		
		//Perform insert operation
		session.save(emp);
		
		//Commit the operation
		transaction.commit();
		
		//Close the session
		session.close();
	}

}
