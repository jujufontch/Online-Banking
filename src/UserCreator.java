import java.util.Scanner;
public class UserCreator {



    public static Benutzer create(){

        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        int scan =0;
        String name="";

        String passwort="";


        System.out.println("Da sie keinen Konto besitzen werden wir zusammen gleich einen erstellen \n");

        System.out.println("Geben sie zuerst ihr benutzername ein \n");

        name= scanner.nextLine();

        while(main.nameprüfer(name)==true){
            System.out.println("Sorry dieser name ist schon besetzt  \n Geben sie bitte einen anderen ein");
            name= scanner.nextLine();

        }
        System.out.println("Geben sie jetzt ihr passwort ein \n");

        passwort= scanner.nextLine();

        while(main.passwortprüfer(passwort)==true){

            System.out.println("Sorry dieser passwort ist schon besetzt  \n Geben sie bitte einen anderen ein");
            name= scanner.nextLine();

        }

        Benutzer user = new Benutzer(passwort,name,1);
        return user;

    }
}
