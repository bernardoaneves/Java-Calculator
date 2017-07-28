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

    double result = e(5);
    System.out.println("e to the 5th power is approximately " + result);

  }

  // METHODS
  /********************
  * E^x
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
  * FACTORIAL
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
