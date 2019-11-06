package HRapp.MAJ.Model;


/*
*
Odpowiada za przetwarzanie danych o typach umów

*/
public class TypyUmowy{
    int ID;
    String nazwa;
    String nazwaSkr;
    float podatek; //procent
    
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

    public float getPodatek(){
        return podatek;
    }
    
    public void setPodatek(float Podatek){
        podatek = Podatek;
    }
    
}