
import java.io.FileInputStream;
import java.sql.*;

public class image7 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/newjdbc";
        String username = "root";
        String password = "0069";

        String image_path =
                "C:\\Users\\DELL\\OneDrive\\Desktop\\CHOTU\\Photo-zoom 2.jpg";

        String query = "INSERT INTO image_table(image_data) VALUES (?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //  new driver
            System.out.println("Driver Loaded SuccessFully");

            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Esatblished SuccessFully !");

            FileInputStream fis = new FileInputStream(image_path);
            byte[] imageData = fis.readAllBytes();

            PreparedStatement ps = con.prepareStatement(query);
            ps.setBytes(1, imageData);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Image inserted Successfully !");
            }

            fis.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

