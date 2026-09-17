import java.sql.*;

public class week8 {
    static final String DB_URL = "jdbc:mysql://localhost:3306/training";
    static final String USER = "root";
    static final String PASS = "Vardhan@09";

    public static void main(String args[]){
        
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            //1. create table 
            String Createtable = "CREATE TABLE IF NOT EXISTS emp1 (Eno INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), salary DECIMAL(10,2), department VARCHAR(50))"; 
            stmt.executeUpdate(Createtable);
            System.out.println(" Employee Table created successfully");

            //2. insert records 
            String insertQuery = "INSERT INTO emp1 (name, salary, department) VALUES ('vamshi', 50000.00, 'Computer Science')";
            stmt.executeUpdate(insertQuery);
            System.out.println("Record 1 inserted successfully");
            
            String insertQuery2 = "INSERT INTO emp1 (name, salary, department) VALUES ('shiva', 60000.00, 'Computer Science')";
            stmt.executeUpdate(insertQuery2);
            System.out.println("Record 2 inserted successfully");

            String retireve="select * from emp1;";
            ResultSet rs=stmt.executeQuery(retireve);
            System.out.println("ID  | name | salary  | department");
            while(rs.next()){
                System.out.println(rs.getInt("Eno") + " | " + rs.getString("name") + " | " + rs.getDouble("salary") + " | " + rs.getString("department"));    
            }

            //3. delete record
            String del="delete from emp1 where Eno=1;";
            stmt.executeUpdate(del);
            System.out.println("Record deleted susccessfully" );

            //4. update record 

            String upd="update emp1 set name='Vardhan' where Eno=2;";
            stmt.executeUpdate(upd);
            System.out.println("Record updated successfully");

            //5. using select query to retrieve records
            String retireve2="select * from emp1;";
            ResultSet rs2=stmt.executeQuery(retireve2);
            System.out.println("ID  | name | salary  | department");
            while(rs2.next()){
                System.out.println(rs2.getInt("Eno") + " | " + rs2.getString("name") + " | " + rs2.getDouble("salary") + " | " + rs2.getString("department"));    
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
