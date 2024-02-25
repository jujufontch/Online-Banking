import java.util.Scanner;

public class AdminKontoSt

{

    public static void manager(){

        System.out.println("Was würden sie dann gerne tun  President???????");
        Admin pdg= new Admin();

        int scan = 0;
        String name ="";
        Scanner scanner =new Scanner(System.in);
        Main main = new Main();
        int wahl =0;

        do {


        System.out.println("Was wollen sie dann machen , geben sie bitte die Nummer ihrer  Wahl ein\n");

        System.out.println("1 . Um Info über alle Kunde zu bekommen\n");
        System.out.println("2 . Um Info über alle durchgeführten Transaktionen anzuzeigen\n");
        System.out.println("3 . Um die von einer bestimmten Kunde ausgeführten Transaktionen anzuzeigen\n");
        System.out.println("4 . Um die von einer bestimmten Kunde ausgeführten Geldabhebungen anzuzeigen\n");
        System.out.println("5 . Um die von einer bestimmten Kunde ausgeführten  Geldeinzahlung anzuzeigen\n");
        System.out.println("100 . Um das Menü zu Beenden ");

        scan = scanner.nextInt();

        switch(scan) {

            case 1:
                System.out.println("1. Sie haben sie sich entschieden Info über alle Kunde zu bekommen\n");
                System.out.println(" Hier sind sie\n");
                pdg.showAllCustomerInfo();

                break;

            case 2:

                System.out.println("2. Sie haben sie sich entschieden Info über alle durchgeführten Transaktionen anzuzeigen\n");
                System.out.println(" Hier sind sie\n");
                pdg.showAllTran();

                break;

            case 3:

                System.out.println("2. Sie haben sie sich entschieden die von einer bestimmten Kunde ausgeführten Transaktionen anzuzeigen\n");
                System.out.println("Geben sie bitte den Benutzername der Kunde\n");

                name = scanner.nextLine();

                while (!main.nameprüfer(name)) {

                    System.out.println("Geben sie bitte einen gültigen Benutzername ein \n");
                    name = scanner.nextLine();


                }

                pdg.customerTransaction(name);

                break;


            case 4:
                System.out.println("2. Sie haben sie sich entschieden die von einer bestimmten Kunde ausgeführten Geldabhebungen anzuzeigen\n");
                System.out.println("Geben sie bitte den Benutzername der Kunde\n");

                name = scanner.nextLine();
                while (!main.nameprüfer(name)) {

                    System.out.println("Geben sie bitte einen gültigen Benutzername ein \n");
                    name = scanner.nextLine();


                }

                pdg.customerWithdrawal(name);

                break;

            case 5:
                System.out.println("2. Sie haben sie sich entschieden die von einer bestimmten Kunde ausgeführten  Geldeinzahlung anzuzeigen\n");
                System.out.println("Geben sie bitte den Benutzername der Kunde\n");

                name = scanner.nextLine();

                while (!main.nameprüfer(name)) {

                    System.out.println("Geben sie bitte einen gültigen Benutzername ein \n");
                    name = scanner.nextLine();


                }

                pdg.customerDeposit(name);

                break;

            case 100:
                System.out.println("Dieses Menü wird beedet !");

                break;

        }

        }  while(wahl!=100);

    }
}
