package sample;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{
    //fungere på samme måde som Person eller Student, hvor vi laver en Liste hvor i der kun kan komme
    //Strings i dette tilfælde.
    private List<String> subjects = new ArrayList<>();
    private String initials;
    private double salary;

    public Teacher(int id, String name, String initials) {
        //som Student, bruger vi super fordi vi nedarver fra Person.
        //og da Person klassen allerede har en constructer, hvor i den skal bruge
        //et ID og et navn, skal vi gøre det samme her.
        super(id, name);
        this.initials = initials;
    }

    //Returnere listen af fag som denne lære har.
    public List<String> getSubjects(){
        return subjects;
    }

    //returnere vores læres initialer fra vores lokale variable.
    public String getInitials(){
        return initials;
    }

    //overflødig UML diagrams kode.
    public double getSalary() {
        return salary;
    }

    //Her tilføjer vi et fag som denne lære underviser i til vores liste.
    public void addSubjects(String subject){
        subjects.add(subject);
    }

    //Tilføjer hvilken løn vores lære for.
    public void addSalary(double salary){
        this.salary = salary;
    }

    //returnere hvad der skal displayes når vi vil se vores lærere. Her er det ID, navn, email, initialer og
    //vores lærers hovedfag. Beskrevet på moodle som at være det første element i vores læres fag liste, AKA index 0.
    @Override
    public String toString() {
        //Vi bruger String.Format til at formatere stringen. Så der er regelmæssige mellemrum imellem tingene.
        //Det ser generelt bedre ud. For at give et generelt overblik over format formen så
        //kan man dele stringen op. For hver element bag stringen skal der være et % tegn
        //f.eks %-5s refere til getID() stringen. - tegnet refere til hvilken side den skal holde sig til. -betyder
        //at den skal holde sig til venstre margen, og hvis den ikke var der, så skal den holde sig til højre.
        //5 refere til hvor meget mellemrum der skal være bag den. Det er her det er brugbart for at holde en specifik
        //mellemrum mellem elementerne. s er bare datatypen den forventer det element har. s for String, d for Integer
        //f for Float, osv. baeldung.com/java-printstream-printf giver et godt overview over det.
        return String.format("%-5s%-10s%-20s%-10s%-5s", getId(), getName(), getEmail(), getInitials(), getSubjects().get(0));
        //return getId() + "  " + getName() + "   " + getEmail() + "  " + getInitials() + "   " + getSubjects().get(0);
    }
}
