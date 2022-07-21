package com.karaarslan.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karaarslan.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			// display the students
			displayStudents(theStudents);

			// query students: firstName='Merve'
			theStudents = session.createQuery("from Student s where s.firstName='Merve'").getResultList();
			System.out.println("Students who have first name of Merve");
			displayStudents(theStudents);

			// query students : firstName='Merve' OR lastName=Yüksel
			theStudents = session.createQuery("from Student s where" + " s.firstName='Merve' OR lastName='Yüksel'")
					.getResultList();
			System.out.println("Students who have first name of Merve or last name of Yüksel");
			displayStudents(theStudents);

			theStudents = session.createQuery("from Student s where" + " s.email LIKE '%arslan%'").getResultList();
			displayStudents(theStudents);

			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
