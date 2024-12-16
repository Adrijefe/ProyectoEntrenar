package com.AdrianPeiro;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class MainSQL {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/Empresa";
        String user = "adrian";
        String password = "1234567";

        try (Connection connection = DriverManager.getConnection(url,user,password)) {
            Statement statement = connection.createStatement();
            System.out.println(" Base de datos creada con sus datos insertados ");


            System.out.println("Consulta 1");

            String consultaJugadoresYTorneos =
                    "SELECT J.Nombre AS jugador, T.NombreTorneo AS torneo, T.Año AS año " +
                            "FROM Jugadores J " +
                            "JOIN Torneos T ON J.ID_Jugador = T.ID_Jugador";
            ResultSet resultSet1 = statement.executeQuery(consultaJugadoresYTorneos);
            while (resultSet1.next()) {
                System.out.println(resultSet1.getString("jugador") + " " +
                        resultSet1.getString("torneo") + " - "+ resultSet1.getInt("año"));
            }
            System.out.println();

            System.out.println("Consulta 2");
            String consultaJugadoresActividadAntes2000 =
                    "SELECT J.Nombre, A.AñoInicio, A.AñoFin " +
                            "FROM Jugadores J " +
                            "JOIN AñosActividad A ON J.ID_Jugador = A.ID_Años " +
                            "WHERE A.AñoInicio < 2000";
            ResultSet resultSet2 = statement.executeQuery(consultaJugadoresActividadAntes2000);

            while (resultSet2.next()) {
                System.out.println(resultSet2.getString("Nombre") +" - " +
                        resultSet2.getInt("AñoInicio")  + " - "+ resultSet2.getInt("AñoFin"));
            }
            System.out.println();

            System.out.println("Consulta 3");
            String consultaJugadoresPorPais =
                    "SELECT País, COUNT(*) AS cantidad " +
                            "FROM Jugadores " +
                            "GROUP BY País";
            ResultSet resultSet3 = statement.executeQuery(consultaJugadoresPorPais);
            while (resultSet3.next()) {
                System.out.println(resultSet3.getString("País") +" + " + resultSet3.getInt("cantidad"));
            }
            System.out.println();




        }


    }
}
