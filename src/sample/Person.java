package sample;

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
        return getId() + "  " + getName() + "   " + getEmail();
    }
}
