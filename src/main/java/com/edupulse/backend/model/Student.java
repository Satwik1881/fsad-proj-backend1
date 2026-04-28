package com.edupulse.backend.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String grade;
    private Integer attendance;

    @ElementCollection
    @CollectionTable(name = "student_subjects", joinColumns = @JoinColumn(name = "student_id"))
    @MapKeyColumn(name = "subject_name")
    @Column(name = "score")
    private Map<String, Integer> subjects = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "student_history", joinColumns = @JoinColumn(name = "student_id"))
    private List<MonthlyPerformance> history = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "student_recommendations", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "`recommendation`")
    private List<String> recommendations = new ArrayList<>();

    public Student() {}

    public Student(Long id, String name, String email, String grade, Integer attendance, Map<String, Integer> subjects, List<MonthlyPerformance> history, List<String> recommendations) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.grade = grade;
        this.attendance = attendance;
        this.subjects = subjects;
        this.history = history;
        this.recommendations = recommendations;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public Integer getAttendance() { return attendance; }
    public void setAttendance(Integer attendance) { this.attendance = attendance; }
    public Map<String, Integer> getSubjects() { return subjects; }
    public void setSubjects(Map<String, Integer> subjects) { this.subjects = subjects; }
    public List<MonthlyPerformance> getHistory() { return history; }
    public void setHistory(List<MonthlyPerformance> history) { this.history = history; }
    public List<String> getRecommendations() { return recommendations; }
    public void setRecommendations(List<String> recommendations) { this.recommendations = recommendations; }
}
