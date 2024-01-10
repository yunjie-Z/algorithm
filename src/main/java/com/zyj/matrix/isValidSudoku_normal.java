package com.zyj.matrix;

/**
 * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用'.'表示。
 *
 */
public class isValidSudoku_normal {
    public static void main(String[] args) {

    }


    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][][] sub = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.'){
                    int index = board[i][j]-'0'-1;
                    row[i][index]++;
                    column[j][index]++;
                    sub[i/3][j/3][index]++;
                    if(row[i][index]>1||column[j][index]>1||sub[i/3][j/3][index]>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
