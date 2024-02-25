
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Month;
import java.util.Scanner;

public class UserIdentifier {

    public static void Benutzer(){

        String name = "";
        String pw = "";
        Scanner scanner =new Scanner(System.in);
        Main main = new Main();

        System.out.println("Zur Anmeldung ihres Konto geben sie zuerst ihr Benutzername ein bitte \n");
        name= scanner.nextLine();

        if(main.nameprüfer(name)==false &&  (!name.equals("0000")))
        while(main.nameprüfer(name)==false){

            System.out.println("Geben sie bitte einen gültigen Benutzername , achten sie auf Gross- und Kleinbuchstaben");
            name=scanner.nextLine();
            if(main.nameprüfer(name)==true)
                break;

        }

        System.out.println("Geben sie jetzt ihr Passworrt ein bitte \n");
        pw= scanner.nextLine();


        if(main.passwortprüfer(pw)==false && (!pw.equals("0000")))
        while(main.passwortprüfer(pw)==false){



        System.out.println("Geben sie bitte einen gültigen Passwort , achten sie auf Gross- und Kleinbuchstaben");
        pw=scanner.nextLine();
        if(main.passwortprüfer(pw)==true)
            break;
 }

        if(name.equals("0000")  && pw.equals("0000")){

           System.out.println("Wilkommen President!!!!!!!!\n");

            AdminKontoSt pdg= new AdminKontoSt();

            pdg.manager();

            int wahl=0;

            System.out.println("Möchten sie noch eine Aktion durchführen President?\n");
            System.out.println("Geben sie bitte 1 ein falls ja\n ");

            wahl= scanner.nextInt();

             while(wahl==1){

                 pdg.manager();

                System.out.println("Möchten sie noch eine Aktion durchführen President?\n");
                System.out.println("Geben sie bitte 1 ein falls ja\n ");


    }









}

        else {

            System.out.println("Wilkommen "+name+"\n");

            Benutzer user = new Benutzer(pw,name);

            KontoSteuern ks = new KontoSteuern();

            ks.manage(user);


        }
}
}
