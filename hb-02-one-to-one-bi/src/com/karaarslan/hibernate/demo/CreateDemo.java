package com.karaarslan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karaarslan.hibernate.demo.entity.Instructor;
import com.karaarslan.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
//			// create the objects
//			Instructor tempInstructor = new Instructor("Erhan", "Karaarslan", "erhannkaraarslan@gmail.com");
//
//			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.erhanka.com/youtube",
//					"software tech");

			// create the objects
			Instructor tempInstructor = new Instructor("Merve", "Karaarslan", "merveekaraarslan@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.merveka.com/youtube",
					"watching series");

			// associate the objects
			tempInstructor.setinstructorDetail(tempInstructorDetail);

			// start transaction
			session.beginTransaction();

			// save instructor
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			System.out.println("Saving instructor : " + tempInstructor);
			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
