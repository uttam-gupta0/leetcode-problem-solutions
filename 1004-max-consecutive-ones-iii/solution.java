// 3 ms | 54.5 MB
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroes = 0;
        int best = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zeroes++;
            }

            while(zeroes > k) {
                if(nums[left] == 0) {
                    zeroes--;
                }
                left++;
            }
            int length = i - left + 1;
            if(length > best) {
                best = length;
            }
        }
        return best;
    }
}