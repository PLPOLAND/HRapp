package HRapp.MAJ.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import HRapp.MAJ.Model.User;

@Repository
public class UsersDAO{

    @Autowired
    private JdbcTemplate baza;
    //zmieniłam bo ID usera i ID permissions (typKonta) wyświetlało się jako jedno (?) + wypisuje podatek
    final String GET_ALL_WHOLE_USERS_DATA = "SELECT u.ID, u.nickname, u.email, u.pass, u.oldpass, ud.imie, ud.nazwisko, ud.kontoBankowe, ud.wyplataBrutto, p.ID as Uprawnienia, s.Nazwa as Stanowisko, t.nazwa as typUmowy, t.podatek FROM Users u NATURAL JOIN UsersData ud LEFT JOIN Stanowiska s ON ud.id_s=s.ID_s LEFT JOIN TypyUmowy t ON ud.id_t_u=t.ID_T NATURAL JOIN Permissions p;";
   // final String GET_ALL_WHOLE_USERS_DATA ="SELECT * FROM Users NATURAL JOIN UsersData LEFT JOIN Stanowiska ON UsersData.id_s=Stanowiska.ID_s LEFT JOIN TypyUmowy ON UsersData.id_t_u=TypyUmowy.ID_T NATURAL JOIN Permissions";
    final String FIND_USER_LOGIN = "SELECT * FROM Users WHERE nickname = ? AND pass = ? ";
    final String GET_USER_DATA = "SELECT * FROM Users NATURAL JOIN UsersData LEFT JOIN Stanowiska ON UsersData.id_s=Stanowiska.ID_s LEFT JOIN TypyUmowy ON UsersData.id_t_u=TypyUmowy.ID_T NATURAL JOIN Permissions";
    
    /**
     * Pobieranie wszystkich danych usera z bazy danych
     * @return List<User>
     */
    public List<User> getAllUsers(){
        return baza.query(GET_ALL_WHOLE_USERS_DATA, getMap());
    }

    public List<User> getUserLoginData(String Nick, String Pass){
        return baza.query(FIND_USER_LOGIN, new Object [] {Nick,Pass},  getLoginMap());
    }

    public User find_user_by_id(Integer id) {
		return (User)baza.query(GET_ALL_WHOLE_USERS_DATA + " WHERE u.ID = \"" + id + "\"", getMap());
	}


    private RowMapper<User> getLoginMap(){
        RowMapper<User> Map = (rs, rowNum) -> {
            User user = new User();
            user.setID(rs.getInt("ID"));
            user.setNick(rs.getString("nickname"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("pass"));
            user.setOldPassword(rs.getString("oldpass"));
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
            user.setTypUmowy(rs.getString("typUmowy"));
            user.setProcentPodatku(rs.getInt("podatek"));
            //TODO reszta danych

			return user;
		};
        return Map;
	}

}