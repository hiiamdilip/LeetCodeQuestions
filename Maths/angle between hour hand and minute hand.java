import java.io.*;
public class Main{
    
    public static void main(String[] args){
        double result = getAngle(3, 30);
        System.out.println(result);
    }
    
   private static double getAngle(int hr, int min ){
       int temp = (hr == 12) ? 0: hr;
       int baseHrvalue = (30 * temp);
       double hrValue = (0.5 * min );
       int minValue = (6 * min);
       double result = Math.abs(minValue - (hrValue + baseHrvalue));
       return result;
    } 
}
