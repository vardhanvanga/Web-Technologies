import java.sql.*;

public class crud {
    static final String DB_URL = "jdbc:mysql://localhost:3306/training";
    static final String USER = "root";
    static final String PASS = "admin";

    public static void main(String args[]){
        
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            //1. create table 
            String Createtable = "CREATE TABLE IF NOT EXISTS student (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), cgpa DECIMAL(3,2), department VARCHAR(50))"; 
            stmt.executeUpdate(Createtable);
            System.out.println(" Student Table created successfully");

            //2. inseert records 
            String insertQuery = "INSERT INTO student (name, cgpa, department) VALUES ('vamshi', 3.5, 'Computer Science')";
            stmt.executeUpdate(insertQuery);
            System.out.println("Record 1 inserted successfully");

            String insertQuery2 = "INSERT INTO student (name, cgpa, department) VALUES ('shiva', 4.5, 'Computer Science')";
            stmt.executeUpdate(insertQuery2);
            System.out.println("Record 2 inserted successfully");

            String retireve="select * from student;";
            ResultSet rs=stmt.executeQuery(retireve);
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", CGPA: " + rs.getDouble("cgpa") + ", Department: " + rs.getString("department"));
            }

            //3. delete record
            String del="delete from student where id=1;";
            stmt.executeUpdate(del);
            System.out.println("Record deleted susccessfully" );

            //4. update record 

            String upd="update student set name='Vardhan' where id=2;";
            stmt.executeUpdate(upd);
            System.out.println("Record updated successfully");

            //5. using select query to retrieve records
            String retireve2="select * from student;";
            ResultSet rs2=stmt.executeQuery(retireve2);
            while(rs2.next()){
                System.out.println("ID: " + rs2.getInt("id") + ", Name: " + rs2.getString("name") + ", CGPA: " + rs2.getDouble("cgpa") + ", Department: " + rs2.getString("department"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
