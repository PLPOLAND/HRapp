package HRapp.MAJ.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import HRapp.MAJ.Model.User;



/**
 * Klasa służąca do pobierania danych z bazy danych
 */
@Repository
public class UsersDAO{

    @Autowired
    private JdbcTemplate baza;
    //zmieniłam bo ID usera i ID permissions (typKonta) wyświetlało się jako jedno (?) + wypisuje podatek
    final String GET_ALL_WHOLE_USERS_DATA = "SELECT u.ID, u.nickname, u.email, u.pass, u.oldpass, ud.imie, ud.nazwisko, ud.kontoBankowe, ud.wyplataBrutto, ud.pesel, ud.dataUrodzenia, ud.nrTelefonu, ud.ulica, ud.nrDomu, ud.nrMieszkania, ud.miasto, ud.kodPocztowy, p.ID as Uprawnienia, s.Nazwa as Stanowisko, t.ID_T as typUmowy FROM Users u NATURAL JOIN UsersData ud LEFT JOIN Stanowiska s ON ud.id_s=s.ID_s LEFT JOIN TypyUmowy t ON ud.id_t_u=t.ID_T NATURAL JOIN Permissions p";
   // final String GET_ALL_WHOLE_USERS_DATA ="SELECT * FROM Users NATURAL JOIN UsersData LEFT JOIN Stanowiska ON UsersData.id_s=Stanowiska.ID_s LEFT JOIN TypyUmowy ON UsersData.id_t_u=TypyUmowy.ID_T NATURAL JOIN Permissions";
    final String FIND_USER_LOGIN = "SELECT Users.*, UsersData.imie, UsersData.nazwisko FROM Users NATURAL JOIN UsersData  WHERE nickname = ? AND pass = ?";
    final String EDIT_USER = "UPDATE Users SET nickname = ?, email = ? WHERE ID = ?";
    final String EDIT_USER_DATA = "UPDATE UsersData SET imie = ?, nazwisko = ?, pesel = ?, nrTelefonu = ?, dataUrodzenia = ?, kontoBankowe = ?, wyplataBrutto = ?, id_s = ?, id_t_u = ?, ulica = ?, nrDomu = ?, nrMieszkania = ?, miasto = ?, kodPocztowy = ? WHERE ID = ?";
    final String ADD_USER = "INSERT INTO Users (nickname, email, pass, oldpass) VALUES (?,?,?, '')";
    final String ADD_USER_DATA = "INSERT INTO UsersData (ID, imie, nazwisko, pesel, nrTelefonu, dataUrodzenia, kontoBankowe, wyplataBrutto, id_s, id_t_u, ulica, nrDomu, nrMieszkania, miasto, kodPocztowy) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    final String GET_USER_DATA = "SELECT * FROM Users NATURAL JOIN UsersData LEFT JOIN Stanowiska ON UsersData.id_s=Stanowiska.ID_s LEFT JOIN TypyUmowy ON UsersData.id_t_u=TypyUmowy.ID_T NATURAL JOIN Permissions";
    final String GET_USER_ID = "SELECT ID FROM Users WHERE nickname=? AND email=?";
    final String GET_USER_DATA_MAIN_PAGE = "SELECT Users.ID, UsersData.imie, UsersData.nazwisko, Stanowiska.Nazwa as Stanowisko, Users.email FROM Users NATURAL JOIN UsersData NATURAL JOIN Stanowiska;";
    final String DELETE_USER = "DELETE from Users WHERE ID = ?";
    final String LIMITED_EDIT_USER_DATA = "UPDATE UsersData SET imie = ?, nazwisko = ?, pesel = ?, nrTelefonu = ?, dataUrodzenia = ?, kontoBankowe = ?, ulica = ?, nrDomu = ?, nrMieszkania = ?, miasto = ?, kodPocztowy = ? WHERE ID = ?";
    
    /**
     * Pobieranie wszystkich danych usera z bazy danych
     * @return List<User>
     */
    public List<User> getAllUsers(){
        return baza.query(GET_ALL_WHOLE_USERS_DATA, getMap());
    }

    /**
     * Pobieranie danych usera potrzebnych do logowania z bazy danych
     * @return List<User>
     */
    public List<User> getUserLoginData(String Nick, String Pass){
        return baza.query(FIND_USER_LOGIN, new Object [] {Nick,Pass},  getLoginMap());
    }
    /**
     * Pobieranie danych usera potrzebnych do wyświetlania na stronie z lista userow
     * @return List<User>
     */
    public List<User> getUsersMainPageData() {
        return baza.query(GET_USER_DATA_MAIN_PAGE, getMainPageDataMap());
    }

    /**
     * Znajdowanie konkretnego usera po jego ID w bazie danych
     * @return User
     */
    public User find_user_by_id(Integer id) {
		return baza.query(GET_ALL_WHOLE_USERS_DATA + " WHERE u.ID = \"" + id + "\"", getMap()).get(0);
    }

    /**
     * Aktualizacja danych usera w bazie danych
     */
    public void editUser(int id, String imie, String nazwisko, String nickname, String email, String nrkonta, int typumowy, int stanowisko, double wyplatabrutto, String pesel, String dataurodzenia, String nrtelefonu, String ulica, String nrdomu, int nrmieszkania, String miasto, String kodpocztowy){
        baza.update(EDIT_USER, nickname, email, id);
        baza.update(EDIT_USER_DATA, imie, nazwisko, pesel, nrtelefonu, dataurodzenia, nrkonta, wyplatabrutto, stanowisko, typumowy, ulica, nrdomu, nrmieszkania, miasto, kodpocztowy, id);
    }

    /**
     * Ograniczona aktualizacja danych usera w bazie danych
     */
    public void limitedEditUser(int id, String imie, String nazwisko, String nickname, String email, String nrkonta, String pesel, String dataurodzenia, String nrtelefonu, String ulica, String nrdomu, int nrmieszkania, String miasto, String kodpocztowy){
        baza.update(EDIT_USER, nickname, email, id);
        baza.update(LIMITED_EDIT_USER_DATA, imie, nazwisko, pesel, nrtelefonu, dataurodzenia, nrkonta, ulica, nrdomu, nrmieszkania, miasto, kodpocztowy, id);
    }

    /**
     * Dodawanie nowego usera do bazy danych
     * @return id
     */
    public int addUser(String imie, String nazwisko, String nickname, String email, String nrkonta, int typumowy, int stanowisko, double wyplatabrutto, String haslo, String pesel, String dataurodzenia, String nrtelefonu, String ulica, String nrdomu, int nrmieszkania, String miasto, String kodpocztowy){
        baza.update(ADD_USER, nickname, email, haslo);
        int id = baza.queryForObject(GET_USER_ID, Integer.class, nickname, email);
        baza.update(ADD_USER_DATA, id, imie, nazwisko, pesel, nrtelefonu, dataurodzenia, nrkonta, wyplatabrutto, stanowisko, typumowy, ulica, nrdomu, nrmieszkania,miasto,kodpocztowy);
        return id;
    }

    public void  deleteUser(int id){
        baza.update(DELETE_USER, id);
    }


    private RowMapper<User> getLoginMap(){
        RowMapper<User> Map = (rs, rowNum) -> {
            User user = new User();
            user.setID(rs.getInt("ID"));
            user.setNick(rs.getString("nickname"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("pass"));
            user.setOldPassword(rs.getString("oldpass"));
            user.setImie(rs.getString("imie"));
            user.setNazwisko(rs.getString("nazwisko"));
            user.setUprawnienia(user.getID(), baza);
            return user;
        };
        return Map;
    }
    
    /**
     * Służy do mapowania rekordów na obiekty Usera ze wszystkimi danymi
     */
    private RowMapper<User> getMainPageDataMap() {
        RowMapper<User> Map = (rs, rowNum) -> {
            User user = new User();
            user.setID(rs.getInt("ID"));
            user.setEmail(rs.getString("email"));
            user.setImie(rs.getString("imie"));
            user.setNazwisko(rs.getString("nazwisko"));
            user.setStanowisko(rs.getString("Stanowisko"));
            return user;
        };
        return Map;
    }

    /**
     * Służy do mapowania rekordów na obiekty Usera ze wszystkimi danymi
     */
    private RowMapper<User> getMap() {
		RowMapper<User> Map = (rs, rowNum) -> {
			User user = new User();
            user.setID(rs.getInt("ID"));
            user.setNick(rs.getString("nickname"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("pass"));
            user.setOldPassword(rs.getString("oldpass"));
            user.setImie(rs.getString("imie"));
            user.setNazwisko(rs.getString("nazwisko"));
            user.setKontoBankowe(rs.getString("kontoBankowe"));
            user.setWyplataBrutto(rs.getFloat("wyplataBrutto"));
            user.setUprawnienia(rs.getInt("Uprawnienia"), baza);
            user.setStanowisko(rs.getString("Stanowisko"));
            user.setTypUmowy(rs.getInt("typUmowy"),baza);
            user.setPesel(rs.getString("pesel"));
            user.setDataUrodzenia(rs.getString("dataUrodzenia"));
            user.setNrTelefonu(rs.getString("nrTelefonu"));
            user.setUlica(rs.getString("ulica"));
            user.setNrDomu(rs.getString("nrDomu"));
            user.setNrMieszkania(rs.getInt("nrMieszkania"));
            user.setMiasto(rs.getString("miasto"));
            user.setKodPocztowy(rs.getString("kodPocztowy"));
            //TODO reszta danych

			return user;
		};
        return Map;
	}

}