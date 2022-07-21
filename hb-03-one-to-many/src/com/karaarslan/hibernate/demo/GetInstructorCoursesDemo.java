package com.karaarslan.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karaarslan.hibernate.demo.entity.Course;
import com.karaarslan.hibernate.demo.entity.Instructor;
import com.karaarslan.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

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

			List<Course> courses = tempInstructor.getCourses();

			for (Course course : courses) {

				System.out.println(course);

			}

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}
	}

}
