import java.util.Scanner;

public class RearrangeArray {
    public static void rearrange(int[] arr) {
        int left = 0, right = 0;
        
        while (right < arr.length) {
            if (arr[right] < 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        rearrange(arr);
        
        System.out.println("Rearranged array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        sc.close();
    }
}

