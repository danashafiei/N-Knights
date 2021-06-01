package NHorse;
//Programmer : Dana Shafiei
//java Program For N-Horse

import java.util.Scanner;



public class NHorse {

    static int count=0;//For Correct Answer
//Function For Promising : Return False Or True
    public static boolean promisingNH(int board[][], int i, int j){
        if(i-1 >= 0 && j-2 >=0 && board[i-1][j-2] == 1){
            return false;

        }
        if(i-2 >=0 && j-1 >=0 && board[i-2][j-1] == 1){
            return false;
        }
        if(i-2 >=0 && j+1 < board.length && board[i-2][j+1] == 1){
            return false;
        }
        if (i-1 >=0 && j+2 < board.length && board[i-1][j+2] == 1){
            return false;
        }
        return true;

    }
    //Function For Print Result And Back-Tracking Algorithm
    public static void NH(int a, int N, int[][] board, int b){
        if(a == N){
            for (int row = 0; row < board.length; row++){
                for (int col = 0; col < board.length; col++){
                    System.out.print(board[row][col] + "\t");//Print Result Matrixs

                }
                System.out.println();

            }
            System.out.println();
            count++;
            return;

        }
        //For BackTracking
        for(int i = b +1; i < board.length * board.length; i++){
            int row = i / board.length;
            int col = i % board.length;

            if (board[row][col] == 0 && promisingNH(board, row, col)){
                board[row][col] = 1;

                NH(a+1, N, board, row * board.length + col);
                board[row][col] = 0;
            }
        }
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Number Of Your Knights :");
        int N = input.nextInt();//For N*N Matrix And N Knights
        int[][] board = new int[N][N];
        System.out.println("Result : ");
        NH(0, N, board, -1);

        System.out.println("Number Of Correct Answers : " + count);

    }


}
