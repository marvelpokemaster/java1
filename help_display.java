// Assuming you have called selectRow method and obtained a ResultSet object named resultSet
ResultSet resultSet = MyDatabaseHelper.selectRow("john@example.com");

try {
    // Check if the result set is not null and contains at least one row
    if (resultSet != null && resultSet.next()) {
        // Retrieve data from the result set for the first row
        int id = resultSet.getInt("id");
        String email = resultSet.getString("email");
        String name = resultSet.getString("name");
        String roll = resultSet.getString("roll");
        String school = resultSet.getString("school");
        String specialisation = resultSet.getString("specialisation");
        int fee_initial = resultSet.getInt("fee_initial");
        int sgpa1 = resultSet.getInt("sgpa1");
        int sgpa2 = resultSet.getInt("sgpa2");
        Date lib = resultSet.getDate("lib");
        int indiscipline = resultSet.getInt("indiscipline");

        // Now you can use the retrieved data as needed
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Name: " + name);
        System.out.println("Roll: " + roll);
        System.out.println("School: " + school);
        System.out.println("Specialisation: " + specialisation);
        System.out.println("Fee Initial: " + fee_initial);
        System.out.println("SGPA1: " + sgpa1);
        System.out.println("SGPA2: " + sgpa2);
        System.out.println("Library Date: " + lib);
        System.out.println("Indiscipline: " + indiscipline);
    } else {
        // Handle case when no rows are returned for the given email
        System.out.println("No data found for the provided email.");
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
