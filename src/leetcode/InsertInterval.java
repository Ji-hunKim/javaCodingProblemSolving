package leetcode;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int[][] { newInterval }; //Edge case
        List<int[]> list = new ArrayList<>();
        boolean isAvailable = true;
        for(int i=0; i<intervals.length; i++) {
            int[] nowInterval = intervals[i];
            if(!isAvailable) {
                list.add(nowInterval);
                continue;
            }
            if(nowInterval[0] > newInterval[1]) {
                list.add(nowInterval);
                continue;
            }
            if(nowInterval[1] < newInterval[0]) list.add(nowInterval);
            else { //nowInterval[1] >= newInterval[0]
                isAvailable = false;
                int tempLeft = Math.min(nowInterval[0], newInterval[0]);
                int tempRight = Math.max(nowInterval[1], newInterval[1]);
                for(int j=i+1; j<intervals.length; j++) {
                    i++;
                    int[] nextInterval = intervals[j];
                    if(nextInterval[0] > tempRight) {
                        i--;
                        break;
                    }
                    else tempRight = Math.max(tempRight, nextInterval[1]);
                }
                list.add(new int[] { tempLeft, tempRight });
            }
        }

        if(isAvailable) {
            list.add(newInterval);
        }

        int[][] result = list.toArray(new int[][]{new int[list.size()]});
        Arrays.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        return result;
    }
}
