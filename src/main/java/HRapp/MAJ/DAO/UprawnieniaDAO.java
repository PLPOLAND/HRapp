package HRapp.MAJ.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import HRapp.MAJ.Model.Uprawnienia;

@Repository
public class UprawnieniaDAO{

    @Autowired
    private JdbcTemplate baza1;

    final String GET_ALL_USERS_PERMISSION_DATA = "SELECT ID, admin FROM Permissions";
    final String ADD_PERMISSION = "INSERT INTO Permissions (ID, admin) VALUES (?, ?)";
    final String EDIT_PERMISSION =  "UPDATE Permissions SET admin = ? WHERE ID = ?";


    public List<Uprawnienia> getAllPermissionsData(){
        return baza1.query(GET_ALL_USERS_PERMISSION_DATA, getMap());
    }

    public List<Uprawnienia> find_permission_data_by_id(int id, JdbcTemplate baza) {
        List<Uprawnienia> U =  baza.query(GET_ALL_USERS_PERMISSION_DATA + " WHERE ID =  "+ id +";", getMap());
        return U;
    }
    
    public void addPermission(int id, int uprawnienia){
        baza1.update(ADD_PERMISSION, id, uprawnienia);
    }

    public void editPermission(int id, int uprawnienia){
        baza1.update(EDIT_PERMISSION, uprawnienia, id);
    }

    private RowMapper<Uprawnienia> getMap() {
		RowMapper<Uprawnienia> Map = (rs, rowNum) -> {
			Uprawnienia upr = new Uprawnienia();
            upr.setID(rs.getInt("ID"));
            upr.setAdmin(rs.getInt("admin"));

			return upr;
		};
        return Map;
    }
      //TODO dopisać reszte uprawnień jak będą 
      //TODO dodawanie/edytowanie uprawnień
}
