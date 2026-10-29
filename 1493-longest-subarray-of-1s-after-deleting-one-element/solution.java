// 3 ms | 72.7 MB
class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int zeroes = 0;
        int best =0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zeroes++;
            }

            while(zeroes > 1) {
                if(nums[left] == 0) {
                    zeroes--;
                }
                left++;
            }
            int length = i - left;
            if(length > best) {
                best = length;
            }
        }
        return best;
    }
}