import java.sql.*;
public class help_display {
    public static void main(String[] args) {
        // Insert a sample row into the students table (optional for testing)
        AmritaDBHelper.insertRow("101", "password123", "Engineering", "CSE", 8.5, 8.7, 50000);

        // Select the row with roll_no "101"
        ResultSet resultSet = AmritaDBHelper.selectRow("101");

        try {
            // Check if the result set is not null and contains at least one row
            if (resultSet != null && resultSet.next()) {
                // Retrieve data from the result set for the first row
                String roll_no = resultSet.getString("roll_no");
                String password = resultSet.getString("password");
                String school = resultSet.getString("school");
                String branch = resultSet.getString("branch");
                double sgpa1 = resultSet.getDouble("sgpa1");
                double sgpa2 = resultSet.getDouble("sgpa2");
                double beforefee = resultSet.getDouble("beforefee");

                // Now you can use the retrieved data as needed
                System.out.println("Roll No: " + roll_no);
                System.out.println("Password: " + password);
                System.out.println("School: " + school);
                System.out.println("Branch: " + branch);
                System.out.println("SGPA1: " + sgpa1);
                System.out.println("SGPA2: " + sgpa2);
                System.out.println("Before Fee: " + beforefee);
            } else {
                // Handle case when no rows are returned for the given roll_no
                System.out.println("No data found for the provided roll number.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the result set to release database resources
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
