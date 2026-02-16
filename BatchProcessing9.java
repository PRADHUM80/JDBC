import java.sql.*;

public class BatchProcessing9 {
    
        public static void main(String[] args) throws ClassNotFoundException{
     
        String url = "jdbc:mysql://localhost:3306/newjdbc";
        String username = "root";
        String password = "0069";


        try{
        Class.forName("com.mysql.cj.jdbc.Driver");  // Loaded Driver
        System.out.println("Driver Loaded SuccessFully");
        }
        catch(Exception e) {
            e.printStackTrace();
        }


        try{

            Connection con = DriverManager.getConnection(url, username, password);  // Conection Established
            System.out.println("Connection Esatblished SuccessFully !");

            con.setAutoCommit(false);

            Statement stmt = con.createStatement();
            stmt.addBatch("INSERT INTO employees(id, name, job_title,salary) VALUES (9, 'Vashu', 'HR Manager', 65000.00)");
            stmt.addBatch("INSERT INTO employees(id, name, job_title,salary) VALUES (10, 'Karan', 'Cyber Security', 75000.00)");
            stmt.addBatch("INSERT INTO employees(id, name, job_title,salary) VALUES (11,'Vipul', 'Devops', 85000.00)");

            int[] batchResult = stmt.executeBatch();

            con.commit();
            System.out.println("Batch Executed Successfully!!!");







        }

            catch(Exception e2) {
            e2.printStackTrace();
            }


    }  
}
