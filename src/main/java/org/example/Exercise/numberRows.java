package org.example.Exercise;

import java.util.Scanner;

public class numberRows {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        for(int i = rows; i >=0; i--){
            for(int j = i; j < rows; j++){
                System.out.println(j + " ");
            }
            System.out.println();
        }

        for(int i = 2; i < rows; i++){
            for(int  j = i; j < rows; j++){
                System.out.println(j+ "");
            }
            System.out.println();
        }
    }
}