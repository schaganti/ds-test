package chags.io.ds;

public class PowerOfX {

    public static void main(String[] args) {
        PowerOfX powerOfX = new PowerOfX();
        System.out.println(powerOfX.myPow(2, 5));
    }

    public double myPow(double x, int n) {
        return n<0 ? 1/myPowInternal(x, -n, 1.0) : myPowInternal(x, n, 1.0);
    }

    public double myPowInternal(double x, int n, double aux) {
        if (n == 1.0) {
            return x * aux;
        }
        if(n == 0.0) {
            return 1;
        }
       return n%2==0 ? myPowInternal(x*x, n/2, aux) : myPowInternal(x*x, (n-1)/2, x * aux);
    }

}
