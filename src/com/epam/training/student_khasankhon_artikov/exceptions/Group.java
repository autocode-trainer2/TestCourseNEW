package com.epam.training.student_khasankhon_artikov.exceptions;

import java.util.HashSet;
import java.util.Set;

public class Group {
    public String name;
    private Set<Student> students = new HashSet<>();

    public Group(String name) {
        this.name = name;
    }

    public boolean hasStudent() throws StudentNotExistsException {
        if (this.students.size() != 0) {
            return true;
        } else {
            throw new StudentNotExistsException("Each Group must have at least one Student.");
        }
    }


    public Set<Student> getStudents() {
        return this.students;
    }

    public void addStudents(Student student) {
        this.students.add(student);
    }

    public void calculateAverageScoreOfSubject(Subject chosenSubject) throws StudentNotExistsException, SubjectNotExistsException {
        if (hasStudent()) {
            float sumOfScore = 0;
            int countOfSubjects = 0;
            for (Student student : students) {
                if (student.hasSubject() && student.getSubjects().containsKey(chosenSubject)) {
                    sumOfScore += (Integer) student.getSubjects().get(chosenSubject);
                    countOfSubjects++;
                }
            }
            float result;
            if (countOfSubjects > 0){
            result = sumOfScore / countOfSubjects;}
            else {result = 0; }
            System.out.println("Group{name='" + name + "' Subject='" + chosenSubject.name + "', AverageScore=" + result + "}");

        }
    }


    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
