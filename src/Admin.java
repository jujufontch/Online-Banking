import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin {

    sql SQl = new sql();

    Connection con ;

    Statement phrase;

    public void showAllTran(){

        ResultSet rs = SQl.Operation("BankOPeration");
        int spalte = SQl.getResultColumn(rs);

        SQl.Select(spalte,rs);


    }

    public void showAllCustomerInfo(){

        ResultSet rs = SQl.Result();
        int spalte = SQl.getResultColumn(rs);

        SQl.Select(spalte,rs);

    }

    public void customerDeposit(String name){

        ResultSet rs = SQl.Operation(name+"deposits");
        int spalte = SQl.getResultColumn(rs);

        SQl.Select(spalte,rs);


    }

    public void customerWithdrawal(String name){

        ResultSet rs = SQl.Operation(name+"withrawal");
        int spalte = SQl.getResultColumn(rs);

        SQl.Select(spalte,rs);


    }

    public void customerTransaction(String name){

        ResultSet rs = SQl.Operation(name+"transactions");
        int spalte = SQl.getResultColumn(rs);

        SQl.Select(spalte,rs);


    }

}
