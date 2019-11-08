package HRapp.MAJ.Model;

import HRapp.MAJ.DAO.UprawnieniaDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/*
*
Odpowiada za przetwarzanie danych o uprawnieniach

*/
public class Uprawnienia{
    int ID;
    boolean admin;
    @Autowired
    UprawnieniaDAO uprdao;
    
    /**
     * Pobieranie ID uprawnienia
     * @return ID
     */
    public int getID(){
        return ID;
    }

    /**
     * Ustawienie ID uprawnienia
     * @param id;
     */
    public void setID(int id){ 
        this.ID = id;
    }

    /**
     * Pobieranie wartości admin
     * @return admin
     */
    public boolean getAdmin(){
        return admin;
    }

    /**
     * Ustawienie wartości admin
     * @return admin
     */
    public void setAdmin(int Admin){
        if(Admin == 1)
        admin = true;
        else
        admin = false;
    }

    /*
    *
    na podstawie ID permissions ustawia resztę wartości
    */

    public void setAll(int id, JdbcTemplate baza){
        ID= id;
        UprawnieniaDAO UPR = new UprawnieniaDAO();
        List<Uprawnienia> UPR2 = UPR.find_permission_data_by_id(id,baza);      
        admin = UPR2.get(0).admin;
    }

    public String getTypKonta(){
        if(admin == true)
            return "Administrator";
        else
             return "Uzytkownik";
    }
     //@TODO dodać pozostałe uprawnienia jeśli będą
}