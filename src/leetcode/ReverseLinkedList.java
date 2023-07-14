package leetcode;

class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stk = new Stack<>();
        ListNode now = head;
        ListNode answer;
        while(now != null){
            stk.add(now);
            if(now.next == null) break;
            now = now.next;
        }

        answer = now;

        while(!stk.isEmpty()){
            now = stk.pop();
            if(stk.isEmpty()){
                now.next = null;
                break;
            }
            now.next = stk.peek();
        }

        return answer;
    }
}