import java.util.*;

class WordExample {
    private String strdata;

    // Parameterized Constructor
    public WordExample(String str) {
        // Validate sentence termination
        if (!str.endsWith(".") && !str.endsWith("?") && !str.endsWith("!")) {
            throw new IllegalArgumentException("Sentence must end with '.', '?' or '!' only.");
        }
        this.strdata = str.trim();
    }

    // Method to count words that begin and end with a vowel
    public void countWord() {
        String[] words = strdata.substring(0, strdata.length() - 1).split("\\s+");
        int count = 0;
        for (String word : words) {
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                count++;
            }
        }
        System.out.println("Number of words beginning and ending with a vowel: " + count);
    }

    // Method to rearrange words
    public void placeWord() {
        String[] words = strdata.substring(0, strdata.length() - 1).split("\\s+");
        List<String> vowelWords = new ArrayList<>();
        List<String> otherWords = new ArrayList<>();
        
        for (String word : words) {
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                vowelWords.add(word);
            } else {
                otherWords.add(word);
            }
        
        }
        
        // Combine words while maintaining order
        vowelWords.addAll(otherWords);
        String rearrangedSentence = String.join(" ", vowelWords) + strdata.charAt(strdata.length() - 1);
        System.out.println("Rearranged Sentence: " + rearrangedSentence);
    }

    // Helper method to check if a character is a vowel
    private boolean isVowel(char ch) {
        return "AEIOU".indexOf(ch) != -1;
    }

    public static void main(String[] args) {
        WordExample example = new WordExample("APPLE ORANGE UMBRELLA EAGLE TIGER ELEPHANT!");
        example.countWord();
        example.placeWord();
    }
}

