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

    public void Add(String opis, String adres,boolean czyDropDown) {
        pozycjemenu.add(new PozycjaMenu(opis, adres, czyDropDown));
    }

    public void AddToDropDawnPos(String posOpis, String opis, String adres){
        int i = 0;
        for (PozycjaMenu pozycjaMenu : pozycjemenu) {
            if(pozycjaMenu.opis.equals(posOpis))
                break;
            i++;
        }
        pozycjemenu.get(i).addDropDownPos(opis,adres);
    }

    public String printMenu(){
        String menu = "<div class= \"menu\"> \n <ul>\n";

        for (PozycjaMenu pozycjaMenu : pozycjemenu) {
            menu += pozycjaMenu.print();
        }


        menu += "\n</ul> </div>";
        return menu;
    }

}