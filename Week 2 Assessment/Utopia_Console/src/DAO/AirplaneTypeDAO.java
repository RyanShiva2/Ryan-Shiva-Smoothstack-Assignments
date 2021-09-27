package DAO;

import POJO.AirplaneType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneTypeDAO extends BaseDAO<AirplaneType> {

    public AirplaneTypeDAO(Connection conn) {
        super(conn);
    }

    public void addAirplaneType(AirplaneType airplaneType) throws SQLException {
        save("INSERT INTO airplane_type (id, max_capacity) VALUES (?, ?)",
                new Object[]{airplaneType.getAirplaneTypeId(),
                        airplaneType.getMaxCapacity()});
    }

    public void updateAirplaneType(AirplaneType airplaneType) throws SQLException {
        save("UPDATE airplane_type SET max_capacity = ? WHERE id = ?",
                new Object[]{airplaneType.getMaxCapacity(),
                        airplaneType.getAirplaneTypeId()});
    }

    public void deleteAirplaneType(AirplaneType airplaneType) throws SQLException {
        save("DELETE FROM airplane_type WHERE id = ?",
                new Object[]{airplaneType.getAirplaneTypeId()});
    }

    public List<AirplaneType> readAirplaneTypes() throws ClassNotFoundException, SQLException {
        return read("SELECT * FROM airplane_type", null);
    }

    @Override
    protected List<AirplaneType> extractData(ResultSet rs) throws SQLException {
        List<AirplaneType> airplaneTypes = new ArrayList<>();
        while (rs.next()) {
            AirplaneType airplaneType = new AirplaneType();
            airplaneType.setAirplaneTypeId(rs.getInt("id"));
            airplaneType.setMaxCapacity(rs.getInt("max_capacity"));
            airplaneTypes.add(airplaneType);
        }
        return airplaneTypes;
    }
}