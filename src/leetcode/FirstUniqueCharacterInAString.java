package leetcode;

class Solution {
    public int firstUniqChar(String s) {

        // 초기 세팅
        int[] alpa = new int[26];
        Arrays.fill(alpa, -1);

        // 알파벳의 위치를 파악하고 중복이면 MAX 값을 넣어준다.
        for(int i=0; i<s.length(); i++){
            int n = s.charAt(i) - 'a';
            if(alpa[n] == -1){
                alpa[n] = i;
            }else if(alpa[n] > -1){
                alpa[n] = Integer.MAX_VALUE;
            }
        }
        // 존재하는 알파벳 중에 최소 값을 찾는다.
        int min = Integer.MAX_VALUE;
        for(int i=0; i<26 ; i++){
            if(alpa[i] != -1) min = Math.min(min, alpa[i]);
        }

        // 만약, 1개인 알파벳이 존재하지않으면 -1 출력.
        if(min == Integer.MAX_VALUE) min = -1;
        return min;
    }
}