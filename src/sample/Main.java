package sample;

import java.io.IOException;


//Vi bruger vores Main klasse som "Test klasse" som beskrevet i exercise 1. Man kunne sagtens
//have lavet en anden java classe og så bare have kaldt den her, men det er i regelen det samme.
//måske en del mindre rod i Main klassen, men ja. Smag og behag.
public class Main {
    //Initialisere vores PersonManager
    public static PersonManager pm = new PersonManager();

    //initialisere vores personer, teacher og students.
    public static Person test1 = new Person(100, "Hans Peter");
    public static Person test2 = new Person(101, "Hans ole");
    public static Person test3 = new Person(102, "Hans Jørgen");
    public static Teacher teacher1 = new Teacher(103, "REEEE", "RE");
    public static Student student1 = new Student(104,"Mike", "CS");

    public static void main(String[] args) throws IOException {
        //Duplicate ID check - Helt sikkert en bedre måde at gøre det på. stream.distinct() måske
        pm.addPerson(test1);
        Person test4 = new Person(100,"Hans");
        pm.addPerson(test4);

        //Sætter emails til vores 3 Personer, og adder dem til vores personmanagers person list.
        test1.setEmail("HansPeter@gmail.com");
        test2.setEmail("HansOle@gmail.com");
        test3.setEmail("HansJørgen@gmail.com");
        pm.addPerson(test1);
        pm.addPerson(test2);
        pm.addPerson(test3);

        //Sætter vores teachers ting, så som email osv. og adder den til vores personmanagers teacher list.
        teacher1.setEmail("REEE@gmail.com");
        teacher1.addSalary(100);
        teacher1.addSubjects("Crying");
        pm.addTeacher(teacher1);

        //sætter vores students ting, og adder den til vores personmanagers student list.
        student1.addGrade(new GradeInfo("sco", 12));
        student1.getGrade("sco");
        student1.setEmail("mikehovedskov@gmail.com");
        pm.addStudent(student1);

        //Initialisere vores main menu, og starter den.
        MainMenu mm = new MainMenu("Main Menu!",new String[]{"Print Persons", "Print Teachers", "Print Students"}, pm);
        mm.run();
    }
}
