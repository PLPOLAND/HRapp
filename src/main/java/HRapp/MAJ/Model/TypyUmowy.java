package HRapp.MAJ.Model;

import HRapp.MAJ.DAO.TypyUmowyDAO;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/*
*
Odpowiada za przetwarzanie danych o typach umów

*/
public class TypyUmowy{
    int ID;
    String nazwa;
    String nazwaSkr;
    float funduszPracy;
    float ubWypadkowe;
    float ubRentowePracodawca;
    float ubRentowePracownik;
    float ubEmerytalnePracodawca;
    float ubEmerytalnePracownik;
    float ubChorobowe;
    float ubZdrowotne;
    float zaliczkaPIT;
    float FGSP;
    
    public int getID(){
        return ID;
    }
    
    public void setID(int id){
        ID = id;
    }

    public String getNazwa(){
        return nazwa;
    }
    
    public void setNazwa(String Nazwa){
        nazwa = Nazwa;
    }

    public String getNazwaSkr(){
        return nazwaSkr;
    }
    
    public void setNazwaSkr(String NazwaSkr){
        nazwaSkr = NazwaSkr;
    }

    public float getFunduszPracy(){
        return funduszPracy;
    };
    public void setFunduszPracy(float fp){
        funduszPracy = fp;
    };
    public float getUbWypadkowe(){
        return ubWypadkowe;
    };
    public void setUbWypadkowe(float uw){
        ubWypadkowe = uw;
    };
    public float getUbRentowePracodawca(){
        return ubRentowePracodawca;
    };
    public void setUbRentowePracodawca(float ur){
        ubRentowePracodawca = ur;
    };
    public float getUbRentowePracownik(){
        return ubRentowePracownik;
    };
    public void setUbRentowePracownik(float ur){
        ubRentowePracownik = ur;
    };
    public float getUbEmerytalnePracodawca(){
        return ubEmerytalnePracodawca;
    };
    public void setUbEmerytalnePracodawca(float ue){
         ubEmerytalnePracodawca = ue;
    };
    public float getUbEmerytalnePracownik(){
        return ubEmerytalnePracownik;
    };
    public void setUbEmerytalnePracownik(float ue){
         ubEmerytalnePracownik = ue;
    };
    public float getUbChorobowe(){
        return ubChorobowe;
    };
    public void setUbChorobowe(float uc){
         ubChorobowe = uc;
    };
    public float getUbZdrowotne(){
        return ubZdrowotne;
    };
    public void setUbZdrowotne(float uz){
         ubZdrowotne = uz;
    };
    public float getZaliczkaPIT(){
        return zaliczkaPIT;
    };
    public void setZaliczkaPIT(float z){
         zaliczkaPIT = z;
    };
    public float getFGSP(){
        return FGSP;
    };
    public void setFGSP(float f){
         FGSP = f;
    }
    public void setAll(int id_U, JdbcTemplate baza){
        ID= id_U;
        TypyUmowyDAO TU = new TypyUmowyDAO();
        List<TypyUmowy> TUm = TU.find_typ_umowy_by_id(id_U,baza);      
         nazwa = TUm.get(0).nazwa;
         nazwaSkr = TUm.get(0).nazwaSkr;
         funduszPracy = TUm.get(0).funduszPracy;
         ubWypadkowe = TUm.get(0).ubWypadkowe;
         ubRentowePracodawca = TUm.get(0).ubRentowePracodawca;
         ubRentowePracownik = TUm.get(0).ubRentowePracownik;
         ubEmerytalnePracodawca = TUm.get(0).ubEmerytalnePracodawca;
         ubEmerytalnePracownik = TUm.get(0).ubEmerytalnePracownik;
         ubChorobowe = TUm.get(0).ubChorobowe;
         ubZdrowotne = TUm.get(0).ubZdrowotne;
         zaliczkaPIT = TUm.get(0).zaliczkaPIT;
         FGSP = TUm.get(0).FGSP;
    }
}