// 0 ms | 42.1 MB
class Solution {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int highestAltitude = 0;
        
        for (int g : gain) {
            currentAltitude += g;
            highestAltitude = Math.max(highestAltitude, currentAltitude);
        }
        
        return highestAltitude;
    }
}