package com.company;

public class Main {

    public static void main(String[] args) {

	System.out.println("Hello World!");
    String languages[]= {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);

        n=n*3;
        System.out.println(n);

        n=n+0b10101;
        System.out.println(n);

        n=n+0XFF;
        System.out.println(n);

        n=n*6;
        System.out.println(n);

        int result=0;
        while(n!=0) {
                result = result + n % 10;
                n = n / 10;

                if( n==0 && result >9) {
                    n = result;
                    result = 0;
                }

        }



        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);

    }
}
