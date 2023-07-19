package leetcode;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i=0; i<nums1.length; i++){
            set.add(nums1[i]);
        }

        for(int i=0; i<nums2.length; i++){
            if(set.contains(nums2[i])) set2.add(nums2[i]);
        }

        int[] answer = new int[set2.size()];
        List<Integer> li2 = new ArrayList<>(set2);

        for(int i=0; i<li2.size(); i++){
            answer[i] = li2.get(i);
        }

        return answer;
    }
}