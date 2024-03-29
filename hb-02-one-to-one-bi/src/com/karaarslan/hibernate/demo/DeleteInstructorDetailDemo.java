package com.karaarslan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karaarslan.hibernate.demo.entity.Instructor;
import com.karaarslan.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
//			
			// start transaction
			session.beginTransaction();

			// get the instructor detail object
			int theId = 3;

			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			// print the instructor detail
			System.out.println("tempInstructorDetail : " + tempInstructorDetail);
			// print the associated instructor
			System.out.println("the associated instructor : " + tempInstructorDetail.getInstructor());

			// delete the instructor detail
			System.out.println("Deleting tempInstructorDetail : " + tempInstructorDetail);

			// remove the associated object reference
			// break bi-directional link
			tempInstructorDetail.getInstructor().setinstructorDetail(null);
			session.delete(tempInstructorDetail);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
