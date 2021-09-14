import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Random rand = new Random();
		int answer = rand.nextInt(100) + 1;

		for (int i = 1; i <= 5; ++i) {
			System.out.println("Please guess a number from 1-100.");
			int guess = scanner.nextInt();

			if (Math.abs(answer - guess) <= 10) {
				System.out.println("The correct answer was " + answer + ".");
				System.exit(0);
			} else if (i < 5) {
				System.out.println("Please guess again.");
			} else {
				System.out.println("Sorry, the correct answer was " + answer + ".");
			}
		}
	}
}
