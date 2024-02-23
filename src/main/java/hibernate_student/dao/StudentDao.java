package hibernate_student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_student.dto.Student;

public class StudentDao {

	private EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shree");
		return entityManagerFactory.createEntityManager();
	}

	public void saveStudent(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}

	public Student fetchStudent(int id) {
		EntityManager entityManager = getEntityManager();
		Student student = entityManager.find(Student.class, id);
		if (student != null) {
			System.out.println(student);
			return student;
		} else {
			System.out.println("Student with the given id is not found");
			return null;
		}
	}

	public void updateStudent(Student updatedStudent) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student dbStudent = entityManager.find(Student.class, updatedStudent.getId());

		if (dbStudent != null) {
			entityTransaction.begin();
			entityManager.merge(updatedStudent);
			entityTransaction.commit();
		} else {
			System.out.println("Student with the given id is not found");
		}
	}

	public void deleteStudent(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student dbStudent = entityManager.find(Student.class, id);

		if (dbStudent != null) {
			entityTransaction.begin();
			entityManager.remove(dbStudent);
			entityTransaction.commit();
		} else {
			System.out.println("Student with the given id is not found");
		}
	}

	public void getAllStudents() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT s FROM Student s");
		List<Student> list = query.getResultList();
		System.out.println(list);
	}

	public void getStudent(long phone) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.phone=?1");
		query.setParameter(1, phone);
		try {
			Student student = (Student) query.getSingleResult();
			System.out.println(student);
		} catch (Exception e) {
			System.out.println("Student with phone "+phone+" not found");
		}

	}
	
	public void getStudent(String email) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.email=?1");
		query.setParameter(1, email);
		try {
			Student student = (Student) query.getSingleResult();
			System.out.println(student);
		} catch (Exception e) {
			System.out.println("Student with phone "+email+" not found");
		}

	}

}
