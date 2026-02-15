import java.sql.*;

public class TransactionHandling8 {
        public static void main(String[] args) throws ClassNotFoundException{
     
        String url = "jdbc:mysql://localhost:3306/newjdbc";
        String username = "root";
        String password = "0069";
        String withdrawQuery = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
        String depositeQuery = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";


        try{
        Class.forName("com.mysql.cj.jdbc.Driver");  // Loaded Driver
        System.out.println("Driver Loaded SuccessFully");
        }
        catch(Exception e) {
            e.printStackTrace();
        }



            try  {
                 Connection con = DriverManager.getConnection(url, username, password);  // Conection Established
                 System.out.println("Connection Esatblished SuccessFully !");
                 con.setAutoCommit(false);

                 PreparedStatement withdrawStatement = con.prepareStatement(withdrawQuery);
                 PreparedStatement depositStatement = con.prepareStatement(depositeQuery);

                 withdrawStatement.setDouble(1, 500.00);
                 withdrawStatement.setString(2, "account123");

                 depositStatement.setDouble(1, 500.00);
                 depositStatement.setString(2, "account456");

                 int rowsAffectedWithdrawl = withdrawStatement.executeUpdate();
                 int rowsAffectedDiposit = depositStatement.executeUpdate();
                 if(rowsAffectedWithdrawl > 0  && rowsAffectedDiposit > 0) {
                    System.out.println("Transaction Successfu!");
                 } 
                 else {
                    con.rollback();
                    System.out.println("Transaction Failed !!!");
                 }
                //  withdrawStatement.executeUpdate();
                //  depositStatement.executeUpdate();
                //  con.commit();
                //  System.out.println("Transaction Successful !");

            }
            catch(Exception e2) {
            e2.printStackTrace();  // rollback().
            }



    } 
}
