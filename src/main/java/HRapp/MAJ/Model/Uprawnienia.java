package HRapp.MAJ.Model;

import HRapp.MAJ.DAO.UprawnieniaDAO;
import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Odpowiada za przetwarzanie danych o uprawnieniach
 * 
 * @TODO dodać pozostałe uprawnienia jeśli będą
 * @TODO dodać pozostałe javadocy
 */
@Component
public class Uprawnienia {
    int ID;
    boolean admin;
    boolean add_user;
    boolean del_user;
    boolean edit_user;
    boolean show_d_data; // czy użytkownik może zobaczyć prywatne dane
    boolean finance_management;

    /**
     * Pobieranie ID uprawnienia
     * 
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Ustawienie ID uprawnienia
     * 
     * @param id;
     */
    public void setID(int id) {
        this.ID = id;
    }
    /**
     * Zwraca czy jest adminem
     * @return admin
     */
    public boolean isAdmin() {
        return admin;
    }
    /**
     * Pobieranie wartości admin
     * 
     * @return admin
     */
    public boolean getAdmin() {
        return admin;
    }

    /**
     * Ustawienie wartości admin
     * 
     * @return admin
     */
    public void setAdmin(int Admin) {
        if (Admin == 1)
            admin = true;
        else
            admin = false;
    }

    /**
     * Zwraca czy ma pozwolenie na dodawanie userów
     * 
     * @return add_user
     */
    public boolean isAdd_user() {
        return this.add_user;
    }

    /**
     * Zwraca wartość flagi add_user
     * 
     * @return add_user
     */
    public boolean getAdd_user() {
        return this.add_user;
    }

    /**
     * Ustawia wartość flagi add_user
     * 
     * @param add_user
     */
    public void setAdd_user(boolean add_user) {
        this.add_user = add_user;
    }

    /**
     * Zwraca czy ma pozwolenie na delete userów
     * 
     * @return del_user
     */
    public boolean isDel_user() {
        return this.del_user;
    }

    /**
     * Zwraca wartość flagi del_user
     * 
     * @return del_user
     */
    public boolean getDel_user() {
        return this.del_user;
    }

    /**
     * Ustawia wartość flagi del_user
     * 
     * @param del_user
     */
    public void setDel_user(boolean del_user) {
        this.del_user = del_user;
    }

    /**
     * Zwraca czy ma pozwolenie na edytowanie userów
     * 
     * @return edit_user
     */
    public boolean isEdit_user() {
        return this.edit_user;
    }

    /**
     * Zwraca wartość flagi edit_user
     * 
     * @return edit_user
     */
    public boolean getEdit_user() {
        return this.edit_user;
    }

    /**
     * Ustawia wartość flagi edit_user
     * 
     * @param edit_user
     */
    public void setEdit_user(boolean edit_user) {
        this.edit_user = edit_user;
    }


    public boolean isShow_d_data() {
        return this.show_d_data;
    }

    public boolean getShow_d_data() {
        return this.show_d_data;
    }

    public void setShow_d_data(boolean show_d_data) {
        this.show_d_data = show_d_data;
    }


    public boolean isFinance_management() {
        return this.finance_management;
    }

    public boolean getFinance_management() {
        return this.finance_management;
    }

    public void setFinance_management(boolean finance_management) {
        this.finance_management = finance_management;
    }

    /**
     * Na podstawie ID pobiera i ustawia uprawnienia z bazy danych.
     * 
     * 
     * @param id   - id użytkownika
     * @param baza - baza danych z której pobierane są uprawnienia
     * 
     * @author Alicja
     * @author Marek
     */
    public void setAll(int id, JdbcTemplate baza) {
        ID = id;
        UprawnieniaDAO UPR = new UprawnieniaDAO();
        List<Uprawnienia> UPR2 = UPR.find_permission_data_by_id(id, baza);
        // admin = UPR2.get(0).admin;
        this.setAll(UPR2.get(0));
    }
    /**
     * Ustawia uprawnienia na podstawie dostarczonych uprawnień
     * @param uprawnienia - obiekt którego dane zostaną skopiowane
     */
    public void setAll(Uprawnienia uprawnienia) {
        this.ID = uprawnienia.ID;
        this.admin = uprawnienia.admin;
        this.add_user = uprawnienia.add_user;
        this.del_user = uprawnienia.del_user;
        this.edit_user = uprawnienia.edit_user;
        this.show_d_data = uprawnienia.show_d_data;
        this.finance_management = uprawnienia.finance_management;
    }

    @Override
    public String toString() {
       /* return "{" + " ID='" + getID() + "'" + ", admin='" + getAdmin() + "'" + ", add_user='" + isAdd_user() + "'"
                + ", del_user='" + isDel_user() + "'" + ", edit_user='" + isEdit_user() + "'" + ", show_all_users='"
                + isShow_all_users() + "'" + ", show_d_data='" + isShow_d_data() + "'" + "}";*/
                if (admin == true)
                return "Administrator";
            else if(add_user == false && del_user == false && edit_user == false &&  show_d_data == false && finance_management == false)
                return "Podstawowe";
            else{
                String upr = "Podstawowe oraz: ";
                if(add_user == true)
                upr += "Dodawanie użytkowników; ";
                if(del_user == true)
                upr += "Usuwanie użytkowników; ";
                if(edit_user == true)
                upr += "Edytowanie użytkowników; ";
                if(show_d_data == true)
                upr += "Wyświetlanie szczegółowych danych użytkowników; ";
                if(finance_management == true)
                upr += "Zarządzanie finansami; ";
                return upr;
            }
    }
    
}