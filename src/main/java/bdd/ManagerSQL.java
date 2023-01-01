package bdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerSQL {

    private static final String SQL_SERVER_AUTHENTICATION_STRING = "jdbc:sqlserver://%s:%s;databaseName=%s;user=%s;password=%s";

    //CONEXION CON LA BASE DE DATOS
    public static Connection getConnectionSQL() {
        Connection con = null;

        String ipServer = "localhost";
        String portServer = "1433";
        String dbName = "ChallengeSql";
        String user = "SqlUser";
        String password = "SqlPassword";
        String connectionUrl = String.format(SQL_SERVER_AUTHENTICATION_STRING, ipServer, portServer, dbName, user, password);

        try {
            con = DriverManager.getConnection(connectionUrl);
            System.out.println("Established Connection");
        } catch (SQLException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        return con;
    }

    public static void closeConnection(Connection con) {
        try {
            con.close();
            System.out.println("Closed Connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> getUsersList() {
        List<String[]> usuarioModelos = new ArrayList<>();
        String[] output = new String[10];
        String query = "Select * from usuarios";

        try {
            Connection con = getConnectionSQL();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                output[0] = rs.getString("idUser");
                output[1] = rs.getString("cedula");
                output[2] = rs.getString("nombre");
                output[3] = rs.getString("apellido");
                output[4] = rs.getString("direccion");
                output[5] = rs.getString("sector");
                output[6] = rs.getString("tel1");
                output[7] = rs.getString("tel2");
                output[8] = rs.getString("email");
                output[9] = rs.getString("genero");
                usuarioModelos.add(output);
                output = new String[10];
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return usuarioModelos;
    }
}