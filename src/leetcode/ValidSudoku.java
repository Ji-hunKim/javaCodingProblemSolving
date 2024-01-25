package leetcode;

import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        List<Integer> temp = null;

        //1. row and cloumn check
        for (int i=0; i<9; i++){
            temp = new ArrayList<>();
            for(int p=1; p<=9; p++){
                temp.add(p);
            }

            for(int j=0; j<9; j++){
                int now = board[i][j]-'0';
                if(now != -2){
                    if(temp.contains(now)){
                        temp.remove(Integer.valueOf(now));
                    }else{
                        return false;
                    }
                }
            }

            temp = new ArrayList<>();
            for(int p=1; p<=9; p++){
                temp.add(p);
            }

            for(int j=0; j<9; j++){
                int now = board[j][i]-'0';
                if(now != -2){
                    if(temp.contains(now)){
                        temp.remove(Integer.valueOf(now));
                    }else{
                        return false;
                    }
                }
            }
        }

        //2. square check
        for (int i=0; i<9; i=i+3){
            for(int j=0; j<9; j=j+3){
                temp = new ArrayList<>();
                for(int p=1; p<=9; p++){
                    temp.add(p);
                }

                for(int k=i; k<i+3; k++){
                    for(int l=j; l<j+3; l++){
                        int now = board[k][l]-'0';
                        if(now != -2){
                            if(temp.contains(now)){
                                temp.remove(Integer.valueOf(now));
                            }else{
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}