package HRapp.MAJ.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import HRapp.MAJ.Model.Stanowiska;

@Repository
public class StanowiskaDAO{

    @Autowired
    private JdbcTemplate baza;

    final String GET_ALL_STANOWISKA_DATA = "SELECT ID_s, Nazwa, NazwaSkr FROM stanowiska";

    public List<Stanowiska> getAllStanowiska(){
        return baza.query(GET_ALL_STANOWISKA_DATA, getMap());
    }

    private RowMapper<Stanowiska> getMap() {
		RowMapper<Stanowiska> Map = (rs, rowNum) -> {
			Stanowiska stan = new Stanowiska();
            stan.setID(rs.getInt("ID_s"));
            stan.setNazwa(rs.getString("Nazwa"));
            stan.setNazwaSkr(rs.getString("NazwaSkr"));

			return stan;
		};
        return Map;
    }

}
