/**
 * Abstract class implementing the basic functionality of a console based
 * menu class. A menu can be created by sub-classing this class and implement
 * the abstract method doAction(option).
 * <p>
 * The constructor of the sub-class must invoke the super-class constructor by
 * the instruction
 * <p>
 * super(“some header”, “menuoption1", "menuoption2");
 * <p>
 * Note, that this instruction must be the first instruction of the sub-class
 * constructor.
 *
 * @author bhp
 */
package sample;

import java.util.Scanner;

//Her bliver det en smule tricky. Er heller ikke helt sikker på i hvilken sammenhæng
//han vil have os til at bruge den her abstracte klasse til. Men det jeg har gjort virker, og giver
//relativt mening IMO.

//Det meste af der er beskrevet her inde, så hvis man kan lidt engelsk, er det egentligt ikke et problem.
//Har dog kommenteret lidt hvor jeg har lavet nogle ændringer.
public abstract class Menu {
    // value used to exit the menu.
    // the value can be changed by the sub-class constructor.
    protected int EXIT_OPTION = 0;

    // The menu header text
    private String header;

    // The list of menu options texts.
    private String[] menuItems;

    //Vi laver en start værdi som ikke er hverken 0, 1, 2 eller 3
    //Da hvis det var 0 ville den automatisk afslutte programmet når vi startede det
    //og hvis det var 1,2 eller 3 ville den selecte den menu på opstart.
    private int standardOption = -1;

    /**
     * Abstract method stating what should be done, when menu option is selected.
     * The method must be overridden by the sub-class.
     * @param option the menu option that has been selected.
     */
    protected abstract void doAction(int option);


    /**
     * Creates an instance of the class with the given header text and
     * menu options.
     * @param header    The header text of the menu.
     * @param menuItems The list of menu items texts.
     */
    public Menu(String header, String[] menuItems) {
        this.header = header;
        this.menuItems = menuItems;
    }

    /**
     * Executes the menu until the EXIT_OPTION has been selected.
     * This is an implementation of the Template Method design pattern.
     */
    public void run() {
        boolean done = false;
        while (!done) {

            int option = getOption();
            //Tjekker om vi har tastet 0, hvis vi har, skal den afslutte programmet.
            //hvis ikke, skal den vise menuen igen, og vente på et nyt input.
            if (option == EXIT_OPTION) {
                done = true;
            }else {
                showMenu();
                doAction(option);
                pause();
                clear();
            }


        }
    }

    /**
     * Returns a valid menu-option input from the keyboard. The method continues
     * prompting for an option value, until a valid option has been input.
     * @return A valid menu option.
     */
    private int getOption() {
        return standardOption; // Returnere hvilket element i listen vi har valgt. 0,1,2 eller 3.
    }

    /**
     * Prints out a console menu with a header text and a list
     * of menu options. The menu options will be assigned the numbers
     * from 1 to the number of options in the menu.
     */
    private void showMenu() {
        //vi printer menuen i consolen som normalt med System.out.println(). Vi starter med headeren, som er vores title
        //så printer vi vores exit statement, da det ikke er en del af vores liste af menuItems.
        System.out.println(header);
        System.out.println("(0)exit");
        //så sætter vi vores index til 1. Her bruger vi index til at style vores menu så det er nemmere for brugeren
        //at se hvad de skal skrive for at aktivere menuen.
        //Så det kommer til at se således ud: "(1)Print Persons" istedet for bare "Print Persons".
        //og det gør vi ved bare at indsætte det index i stringen med + omkring den. så den bliver indkooperert i stringen.
        //(Også derfor vi starter på 1, da "exit allerede har 0 jo.)
        int index = 1;
        for (String s : menuItems){
            System.out.println("("+index+")" + s);
            //når vi har printet et menu item, så plusser vi 1 til vores index.
            index++;
        }
        //og så tilføjer vi en blank linje neden for, for udseendets skyld
        System.out.println();
    }

    /**
     * Waits until the 'enter' key is pressed.
     */
    protected void pause() {
        //Her bruger vi en nifty lille funktion fra Java af. Deres Scanner objekt.
        //Vi starter med at lave en ny scanner og kalder den s, og siger at den scanner skal bruge System.in
        //som input metode. Så hvad en vi skriver, bliver gemt i vores s objekt, og så har scanner en masse metoder
        //som vi kan bruge til, i vores tilfælde at vælge menu option.
        Scanner s = new Scanner(System.in);
        //her så sætter vi en int til at være det næste tal vi skriver i consolen.
        int scannerInt = s.nextInt();
        //Vi tjeker om det er mindre end 0. Hvis den er, skal vores option defaultes til at være 0.
        if (scannerInt < 0){
            standardOption = 0;
        } else if(scannerInt > menuItems.length){ // ellers, hvis den er højere end 3, eller den mængde af menu items
            // vi har sat, skal den sættes til at være det højeste mulige tal.
            standardOption = menuItems.length;
        } else{ // Ellers, så er den jo inden for de rammer der er sat, og så kan vi sætte vores valgte menu item
            // til at være det næste tal vi har skrevet.
            standardOption = scannerInt;
        }
        //OBS der er en edge case her som kan fikses, og hvis det var et ordentligt program som vi ville udgive
        //skulle det fikses. En edge case er et tilfælde som ikke ofte sker, men kan ske, og ville forvolde problemer,
        //i vores tilfælde at programmet crasher hvis ikke det bliver løst. I dette tilfælde er edge casen
        //at vi forventer et helt tal at blive tastet ind. Hvis ikke der er en integer altså et helt tal.
        //bliver vores program forvirret, og koger sammen.
    }

    /**
     * Clears the screen by writing several empty lines.
     */
    protected void clear() {
        //Giver sig selv. Vi laver 10 nye linjer som bare er blanke, for at simulere
        //at den cleare consollen. Mener ikke java har en dedikeret metode til at cleare
        //en console skærm på som C eller C++ f.eks har.
        for (int i = 0; i < 10 ; i++) {
            System.out.println();
        }
    }
}
