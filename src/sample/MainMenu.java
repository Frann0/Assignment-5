package sample;

import java.util.List;

//Vores MainMenu ned arver fra Menu som er denne her abstracte klasse for vores menu system.
//Og fordi den er abstract kan der være metoder som skal implementeres, ligesom ved interfaces.
//i dette tilfælde vil det være doAction som skal være der. Den er forklaret når vi når der til.
public class MainMenu extends Menu {
    //Vi laver lister til vores Persons, Teachers og Students, som vi får fra vores Constructer.
    public List<Person> persons;
    public List<Teacher> teachers;
    public List<Student> students;

    //Vi laver en reference til et PersonManager object som vi får fra vores constructor også.
    //Det er vigtigt at vi ikke bare laver et nyt objekt, da alle vores lister osv. er sat i vores Mains PersonManager.
    //forklaring kommer i constructoren.
    public PersonManager pm;

    /**
     * Creates an instance of the class with the given header text and
     * menu options.
     *
     * @param header    The header text of the menu.
     * @param menuItems The list of menu items texts.
     */
    public MainMenu(String header, String[] menuItems, PersonManager pm) {
        super(header, menuItems);

        //som vi kan se, så er der et ekstra element i vores constructers Parametre, som ikke stammer fra
        //vores abstracte Menu klasse. Nemlig PersonManageren.

        //For at vi får de samme lister som vi lavede i Main klassen, så sætter vi dem her, når vi har
        //en reference til det samme PersonManager objekt vi brugte i Main.
        //kan være rimeligt forvirrende, i know. Skriv hvis ikke i fatter det, ellers så lige hiv fat i mig i skolen :P
        persons = pm.getAllPersons();
        teachers = pm.getAllTeachers();
        students = pm.getAllStudents();
        this.pm = pm;
    }

    //Vi implementere vores doAction funktion som i følge vores abstracte klasse skulle implementeres her.
    @Override
    protected void doAction(int option) {
        //simple switch, vi tjekker hvilken option vi har valgt. Per default ville den skrive
        //"enter option" da vi starter med en option på -1. Når vi så har valgt et tal, så gør
        //den noget forskelligt alt efter hvilket tal der er valgt.
        //Man kan opnå det samme med en if else blok, men når vi har mere end 3-4 forskellige
        //cases så er det mere læsbart at bruge en switch.
        switch (option) {
            case 1: //Hvis den er 1 så kalder vi funktionen printPersons() som er beskrevet neden for.
                printPersons();
                break; // og så husker vi at breake ud af switchen når det er gjort.
            //hvis vi ikke gør det, så ville den bare forsætte ned og execute den kode der er nedenfor,
            //indtil den enten rammer en break; eller den afsluttende "}". Alt det her, gør sig gælden
            //resten af switch casene også.
            case 2:
                printTeachers();
                break;
            case 3:
                printStudents();
                break;
            default: //som beskrevet ovenfor, så er det vores default statement, så hvis det tal vi har valgt
                //(Selvom det er umuligt) ville den skrive dette ud i consolen. Dette bliver brugt til at starte med
                //fordi vores option er -1. Lige så snart du skriver et tal, ville det være mellem 0-3.
                System.out.println("Enter option");
        }
    }

    //Resten af funktionerne, er sådan set bare for at printe ud hvad der er i vores lister og displaye dem på skærmen.
    //man kan altid lege med spacingen osv. for at få det til at se pænt ud. De fungere alle på samme måde
    //bare med forskellige lister, alt efter om man valgte Personer, teachers eller students.
    private void printStudents() {
        System.out.println("ID  Name    Email               Education    AVG. GRADE");
        for (Student s : students) {
            System.out.println(s.toString());
        }
    }

    private void printPersons() {
        System.out.println("ID      Name    Email");
        for (Person p : persons) {
            System.out.println(p.toString());
        }
    }

    private void printTeachers() {
        System.out.println("ID  Name    Email   Initials    MAIN");
        for (Teacher t : teachers) {
            System.out.println(t.toString());
        }
    }
}
