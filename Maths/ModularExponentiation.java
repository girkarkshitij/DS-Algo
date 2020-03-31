//Time Complexity : O(log n)

import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static long MOD=1000000000+7;
	
	public static void main (String[] args){
		System.out.println(ModExpo(5,4)); //625
	}
	
	public static long ModExpo(long x,long n){
        if(n==0) 
        	return 1;
        if((n&1)==0)  // n is even
        	return ModExpo((x*x)%MOD,n/2)%MOD;
        return ((x%MOD)*ModExpo((x*x)%MOD,(n-1)/2))%MOD;  // n is odd
    }
}
