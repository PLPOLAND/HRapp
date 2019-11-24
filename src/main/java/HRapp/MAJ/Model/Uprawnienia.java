package HRapp.MAJ.Model;

import HRapp.MAJ.DAO.UprawnieniaDAO;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Odpowiada za przetwarzanie danych o uprawnieniach
 * 
 * @TODO dodać pozostałe uprawnienia jeśli będą
 * @TODO dodać pozostałe javadocy
 */
public class Uprawnienia {
    int ID;
    boolean admin;
    boolean add_user;
    boolean del_user;
    boolean edit_user;
    boolean show_all_users;
    boolean show_d_data; // czy użytkownik może zobaczyć prywatne dane

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

    public boolean isShow_all_users() {
        return this.show_all_users;
    }

    public boolean getShow_all_users() {
        return this.show_all_users;
    }

    public void setShow_all_users(boolean show_all_users) {
        this.show_all_users = show_all_users;
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

    /**
     *
     * na podstawie ID permissions ustawia resztę wartości
     */
    public void setAll(int id, JdbcTemplate baza) {
        ID = id;
        UprawnieniaDAO UPR = new UprawnieniaDAO();
        List<Uprawnienia> UPR2 = UPR.find_permission_data_by_id(id, baza);
        admin = UPR2.get(0).admin;
    }

    public String getTypKonta() {
        if (admin == true)
            return "Administrator";
        else
            return "Uzytkownik";
    }

    @Override
    public String toString() {
        return "{" + " ID='" + getID() + "'" + ", admin='" + getAdmin() + "'" + ", add_user='" + isAdd_user() + "'"
                + ", del_user='" + isDel_user() + "'" + ", edit_user='" + isEdit_user() + "'" + ", show_all_users='"
                + isShow_all_users() + "'" + ", show_d_data='" + isShow_d_data() + "'" + "}";
    }
}