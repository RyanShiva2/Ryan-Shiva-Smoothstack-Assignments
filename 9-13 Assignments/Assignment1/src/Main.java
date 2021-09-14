public class Main {

    public static int periodCount = 9;

    public static void main(String[] args) {
        //Print Pattern 1
        System.out.println("1)");
        for (int i = 1; i <= 4; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }
        printPeriods();

        //Print Pattern 2
        System.out.println("2)");
        printPeriods();
        for (int i = 4; i >= 1; --i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }

        //Print Pattern 3
        System.out.println("3)");
        for (int i = 1; i <= 4; ++i) {
            for (int j = 5; j >= i; --j) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }
        printPeriods();

        //Print Pattern 4
        System.out.println("4)");
        printPeriods();
        for (int i = 4; i >= 1; --i) {
            for (int j = 5; j >= i; --j) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printPeriods() {
        for (int i = 1; i <= periodCount; ++i) {
            System.out.print(".");
        }
        System.out.println();
        ++periodCount;
    }
}
