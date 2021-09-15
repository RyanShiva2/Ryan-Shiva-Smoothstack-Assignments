public class Main {

    /*  Assignment 1
        Take multiple values from the command line and show the result of adding all of them.*/

    public static void main(String[] args) {
        int result = 0;

        try {
            for (String arg : args) {
                result += Integer.parseInt(arg);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Command Line Arguments contain a non-integer value.");
            System.exit(0);
        }

        System.out.println("The result of adding the command line arguments is: " + result);
    }
}
