package HRapp.MAJ.Banner;

import java.util.ArrayList;
import java.util.List;

import HRapp.MAJ.Banner.PozycjaMenu;
import HRapp.MAJ.Model.Uprawnienia;

import javax.servlet.http.HttpSession;

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
    public Menu( Uprawnienia uprawnienia, HttpSession session) {
        pozycjemenu = new ArrayList<>();
        int id = (Integer) session.getAttribute("id");
        //tymczasowe pozycje
        // System.out.println("MENU: " + uprawnienia.toString());//DEBUG
        this.Add("Moje konto", "/user_profile_page?id=" + id);
        if (uprawnienia.isAdmin()) {
            this.Add("strona admina", "/adminhome");
            //this.Add("Moje konto", "/user_profile_page?id=" + id);
            this.Add("Użytkownicy", "/adminhome", true);
            this.AddToDropDawnPos("Użytkownicy", "Dodaj użytkownika", "/add_user_page");
            this.Add("Finanse", "#", true);
            this.AddToDropDawnPos("Finanse", "Moje finanse", "/user_payment_page?id=" + id);
            this.AddToDropDawnPos("Finanse", "Finanse użytkowników", "/payment_data_users_list");
            this.AddToDropDawnPos("Finanse", "Dodaj wypłatę", "/add_payment_users_list");
            this.AddToDropDawnPos("Finanse", "Historia wypłat", "/payment_history");
        }
        else{
            if(uprawnienia.isShow_d_data()){
                if (!this.havePosition(new PozycjaMenu("Użytkownicy", "#", true))) {
                    if(uprawnienia.isAdd_user() || uprawnienia.isDel_user() || uprawnienia.isEdit_user()){
                        this.Add("Użytkownicy", "/details_users_list", true);
                        if(uprawnienia.isAdd_user())
                            this.AddToDropDawnPos("Użytkownicy", "Dodaj użytkownika", "/add_user_page");
                        if(uprawnienia.isDel_user())
                            this.AddToDropDawnPos("Użytkownicy", "Usuń użytkownika", "/delete_users_list");
                        if(uprawnienia.isEdit_user())
                            this.AddToDropDawnPos("Użytkownicy", "Edytuj użytkownika", "/edit_users_list");
                    }
                    else
                    this.Add("Użytkownicy", "/details_users_list");
                }
                this.AddToDropDawnPos("Użytkownicy", "Dodawanie", "/add_user_page");
            }else{
                if(uprawnienia.isAdd_user() || uprawnienia.isDel_user() || uprawnienia.isEdit_user()){
                    this.Add("Użytkownicy", "/users_list", true);
                    if(uprawnienia.isAdd_user())
                        this.AddToDropDawnPos("Użytkownicy", "Dodaj użytkownika", "/add_user_page");
                    if(uprawnienia.isDel_user())
                        this.AddToDropDawnPos("Użytkownicy", "Usuń użytkownika", "/delete_users_list");
                    if(uprawnienia.isEdit_user())
                        this.AddToDropDawnPos("Użytkownicy", "Edytuj użytkownika", "/edit_users_list");
                }else
                    this.Add("Użytkownicy", "/users_list"); 
            }
            if(uprawnienia.isFinance_management()){
                this.Add("Finanse", "#", true);
                this.AddToDropDawnPos("Finanse", "Moje finanse", "/user_payment_page?id=" + id);
                this.AddToDropDawnPos("Finanse", "Finanse użytkowników", "/payment_data_users_list");
                this.AddToDropDawnPos("Finanse", "Dodaj wypłatę", "/add_payment_users_list");
                this.AddToDropDawnPos("Finanse", "Historia wypłat", "/payment_history");
            }else{
                this.Add("Moje Finanse", "/user_payment_page?id=" + id);
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