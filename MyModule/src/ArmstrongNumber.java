public class ArmstrongNumber {

    static long SumOfCube(double i){
        double result=0;
        while (i>0){
            result=result+Math.pow((i%10),3);
            i=Math.floor(i/10);
        }
        return (long) result;
    }


    public static void main(String[] args) {
        System.out.println(SumOfCube(123));
    }

}
