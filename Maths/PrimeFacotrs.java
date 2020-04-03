/**
 * Prime factors (Duplicates are allowed)
 */
 
import java.util.ArrayList;
import java.util.List;

class Main{
    public static void main(String[] args) {
        List<Integer> list=primeFactors(259);  //[7, 37]
        System.out.println(list);
    }

    public static List<Integer> primeFactors(int n){
        List<Integer> list = new ArrayList<>();

        //number of 2s
        while (n % 2==0){
            list.add(2);
            n/=2;
        }
        //n is a power of 2
        if (n==0)
            return list;

        //odd numbers
        for (int i = 3; i <=Math.sqrt(n) ; i+=2) {
            while (n % i==0){
                list.add(i);
                n/=i;
            }
        }

        //n is a prime number greater than 2
        if (n > 2)
            list.add(n);

        return list;
    }
}
