public class Factorial {

    static long evaluateFacrorial(long n){
      if (n>1) return n*evaluateFacrorial(n-1);
      return 1;
   }

    public static void main(String[] args) {
        System.out.println(evaluateFacrorial(5));
    }

}
