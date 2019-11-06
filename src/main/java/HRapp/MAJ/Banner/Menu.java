package HRapp.MAJ.Banner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import HRapp.MAJ.Banner.PozycjaMenu;

/**
 * Menu Klasa służąca do przechowywania i wypisywania menu poziomowego
 * 
 * @author Marek Pałdyna
 * @version 1.0
 */
@Repository
public class Menu {
    /** Przechowuje pozycje menu */
    List<PozycjaMenu> pozycjemenu;

    /** Konstruktor */
    public Menu() {
        pozycjemenu = new ArrayList<>();
        //tymczasowe pozycje
        this.Add("logowanie", "/");
        this.Add("strona admina", "/adminhome");
        this.Add("test", "/test", true);
        this.Add("templatka", "/tmp");
        this.AddToDropDawnPos("test", "pos1", "#");
        this.AddToDropDawnPos("test", "pos2", "#");
        // this.AddToDropDawnPos("test", "pos3", "#");
        // this.AddToDropDawnPos("test", "pos4", "#");
    }

    /**
     * Dodaje pozycję do menu bez Rozwijanego menu
     * 
     * @param opis  - tekst wyświetlany w pozycji menu
     * @param adres - adres linka
     */
    public void Add(String opis, String adres) {
        pozycjemenu.add(new PozycjaMenu(opis, adres));
    }

    /**
     * Dodaje pozycje do menu z rozwijanym menu
     * 
     * @param opis        - tekst wyświetlany w pozycji menu
     * @param adres       - adres linka
     * @param czyDropDown - czy ma być to pozycja z rozwijanym menu
     */
    public void Add(String opis, String adres, boolean czyDropDown) {
        pozycjemenu.add(new PozycjaMenu(opis, adres, czyDropDown));
    }

    /**
     * Dodaje pozycje do rozwijanego menu
     * 
     * @param posOpis - opis pozycji z rozwijanym menu
     * @param opis    - tekst wyświetlany w pozycji menu
     * @param adres   - adres linka
     */
    public void AddToDropDawnPos(String posOpis, String opis, String adres) {
        int i = 0;
        for (PozycjaMenu pozycjaMenu : pozycjemenu) {
            if (pozycjaMenu.opis.equals(posOpis))
                break;
            i++;
        }
        if (i == pozycjemenu.size()) {
            System.out.println("Nie znaleziono pozycji z opisem" + posOpis);
            return;
        } else {
            pozycjemenu.get(i).addDropDownPos(opis, adres);
            return;
        }
    }

    /**
     * Drukuje menu
     * 
     * @return String - zawiera kod HTML z menu poziomym
     */
    public String printMenu() {
        String menu = "<div class= \"menu\"> \n <ul>\n";

        for (PozycjaMenu pozycjaMenu : pozycjemenu) {
            menu += pozycjaMenu.print();
        }

        menu += "\n</ul> </div>";
        return menu;
    }

}