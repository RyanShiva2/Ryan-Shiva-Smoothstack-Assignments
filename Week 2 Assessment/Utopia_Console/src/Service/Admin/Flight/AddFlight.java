package Service.Admin.Flight;

import DAO.AirplaneDAO;
import DAO.AirportDAO;
import DAO.FlightDAO;
import DAO.RouteDAO;
import POJO.Airplane;
import POJO.Airport;
import POJO.Flight;
import POJO.Route;
import Service.Admin.AdminService;
import Service.Admin.Airport.AddAirport;
import Service.ConnectionUtil;
import Service.ServiceUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class AddFlight {

    public void addFlight() throws SQLException, ClassNotFoundException {

        ConnectionUtil connUtil = new ConnectionUtil();
        Connection conn = connUtil.getConnection();

        ServiceUtil serviceUtil = new ServiceUtil();
        Scanner scanner = new Scanner(System.in);

        AirportDAO airportDAO = new AirportDAO(conn);
        AirplaneDAO airplaneDAO = new AirplaneDAO(conn);
        FlightDAO flightDAO = new FlightDAO(conn);
        RouteDAO routeDAO = new RouteDAO(conn);
        AdminService adminService = new AdminService();
        AddAirport addAirport = new AddAirport();

        ArrayList<Airport> airports = new ArrayList<>(airportDAO.readAirports());
        ArrayList<Airplane> airplanes = new ArrayList<>(airplaneDAO.readAirplanes());
        ArrayList<String> airportMenuOptions = new ArrayList<>();
        ArrayList<Route> routes = new ArrayList<>(routeDAO.readRoutes());

        Flight flight = new Flight();
        Route route = new Route();
        LocalDate departureDate = null;
        LocalTime departureTime = null;

        final String menuTitle = "ADD FLIGHT";

        try {
            Integer counter = 0;
            for (Airport airport : airports) {
                airportMenuOptions.add(airport.getAirportCode() + " - " + airport.getCityName());
                ++counter;
            }
            airportMenuOptions.add("Create a new Airport");

            System.out.println(menuTitle);

            route.setOriginAirport(getDepartureAirportInput(serviceUtil, airportMenuOptions, flight, airports, addAirport));
            route.setDestinationAirport(getDestinationAirportInput(serviceUtil, airportMenuOptions, flight, airports, addAirport));

            Boolean routeExists = false;
            for (Route routeInDb : routes) {
                if (route.getDestinationAirport().getAirportCode().equals(routeInDb.getDestinationAirport().getAirportCode())
                        && route.getOriginAirport().getAirportCode().equals(routeInDb.getOriginAirport().getAirportCode())) {
                    routeExists = true;
                    flight.getRoute().setRouteId(routeInDb.getRouteId());
                    break;
                }
            }

            if (!routeExists) {
                flight.getRoute().setRouteId(routeDAO.addRoute(route));
            }

            departureDate = getDepartureDateInput(serviceUtil, departureDate, scanner);
            departureTime = getDepartureTimeInput(serviceUtil, departureTime, scanner);

            flight.setDepartureTime(LocalDateTime.of(departureDate, departureTime));

            getAirplaneInput(serviceUtil, airplanes, flight);
            getReservedSeatsInput(flight, scanner);
            getSeatPriceInput(flight, scanner);
            getFlightIdInput(flight, scanner);


            flightDAO.addFlight(flight);
            conn.commit();

            System.out.println("The flight was successfully added.");
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            System.out.println("The flight was not added.");
        } finally {
            if (conn != null) {
                conn.close();
            }
            adminService.displayAdminMainMenu();
        }
    }

    public Airport getDepartureAirportInput(ServiceUtil serviceUtil, ArrayList<String> airportMenuOptions, Flight flight, ArrayList<Airport> airports, AddAirport addAirport) throws SQLException, ClassNotFoundException {
        System.out.println();
        System.out.println("Select a Departure Airport for the Flight: ");

        Airport departureAirport;
        Integer selection = serviceUtil.displayMenu(airportMenuOptions);

        if (selection == airportMenuOptions.size()) {
            addAirport.addAirport();
        } else {
            departureAirport = airports.get(selection - 1);
            flight.getRoute().setOriginAirport(departureAirport);
            airportMenuOptions.remove(selection - 1);
            return departureAirport;
        }
        return null;
    }

    public Airport getDestinationAirportInput(ServiceUtil serviceUtil, ArrayList<String> airportMenuOptions, Flight flight, ArrayList<Airport> airports, AddAirport addAirport) throws SQLException, ClassNotFoundException {
        System.out.println();
        System.out.println("Select a Destination Airport for the Flight: ");

        Airport destinationAirport;
        Integer selection = serviceUtil.displayMenu(airportMenuOptions);

        if (selection == airportMenuOptions.size()) {
            addAirport.addAirport();
        } else {
            for (Airport airport : airports) {
                if (airport.getAirportCode().equals(airportMenuOptions.get(selection - 1).substring(0, 3))) {
                    destinationAirport = airport;
                    flight.getRoute().setDestinationAirport(destinationAirport);
                    return destinationAirport;
                }
            }
        }
        return null;
    }

    public LocalTime getDepartureTimeInput(ServiceUtil serviceUtil, LocalTime departureTime, Scanner scanner) {
        System.out.println();
        System.out.println("Select a Departure Time for the Flight: ");

        ArrayList<String> times = new ArrayList<>();

        for (int i = 1; i <= 24; ++i) {
            times.add(LocalTime.now().truncatedTo(ChronoUnit.HOURS).plusHours(i).toString());
        }
        times.add("Create a new Departure Time");

        Integer selection = serviceUtil.displayMenu(times);

        if (selection == times.size()) {
            return getCustomTimeInput(scanner);
        } else {
            return LocalTime.parse(times.get(selection - 1));
        }
    }

    public LocalDate getDepartureDateInput(ServiceUtil serviceUtil, LocalDate departureDate, Scanner scanner) {
        System.out.println();
        System.out.println("Select a Departure Date for the Flight: ");

        ArrayList<String> dates = new ArrayList<>();

        for (int i = 1; i <= 14; ++i) {
            dates.add(LocalDate.now().plusDays(i).toString());
        }
        dates.add("Create a new Departure Date");

        int selection = serviceUtil.displayMenu(dates);

        if (selection == dates.size()) {
            return getCustomDateInput(scanner);
        } else {
            return LocalDate.parse(dates.get(selection - 1));
        }
    }

    public void getReservedSeatsInput(Flight flight, Scanner scanner) {
        System.out.println();

        Integer selection = -1;
        Boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Input the Number of Reserved Seats: ");
                selection = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (Exception e) {
                e.getMessage();
            }
        }
        flight.setReservedSeats(selection);
    }

    public void getSeatPriceInput(Flight flight, Scanner scanner) {
        System.out.println();

        Boolean validInput = false;
        float userInput = (float) -1.0;
        while (!validInput) {
            try {
                System.out.println("Input the Seat Price: ");
                userInput = Float.parseFloat(scanner.nextLine());
                validInput = true;
            } catch (Exception e) {
                e.getMessage();
            }
        }
        flight.setSeatPrice(userInput);
    }

    public void getAirplaneInput(ServiceUtil serviceUtil, ArrayList<Airplane> airplanes, Flight flight) {
        System.out.println();
        System.out.println("Select the Airplane by its ID: ");

        ArrayList<String> airplaneIDs = new ArrayList<>();
        for (Airplane airplane : airplanes) {
            airplaneIDs.add("ID: " + airplane.getAirplaneId().toString());
        }

        Integer selection = serviceUtil.displayMenu(airplaneIDs);
        flight.getAirplane().setAirplaneId(airplanes.get(selection - 1).getAirplaneId());
    }

    public void getFlightIdInput(Flight flight, Scanner scanner) {
        System.out.println();

        Boolean validInput = false;
        Integer selection = -1;
        while (!validInput) {
            try {
                System.out.println("Input the Flight ID: ");
                selection = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (Exception e) {
                e.getMessage();
            }
        }
        flight.setFlightId(selection);
    }

    public LocalDate getCustomDateInput(Scanner scanner) {
        while (true) {
            try {
                System.out.println();
                System.out.print("Enter the Departure Date (format 'YYYY-MM-DD'): ");
                return LocalDate.parse(scanner.nextLine());
            } catch (Exception ignored) {
            }
        }
    }

    public LocalTime getCustomTimeInput(Scanner scanner) {
        while (true) {
            try {
                System.out.println();
                System.out.print("Enter the Departure Time (format 'HH:MM'): ");
                return LocalTime.parse(scanner.nextLine());
            } catch (Exception ignored) {
            }
        }
    }
}