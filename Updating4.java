import java.sql.*;

public class Updating4 {

    public static void main(String[] args) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/newjdbc";
        String username = "root";
        String password = "0069";
        String query = "UPDATE employees\n" + "SET job_title = 'FullStack', salary = 69000.0\n " + "WHERE id = 3;" ;

        try{
        Class.forName("com.mysql.jdbc.Driver");  // Loaded Driver
        System.out.println("Driver Loaded SuccessFully");
        }
        catch(Exception e) {
            e.printStackTrace();
        }


        try {
            
            Connection con = DriverManager.getConnection(url, username, password);  // Conection Established
            System.out.println("Connection Esatblished SuccessFully !");

            // Statement interface...
            Statement stmt = con.createStatement();
            int rowsaffected = stmt.executeUpdate(query); // delete 

            if(rowsaffected > 0) {
                System.out.println("Update SuccessFully : " + rowsaffected + "row(s) affected. ");

            } else {
                System.out.println("Update failed!!");
            }

            stmt.close();
            con.close();
            System.out.println("Connection close Successfully");


        } 
        catch(Exception e2) {
            e2.printStackTrace();
        }


    }
    
}
