package Service.Admin.Seat;

import Service.Admin.AdminService;
import Service.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class UpdateSeat {

    public void updateSeat() throws SQLException, ClassNotFoundException {
        ConnectionUtil connUtil = new ConnectionUtil();
        Connection conn = connUtil.getConnection();

        AdminService adminService = new AdminService();

        try {
            System.out.println("The seat was successfully updated.");
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            System.out.println("The seat was not updated.");
        } finally {
            if (conn != null) {
                conn.close();
            }
            adminService.displayAdminMainMenu();
        }
    }
}
