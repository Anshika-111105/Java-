import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

public class StringListProcessor {
    public static void removeEvenLength(ArrayList<String> list) {
        
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.length() % 2 == 0) {
                iterator.remove();
            }
        }
    }
    public static void removeEvenLengthModern(ArrayList<String> list) {
        list.removeIf(str -> str.length() % 2 == 0);
    }
    
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(
            "hello", "world", "java", "programming", "code", "test", "a", "collection"
        ));
        System.out.println("Original list: " + words);
        removeEvenLength(words);
        System.out.println("After removing even length strings: " + words);
    }
}