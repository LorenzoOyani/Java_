package org.example.Exercise;

import java.util.Scanner;

public class triangle {
    public static void main(String[] args){
        System.out.print("Enter a value:");
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        for(int i = 0; i < d; i++){

            for(int j = 0; j <= i; j++){
                System.out.println( "*");
            }
            System.out.println();
        }

    }
}