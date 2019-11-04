package HRapp.MAJ.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import HRapp.MAJ.Model.Uprawnienia;

@Repository
public class UprawnieniaDAO{

    final String GET_ALL_USERS_PERMISSION_DATA = "SELECT ID, admin FROM permissions";

/*
    public List<Uprawnienia> getAllPermissionsData(){
        return baza.query(GET_ALL_USERS_PERMISSION_DATA, getMap());
    }
*/
    public List<Uprawnienia> find_permission_data_by_id(int id, JdbcTemplate baza) {
        List<Uprawnienia> U =  baza.query(GET_ALL_USERS_PERMISSION_DATA + " WHERE ID =  "+ id +";", getMap());
        return U;
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
}
