// 2 ms | 45.9 MB
class Solution {
    public String minWindow(String s, String t) {
        char[] c = s.toCharArray();
        char[] c1 = t.toCharArray();
        int[] need = new int[128];
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for(char ch : c1) {                  
            need[ch]++;
        }
        int required = t.length();           

        for(right = 0; right < c.length; right++) {   
            if(need[c[right]] > 0) {        
                required--;
            }
            need[c[right]]--;                
            while(required == 0) {           
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                need[c[left]]++;
                if(need[c[left]] > 0) {      
                    required++;
                }
                left++;                      
            }
        }

        if(minLen == Integer.MAX_VALUE) {    
            return "";
        }
        return s.substring(start, start + minLen);
    }
}