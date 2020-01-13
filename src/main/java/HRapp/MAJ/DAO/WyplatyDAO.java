package HRapp.MAJ.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import HRapp.MAJ.Model.Wyplaty;

@Repository
public class WyplatyDAO{

    @Autowired
    private JdbcTemplate baza;

   final String GET_ALL_WYPLATY_DATA = "SELECT ID_w, ID, dataOD, dataDo, dataZaksiegowania, kwotaBrutto, przepracowaneGodziny, imie, nazwisko, kontoBankowe FROM Wyplaty NATURAL JOIN UsersData";
   final String ADD_WYPLATA = "INSERT INTO Wyplaty (ID, dataOd, dataDo, dataZaksiegowania, kwotaBrutto, przepracowaneGodziny) VALUES (?,?,?,?,?,?)";

    public List<Wyplaty> getAllWyplaty(){
        return baza.query(GET_ALL_WYPLATY_DATA, getMap());
    }

    public List<Wyplaty> getAllUsersWyplaty(int ID){
        return baza.query(GET_ALL_WYPLATY_DATA + " WHERE ID = \"" + ID + "\"", getMap());
    }

    public void addWyplata(int id, String dataOd, String dataDo, String dataZaksiegowania, double kwotaBrutto, int przepracowaneGodziny){
        baza.update(ADD_WYPLATA, id, dataOd, dataDo, dataZaksiegowania, kwotaBrutto, przepracowaneGodziny);
    }

    private RowMapper<Wyplaty> getMap() {
		RowMapper<Wyplaty> Map = (rs, rowNum) -> {
			Wyplaty wyplata = new Wyplaty();
            wyplata.setID(rs.getInt("ID"));
            wyplata.setID_w(rs.getInt("ID_w"));
            wyplata.setDataOd(rs.getString("dataOd"));
            wyplata.setDataDo(rs.getString("dataDo"));
            wyplata.setDataZaksiegowania(rs.getString("dataZaksiegowania"));
            wyplata.setKwotaBrutto(rs.getDouble("kwotaBrutto"));
            wyplata.setPrzepracowaneGodziny(rs.getInt("przepracowaneGodziny"));
            wyplata.setNrKonta(rs.getString("kontoBankowe"));
            wyplata.setImie(rs.getString("imie"));
            wyplata.setNazwisko(rs.getString("nazwisko"));

			return wyplata;
		};
        return Map;
    }

}
