import java.util.ArrayList;

public class PairwiseSwap {
    
    public static void swapPairs(ArrayList<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            // Swap elements at index i and i+1
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("four");
        list.add("score");
        list.add("and");
        list.add("seven");
        list.add("years");
        list.add("ago");

        swapPairs(list);
        System.out.println(list); // Output: [score, four, seven, and, ago, years]

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("to");
        list2.add("be");
        list2.add("or");
        list2.add("not");
        list2.add("to");
        list2.add("be");
        list2.add("hamlet");

        swapPairs(list2);
        System.out.println(list2); // Output: [be, to, not, or, be, to, hamlet]
    }
}
