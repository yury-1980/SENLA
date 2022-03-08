import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        System.out.print("enter the string: ");
        String str = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            try{
            sum = sum + Integer.parseInt(String.valueOf(str.charAt(i)));

            }catch (NumberFormatException e){

            }
        }
        System.out.println("sum of digits: " + sum);
    }
}
