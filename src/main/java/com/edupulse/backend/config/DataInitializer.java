package com.edupulse.backend.config;

import com.edupulse.backend.model.Student;
import com.edupulse.backend.model.User;
import com.edupulse.backend.repository.StudentRepository;
import com.edupulse.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, StudentRepository studentRepository) {
        return args -> {
            // Check if users already exist to avoid duplicates
            // Ensure Teacher exists
            User teacher = userRepository.findByEmail("teacher@edu.com").orElse(null);
            if (teacher == null) {
                teacher = new User(null, "Dr. Sarah Wilson", "teacher@edu.com", "admin123", "teacher");
                userRepository.save(teacher);
                System.out.println("✅ Demo teacher initialized: teacher@edu.com / admin123");
            } else if (!"admin123".equals(teacher.getPassword())) {
                teacher.setPassword("admin123");
                userRepository.save(teacher);
                System.out.println("✅ Demo teacher password reset to admin123");
            }

            // Ensure Alex exists
            if (userRepository.findByEmail("alex@edu.com").isEmpty()) {
                User studentUser = new User(null, "Alex Johnson", "alex@edu.com", "student123", "student");
                userRepository.save(studentUser);
                System.out.println("✅ Demo student initialized: alex@edu.com / student123");
            }

            if (studentRepository.count() == 0) {
                // Initialize Student Record for the Dashboard
                Student alex = new Student();
                alex.setName("Alex Johnson");
                alex.setEmail("alex@edu.com");
                alex.setGrade("10th");
                alex.setAttendance(95);
                
                Map<String, Integer> subjects = new HashMap<>();
                subjects.put("Mathematics", 88);
                subjects.put("Science", 92);
                subjects.put("English", 85);
                subjects.put("History", 78);
                subjects.put("Arts", 95);
                alex.setSubjects(subjects);
                
                studentRepository.save(alex);
                System.out.println("✅ Student record for Alex Johnson created.");
            }
        };
    }
}
