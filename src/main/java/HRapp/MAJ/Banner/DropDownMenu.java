package HRapp.MAJ.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * DropDownMenu przechowuje menu wysuwane
 * 
 * @author Marek Pałdyna
 */
public class DropDownMenu {

    List<PozycjaMenu> pozycjemenu;

    public DropDownMenu(){
       pozycjemenu = new ArrayList<>();
    }

    public void Add(String opis, String adres) {
        pozycjemenu.add(new PozycjaMenu(opis, adres));
    }

    public String printMenu() {
        String menu = "<ul class= \"drop-down\"> \n";

        for (PozycjaMenu pozycjaMenu : pozycjemenu) {
            menu += pozycjaMenu.print();
        }

        menu += "\n</ul>";
        return menu;
    }
    
}