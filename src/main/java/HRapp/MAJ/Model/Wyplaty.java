package HRapp.MAJ.Model;


/*
*
Odpowiada za przetwarzanie danych o wyplatach

*/
public class Wyplaty{
    int ID_w;
    int ID; //ID użytkownika
    String kontoBankowe; // nr konta, na które została przelana wypłata
    String imie; // imię osoby, której przelano wypłatę
    String nazwisko; // nazwisko osoby, której przelano wypłatę
    String dataOd;
    String dataDo;
    String dataZaksiegowania;
    double kwotaBrutto;
    int przepracowaneGodziny;
    
    public int getID_w(){
        return ID_w;
    }
    
    public void setID_w(int id_w){
        ID_w = id_w;
    }

    public int getID(){
        return ID;
    }
    
    public void setID(int id){
        ID = id;
    }

    public String getNrKonta(){
        return kontoBankowe;
    }
    
    public void setNrKonta(String NrKonta){
        kontoBankowe = NrKonta;
    }
    public String getImie(){
        return imie;
    }
    
    public void setImie(String Imie){
        imie = Imie;
    }
    public String getNazwisko(){
        return nazwisko;
    }
    
    public void setNazwisko(String Nazwisko){
        nazwisko = Nazwisko;
    }
    public String getDataOd(){
        return dataOd;
    }
    
    public void setDataOd(String DataOd){
        dataOd = DataOd;
    }

     public String getDataDo(){
        return dataDo;
    }
    
    public void setDataDo(String DataDo){
        dataDo = DataDo;
    }

    public String getDataZaksiegowania(){
        return dataZaksiegowania;
    }
    
    public void setDataZaksiegowania(String DataZaksiegowania){
        dataZaksiegowania = DataZaksiegowania;
    }

    public double getKwotaBrutto(){
        return kwotaBrutto;
    }

    public void setKwotaBrutto(double KwotaBrutto){
        kwotaBrutto = KwotaBrutto;
    }

    public int getPrzepracowaneGodziny(){
        return przepracowaneGodziny;
    }

    public void setPrzepracowaneGodziny(int PrzepracowaneGodziny){
        przepracowaneGodziny = PrzepracowaneGodziny;
    }
    
}