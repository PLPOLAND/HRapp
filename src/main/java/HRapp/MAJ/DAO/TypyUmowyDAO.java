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

    final String GET_ALL_TYPY_UMOWY_DATA = "SELECT ID_T, nazwa, nazwaSkr, podatek FROM typyumowy";

    public List<TypyUmowy> getAllTypyUmowy(){
        return baza.query(GET_ALL_TYPY_UMOWY_DATA, getMap());
    }

    private RowMapper<TypyUmowy> getMap() {
		RowMapper<TypyUmowy> Map = (rs, rowNum) -> {
			TypyUmowy um = new TypyUmowy();
            um.setID(rs.getInt("ID_T"));
            um.setNazwa(rs.getString("nazwa"));
            um.setNazwaSkr(rs.getString("nazwaSkr"));
            um.setPodatek(rs.getFloat("podatek"));

			return um;
		};
        return Map;
    }
}
