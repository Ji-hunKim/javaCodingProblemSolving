package programmers;

class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];
    for(int i=0;i<n;i++){
      long temp1 = Long.parseLong(Long.toBinaryString(arr1[i]));
      long temp2 = Long.parseLong(Long.toBinaryString(arr2[i]));
      String bin1 = String.format("%0"+n+"d",temp1);
      String bin2 = String.format("%0"+n+"d",temp2);
      String temp = "";
      for(int j=0;j<n;j++){
        if(bin1.charAt(j) == '0' && bin2.charAt(j) == '0') temp += " ";
        else temp += "#";
      }
      answer[i] = temp;
    }
    return answer;
  }
}
