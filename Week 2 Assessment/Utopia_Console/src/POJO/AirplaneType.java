package POJO;

import java.util.List;

public class AirplaneType {

    private Integer airplaneTypeId;
    private Integer maxCapacity;
    private List<Airplane> airplanes;

    public Integer getAirplaneTypeId() {
        return airplaneTypeId;
    }

    public void setAirplaneTypeId(Integer airplaneTypeId) {
        this.airplaneTypeId = airplaneTypeId;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(List<Airplane> airplanes) {
        this.airplanes = airplanes;
    }
}
