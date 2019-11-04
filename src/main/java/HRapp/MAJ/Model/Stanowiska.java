package HRapp.MAJ.Model;


/*
*
Odpowiada za przetwarzanie danych o stanowiskach

*/
public class Stanowiska{
    int ID;
    String nazwa;
    String nazwaSkr;
    
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
    
}