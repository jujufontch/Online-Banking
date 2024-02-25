import java.util.Scanner;

public class A {

    static int s = 0;
    static int s1 = 0;
    static int s11=0;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        do {
            System.out.println("Wählen Sie: ");
            System.out.println("1. Option 1");
            System.out.println("2. Option 2");
            System.out.println("100. Beenden");

            s = scanner.nextInt();

            switch (s) {
                case 1:
                    handleOption1(scanner);
                    break;
                case 2:
                    handleOption2(scanner);
                    break;
                case 100:
                    System.out.println("Auf Wiedersehen");
                    break;
                default:
                    System.out.println("Ungültige Eingabe. Versuchen Sie es erneut.");
                    break;
            }

        }
        while (s != 100);

        scanner.close();
    }

    private static void handleOption1(Scanner scanner) {


        do {
            System.out.println("Wählen Sie (1): ");
            System.out.println("1(1). Option 1");
            System.out.println("2(1). Option 2");
            System.out.println("100. Zurück");

            s1 = scanner.nextInt();

            switch (s1) {
                case 1:
                    handleOption11(scanner);
                    break;
                case 2:
                    System.out.println("Wählen Sie (1) zurück");
                    s1= 100;
                    break;
                case 100:
                    System.out.println("Zurück");
                    break;
                default:
                    System.out.println("Ungültige Eingabe. Versuchen Sie es erneut.");
                    break;
            }
        } while (s1 != 100);
    }

    private static void handleOption11(Scanner scanner) {


        do {
            System.out.println("Wählen Sie (11): ");
            System.out.println("1(11). Option 1");
            System.out.println("2(11). Option 2");
            System.out.println("100. Zurück");

            s11 = scanner.nextInt();

            switch (s11) {
                case 1:
                    System.out.println("Wählen Sie (111): ");
                    System.out.println("1(111). Option 1");
                    System.out.println("2(111). Option 2");
                    s11=100;
                    s1=100;

                    break;
                case 100:
                    System.out.println("Zurück");
                    break;
                default:
                    System.out.println("Ungültige Eingabe. Versuchen Sie es erneut.");
                    break;
            }
        } while (s11 != 100);
    }

    private static void handleOption2(Scanner scanner) {
        int s2;

        do {
            System.out.println("Wählen Sie (2): ");
            System.out.println("1(2). Option 1");
            System.out.println("2(2). Option 2");
            System.out.println("100. Zurück");

            s2 = scanner.nextInt();

            switch (s2) {
                case 1:
                    System.out.println("Wählen Sie (21): ");
                    System.out.println("1(21). Option 1");
                    System.out.println("2(21). Option 2");
                    break;
                case 100:
                    System.out.println("Zurück");
                    break;
                default:
                    System.out.println("Ungültige Eingabe. Versuchen Sie es erneut.");
                    break;
            }
        } while (s2 != 100);
    }
}
