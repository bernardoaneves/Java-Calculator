/**********************************************************************************
* @author Bernardo Neves
*
* This is a Java Calculator that uses what Calculus II teaches us about
* Infinite series to define "exotic" functions such as e^x, sin(x), cos(x)...
* The mission of this program is to further explore the worlds of Computer
* Science and Mathematics
*
* To test these methods, copy and paste this code into an Eclipse Class called
* calculatorTesting, which must be in a Package called calculator
* called Calculator
*
* This is one of my first projects as an Open Source Programmer. Enjoy!!
***********************************************************************************/

package calculator;

public class calculatorTesting{

  // MAIN METHOD TO TEST THE CREATED METHODS
  public static void main(String[] args){

    double result = e(3);
    System.out.println("e to the 3rd power is approximately " + result);
    double result2 = sin(30);
    System.out.println("sin(30) is approximately " + result2);
    double result3 = cos(30);
    System.out.println("cos(30) is approximately " + result3);
    double result4 = arctan(0.57735);
    System.out.println("arctan(0.57735) is approximately " + result4);

  }

  // METHODS
  /********************
  * e^x
  * defines the fucntion e^x based on its infinite series expansion
  * @parameter x - this is the exponent to which e will be raised
  * @return - will return an approximate value of e^x
  *********************/
  public static double e(int x){

    // calculate the answer
    double answer = 0;
    for(int i = 0; i < 21; i++){
      answer += (Math.pow(x, i))/(double)fact(i);
    }

    // round it up to 3 decimal places
    answer = ((int)(1000*answer))/1000.0;
    return answer;

  }

  /********************
  * sin(x)
  * defines the function sin(x) based on its infinite series expansion
  * @parameter a - the angle, in degrees, whose sine is to be calculated
  * @return - will return an approximate value of sin(a)
  *********************/
  public static double sin(int a){

    // convert the angle to radians
    double ar = (a * Math.PI) / 180.0;

    // the series is alternating
    int count = 0;

    // calculate the answer
    double answer = 0;
    for(int i = 1; i < 20; i+=2){
      if(count % 2 == 0)
        answer += (Math.pow(ar, i))/(double)fact(i);
      else
        answer -= (Math.pow(ar, i))/(double)fact(i);
      count++;
    }

    // round it up to 3 decimal places
    answer = ((int)(1000*answer))/1000.0;
    return answer;

  }

  /********************
  * cos(x)
  * defines the function cos(x) based on its infinite series expansion
  * @parameter a - the angle, in degrees, whose cosine is to be calculated
  * @return - will return an approximate value of cos(a)
  *********************/
  public static double cos(int a){

    // conver the angle to radians
    double ar = (a * Math.PI) / 180.0;

    // the series is alternating
    int count = 0;

    // calculate the answer
    double answer = 0;
    for(int i = 0; i < 21; i+=2){
      if(count % 2 == 0)
        answer += (Math.pow(ar, i))/(double)fact(i);
      else
        answer -= (Math.pow(ar, i))/(double)fact(i);
      count++;
    }

    // round it up to 3 decimal places
    answer = ((int)(1000*answer))/1000.0;
    return answer;

  }

  /********************
  * arctan(x)
  * defines the function arctan(x) based on its infinite series expansion
  * @parameter t - the tangent of the angle we want to calculate
  * @return - will return the angle, in degrees, whose tangent is t
  *********************/
  public static double arctan(double t){

    // calculate arctan(t), in radians
    double ar = 0;

    // the series is alternating
    int count = 0;

    // infinite series
    for(int i = 1; i < 22; i+=2){
      if(count % 2 == 0)
        ar += (Math.pow(t, i))/(double)i;
      else
        ar -= (Math.pow(t, i))/(double)i;
      count++;
    }

    // convert the angle to degrees
    double ad = (ar * 180.0)/Math.PI;

    // round it to 3 decimal places
    ad = ((int)(ad * 1000))/1000.0;
    return ad;
  }

  /********************
  * factorial
  * defines the factorial function using recursion
  * this function will be very useful for the other functions created here
  * @parameter a - this is the number whose factorial will be calculated
  * @return - a!
  *********************/
  public static long fact(int a){

    // base case
    if(a <= 1)
      return 1;
    // recursion
    else
      return a * fact(a-1);

  }

}
