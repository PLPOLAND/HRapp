package HRapp.MAJ.Banner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import HRapp.MAJ.Banner.PozycjaMenu;
/**
 * Menu
 */
@Repository
public class Menu {

    List<PozycjaMenu> pozycjemenu;
    
    public Menu(){
       pozycjemenu = new ArrayList<>();
    }

    public void Add(String opis, String adres) {
        pozycjemenu.add(new PozycjaMenu(opis,adres));
    }

    public String printMenu(){
        String menu = "<div class= \"menu\"> \n <ol>\n";

        for (PozycjaMenu pozycjaMenu : pozycjemenu) {
            menu += pozycjaMenu.print();
        }


        menu += "\n</ol> </div>";
        return menu;
    }

}