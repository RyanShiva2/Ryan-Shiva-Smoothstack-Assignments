public class Main {
    /*  Assignment 2
        Construct a 2D array and find the max number and show its position in the array.*/

    public static void main(String[] args) {
        // Construct 2D array
	    int[][] twoDArray = {
                {12, 3},
                {28, 52},
                {78, 49}
        };

	    // Find Max Number
	    int maxNum = Integer.MIN_VALUE;
	    int[] maxNumIndices = new int[2];

	    for (int i = 0; i < twoDArray.length; ++i) {
	        for (int j = 0; j < twoDArray[i].length; ++j) {
	            if (twoDArray[i][j] > maxNum) {
	                maxNum = twoDArray[i][j];
	                maxNumIndices[0] = i;
	                maxNumIndices[1] = j;
                }
            }
        }
	    System.out.println("The maximum number in the 2D array is: " + maxNum);

	    // Show position
        System.out.println("The position of the maximum number in the array is: (" + maxNumIndices[0] + ", " + maxNumIndices[1] + ")");
    }
}
