import Service.Admin.AdminService;

import java.sql.SQLException;

public class Utopia {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AdminService adminService = new AdminService();
        adminService.displayAdminMainMenu();

        /*ConnectionUtil connectionUtil = new ConnectionUtil();
        Connection conn = connectionUtil.getConnection();

        AirportDAO airportDAO = new AirportDAO(conn);
        ArrayList<Airport> airports = new ArrayList<>(airportDAO.readAirports());
        RouteDAO routeDAO = new RouteDAO(conn);

        Route route = new Route();
        route.setOriginAirport(airports.get(0));
        route.setDestinationAirport(airports.get(1));

        System.out.println(routeDAO.addRoute(route));
        conn.commit();
        conn.close();*/



        //ATL
        //CLT






/*        ConnectionUtil connectionUtil = new ConnectionUtil();
        Connection conn = connectionUtil.getConnection();

        //Route route = new Route();
        *//*Airport originAirport = new Airport();
        Airport destinationAirport = new Airport();
        originAirport.setAirportCode("ATL");
        destinationAirport.setAirportCode("DEN");
        route.setOriginAirport(originAirport);
        route.setDestinationAirport(destinationAirport);
        route.setRouteId(4);*//*

        //route.getOriginAirport().setAirportCode("ATL");
        //route.getDestinationAirport().setAirportCode("DEN");


        //RouteDAO routeDAO = new RouteDAO(conn);

        //routeDAO.deleteRoute(route);
        //conn.commit();
        //routeDAO.addRoute(route);
        //conn.commit();
        conn.close();

        //System.out.println(routeDAO.readRoutes().toString());

        *//*PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM route WHERE origin_id = ?");
        System.out.println("Enter origin id to search: ");
        Scanner scanner = new Scanner(System.in);
        String originId = scanner.nextLine();
        pstmt.setString(1, originId);

        //4. Exec
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()) {
            System.out.println("Route ID: "+rs.getInt("id"));
            System.out.println("Route Origin ID: "+rs.getString("origin_id"));
            System.out.println("Route Dest ID: "+rs.getString("destination_id"));
            System.out.println("-------------");
        }*/
    }
}
