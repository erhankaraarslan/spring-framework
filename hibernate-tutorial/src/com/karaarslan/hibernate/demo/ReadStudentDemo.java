package com.karaarslan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karaarslan.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Hakan Efe", "Yüksel", "hakanefe@gmail.com");
			session.beginTransaction();

			System.out.println("Saving the student...");
			session.save(tempStudent);
			session.getTransaction().commit();
			System.out.println("Saved stundent. Generated id : " + tempStudent.getId());

			// new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("\nGetting student with id : " + tempStudent.getId());

			Student myStudent = session.get(Student.class, tempStudent.getId());

			System.out.println("Get complete : " + myStudent);

			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
