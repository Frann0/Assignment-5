package sample;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    //initialisere vores Liste gradeReport til et nyt ArrayList objekt, som kun kan indeholde GradeInfo objekter.
    //fungere på samme måde som vores persons liste i PersonManager klassen.
    private List<GradeInfo> gradeReport = new ArrayList<>();
    private String education;

    public Student(int id,String name,String education){
        //Vi bruger super() funktionen, da vi nedarver fra Person klassen. Og da den har en
        //constructer hvor den skal have et ID og et name i dens parametre, skal vi kalde den her.
        super(id,name);
        //sætter vores lokale variable(den ovenfor private String education) til at være den variable
        //vi får igennem vores constructers parametre. Derfor bruger vi this.* for at signalere
        //at vi sætter this, altså denne her klasses variable Education til at være parametren education.
        this.education = education;
    }

    //Overflødig kode fra UML igen, bliver aldrig kaldt.
    public List<GradeInfo> getGradeReport() {
        return gradeReport;
    }

    //returner værdien af vores education variable. this.* er overflødigt her, men det er nemmere at
    //gennemskue hvilken variable man snakker om (IN MY OPINION). education ville være længe fint at skrive her.
    public String getEducation(){
        return this.education;
    }

    //Returnere vores gennemsnitlige karakter.
    //går sådan set bare igennem alle værdier i vores liste gradeReport.
    //og så tilføjer vi det til vores allGrades variable. Til sidst regner vi jo bare gennemsnittet ud
    //ved at dividere den værdi med antallet af vores fag.
    public double getAverageGrade(){
        int allGrades = 0;
        //totalSubjects er mængden af fag vi har. Aka størrelsen af vores liste.
        int totalSubjects = gradeReport.size();
        for (GradeInfo gradeInfo : gradeReport) {
            allGrades += (double) gradeInfo.getGrade();
        }
        return allGrades/totalSubjects;
    }

    //Totalt dumt lavet, men det virker. Vi bruger vores for each loop igen
    //her går vi igennem alle elementer i vores liste, for at finde ud af om
    //den string "Subject" som er i parameteren til denne funktion, er en del af vores fag.
    //hvis den er det, så returnere den vores karakter i det fag.
    //her er det dumme. Hvis vi ikke har det Subject, så returnere den jo bare det første
    //fag i listens, karakter. Så hvis jeg havde spurgt efter en karakter i f.eks dansk, men jeg ikke havde dansk
    //så ville den tage karakteren der stod på den første plads i listen, det kunne være f.eks Engelsk.
    public int getGrade(String Subject){
        int index = 0;
        for (GradeInfo g:gradeReport) {
            if (g.getSubject().equals(Subject)){
                break;
            }
            index++;
        }
        return gradeReport.get(index).getGrade();
    }

    //Tilføjer en karakter specificeret af vores GradeInfo klasse.
    public void addGrade(GradeInfo grade){
        gradeReport.add(grade);
    }

    //toString bruges her for at vide hvad der skal displayes. I forhold til vores Student
    //skal den vise, ID, Navn, Email, Uddannelse og gennemsnitlige Karakter.
    public String toString(){
        //Vi bruger String.Format til at formatere stringen. Så der er regelmæssige mellemrum imellem tingene.
        //Det ser generelt bedre ud. For at give et generelt overblik over format formen så
        //kan man dele stringen op. For hver element bag stringen skal der være et % tegn
        //f.eks %-5s refere til getID() stringen. - tegnet refere til hvilken side den skal holde sig til. -betyder
        //at den skal holde sig til venstre margen, og hvis den ikke var der, så skal den holde sig til højre.
        //5 refere til hvor meget mellemrum der skal være bag den. Det er her det er brugbart for at holde en specifik
        //mellemrum mellem elementerne. s er bare datatypen den forventer det element har. s for String, d for Integer
        //f for Float, osv. baeldung.com/java-printstream-printf giver et godt overview over det.
        return String.format("%-5s%-10s%-30s%-10s%-5s", getId(), getName(), getEmail(), getEducation(), getAverageGrade());
        //return getId() + "  " + getName() + "   " + getEmail() + "  " + getEducation() + "   " + getAverageGrade();
    }

}
