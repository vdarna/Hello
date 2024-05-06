package com.example.department;

import com.example.department.entity.Department;
import com.example.department.entity.PropertyCheckPassword;
import com.example.department.repository.DepartmentRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class DepartmentApplication {

	public static void main(String[] args) {

		BeanFactory context = SpringApplication.run(DepartmentApplication.class, args);

		DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);

		Set<Integer> ids = new HashSet<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		ids.add(4);
		List<Department> departments = departmentRepository.findInfoByIds(ids);

		System.out.println("department Name ::::::"+departments.size());
	}

	@Bean(name = "asyncExecutor")
	public Executor asyncExecutor()
	{
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(3);
		executor.setMaxPoolSize(3);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("AsynchThread-");
		executor.initialize();
		return executor;
	}
}
