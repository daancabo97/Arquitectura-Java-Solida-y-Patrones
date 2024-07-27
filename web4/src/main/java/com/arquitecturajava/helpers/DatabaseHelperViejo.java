package com.arquitecturajava.helpers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHelperViejo {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "";

    // Método para obtener una conexión a la base de datos
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
    	  Class.forName("com.mysql.cj.jdbc.Driver");
      	return DriverManager.getConnection(JDBC_URL, USUARIO, CONTRASEÑA);
    }

    // Método para cerrar la conexión y liberar recursos
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para ejecutar consultas de modificación (inserciones, actualizaciones, eliminaciones)
    public static int executeUpdate(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);

            // Establecer parámetros de la consulta
            for (int i = 0; i < parameters.length; i++) {
                preparedStatement.setObject(i + 1, parameters[i]);
            }

            // Ejecutar la consulta de modificación
            return preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return -1; // Devolver un valor negativo en caso de error
        } finally {
            close(connection, preparedStatement, null);
        }
    }

    // Método para ejecutar consultas de selección
    public static ResultSet executeQuery(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);

            // Establecer parámetros de la consulta
            for (int i = 0; i < parameters.length; i++) {
                preparedStatement.setObject(i + 1, parameters[i]);
            }

            // Ejecutar la consulta de selección
            return preparedStatement.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null; // Devolver null en caso de error
        }
    }
}


