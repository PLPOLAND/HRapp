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

    final String GET_ALL_WHOLE_USERS_DATA ="SELECT * FROM Users NATURAL JOIN UsersData LEFT JOIN Stanowiska ON UsersData.id_s=Stanowiska.ID_s LEFT JOIN TypyUmowy ON UsersData.id_t_u=TypyUmowy.ID_T NATURAL JOIN Permissions";
    final String FIND_USER_LOGIN = "SELECT * FROM Users WHERE nickname = ? AND pass = ? ";
    
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
            // user.setImie(rs.getString("imie"));
            // user.setNazwisko(rs.getString("nazwisko"));
            user.setKontoBankowe(rs.getString("kontoBankowe"));
            user.setWyplataBrutto(rs.getFloat("wyplataBrutto"));
            //TODO reszta danych

			return user;
		};
        return Map;
	}

}