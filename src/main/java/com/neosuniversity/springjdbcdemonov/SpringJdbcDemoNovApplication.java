package com.neosuniversity.springjdbcdemonov;

import com.neosuniversity.springjdbcdemonov.dao.EmployeeDAO;
import com.neosuniversity.springjdbcdemonov.domain.Employee;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@CommonsLog
public class SpringJdbcDemoNovApplication implements CommandLineRunner {

	@Autowired
	private EmployeeDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoNovApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Similar al metodo MAIN");

		Employee emp = new Employee(null,"Mario", "Hidalgo",
				"mario.hidalgo@yahoo.com.mx");

		dao.save(emp);

		List<Employee> list = dao.findAll();

		list.forEach(employee -> System.out.println(employee));


		// actualizacion

		Employee emp2 = new Employee(1,"HUGO", "HIDALGO",
				"HUGO@yahoo.com.mx");

		System.out.println("---------------------------");
		dao.update(emp2);
		list = dao.findAll();
		list.forEach(System.out::println);


		System.out.println("---------------------------");

		dao.delete(1);

		list = dao.findAll();
		list.forEach(System.out::println);




	}
}
