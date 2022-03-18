package com.epam.training.student_khasankhon_artikov.exceptions;

import java.util.HashSet;
import java.util.Set;

public class Faculty {
    public String name;
    private Set<Group> groups = new HashSet<>();

    public Faculty(String name) {
        this.name = name;
    }

    public boolean hasGroup() throws GroupNotExistsException {
        if (this.groups.size() != 0) {
            return true;
        } else {
            throw new GroupNotExistsException("Each Faculty must have at least one Group.");
        }
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) {
        this.groups.add(group);
    }

    public void calculateAverageScoreOfSubject(Subject chosenSubject) throws GroupNotExistsException,
            StudentNotExistsException, SubjectNotExistsException {
        if (hasGroup()) {
            float sumOfScore = 0;
            int countOfSubjects = 0;
            for (Group group : this.groups) {
                if (group.hasStudent()) {
                    for (Student student : group.getStudents()) {
                        if (student.hasSubject() && student.getSubjects().containsKey(chosenSubject)) {
                            sumOfScore += (Integer) student.getSubjects().get(chosenSubject);
                            countOfSubjects++;
                        }
                    }
                }
            }
            float result;
            if (countOfSubjects > 0) {
                result = sumOfScore / countOfSubjects;
            } else {
                result = 0;
            }
            System.out.println("Faculty{name='" + name + "' Subject='" + chosenSubject.name + "', AverageScore=" + result + "}");

        }
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", groups=" + groups +
                '}';
    }
}
