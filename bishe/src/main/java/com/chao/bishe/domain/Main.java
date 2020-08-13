package com.chao.bishe.domain;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int x=-1;
        int y=-1;
        for(int i=2;i<=Math.sqrt(a);i++){
            if(isPrime(i)&&a%i==0&&isPrime(Math.floorDiv(a,i))){
               x=i;
               y=Math.floorDiv(a,i);
               break;
            }
        }
        System.out.print(x+" "+y);
    }
    public static boolean isPrime(int  n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}