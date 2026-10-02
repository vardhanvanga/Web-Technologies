import java.sql.*;

public class week9 {

    // Database details
    static final String URL = "jdbc:mysql://localhost:3306/training";
    static final String USER = "root";
    static final String PASSWORD ="Vardhan@09";

    public static void main(String[] args) {

        try {
            // Load MySQL JDBC Driver
            //Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // 1. CREATE TABLE
            String createTable = """
                    CREATE TABLE IF NOT EXISTS product (
                        product_no INT PRIMARY KEY,
                        name VARCHAR(100),
                        image VARCHAR(255),
                        price DECIMAL(10,2)
                    )
                    """;

            Statement st = con.createStatement();
            st.executeUpdate(createTable);
            System.out.println("Product table created successfully.");

            // 2. INSERT
            String insertSQL =
                    "INSERT INTO product (product_no, name, image, price) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(insertSQL);

            ps.setInt(1, 101);
            ps.setString(2, "Laptop");
            ps.setString(3, "laptop.jpg");
            ps.setDouble(4, 55000.00);

            ps.executeUpdate();
            System.out.println("Product inserted successfully.");

            // 3. RETRIEVE
            String selectSQL = "SELECT * FROM product WHERE product_no = ?";

            ps = con.prepareStatement(selectSQL);
            ps.setInt(1, 101);

            ResultSet rs = ps.executeQuery();

            System.out.println("\nProduct Details:");
            while (rs.next()) {
                System.out.println("Product No : " + rs.getInt("product_no"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Image      : " + rs.getString("image"));
                System.out.println("Price      : " + rs.getDouble("price"));
            }

            // 4. UPDATE
            String updateSQL =
                    "UPDATE product SET name = ?, image = ?, price = ? WHERE product_no = ?";

            ps = con.prepareStatement(updateSQL);

            ps.setString(1, "Gaming Laptop");
            ps.setString(2, "gaming_laptop.jpg");
            ps.setDouble(3, 75000.00);
            ps.setInt(4, 101);

            ps.executeUpdate();
            System.out.println("\nProduct updated successfully.");

            // 5. DELETE
            String deleteSQL = "DELETE FROM product WHERE product_no = ?";

            ps = con.prepareStatement(deleteSQL);
            ps.setInt(1, 101);

            ps.executeUpdate();
            System.out.println("Product deleted successfully.");
 
            // Close resources
            rs.close();
            ps.close();
            st.close();
            con.close();

        }catch (SQLException e) {
            System.out.println("Database error.");
            e.printStackTrace();
        }
    }
}