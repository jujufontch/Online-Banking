import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Month;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String scan ="";

        int scann;
        int scann1;
        int scann2;


        String username="";

        String passwort ="";

        int a = 0;
        do{



        System.out.println("Welcome to Cameroon's International Bank\n");
        System.out.println("Haben sie schon einen Bankkonto ? \n");
        System.out.println("  Geben sie bitte ein \n1. Falls ja \n 2 Falls nein ");
        System.out.println("0. Fall sie die Amwendung beenden wollen ");



        scann= scanner.nextInt();

        switch(scann){

            case 1:
                UserIdentifier id = new UserIdentifier();
                id.Benutzer();
                break;

            case 2:
                System.out.println("Wollen sie einen Konto erstellen?\n");
                System.out.println("  Geben sie bitte ein \n1. Falls ja \n 2 Falls nein \n0. Falls sie zurück wollen");
                scann1= scanner.nextInt();


                do {
                    switch(scann1){
                        case 1:

                            UserCreator creator = new UserCreator();

                            Benutzer  object =creator.create();

                            System.out.println("Was sollen sie jetzt machen ?\n\n");
                            System.out.println("Geben sie 1 ein .Falls sie ihrkonto gleich steuern möchten\n");
                            System.out.println("2 .Falls sie zum Hauptmenü gehen wollen ");
                            scann2= scanner.nextInt();

                            do{

                                switch(scann2){

                                    case 1:
                                        KontoSteuern ks= new KontoSteuern();

                                        ks.manage(object);
                                        break;

                                    case 2:
                                        System.out.println("Sie werden zum Hauptmenü weitergeleitet ");
                                        scann1=0;
                                        break;

                                    default:
                                        System.out.println("Falsche Einagbe , versuchen sie es bitte erneut");
                                        break;

                                }
                            }while(scann2!=2);
                            break;

                        case 2:
                            System.out.println("Okay ");
                            break;


                        case 0 :
                            System.out.println("Okay dann sie werden zum Hauptmenü weitergeleitet");
                            scann1=0;
                            break;

                        default:
                            System.out.println("Falsche Eingabe , versucht es erneut");
                            break;


                    }
                }while(scann!= 0);
                break;
            case 0:
                System.out.println("Die Anwendung wird beendet");
                break;

            default:
                System.out.println("Falsche Eingabe , versuchen sie es bitte erneut");
                break;
             }




        } while(scann!=0);

    }

    public static Boolean nameprüfer(String name){

        sql sql= new sql();

        Boolean bool  ;
        int count = 0;

        ResultSet rs = sql.Result();
        int spalte = sql.getResultColumn(rs);

        try{

            while (rs.next()) {


                    if(rs.getString(1).equals(name)){

                        count+=1;
                        break;
                    }




            }rs.close();
        }
        catch(Exception e){}


       if (count==1){
           bool = true;
       }
       else {
           bool= false;
       }

    return bool ;}

    public static Boolean passwortprüfer(String passwort){ sql sql= new sql();

        Boolean bool = true ;

        ResultSet rs = sql.Result();
        int spalte = sql.getResultColumn(rs);
        int count = 0;

        try{

            while (rs.next()) {


                    if(rs.getString(2).equals(passwort)){

                        count+= 1;
                        break;
                    }




            }rs.close();
        }
        catch(Exception e){}


         if(count ==1){

             bool = true;
         }
         else {

             bool = false ;
         }

        return bool ;}
}