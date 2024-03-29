package HRapp.MAJ.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import HRapp.MAJ.Model.TypyUmowy;

@Repository
public class TypyUmowyDAO{

    @Autowired
    private JdbcTemplate baza;

    final String GET_ALL_TYPY_UMOWY_DATA = "SELECT `ID_T`, `nazwaSkr`, `nazwa`, `funduszPracy`, `ubWypadkowe`,`ubRentowePracodawca`, `ubRentowePracownik`,`ubEmerytalnePracodawca`,`ubEmerytalnePracownik`,`ubChorobowe`,`ubZdrowotne`,`zaliczkaPIT`,`FGSP` FROM TypyUmowy";
    final String GET_USERS_TYPY_UMOWY_DATA = "SELECT `ID`, `ID_T`, `nazwaSkr`, `nazwa`, `funduszPracy`, `ubWypadkowe`,`ubRentowePracodawca`, `ubRentowePracownik`,`ubEmerytalnePracodawca`,`ubEmerytalnePracownik`,`ubChorobowe`,`ubZdrowotne`,`zaliczkaPIT`,`FGSP` FROM TypyUmowy, UsersData u where ID_T = u.id_t_u ";

    public List<TypyUmowy> getAllTypyUmowy(){
        return baza.query(GET_ALL_TYPY_UMOWY_DATA, getMap());
    }

    public List<TypyUmowy> find_typ_umowy_by_id(int id, JdbcTemplate baza1) {
        List<TypyUmowy> TU =  baza1.query(GET_ALL_TYPY_UMOWY_DATA + " WHERE ID_T =  "+ id +";", getMap());
        return TU;
    }
    public TypyUmowy find_typ_umowy_by_id(int id) {
        return baza.query(GET_ALL_TYPY_UMOWY_DATA + " WHERE ID_T =  "+ id +";", getMap()).get(0);
    }
    public TypyUmowy find_typ_umowy_by_user_id(int id) {
        return baza.query(GET_USERS_TYPY_UMOWY_DATA + " AND ID =  "+ id +";", getMap()).get(0);
    }

    private RowMapper<TypyUmowy> getMap() {
		RowMapper<TypyUmowy> Map = (rs, rowNum) -> {
			TypyUmowy um = new TypyUmowy();
            um.setID(rs.getInt("ID_T"));
            um.setNazwa(rs.getString("nazwa"));
            um.setNazwaSkr(rs.getString("nazwaSkr"));
            um.setFunduszPracy(rs.getFloat("funduszPracy"));
            um.setUbWypadkowe(rs.getFloat("ubWypadkowe"));
            um.setUbRentowePracodawca(rs.getFloat("ubRentowePracodawca"));
            um.setUbRentowePracownik(rs.getFloat("ubRentowePracownik"));
            um.setUbEmerytalnePracodawca(rs.getFloat("ubEmerytalnePracodawca"));
            um.setUbEmerytalnePracownik(rs.getFloat("ubEmerytalnePracownik"));
            um.setUbChorobowe(rs.getFloat("ubChorobowe"));
            um.setUbZdrowotne(rs.getFloat("ubZdrowotne"));
            um.setZaliczkaPIT(rs.getFloat("zaliczkaPIT"));
            um.setFGSP(rs.getFloat("FGSP"));

			return um;
		};
        return Map;
    }
}
