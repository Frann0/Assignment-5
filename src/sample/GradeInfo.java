package sample;

public class GradeInfo {
    //måske trivielt viden, men måske godt nok at sige. Vi bruger private variabler i hver af vores klasser
    //og bruger Get og Set metoder til at få værdierne uden for denne klasse. Det gør vi pga Coupling eller Cohesion
    //kan fandme ikke finde rundt i det to. Men i forstår det nok.
    private String subject;
    private int grade;

    //Som de andre klasser, sætter vi i constructeren vores lokale værdier til dem der står i parametre.
    public GradeInfo(String subject, int grade){
        this.subject = subject;
        this.grade = grade;
    }

    //Get metode for at få karakteren for det specifike fag
    public int getGrade() {
        return this.grade;
    }

    //som oven for, en get metode for at få navnet for det fag associeret med et GradeInfo Objekt.
    public String getSubject() {
        return this.subject;
    }

    //Mener kun denne funktion blev brugt til DEBUG formål. Men var alligevel påkrævet
    //af UML diagrammet.
    public String toString(){
        return "Subject: " + getSubject() + " : " + getGrade();
    }
}
