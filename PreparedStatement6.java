import java.util.Scanner;
import java.sql.*;

public class PreparedStatement6 {
    
        public static void main(String[] args) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/newjdbc";
        String username = "root";
        String password = "0069";
        // String query = "Select * from employees where name = ? AND job_title = ?";  // Check details..

        // insert 
        String query = "INSERT INTO employees(id, name, job_title, salary) VALUES (?, ?, ?, ?) ";


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

            // Scanner Class..
            Scanner sc =  new Scanner(System.in);
            System.out.println("Enter ID : ");
            int id = sc.nextInt();
            System.out.println("Enter Name: ");
            String name = sc.next();
            System.out.println("Enter JOB :");
            String job_title = sc.next();
            System.out.println("Enter Salary: ");
            double salary = sc.nextDouble();

            // PreParedStatement ...
            PreparedStatement preparedStatement = con.prepareStatement(query);
            // Checking.
            // preparedStatement.setString(1, "Pradhum");
            // preparedStatement.setString(2, "fullStack");
            // inserting...

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, job_title);
            preparedStatement.setDouble(4, salary);


            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0) {
                System.out.println("Data inserted Successfully !!");
            } else {
                System.out.println("Insertion failed");
            }

            // ResultSet  resultSet = preparedStatement.executeQuery();

            // boolean found = false;
            // while(resultSet.next()) {
            //     found = true;
            //     int id = resultSet.getInt("id");
            //     String name = resultSet.getString("name");
            //     String job_title = resultSet.getString("job_title");
            //     double salary = resultSet.getDouble("salary");

            //     System.out.println("ID : " + id);
            //     System.out.println("Name : " + name);
            //     System.out.println("JOB Title : " + job_title);
            //     System.out.println("SALARY : " + salary);

    
            // }
            // if(!found) {
            //     System.out.println("Invailed");
            // }

            preparedStatement.close();
            con.close();
            // resultSet.close();
            System.out.println("Connection close Successfully..");



            } 
                    catch(Exception e2) {
            e2.printStackTrace();
        }

    }    
}
