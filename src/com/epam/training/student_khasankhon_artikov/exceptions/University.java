package com.epam.training.student_khasankhon_artikov.exceptions;

import java.util.HashSet;
import java.util.Set;

public class University {
    public String name;
    private Set<Faculty> faculties = new HashSet<>();

    public University(String name) {
        this.name = name;
    }

    public boolean hasFaculty() throws GroupNotExistsException {
        if (this.faculties.size() != 0) {
            return true;
        } else {
            throw new GroupNotExistsException("Each University must have at least one Faculty.");
        }
    }

    public Set<Faculty> getFaculties() {
        return this.faculties;
    }

    public void addFaculty(Faculty faculty) {
        this.faculties.add(faculty);
    }

    public void calculateAverageScoreOfSubject(Subject chosenSubject) throws GroupNotExistsException,
            StudentNotExistsException, SubjectNotExistsException {
        if (hasFaculty()) {
            float sumOfScore = 0;
            int countOfSubjects = 0;
            for (Faculty faculty : faculties) {
                if (faculty.hasGroup()) {
                    for (Group group : faculty.getGroups()) {
                        if (group.hasStudent()) {
                            for (Student student : group.getStudents()) {
                                if (student.hasSubject() && student.getSubjects().containsKey(chosenSubject)) {
                                    sumOfScore += (Integer) student.getSubjects().get(chosenSubject);
                                    countOfSubjects++;
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}

