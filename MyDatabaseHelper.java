import java.sql.*;

public class MyDatabaseHelper {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void insertRow(String email, String password, String name, String roll, String school,
                                 String specialisation, int fee_initial, int sgpa1, int sgpa2, Date lib, int indiscipline) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String insertQuery = "INSERT INTO mytable (email, password, name, roll, school, specialisation, " +
                    "fee_initial, sgpa1, sgpa2, lib, indiscipline) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, roll);
            preparedStatement.setString(5, school);
            preparedStatement.setString(6, specialisation);
            preparedStatement.setInt(7, fee_initial);
            preparedStatement.setInt(8, sgpa1);
            preparedStatement.setInt(9, sgpa2);
            preparedStatement.setDate(10, lib);
            preparedStatement.setInt(11, indiscipline);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows inserted: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet selectRow(String email) {
        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String selectQuery = "SELECT * FROM mytable WHERE email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, email);

            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public static void updateRow(String email, String newPassword, String newName, String newRoll, String newSchool,
                            String newSpecialisation, int newFeeInitial, int newSGPA1, int newSGPA2, Date newLib,
                            int newIndiscipline) {
                                
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String updateQuery = "UPDATE mytable SET password = ?, name = ?, roll = ?, school = ?, specialisation = ?, " +
                    "fee_initial = ?, sgpa1 = ?, sgpa2 = ?, lib = ?, indiscipline = ? WHERE email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, newName);
            preparedStatement.setString(3, newRoll);
            preparedStatement.setString(4, newSchool);
            preparedStatement.setString(5, newSpecialisation);
            preparedStatement.setInt(6, newFeeInitial);
            preparedStatement.setInt(7, newSGPA1);
            preparedStatement.setInt(8, newSGPA2);
            preparedStatement.setDate(9, newLib);
            preparedStatement.setInt(10, newIndiscipline);
            preparedStatement.setString(11, email);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows updated: " + rowsAffected);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean emailExists(String email) {
        boolean exists = false;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String selectQuery = "SELECT COUNT(*) AS count FROM mytable WHERE email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                exists = count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }
}
