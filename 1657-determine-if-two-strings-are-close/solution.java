// 72 ms | 47.5 MB
class Solution {
    public boolean closeStrings(String word1, String word2) {
       if (word1.length() != word2.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // Count frequencies of word1
        for (char ch : word1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        // Count frequencies of word2
        for (char ch : word2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        // Check whether both strings have the same unique characters
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }

        // Compare frequency distributions
        ArrayList<Integer> list1 = new ArrayList<>(map1.values());
        ArrayList<Integer> list2 = new ArrayList<>(map2.values());

        Collections.sort(list1);
        Collections.sort(list2);

        return list1.equals(list2);
    }
}