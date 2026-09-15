import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicates26 {

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int k = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Enter sorted numbers (-1 to stop):");

        while (true) {

            int value = sc.nextInt();

            if (value == -1) {
                break;
            }

            list.add(value);
        }

        // Convert ArrayList → int[]
        int[] nums = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        RemoveDuplicates26 obj = new RemoveDuplicates26();

        int k = obj.removeDuplicates(nums);

        System.out.println("Unique elements: " + k);

        System.out.print("Array after removing duplicates: ");

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

        sc.close();
    }
}
