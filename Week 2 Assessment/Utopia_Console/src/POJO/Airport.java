package POJO;

import java.util.List;

public class Airport {

    private String airportCode;
    private String cityName;
    private List<Route> routes;

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    @Override
    public String toString() {
        return "Airport Code: " + airportCode + ", "
                + "City: " + cityName;
    }
}
