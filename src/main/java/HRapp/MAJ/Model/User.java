package HRapp.MAJ.Model;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Odpowiada za przetrzymywanie danych o Użytkowniku.
 * TODO reszta danych
 * @author Marek
*/
public class User{
    int ID;
    String nick;
    String password;
    String oldPassword;
    String email;
    String kontoBankowe;
    float wyplataBrutto;
    String imie;
    String nazwisko;
    Uprawnienia uprawnienia;
    String stanowisko;
    String typUmowy;
    float procentPodatku;
    

    /**
     * Pobieranie ID usera
     * @return ID
     */
    public int getID(){
        return ID;
    }

    /**
     * Ustawia ID usera
     * @param id
     */
    public void setID(int id){
        ID = id;
    }

    /**
     * Pobieranie nick usera
     * @return
     */
    public String getNick(){
        return nick;
    }

    /**
     * Ustawia nick usera
     * @param Nick
     */
    public void setNick(String Nick){
        nick = Nick;
    }

    /**
     * Pobieranie hasla usera
     * @return password
     */
    public String getPassword(){
        return password;
    }

    /**
     * Ustawianie hasla usera
     * @param pass
     */
    public void setPassword(String pass){
        password = pass;
    }

    /**
     * Pobiera starego hasla usera
     * @return oldPassword
     */
    public String getOldPassword(){
        return oldPassword;
    }

    /**
     * Ustawianie starego hasła usera
     * @param oldpass
     */
    public void setOldPassword(String oldpass){
        oldPassword = oldpass;
    }

    /**
     * Pobieranie Emaila usera
     * @return email
     */
    public String getEmail(){
        return email;
    }
    /**
     * Ustawianie Emaila usera
     * @param Email
     */
    public void setEmail(String Email){
        email = Email;
    }

    /**
     * Pobieranie numeru konta bankowego usera
     * @return kontoBankowe
     */
    public String getKontoBankowe(){
        return kontoBankowe;
    }

    /**
     * Ustawianie konta bankowego usera
     * @param konto
     */
    public void setKontoBankowe(String konto){
        kontoBankowe = konto;
    }

    /**
     * Pobieranie wartości brutto pensji usera
     * @return wyplataBrutto
     */
    public Float getWyplataBrutto(){
        return wyplataBrutto;
    }

    /**
     * Ustawianie wartości brutto pensji usera
     * @param kwota
     */
    public void setWyplataBrutto(Float kwota){
        wyplataBrutto = kwota;
    }

    public float getWyplataNetto(){
        return (wyplataBrutto - ((wyplataBrutto * (float) procentPodatku)/100));
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

    public String getUprawnienia(){
        return uprawnienia.getTypKonta();
    }

    public void setUprawnienia(int Upr, JdbcTemplate baza){
        uprawnienia = new Uprawnienia();
        uprawnienia.setAll(Upr,baza);      
    }

    public String getStanowisko(){
        return stanowisko;
    }

    public void setStanowisko(String Stanowisko){
        stanowisko = Stanowisko;
    }

    public String getTypUmowy(){
        return typUmowy;
    }

    public void setTypUmowy(String TypUmowy){
        typUmowy = TypUmowy;
    }

    public int getProcentPodatku(){
        return (int) procentPodatku;
    }

    public void setProcentPodatku(float ProcentPodatku){
        procentPodatku = ProcentPodatku*100;
    }

    /**
     * Zwraca stringa z danymi zawartymi w obiekcie
     * 
     * @TODO Dodac pozostałe dane
     */
    public String toString(){
        return " " + ID + " " + nick + " " + password + " " + oldPassword + " " + email;
    }
}