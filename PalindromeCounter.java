import java.io.*;
import java.util.StringTokenizer;

public class PalindromeCounter {
    public static boolean isPalindrome(String word) {
        word = word.toLowerCase();
        int i = 0, j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return word.length() > 1;
    }
    public static void main(String[] args) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, " ,.;:-!?");
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken();
                    if (isPalindrome(word)) {
                        count++;
                    }
                }
            }
            System.out.println("Total number of palindromes in the file: " + count);
        } catch (FileNotFoundException e) {
            System.out.println("The file 'myfile.txt' was not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}
