/* COURSE      : COP 3337
       * Section     : U08
       * Semester    : Fall 2015
       * Instructor  : Alex Pelin
       * Author      : JoelPerez
       * Assignment #: 2
       * Due date    : November 5, 2015
       * Description : This assignment creates an Employee class and multiple subclasses
       *			   of Employees with different positions, names, wages, etc.
       *			   It then creates a scenario of a restaurant work week in which the workers work and are paid.
       *
       *
       *  I certify that the work is my own and did not consult with
       *  anyone.
       *
       *
       *                                       Joel Perez
       *
       */


package hw3;

public class Recursion 
{
	public static boolean isPestaina(String in)
	{
		int i = in.indexOf("b");
		//check for null or empty string
		if (in == null || in.length() < 2 || in.length()%2 != 0)
			return false;
			
		//case 1 & case 2
		if (in.equals("ab") || in.equals("cbac")) 
			return true;

		//case 3
		if (in.endsWith("a") && in.charAt(in.length()/2-1) == 'b'
			&& in.substring(0, in.length()/2-2).equals
			(in.substring(in.length()/2, in.length()-2)))
			return isPestaina(in.substring(0, in.length()/2-2));
			
		//case 4
		if (in.startsWith("a"))
			while (i != -1)
			{
				if (isPestaina(in.substring(1, i-1)))
					if (isPestaina(in.substring(i+1, in.length())))
						return true;
				i = in.indexOf("b", i+1);
			}
		//cases failed
		return false;
	}
	
	/**
	 * computes the nth finlayson number
	 * @param n the nth degree finlayson to be computed
	 * @return computed nth finlayson term
	 */
	public static long finlayson(int n)
	{
		//checks for a negative number input
		if (n < 0)
			throw new IllegalArgumentException("Error: number must be a positive integer!");
		
		// checks base case 1
		if (n == 0)
			return 1;
		
		//checks base case 2
		if (n == 1)
			return 2;
		
		//recurses
		return 2 * finlayson(n-1) + finlayson(n-2) + 1;
	}
	
	/**
	 * determines whether a string consisting of specific characters is balanced
	 * @param in the string to be tested
	 * @return true if the string is balanced, false otherwise
	 */
	public static boolean isBalanced(String in)
	{
		//checks for null, empty, or odd string
		if (in == null || in.length() == 0 || in.length()%2 != 0)
			return false;
		
		//checks the base cases 1, 2, & 3
		if (in.equals("()") || in.equals("[]") || in.equals("{}"))
			return true;
		
		//checks whether the string contains a balanced pair within and recurses
		if (in.indexOf("()") != -1)
			return isBalanced(in.replace("()", ""));
		if (in.indexOf("[]") != -1)
			return isBalanced(in.replace("[]", ""));
		if (in.indexOf("{}") != -1)
			return isBalanced(in.replace("{}", ""));
		
		//all cases failed
		return false;
	}
	
	/**
	 * conducts a binary search of a given double array
	 * @param arr the array to be searched
	 * @param low the low boundary of the search
	 * @param high the high boundary of the search
	 * @param inq the inquiry
	 * @return the index of the inquiry if found, -1 otherwise
	 */
	public static int binarySearch(double[] arr, int low, int high, double inq)
	{
		//the index of the search
		int i = (high+low)/2;
		
		//checks for many possible errors
		if (arr == null || arr.length == 0 || high < low)
			return -1;
		
		//compares the index item to the inquiry and returns i if found
		if (arr[i] == inq)
			return i;
		
		/*checks of the item at i is less than the inquiry, 
		 *modifies the search area,and recurses
		 */
		if (arr[i] < inq)
			return binarySearch(arr, i+1, high, inq);
		
		/*checks of the item at i is more than the inquiry, 
		 *modifies the search area,and recurses
		 */
		if (arr[i] > inq)
			return binarySearch(arr, low, i-1, inq);
		
		//inquiry not found
		return -1;
	}
	
	public static void main(String[] args) 
    {
	 	
        System.out.println("Checking Hw#3B");
        System.out.println("==============\n\n");

        // check isShaw
        System.out.println("We check isPestaina");
        System.out.println("isPestaina(\"acbacbcbac\") is " + isPestaina("acbacbcbac"));
        System.out.println("isPestaina(\"acbacbcbacabab\") is " + isPestaina("acbacbcbacabab"));
        System.out.println("isPestaina(\"cbacbaba\") is " +
                isPestaina("cbacbaba"));
        System.out.println("isPestaina(\"cbacbcbac\") is " +
                isPestaina("cbacbcbac"));
        System.out.println("isPestaina(\"acbababa\") is " +
                isPestaina("acbababa"));
        System.out.println("isPestaina(\"cbacbcbacabcbacbcbacaa\") is "
                + isPestaina("cbacbcbacabcbacbcbacaa"));

        \\\\\\\\\\\\\\\\\\\\System.out.println("isPestaina(\"aabbcbacbcbaca\") is " + isPestaina("aabbcbacbcbaca"));
        
        System.out.println("\nWe check finlayson");
        
        System.out.println("finlayson(2) = " + finlayson(2));
        System.out.println("finlayson(10) = " + finlayson(10));
        System.out.println("finlayson(17) = " + finlayson(17));
        try
        {
            System.out.printf("finlayson(-2) ");
            long out = finlayson(-2);
            System.out.println( "= " + out);
        }    
        catch (IllegalArgumentException e)
        {
            System.out.println(" caused an illegal argument exception.");
        }    
        
        System.out.println("\nWe test isBalanced.");
        System.out.println("isBalanced(\"\") is " + isBalanced(""));
        System.out.println("isBalanced(\"([]){[]}\") is "  + isBalanced("([]){[]}")) ;
        System.out.println("isBalanced(\"[{{})]\") is " + isBalanced("[{{{)]"));
        System.out.println("isBalanced(\"([)]\") is " + isBalanced("([)]"));
        System.out.println("isBalanced(\"((([[[{{{}}}]]])))\") is " + isBalanced("((([[[{{{}}}]]])))"));
        // test sort
        System.out.println("\nWe test binary search.");
        System.out.println("The input array is table = { 2, 4, 6, 8, 10, 12, 14 }. ");
        double[] table = { 2, 4, 6, 8, 10, 12, 14};

        System.out.println("2 was found in table[0:6] at index " + binarySearch(table, 0, 6, 2));
        System.out.println("3 was found in table[0:6] at index " + binarySearch(table, 0, 6, 3));
        System.out.println("4 was found in table[2:6] at index " + binarySearch(table, 2, 6, 4));
        System.out.println("12 was found in table[2:5] at index " + binarySearch(table, 2, 5, 12));

        System.out.println("\nThis is all folks. I hope that your program worked.");
        System.exit(0);
    }
}
