package com.epam.training.student_khasankhon_artikov.exceptions;

public class main_task {
    public static void main(String[] args) throws ScoreLimitException,
            SubjectNotExistsException, StudentNotExistsException, GroupNotExistsException {

        Subject physics = new Subject("Physics");
        Subject chemistry = new Subject("Chemistry");
        Subject engineering = new Subject("Engineering");
        Subject economics = new Subject("Economics");
        Student james = new Student("James");

        james.addSubjects(physics, 9);
        james.addSubjects(chemistry, 6);
        james.addSubjects(engineering, 7);

        Student thomas = new Student("Thomas");
        thomas.addSubjects(physics, 6);
        thomas.addSubjects(economics, 8);

        Student henry = new Student("Henry");
        henry.addSubjects(chemistry, 8);
        henry.addSubjects(physics, 8);
        henry.addSubjects(economics, 9);

        Student tina = new Student("Tina");
        tina.addSubjects(economics, 10);
        tina.addSubjects(physics, 8);
        tina.addSubjects(chemistry, 7);

        Group teenagersGroup = new Group("Teenagers");
        teenagersGroup.addStudents(james);
        teenagersGroup.addStudents(thomas);
        teenagersGroup.calculateAverageScoreOfSubject(engineering);

        Group newTeenagersGroup = new Group("New Teenagers");
        newTeenagersGroup.addStudents(henry);
        newTeenagersGroup.addStudents(tina);

        Faculty facultyOfEngineers = new Faculty("Engineers");
        facultyOfEngineers.addGroup(teenagersGroup);
        facultyOfEngineers.calculateAverageScoreOfSubject(physics);

        Faculty facultyOfEconomics = new Faculty("Economics");
        facultyOfEconomics.addGroup(newTeenagersGroup);

        University myUniversity = new University("myUniversity");
        myUniversity.addFaculty(facultyOfEngineers);
        myUniversity.addFaculty(facultyOfEconomics);
        myUniversity.calculateAverageScoreOfSubject(physics);
    }
}
