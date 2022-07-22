package com.karaarslan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karaarslan.hibernate.demo.entity.Course;
import com.karaarslan.hibernate.demo.entity.Instructor;
import com.karaarslan.hibernate.demo.entity.InstructorDetail;
import com.karaarslan.hibernate.demo.entity.Review;
import com.karaarslan.hibernate.demo.entity.Student;

public class AddCoursesForErhanDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class).addAnnotatedClass(Review.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// get the student erhan from database

			int theId = 1;

			Student tempStudent = session.get(Student.class, theId);

			System.out.println("\nLoad student : " + tempStudent);
			System.out.println("Course : " + tempStudent.getCourses());

			// create more courses

			Course tempCourse1 = new Course("XYZ102");
			Course tempCourse2 = new Course("ABC103");

			// add student to courses

			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);

			// save the courses
			System.out.println("\nSaving courses...");

			session.save(tempCourse1);
			session.save(tempCourse2);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}
	}

}