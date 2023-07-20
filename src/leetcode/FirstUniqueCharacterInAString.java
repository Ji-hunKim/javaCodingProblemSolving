package leetcode;

class Solution {
    public int firstUniqChar(String s) {
        int[] alph = new int[26];
        //char -> first index pairs
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //count char occurences
            alph[c - 'a']++;
            //this if statement is used for optimization
            //if keySet().size() = 26, then we no longer
            //call map's methods
            if (map.keySet().size() < 26) {
                if (!map.containsKey(c)) {
                    map.put(c, i);
                }
            }
        }
        int minIdx = s.length();
        //finding minimum index of char, whose occurence is 1.
        for (char c : map.keySet()) {
            if (alph[c - 'a'] == 1) {
                int idx = map.get(c);
                if (minIdx > idx) minIdx = idx;
            }
        }
        return minIdx == s.length() ? -1 : minIdx;
    }
}