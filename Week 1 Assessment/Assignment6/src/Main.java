public class Main {

    /*Fix the Singleton class*/

    public static void main(String[] args) {
        SampleSingleton s = SampleSingleton.getInstance();
        System.out.println(s.toString());
    }
}
