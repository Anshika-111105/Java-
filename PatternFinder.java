import java.util.*;
import java.util.regex.*;

public class PatternFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a binary string: ");
        String binaryString = input.nextLine();
        // Regex pattern to match "0+1+0"
        String regex = "0+1+0";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(binaryString);
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Match found: " + matcher.group() + " at index " + matcher.start());
        }
        System.out.println("Total patterns found: " + count);
        input.close();
    }
}
