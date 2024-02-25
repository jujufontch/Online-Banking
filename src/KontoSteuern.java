import java.util.Scanner;
public class KontoSteuern {



    public void manage(Benutzer user){

        int scan ;
        Scanner scanner =new Scanner(System.in);
        int wahl =0;
        do{


        System.out.println("Was wollen sie dann machen , geben sie bitte die Nummer ihrer  Wahl ein\n");

        System.out.println("1 . Um Geld abzuheben\n");
        System.out.println("2 . Um Geld einzuzahlen\n");
        System.out.println("3 . Um die von Ihnen ausgeführten Transaktionen anzuzeigen\n");
        System.out.println("4 . Um die von Ihnen ausgeführten Geldabhebungen anzuzeigen\n");
        System.out.println("5 . Um die von Ihnen ausgeführten  Geldeinzahlung anzuzeigen\n");
        System.out.println("0 . Um das Menü zu beenden");

        scan = scanner.nextInt();

             switch(scan) {


                 case 1:

                     System.out.println("Sie haben sie sich dafür entschieden Geld abzuheben\n");

                     System.out.println("Geben sie bitte den Betrag der sie vom Konto abheben möchten\n");

                     int betrag = scanner.nextInt();

                     while (user.balance > betrag) {

                         System.out.println("Sie haben nicht genug Geld im Konto \n");
                         System.out.println("Geben sie bitte einen anderen betrag der kleiner als" + user.balance + "ist\n");
                         betrag = scanner.nextInt();
                     }

                     user.withdraw(betrag);
                     System.out.println(" Erfolgreiche Operation !!!\n");
                     break;

                 case 2:
                     System.out.println("Sie haben sie sich dafür entschieden Geld einzuzahlen\n");

                     System.out.println("Geben sie bitte den Betrag der sie in den Konto einzahlen möchten\n");

                     double amount = scanner.nextDouble();

                     user.deposit(amount);
                     System.out.println(" Erfolgreiche Operation !!!\n");
                     break;

                 case 3:
                     System.out.println("3 . Sie haben sie sich entschieden die von Ihnen ausgeführten Transaktionen anzuzeigen\n");
                     System.out.println(" Hier sind sie\n");
                     user.showTransactions();
                     break;

                 case 4:
                     System.out.println("4 . Sie haben sie entschiden die von Ihnen ausgeführten Geldabhebungen anzuzeigen\n");
                     System.out.println(" Hier sind sie\n");
                     user.showWithdrawals();
                     break;

                 case 5:
                     System.out.println("5 . Um die von Ihnen ausgeführten  Geldeinzahlung anzuzeigen\n");
                     System.out.println(" Hier sind sie\n");
                     user.showDeposits();
                     break;

                 default:
                     System.out.println(" sie haben leider eine falsche nummer eingegeben \n");

                     break;

                 case 0:

                     System.out.println("Das Menü wird beendet");
                     break;


             }
        }
              while(scan!=0);
}

    }

