package com.rick.algorithms.others;

public class Fibonacci {
	public int getFibonacci(int n){
		if(n == 1 || n == 2)return 1;
		return getFibonacci(n - 1) + getFibonacci(n - 2);
	}
	
	
	public static void main(String args[]) {
		//1,1, 2, 3, 5, 8, 13, 21
		Fibonacci f = new Fibonacci();
		System.out.println("getFibonacci(3)=" + f.getFibonacci(3));
		System.out.println("getFibonacci(5)=" + f.getFibonacci(5));
		System.out.println("getFibonacci(7)=" + f.getFibonacci(7));
		System.out.println("getFibonacci(9)=" + f.getFibonacci(9));
	}
}
