//Euclidean algorithm to find GCD of two numbers

import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	public static void main (String[] args){
		System.out.print(gcd(8,6));  //2
		System.out.print(gcd(1,6));  //1
		System.out.print(gcd(0,8));  //8
	}
	
	public static int gcd(int a,int b){
		if(b == 0)
			return a;
		else
			return gcd(b, a%b);
	}
	
	public static int lcm(int a,int b){
		return a / gcd(a,b) * b;       //It avoids integer overflows by first dividing a with the GCD
	}
}
