import java.sql.*;

public class Demo1 {
    
    public static void main(String[] args) throws ClassNotFoundException{
     
        String url = "jdbc:mysql://localhost:3306/newjdbc";
        String username = "root";
        String password = "0069";
        String query = "Select * from employees";


        try{
        Class.forName("com.mysql.jdbc.Driver");  // Loaded Driver
        System.out.println("Driver Loaded SuccessFully");
        }
        catch(Exception e) {
            e.printStackTrace();
        }


        try{

            Connection con = DriverManager.getConnection(url, username, password);  // Conection Established
            System.out.println("Connection Esatblished SuccessFully !");

            // Statement interface...
            Statement stmt = con.createStatement(); // no arguments take...
            // ResultSet interface..
            ResultSet rs = stmt.executeQuery(query);
            // get Data..
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");

                System.out.println("ID: " + id);
                System.out.println("Name :" + name);
                System.out.println("Job-Title : " + job_title);
                System.out.println("Salary: " + salary);

            }

            rs.close();
            stmt.close();
            con.close();

            System.out.println("Connection close Successfully");
            
        } 
        catch(Exception e2) {
            e2.printStackTrace();
        }
    }
}
