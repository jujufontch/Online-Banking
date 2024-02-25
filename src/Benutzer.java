import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Month;
import java.util.Scanner;

import java.sql.*;
import java.sql.DriverManager;
public class Benutzer {

    String passwort ="";

    String username ;

    double balance ;

    double prevop;

    sql SQL = new sql();

    Connection conn = SQL.connect();

    Temp zeit = new Temp();

    Statement sentence;



    public Benutzer(String passwort, String name){
        passwort = passwort;

        username = name;

        ResultSet rs = SQL.Result();

        int spalte = SQL.getResultColumn(rs);

        try{

            while (rs.next()) {


                    if(rs.getString(2) == this.passwort){

                        this.balance = rs.getDouble(3);
                    }

                rs.close();

            }
        }
        catch(Exception e){}

    }
    public Benutzer(String passwort, String name ,int i ){

        this.passwort = passwort;
        this.username = name;
        this.balance = 1000000;

        SQL.Benutzercon(name,this.passwort,this.username,sentence);

    }

    /*public void deposit(double amt){
        balance =+amt;

        String d = this.username+"deposits";
        try {

            sentence = conn.createStatement();

            String part1 = "INSERT INTO "+d+" (Amount,Date ) VALUES ('"+amt+"'"+",'"+zeit.getYear();
            String part2= "-"+zeit.getMonth()+"-"+zeit.getDay()+" "+zeit.getHour()+":"+zeit.getMinute()+":";
            String part3 = zeit.getSecond()+"')";




            String teil1 = "INSERT INTO BankOperation (Transaction ,Amount,Date , Customername) VALUES ('deposits',"+amt+"'"+",'"+zeit.getYear();
            String teil2= "-"+zeit.getMonth()+"-"+zeit.getDay()+" "+zeit.getHour()+":"+zeit.getMinute()+":";
            String teil3 = zeit.getSecond()+"','"+this.username+"')";

            String t = this.username+"transactions";

            String partie1 = "INSERT INTO "+t+" (Transaction ,Amount,Date ) VALUES ('deposit',"+amt+"'"+",'"+zeit.getYear();
            String partie2= "-"+zeit.getMonth()+"-"+zeit.getDay()+" "+zeit.getHour()+":"+zeit.getMinute()+":";
            String partie3 = zeit.getSecond()+"')";

            String satz1 = part1+part2+part3;

            String satz2 = teil1+teil2+teil3;


            String satz3 = "UPDATE BankKonto " + " SET balance ='"+balance+"'" + " WHERE passwort ='"+ this.passwort+"';";


            String satz4= partie1+partie2+partie3;

            sentence.execute(satz1);
            sentence.execute(satz2);
            sentence.execute(satz3);
            sentence.execute(satz4);
            System.out.println("OPERATION  SUCCESSFULL!!!\n\n");
        }

        catch (Exception e){

            System.out.println("Error in Insertion of the table\n\n");
        }






    }*/

    public void showTransactions(){

        ResultSet rs = SQL.Operation(username+"transactions");

        int spalte = SQL.getResultColumn(rs);

        SQL.Select(spalte,rs);
    }

    public void showDeposits(){

        ResultSet rs = SQL.Operation(username+"deposits");

        int spalte = SQL.getResultColumn(rs);

        SQL.Select(spalte,rs);


    }

    public void showWithdrawals(){

        ResultSet rs = SQL.Operation(username+"withdrawals");

        int spalte = SQL.getResultColumn(rs);

        SQL.Select(spalte,rs);
    }


    public void deposit(double amt) {

        this.balance += amt;

        String depositTable = this.username + "deposits";

        String transactionsTable = this.username + "transactions";


        SQL.deposit(amt,depositTable,this.username,transactionsTable,balance,passwort);


    }


    public void withdraw(double amt){

        if (this.balance<amt){

            System.out.println("Not enough Money in your Account");
        }
        else {

            this.balance -= amt;

            String withdrawTable = this.username + "withdrawals";

            String transactionsTable = this.username + "transactions";

            SQL.withdraw(amt,withdrawTable,this.username,transactionsTable,balance,passwort);



        }

    }
}
