package HRapp.MAJ.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * DropDownMenu przechowuje menu wysuwane
 * 
 * @author Marek Pałdyna
 * @version 1.0
 */
public class DropDownMenu {
    /**Przetrzymuje pozycje menu*/
    List<PozycjaMenu> pozycjemenu;
    
    /** Konstruktor */
    public DropDownMenu(){
       pozycjemenu = new ArrayList<>();
    }

    /**
     * Dodaje pozycję do menu
     * 
     * @param opis  - tekst wyświetlany w pozycji menu
     * @param adres - adres linka
     */
    public void Add(String opis, String adres) {
        pozycjemenu.add(new PozycjaMenu(opis, adres));
    }

    /**
     * Drukuje menu
     * 
     * @return String - zawiera kod HTML z menu poziomym
     */
    public String printMenu() {
        String menu = "<ul class= \"drop-down\"> \n";

        for (PozycjaMenu pozycjaMenu : pozycjemenu) {
            menu += pozycjaMenu.print();
        }

        menu += "\n</ul>";
        return menu;
    }
    
}