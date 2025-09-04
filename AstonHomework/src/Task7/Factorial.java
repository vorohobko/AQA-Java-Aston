package Task7;

public class Factorial {
	public static int getFactorial(int f) {
		  int result = 1;
		  for (int i = 1; i <= f; i++) {
		     result = result * i;
		  }
		  return result;
		}
}
