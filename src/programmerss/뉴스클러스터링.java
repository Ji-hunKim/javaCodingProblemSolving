package programmers;

import java.util.*;

class Solution {
  public int solution(String str1, String str2) {
    int answer = 0;
    int hap = 0;
    int gyo = 0;

    List<String> arr1 = new ArrayList<String>();
    List<String> arr2 = new ArrayList<String>();

    for(int i=0; i<str1.length()-1; i++){
      if(Character.isLetter(str1.charAt(i)) && Character.isLetter(str1.charAt(i+1))){
        String temp = str1.substring(i,i+2).toUpperCase();
        arr1.add(temp);
      }
    }

    for(int i=0; i<str2.length()-1; i++){
      if(Character.isLetter(str2.charAt(i)) && Character.isLetter(str2.charAt(i+1))){
        String temp = str2.substring(i,i+2).toUpperCase();
        arr2.add(temp);
      }
    }
    if(arr1.size() == 0 && arr2.size() ==0) return 65536;

    hap = arr1.size() + arr2.size();

    for(int i=0; i<arr1.size(); i++){
      int j=0;
      while(true){
        if(arr1.get(i).equals(arr2.get(j))){
          gyo++;
          arr2.remove(j);
          j--;
          break;
        }
        j++;
        if(j == arr2.size()) break;
      }
    }

    hap -= gyo;

    float tep;
    tep = (float)gyo/hap*65536;
    answer = (int)tep;

    return answer;
  }
}