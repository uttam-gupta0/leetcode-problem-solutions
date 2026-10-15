// 2 ms | 42 MB
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        return(n & (n - 1)) == 0;
    }
}