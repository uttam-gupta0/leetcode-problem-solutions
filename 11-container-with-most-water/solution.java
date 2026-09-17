// 4 ms | 77.6 MB
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while(left < right) {
            int length = Math.min(height[left], height[right]);
            int width = right - left;
            int area = width * length;
            if(area > max) {
                max = area;
            }
            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return max;
    }
}