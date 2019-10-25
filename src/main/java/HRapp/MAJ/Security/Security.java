package HRapp.MAJ.Security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import HRapp.MAJ.DAO.UsersDAO;
import HRapp.MAJ.Model.User;



/**
 * Klasa odpowiedzialna za logowanie użytkownika, sprawdzanie czy już się zalogował, oraz pobierania danych zalogowanego użytkownika.
 * @author Marek Pałdyna
 * @version 1.0
 */
@Repository
public class Security{
    @Autowired
    UsersDAO database;

    HttpServletRequest request;

    /**
     * Konstruktor
     * Inicjuje Klasę do działania
     * @param req - typu HttpServletRequest - request ze strony
     * @param dat - typu UsersDAO - instancja klasy do połączeń z bazą danych
     */
    public Security(HttpServletRequest req, UsersDAO dat){
        request = req;
        database = dat;
    }
    
    /**
     * Loguje użytkownika. Pobiera dane przesłane przez protokół POST Potrzebuje
     * conajmniej danej "login"
     * 
     * @version 1.0
     * @return true jeśli logowanie się powiodło
     */
    public boolean login() {
        String nickname;
        String pass;

        nickname = request.getParameter("nick").toString();
        pass = request.getParameter("pass").toString();
        
        if (nickname == null || nickname.isEmpty()) {
            return false; 
        }
        
        //TODO HASHOWANIE
        
        
        List<User> resultUsers = database.getUserLoginData(nickname, pass);
        
        if (resultUsers.isEmpty()) {
            return false;
        }
        else{

            String user = resultUsers.get(0).getImie();
            String srUser = resultUsers.get(0).getNazwisko();
            Integer idUser = resultUsers.get(0).getID();
            // String typUser = resultUsers.get(0).getAccount_type(); TODO 
            String typUser = "Administrator";
            HttpSession session = request.getSession();
            session.setAttribute("name", user); //dodawanie pola do sesji
            session.setAttribute("surName", srUser);
            session.setAttribute("id", idUser);
            session.setAttribute("typKonta", typUser);
            session.setMaxInactiveInterval(60 * 60); //usuniecie pol sesji po 60 minutach
            
            return true;
        }
        
    }

    /**
     * 
     * Funkcja sprawdzająca czy użytkownik jest zalogowany
     * 
     * 
     * @version 1.0
     * @return true - jeśli uzytkownik jest zalogowany
     */
    public boolean isLoged() {
        HttpSession session = request.getSession();

        if(session.getAttribute("name") == null || session.getAttribute("surName") == null || session.getAttribute("id") == null){
            return false;
        }
        else{
            return true;
        }
    }
    /**
     * Funkcja zwracająca Imię użytkownika pobieraną z danych sesji
     * 
     * @version 1.0
     * @return  Nazwe użytkownika
     */
    public String getUserName() {
        if (isLoged()) {
            HttpSession session = request.getSession();
            return session.getAttribute("name").toString();
        }
        else 
        return null;
    }
    /**
     * Funkcja zwracająca ID użytkonika pobierany z danych sesji
     * @version 1.0
     * @return Integer ID użytkownika
     */
    public Integer getUserID() {
        if (isLoged()) {
            HttpSession session = request.getSession();
            return (Integer)session.getAttribute("id");
        } else {
            return null;
        }
    }
    
    /**
     * Funckja zwracająca Nazwisko użytkownika z danych sesji     * 
     * @version 1.0
     * @return Nazwisko
     */
    public String getUserSurName() {
        if (isLoged()) {
            HttpSession session = request.getSession();
            return session.getAttribute("surName").toString();
        } else {
            return null;
        }
    }

    /**
     * Funkcja zwracająca typ użytkownika z danych sesji
     * @version 1.0
     * @return Typ Użytkownika
     */
    public String getUserType(){
        if (isLoged()){
            HttpSession session = request.getSession();
            return session.getAttribute("typKonta").toString();
        }
        else{
            return null;
        }
    }
    /**
     * Funckja sprawdza czy zalogowany użytkownik jest Adminem
     * @return Czy użytkownik jest adminem
     */
    public boolean isUserAdmin(){
        if(isLoged()){
            HttpSession session = request.getSession();
            if ("Administrator".equals(session.getAttribute("typKonta").toString())) {
                return true;
            } else {
                return false;
            }
        }
        else{
            return false;
        }
    }

    // /**
    //  * Funkcja pobierająca dane użytkonika z bazy danych na podstawie ID (pobranego z danych sesji)
    //  * @version 1.0
    //  * @return Dane zalogowanego użytkownika
    //  */
    // public User getFullUserData(){
    //     if (isLoged()){
    //         HttpSession session = request.getSession();
    //         List<User> result = database.find_user_by_id((Integer)session.getAttribute("id"));
    //         if (result.isEmpty()) {
    //             return null;
    //         } else {
    //             return result.get(0);
    //         }
    //     }
    //     else{
    //         return null;
    //     }
    // }
    
    /**
     * Funkcja usuwa dane sesji = wylogowanie użytkownika
     */
    public void logout(){
        if(isLoged()){
            HttpSession session = request.getSession();
            
            session.removeAttribute("name"); // usuwanie pola do sesji
            session.removeAttribute("surName");
            session.removeAttribute("id");
            session.removeAttribute("typKonta");
        }
        else
            return;
    }

}