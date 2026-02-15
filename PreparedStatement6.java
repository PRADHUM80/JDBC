
import java.sql.*;
public class PreparedStatement6 {
    
        public static void main(String[] args) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/newjdbc";
        String username = "root";
        String password = "0069";
        String query = "Select * from employees where name = ? AND job_title = ?";


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

            // PreParedStatement ...

            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, "Pradhum");
            preparedStatement.setString(2, "fullStack");

            ResultSet  resultSet = preparedStatement.executeQuery();

            boolean found = false;
            while(resultSet.next()) {
                found = true;
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String job_title = resultSet.getString("job_title");
                double salary = resultSet.getDouble("salary");

                System.out.println("ID : " + id);
                System.out.println("Name : " + name);
                System.out.println("JOB Title : " + job_title);
                System.out.println("SALARY : " + salary);

    
            }
            if(!found) {
                System.out.println("Invailed");
            }

            con.close();
            resultSet.close();
            System.out.println("Connection close Successfully..");



            } 
                    catch(Exception e2) {
            e2.printStackTrace();
        }

    }    
}
