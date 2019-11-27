package HRapp.MAJ.Banner;

import java.util.ArrayList;
import java.util.List;

import HRapp.MAJ.Banner.PozycjaMenu;
import HRapp.MAJ.Model.Uprawnienia;

/**
 * Menu Klasa służąca do przechowywania i wypisywania menu poziomowego
 * 
 * @author Marek Pałdyna
 * @version 1.0
 */
// @Component
public class Menu {
    /** Przechowuje pozycje menu */
    List<PozycjaMenu> pozycjemenu;
    
    /** Konstruktor */
    public Menu( Uprawnienia uprawnienia) {
        pozycjemenu = new ArrayList<>();
        //tymczasowe pozycje
        // System.out.println("MENU: " + uprawnienia.toString());//DEBUG
        if (uprawnienia.isAdmin()) {
            this.Add("logowanie", "/");
            this.Add("strona admina", "/adminhome");
            this.Add("test", "/test", true);
            this.Add("Użytkownicy", "#", true);
            this.AddToDropDawnPos("Użytkownicy", "Lista", "/adminhome");
            this.AddToDropDawnPos("Użytkownicy", "Dodawanie", "/add_user_page");
            this.Add("templatka", "/tmp");
            this.AddToDropDawnPos("test", "menu", "/menu");
            this.AddToDropDawnPos("test", "Testy Julka", "/xxx");
        }
        else{
            if(uprawnienia.isAdd_user()){
                if (!this.havePosition(new PozycjaMenu("Użytkownicy", "#", true))) {
                    this.Add("Użytkownicy", "#", true);
                }
                this.AddToDropDawnPos("Użytkownicy", "Dodawanie", "/add_user_page");
            }
            if(uprawnienia.isDel_user()){
                //.....?
            }
            if(uprawnienia.isShow_all_users()){
                // if(!this.havePosition(new PozycjaMenu("Użytkownicy", "#", true))){
                    this.Add("Użytkownicy", "#", true);
                // }
                this.AddToDropDawnPos("Użytkownicy", "Lista", "/adminhome");
            }
        }
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
     * Funkcja sprawdzająca czy menu posiada dokładnie taką samą pozycję (opis,adres,czyDropdown)
     * @param pozycjaMenu - pozycja do znalezienia
     * @return true jeśli menu zawiera taką pozycję
     */
    public boolean havePosition(PozycjaMenu pozycjaMenu) {
        for (PozycjaMenu poz : pozycjemenu) {
            if (poz.equals(pozycjaMenu))
                return true;
        }
        return false;
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