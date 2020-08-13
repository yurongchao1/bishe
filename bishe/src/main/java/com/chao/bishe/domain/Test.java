package com.chao.bishe.domain;


public class Test {
    public static void main(String[] args){
        int[] arr = { 8, 2, 4, 6, 3, 1, 5, 7, 9 };
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int a:arr){
            System.out.print(a);
        }

    }

}