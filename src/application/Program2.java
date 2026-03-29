package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("\n=== TEST 1: insert ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());

		System.out.println("\n=== TEST 2: update ===");
		newDepartment = new Department(6, "Transport");
		departmentDao.update(newDepartment);
		System.out.println("Updated! New department = " + newDepartment.getName());

		System.out.println("\n=== TEST 3: deleteById ===");
		System.out.print("Enter the id for delete: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);

		System.out.println("\n=== TEST 4: findById ===");
		System.out.print("What's the department's id? ");
		id = sc.nextInt();
		Department dep = departmentDao.findById(id);
		System.out.println(dep);

		System.out.println("\n=== TEST 5: findAll ===");
		List<Department> list = departmentDao.findAll();

		for (Department obj : list) {
			System.out.println(obj);
		}

		sc.close();
	}

}
