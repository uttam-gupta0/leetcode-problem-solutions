// 12 ms | 48.7 MB
import java.util.*;
class Solution {
    public int[] sortedSquares(int[] nums) {
        

        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int arr = nums[i] * nums[i];
            result[i] = arr;
        }
        Arrays.sort(result);
        return result;
    }
}