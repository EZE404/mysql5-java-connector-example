package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {
    Connection conn = null;
    public Connection getConnection() {

        try {
            // Class.forName("com.mysql.jdbc.Driver"); // Not really needed
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba_docker?" +
                            "user=root&password=jorgito");

            System.out.println("CONECTADO");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return this.conn;
    }

    public void closeConnection() {
        try {
            if (this.conn != null) {
                this.conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
