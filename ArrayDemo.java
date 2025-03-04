import java.util.Arrays;

class ArrayDemo {
    
    // Method to find pairs whose sum is equal to a given number
    void arrayFunc(int arr[], int target) {
        System.out.println("Pairs of elements whose sum is " + target + " are :");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println(arr[i] + " + " + arr[j] + " = " + target);
                }
            }
        }
    }

    // Method to merge two sorted arrays while maintaining sorted order
    void arrayFunc(int A[], int p, int B[], int q) {
        int merged[] = new int[p + q];
        System.arraycopy(A, 0, merged, 0, p);
        System.arraycopy(B, 0, merged, p, q);
        
        Arrays.sort(merged);
        
        System.arraycopy(merged, 0, A, 0, p);
        System.arraycopy(merged, p, B, 0, q);
        
        System.out.println("Array A after merging: " + Arrays.toString(A));
        System.out.println("Array B after merging: " + Arrays.toString(B));
    }

    public static void main(String[] args) {
        ArrayDemo obj = new ArrayDemo();
        
        int numbers[] = {4, 6, 5, -10, 8, 5, 20};
        int target = 10;
        obj.arrayFunc(numbers, target);
        
        int A[] = {1, 3, 5, 7};
        int B[] = {2, 4, 6, 8};
        obj.arrayFunc(A, A.length, B, B.length);
    }
}
