import java.util.ArrayList;
import java.util.List;

public class AlternateMerge {
    public static List<Integer> alternate(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        int minSize=Math.min(list1.size(),list2.size());
        for (int i=0; i<minSize;i++) {
            result.add(list1.get(i));
            result.add(list2.get(i));
        }
        if (list1.size()>minSize) {
            result.addAll(list1.subList(minSize, list1.size()));
        } else if (list2.size() > minSize) {
            result.addAll(list2.subList(minSize, list2.size()));
        }

        return result;
    }
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(6, 7, 8, 9, 10, 11, 12);
        List<Integer> result = alternate(list1, list2);
        System.out.println(result);  
    }
}
