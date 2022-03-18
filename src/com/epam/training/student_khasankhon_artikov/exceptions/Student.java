package com.epam.training.student_khasankhon_artikov.exceptions;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private Map subjects = new HashMap();

    public Student(String name) {
        this.name = name;
    }

    public boolean hasSubject() throws SubjectNotExistsException {
        if (this.subjects.size() != 0) {
            return true;
        } else {
            throw new SubjectNotExistsException("Each Student must have at least one Subject.");
        }
    }

    public Map getSubjects() {
        return subjects;
    }

    public void addSubjects(Subject subject, int score) throws ScoreLimitException {
        if (score >=0 && score <= 10) {
            this.subjects.put(subject, score);
        } else {
            throw new ScoreLimitException("The Score for the Subject should be from 0 to 10.");
        }
    }


    public void calculateAverageScore() throws SubjectNotExistsException {
        float sumOfScore = 0;
        for (Object key : subjects.keySet()) {
            sumOfScore += (Integer) subjects.get(key);
        }
        float result = sumOfScore / this.subjects.size();

        System.out.println("Student{name='" + name + "', AverageScore=" + result + "}");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
