import java.sql.Connection;

import java.sql.*;

public class OldBenutzer {

    String Bpasswort ="";

    String Busername ;

    double Bbalance ;

    double Bprevop;

    sql bsql = new sql();

    Connection Bconn = bsql.connect();

    public OldBenutzer(String passwort, String name){
        Bpasswort = passwort;
        Busername = name;

        ResultSet rs = bsql.Result();
        int spalte = bsql.getResultColumn(rs);

        try{

        while (rs.next()) {
            for (int a = 1; a < spalte-1; a++)

                if(rs.getString(a) == this.Bpasswort){

                    this.Bbalance = rs.getDouble(a+1);
                }

            rs.close();

        }}
        catch(Exception e){}











    }
}
