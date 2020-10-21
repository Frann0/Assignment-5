package sample;

import java.util.Formatter;

//En af opgaverne gik ud på at skulle gøre Person abstract og opservere hvad det gjorde ved programmet
//Det ville breake programmet, da du ikke kan lave objekter fra en abstract klasse.
//Vi laver nemlig objekter fra Person i vores Main klasse. Så den ville ikke lade os compile.
public class Person {
    private int id;
    private String name;
    private String email;

    //constructeren for vores Person klasse, tager 2 argumenter ind som parametre.
    //id og name. Her følger vi igen UML diagrammet, da jeg mener det var ret relevant at have Email her også
    //men det stod der ikke i diagrammet, så det har jeg ikke tilføjet her heller.
    public Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    //Standard getter og setter funktioner. returnere vores variabler, eller sætter dem.
    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    //Overflødig kode, men igen, det stod der i UML diagrammet, så det er tilføjet.
    public void setName(String name) {
        this.name = name;
    }

    //Vi bruger den her funktion til at sætte vores email. Da det ikke bliver gjort i constructeren.
    //Hvis ikke vi kalder den her funktion når vi laver et Person objekt, så ville email variablen være Null.
    public void setEmail(String email) {
        this.email = email;
    }

    //Displayer hvad der skal displayes for Person. I dette tilfælde skal det bare være ID'et, navn og email.
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
        return String.format("%-5d%-15s%-35s", getId(), getName(), getEmail());
    }
}
