import java.util.HashMap;
import java.util.Scanner;

public class Fibo {
    static HashMap<Integer, Integer> cashedFibo=new HashMap<>();


    public static void main(String a[]){


        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Your number :");
        int n=sc.nextInt();


        System.out.println("Memoization");
        System.out.print(fibonacciMemoization(n)+"\n");

        System.out.println("Tabulation");
        System.out.print(fibonacciTabulation(n));
    }

    public static int fibonacciMemoization(int x){


        if (cashedFibo.containsKey(x))  {
            return cashedFibo.get(x);
        }

        if (x==0){
            return 0;}
        else if(x==1) {
            return 1;
        }
        else{
            int result=fibonacciMemoization(x-1)+fibonacciMemoization(x-2);
            System.out.print(result+" ");
            cashedFibo.put(x,result);
            return (result);

        }
    }


    public static int fibonacciTabulation(int x){

        int result=0;
        cashedFibo.clear();

        cashedFibo.put(0,0);
        cashedFibo.put(1,1);

        for (int i = 2; i <=x ; i++) {
            result=cashedFibo.get(i-1)+cashedFibo.get(i-2);
            System.out.print(result+" ");
            cashedFibo.put(i,result);
        }

        return cashedFibo.get(x);

    }

}

