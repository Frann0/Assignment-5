package sample;

import java.util.ArrayList;
import java.util.List;

public class PersonManager {
    //Vores lister af "Personer", "Teachers" og "Students"
    //Vi bruger Interfacet List, til at lave disse lister,
    //og initialisere dem med ArrayList. For at sikre vi ikke kan putte
    //en student i teacher listen, bruger vi <> til at specificere hvilket slags
    //objekt der kan være i listen. Det er ikke kun objekter der kan specificeres, men også
    //Integer for hele tal, eller Strings for strings osv.
    private List<Person> persons = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    //Overflødig kode, men skulle være der ifølge UML diagrammet.
    public PersonManager() {

    }

    //Endnu en overflødig funktion. Den bliver aldrig kaldt
    //men skulle være der i følge UML diagrammet.
    //Koden kan bruges til at finde en person i vores persons liste, med et specifikt ID
    public Person getPerson(int id){
        int index = 0;
        for (Person p : persons){
            if (p.getId() == id){
                return persons.get(index);
            }
            index++;
        }
        return null;
    }

    //Adder en Person p til vores persons liste. Hvis det givne ID ikke allerede eksistere i listen.
    public void addPerson(Person p){
        //Tjekker om persons er tom, hvis den er, skal den bare adde personen til listen.
        //da dens ID ikke allerede kan være taget.
        if (persons.isEmpty()){
            persons.add(p);
        }else {
            //Hvis ikke, så skal den sætten en boolean til at være false som standard. Den bliver brugt
            //længere nede i koden.
            boolean idExists = false;
            //Så går vi igennem alle personer i listen med et for each loop(Skal læses som 'For hver person i persons')
            //Det er et enhanced for loop, for at loope igennem objekter eller værdier i en liste nemt.
            //Den erstatter vores normale for(int i = 0; i < givenværdi; i++){} selvom man godt kunne bruge den her også.
            for (Person p1 : persons) {
                //tjekker om den person vi er kommet til, har det samme id som den person vi prøver at adde.
                if (p1.getId() == p.getId()) {
                    //DEBUG v
                    //System.out.println("Cant add a person with the same id");
                    //hvis det er samme id så skal den sætte booleanen til at være true.
                    idExists = true;
                    break;
                }
            }

            //Så checker vi til sidst om vores boolean er true eller false. Hvis den er false, så adder vi personen
            //til vores liste, hvis ikke. Så gør vi intet.
            if (!idExists){
                persons.add(p);
               // System.out.println("added Successfully");
            }
            //System.out.println(persons);
        }
    }

    //Overflødig UML Diagrams kode. Bliver heller aldrig kaldt, men kan bruges til at fjerne
    //en persone fra persons listen, med et specifikt id.
    public void removePerson(int id){
        int index = 0;
        for (Person p : persons){
            if (p.getId() == id){
                persons.remove(index);
            }
            index++;
        }
    }

    //Vores getter funktioner. De returnere egentligt bare listen af personer. teachers eller students.
    //bliver blandt andet brugt til at displaye de personer der er i listen i menu systemet.
    public List<Person> getAllPersons(){
        return persons;
    }
    public List<Teacher> getAllTeachers(){
        return teachers;
    }
    public List<Student> getAllStudents(){
        return students;
    }

    //Overflødig funktion. UML siger den skal være der, men bliver ikke kaldt af noget. Og har
    //ingen ide om hvad den skulle have gjordt heller.
    public void operation(){

    }

    //Copy paste af addPerson funktionen, for at adde teachers. Fungere nøjagtig på samme måde
    // bare med et andet for loop
    public void addTeacher(Teacher teacher1) {
        if (teachers.isEmpty()){
            teachers.add(teacher1);
        }else {
            boolean idExists = false;
            for (Teacher t1 : teachers) {
                if (t1.getId() == teacher1.getId()) {
                    //System.out.println("Cant add a teacher with the same id");
                    idExists = true;
                    break;
                }
            }

            if (!idExists){
                teachers.add(teacher1);
                //System.out.println("added Successfully");
            }
            //System.out.println(teachers);
        }
    }

    //samme som oven for. Fungere nøjagtig ens.
    public void addStudent(Student student1) {
        if (students.isEmpty()){
            students.add(student1);
        }else {
            boolean idExists = false;
            for (Student s1 : students) {
                if (s1.getId() == student1.getId()) {
                    //System.out.println("Cant add a student with the same id");
                    idExists = true;
                    break;
                }
            }

            if (!idExists){
                students.add(student1);
                //System.out.println("added Successfully");
            }
            //System.out.println(students);
        }
    }
}
