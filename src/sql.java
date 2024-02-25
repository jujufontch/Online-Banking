import java.sql.*;

public class sql {

    private Connection connect = connect();

    public Connection connect(){
    String url ;
    Connection connexion= null;
    String password = "0000";
    String user = "root" ;
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");


    } catch (ClassNotFoundException e) {

        System.out.println("Error ");
    }


        try {

        connexion = DriverManager.getConnection("jdbc:mysql://localhost:3305/S", "root", "0000");


    }
        catch(Exception e ){

        System.out.println("Verbindung fehlgeschlagen");
    }
        return connexion;
}

    public ResultSet Result(){

    ResultSet result = null;

    try{

        Connection connector = this.connect();

        Statement sentence = connector.createStatement();

        String satz = "SELECT * FROM BankKonto;";

        sentence.execute(satz);
        result = sentence.executeQuery(satz);}
    catch(Exception e){

    }


    return result;

    }

    public void Benutzercon(String name,String passwort,String username,Statement sentence){

        try {

            sentence = connect.createStatement();

            String satz = "INSERT INTO BankKonto (username,passwort ,balance ) VALUES ('"+name+"','"+passwort+"','1000000');";

            String w = username+"withdrawals";

            String d = username+"deposits";

            String t = username+"transactions";


            String satz1 = "CREATE TABLE "+ w+" ( Amount varchar(255), Date datetime  ); ";

            String satz2 = "CREATE TABLE "+ d +" ( Amount varchar(255), Date datetime ); ";

            String satz3 = "CREATE TABLE "+ t +" ( Transaction varchar(255),Amount varchar(255), Date datetime ); ";



            sentence.execute(satz);
            sentence.execute(satz1);
            sentence.execute(satz2);
            sentence.execute(satz3);
            System.out.println("OPERATION  SUCCESSFULL!!!\n\n");
        }

        catch (Exception e){

            System.out.println("Error in Insertion of the table\n\n");
        }
    }

    public int getResultColumn(ResultSet r){
    int columns = 0;
try{
      columns = r.getMetaData().getColumnCount();}

catch(Exception e){
    System.out.println("Error");
     }

return columns;



 }

    public ResultSet Operation(String phrase){

        ResultSet result = null;

        try{

            Connection connector = this.connect();

            Statement sentence = connector.createStatement();

            String satz = "SELECT * FROM "+phrase+" ;";

            sentence.execute(satz);
            result = sentence.executeQuery(satz);}
        catch(Exception e){

        }


        return result;

    }

    public void Select(int spalte, ResultSet rs){

        try {

            for (int i = 1; i < spalte+1; i++)

                System.out.print(String.format("%-15s", rs.getMetaData().getColumnLabel(i)));

            System.out.println();
            System.out.println("--------------------------------------------------------------");

            while (rs.next()) {
                for (int i = 1; i < spalte+1; i++)

                    System.out.print(String.format("%-15s", rs.getString(i)));

                System.out.println();

            }


            rs.close();


        }
        catch(Exception e){}


    }

    public void deposit (double amt, String depositTable,String username , String transactionsTable, double balance, String passwort){

        try {
            PreparedStatement depositStatement = connect.prepareStatement(
                    "INSERT INTO " + depositTable + " (Amount, Date) VALUES (?, ?)"
            );
            depositStatement.setDouble(1, amt);
            depositStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            depositStatement.executeUpdate();

            PreparedStatement operationStatement = connect.prepareStatement(
                    "INSERT INTO BankOPeration (Transaction, Amount, Date, Customername) VALUES (?, ?, ?, ?)"
            );
            operationStatement.setString(1, "deposits");
            operationStatement.setDouble(2, amt);
            operationStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            operationStatement.setString(4, username);
            operationStatement.executeUpdate();

            PreparedStatement transactionStatement = connect.prepareStatement(
                    "INSERT INTO " + transactionsTable + " (Transaction, Amount, Date) VALUES (?, ?, ?)"
            );
            transactionStatement.setString(1, "deposit");
            transactionStatement.setDouble(2, amt);
            transactionStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            transactionStatement.executeUpdate();

            // Update the balance in BankKonto table
            PreparedStatement updateStatement = connect.prepareStatement(
                    "UPDATE BankKonto SET balance = ? WHERE passwort = ?"
            );
            updateStatement.setDouble(1, balance);
            updateStatement.setString(2, passwort);
            updateStatement.executeUpdate();

            System.out.println("Operation successful!\n\n");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in insertion of the table\n\n");
        }
    }

    public void withdraw (double amt, String depositTable,String username , String transactionsTable, double balance, String passwort){

        try {
            PreparedStatement depositStatement = connect.prepareStatement(
                    "INSERT INTO " + depositTable + " (Amount, Date) VALUES (?, ?)"
            );
            depositStatement.setDouble(1, amt);
            depositStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            depositStatement.executeUpdate();

            PreparedStatement operationStatement = connect.prepareStatement(
                    "INSERT INTO BankOPeration (Transaction, Amount, Date, Customername) VALUES (?, ?, ?, ?)"
            );
            operationStatement.setString(1, "withdrawal");
            operationStatement.setDouble(2, amt);
            operationStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            operationStatement.setString(4, username);
            operationStatement.executeUpdate();

            PreparedStatement transactionStatement = connect.prepareStatement(
                    "INSERT INTO " + transactionsTable + " (Transaction, Amount, Date) VALUES (?, ?, ?)"
            );
            transactionStatement.setString(1, "withdrawal");
            transactionStatement.setDouble(2, amt);
            transactionStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            transactionStatement.executeUpdate();

            // Update the balance in BankKonto table
            PreparedStatement updateStatement = connect.prepareStatement(
                    "UPDATE BankKonto SET balance = ? WHERE passwort = ?"
            );
            updateStatement.setDouble(1, balance);
            updateStatement.setString(2, passwort);
            updateStatement.executeUpdate();

            System.out.println("Operation successful!\n\n");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in insertion of the table\n\n");
        }
    }




}
