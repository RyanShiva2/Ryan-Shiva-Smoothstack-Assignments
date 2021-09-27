import Service.WelcomeMenu;

import java.sql.SQLException;

public class Utopia {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        WelcomeMenu welcomeMenu = new WelcomeMenu();
        welcomeMenu.displayWelcomeMenu();
    }
}
