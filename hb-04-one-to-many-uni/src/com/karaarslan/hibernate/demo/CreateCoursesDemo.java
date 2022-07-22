package com.karaarslan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karaarslan.hibernate.demo.entity.Course;
import com.karaarslan.hibernate.demo.entity.Instructor;
import com.karaarslan.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// get the instructor from db
			int theId = 1;

			Instructor tempInstructor = session.get(Instructor.class, theId);

			// create some courses
			Course course1 = new Course("MATH_101");
			Course course2 = new Course("MATH_102");

			// add courses to instructor
			tempInstructor.add(course1);
			tempInstructor.add(course2);

			// save the courses
			session.save(course1);
			session.save(course2);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}
	}

}
