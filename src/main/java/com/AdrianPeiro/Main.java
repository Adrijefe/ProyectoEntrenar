package com.AdrianPeiro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:src/main/resources/sqlite.db";
        String sql = "src/main/resources/tenistas.sql";

        try (Connection connection = DriverManager.getConnection(url)) {
            Statement statement = connection.createStatement();
            String archivoLeidoSql = new String(Files.readAllBytes(Paths.get(sql)));
            statement.executeUpdate(archivoLeidoSql);
            System.out.println(" Base de datos creada con sus datos insertados ");

            String consultaJugadoresYListas =
                    "SELECT J.Nombre AS jugador, L.NombreLista AS lista " +
                            "FROM Jugadores J " +
                            "JOIN ListaJugadores L ON J.ID_Lista = L.ID_Lista";
            ResultSet resultSet = statement.executeQuery(consultaJugadoresYListas);
            System.out.println(" Jugadores: ");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("jugador") + " pertenece a " + resultSet.getString("lista"));
            }
            System.out.println();

            String consultaJugadoresConMasDe10GrandSlam = "SELECT Nombre, País, Títulos_Grand_Slam " +
                            "FROM Jugadores " +
                            "WHERE Títulos_Grand_Slam > 10";
            ResultSet resultSet2 = statement.executeQuery(consultaJugadoresConMasDe10GrandSlam);
            System.out.println("Jugadores con más de 10 títulos de Grand Slam: ");
            while (resultSet2.next()) {
                System.out.println(resultSet2.getString("Nombre") + " de " +
                        resultSet2.getString("País") + " tiene " +
                        resultSet2.getInt("Títulos_Grand_Slam") + " títulos.");
            }
            System.out.println();

            String consultaJugadoresPorPais = "SELECT Nombre FROM Jugadores WHERE País = 'España'";
            ResultSet resultSet3 = statement.executeQuery(consultaJugadoresPorPais);
            System.out.println("Jugadores de España: ");
            while (resultSet3.next()) {
                System.out.println(resultSet3.getString("Nombre"));
            }
            System.out.println();

            String consultaJugadoresActivos = "SELECT Nombre, Años_Actividad " +
                            "FROM Jugadores " +
                            "WHERE Años_Actividad LIKE '%presente%'";
            ResultSet resultSet4 = statement.executeQuery(consultaJugadoresActivos);
            System.out.println("Jugadores activos: ");
            while (resultSet4.next()) {
                System.out.println(resultSet4.getString("Nombre")  +
                        resultSet4.getString("Años_Actividad") + ")");
            }
            System.out.println();

            String consultaMejorTorneoPorJugador = "SELECT J.Nombre, T.NombreTorneo, T.Año, T.Resultado " +
                            "FROM Jugadores J " +
                            "JOIN Torneos T ON J.ID_Jugador = T.ID_Jugador " +
                            "WHERE T.Resultado = 'Campeón' " +
                            "ORDER BY J.ID_Jugador";
            ResultSet resultSet5 = statement.executeQuery(consultaMejorTorneoPorJugador);
            System.out.println("Mejor torneo de cada jugador: ");
            while (resultSet5.next()) {
                System.out.println(resultSet5.getString("Nombre") + " gano en: " +
                        resultSet5.getString("NombreTorneo") + " (" + resultSet5.getInt("Año") + ")");
            }
            System.out.println();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
