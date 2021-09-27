package DAO;

import POJO.Airplane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneDAO extends BaseDAO<Airplane> {

    public AirplaneDAO(Connection conn) {
        super(conn);
    }

    public void addAirplane(Airplane airplane) throws SQLException {
        save("INSERT INTO airplane (id, type_id) VALUES (?, ?)",
                new Object[]{airplane.getAirplaneId(),
                        airplane.getAirplaneType().getAirplaneTypeId()});
    }

    public void updateAirplane(Airplane airplane) throws SQLException {
        save("UPDATE airplane SET type_id = ? WHERE id = ?",
                new Object[]{airplane.getAirplaneType().getAirplaneTypeId(),
                        airplane.getAirplaneId()});
    }

    public void deleteAirplane(Airplane airplane) throws SQLException {
        save("DELETE FROM airplane WHERE id = ?",
                new Object[]{airplane.getAirplaneId()});
    }

    public List<Airplane> readAirplanes() throws ClassNotFoundException, SQLException {
        return read("SELECT * FROM airplane", null);
    }

    @Override
    protected List<Airplane> extractData(ResultSet rs) throws SQLException {
        List<Airplane> airplanes = new ArrayList<>();
        while (rs.next()) {
            Airplane airplane = new Airplane();
            airplane.setAirplaneId(rs.getInt("id"));
            airplane.getAirplaneType().setAirplaneTypeId(rs.getInt("type_id"));
            airplanes.add(airplane);
        }
        return airplanes;
    }
}