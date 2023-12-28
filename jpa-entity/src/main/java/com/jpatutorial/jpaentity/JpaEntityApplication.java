package com.jpatutorial.jpaentity;

import com.jpatutorial.jpaentity.dependency_injection.CommunicationService;
import com.jpatutorial.jpaentity.dependency_injection.CustomerService;
import com.jpatutorial.jpaentity.dependency_injection.EmailService;
import com.jpatutorial.jpaentity.dependency_injection.SMSService;
import com.jpatutorial.jpaentity.repository.CourseRepository;
import com.jpatutorial.jpaentity.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaEntityApplication {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaEntityApplication.class, args);
    }

    @Bean
    ApplicationRunner thisWillRunAutomatically() {
        return args -> {
            System.out.printf("Inicializando\n");
//            List<Course> courses = new ArrayList<>();
//            courses.add(new Course("Data Structures"));
//            courses.add(new Course("Database Systems"));
//            courses.add(new Course("Operating Systems"));
//            courseRepository.saveAll(courses);
//            System.out.printf("Saved courses %s\n", courses.toString());

            // Dependency injection
            System.out.printf("Dependency injection\n");
            // ✖️Bad practice: CommunicationService is tightly coupled to EmailService
//            CommunicationService communicacionService = new CommunicationService();
            // ✔️Good practice: CommunicationService is loosely coupled to EmailService
            CommunicationService communicationService = new CommunicationService(new SMSService());
            CustomerService customerService = new CustomerService();


            List<String> customerNames = customerService.getCustomerNames();
            for (String customerName : customerNames) {
                System.out.printf(communicationService.sendService("Hello", customerName) + "\n");
            }
        };
    }

}
