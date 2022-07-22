package com.karaarslan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.karaarslan.hibernate.demo.entity.Course;
import com.karaarslan.hibernate.demo.entity.Instructor;
import com.karaarslan.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// option 2: Hibernate query with HQL

			// get the instructor from db
			int theId = 1;

			Query<Instructor> query = session.createQuery(
					"select i from Instructor i " + "JOIN FETCH i.courses " + "where i.id=:theInstructorId",
					Instructor.class);

			// set parameter on query
			query.setParameter("theInstructorId", theId);

			// execute query and get instructor

			Instructor tempInstructor = query.getSingleResult();
			System.out.println("Instructor : " + tempInstructor);

			// commit transaction
			session.getTransaction().commit();

			// close the session
			session.close();
			System.out.println("\nThe session is now closed!\n");
			System.out.println("Courses : " + tempInstructor.getCourses());

//			Instructor tempInstructor = session.get(Instructor.class, theId);
//			System.out.println("Instructor : " + tempInstructor);
//			System.out.println("Courses : " + tempInstructor.getCourses());
//			// commit transaction
//			session.getTransaction().commit();
//			session.close();
//			System.out.println("\nThe session is now closed!\n");
//
//			// option 1: call getter method while session is open
//			System.out.println("Courses : " + tempInstructor.getCourses());

			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}
	}

}
