package POJO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirplaneTest {
    Airplane airplane = new Airplane();

    @Test
    void getAirplaneId() {
        airplane.setAirplaneId(5);
        assertEquals(airplane.getAirplaneId(), 5);
    }

    @Test
    void getAirplaneType() {
        AirplaneType airplaneType = new AirplaneType();
        airplaneType.setAirplaneTypeId(9);
        airplane.setAirplaneType(airplaneType);
        assertEquals(airplane.getAirplaneType().getAirplaneTypeId(), 9);
    }
}