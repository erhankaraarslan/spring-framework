package com.karaarslan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karaarslan.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			System.out.println("Creating new student object...");
			Student student1 = new Student("Erhan", "Karaarslan", "erhannkaraarslan@gmail.com");
			Student student2 = new Student("Merve", "Karaarslan", "mervekaraarslan@gmail.com");
			Student student3 = new Student("Karamel", "Karaarslan", "goldenKaramel@gmail.com");
			session.beginTransaction();

			System.out.println("Saving the student...");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
