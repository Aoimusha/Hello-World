/* COURSE      : COP 3337
       * Section     : U08
       * Semester    : Fall 2015
       * Instructor  : Alex Pelin
       * Author      : JoelPerez
       * Assignment #: 4
       * Due date    : November 24, 2015
       * Description : This assignment creates the various generic methods isSorted, merge, lessThanOrEqualTo
       * 			, and repeatedItems. These method descritions are provided below.
       *
       *
       *  I certify that the work is my own and did not consult with
       *  anyone.
       *
       *
       *                                       Joel Perez
       *
       */

package hw4;

import java.lang.reflect.Array;

//A class that tests generic methods
public class Generics
{
	/*
	 * Checks whether or not a list is sorted in ascending order.
	 * @param arr the array to be tested.
	 * @return returns true if the list is sorted, null, or empty, and false otherwise.
	 */
	public static <T extends Comparable<? super T>> 
	boolean isSorted(T[] arr)
	{
		//check for null array
		if (arr == null || arr.length == 0)
			return true;											

		
		T pre = arr[0]; //the previous item in the list to be compared to.
		
		//traverses the array comparing the current item to the previous.
		for (T item:arr)
		{
			//compares the items
			if (pre.compareTo(item) <= 0)
				pre = item;
			else
				//returns false if the item fails the test
				return false;
		}
		//returns true if all items have passed the for loop.
		return true;
	}

	/*	
	 * combines 2 sorted arrays into one.
	 * @param arr1 the first array to be combined.
	 * @param arr2 the second array to be combined.
	 */
	public static <T  extends Comparable<? super T>> 
	T[] merge(T[] arr1, T[] arr2)
  	{
		//checks for null or empty array and throws exception if found.
  		if (arr1 == null || arr2 == null)
  			throw new IllegalArgumentException("Null Array!");

  		int i = 0; //the index of the first array.
  		int j = 0; //the index of the second array.
  		int k = 0; //the index of the combined array.
  		T[] join = (T[]) Array.newInstance(arr1.getClass().getComponentType(), //the new combined array.
  				arr1.length + arr2.length);
  
  		//traverses and compares the 2 arrays, selecting the smaller item to add to the new combined array.
  		while(i < arr1.length && j < arr2.length)
  		{
  			if (arr1[i].compareTo(arr2[j]) <= 0)
  			{
 				join[k] = arr1[i];
  				i++;
  			}
  			else
  			{
  				join[k] = arr2[j];
  				j++;
  			}
  			k++;
  		}
  		
  		//copies the arrays to the new combined array.
  		if (i == arr1.length)
  			System.arraycopy(arr2, j, join, i + j, arr2.length - j);
  		else
  			System.arraycopy(arr1, i, join, i + j, arr1.length - i);
  		
  		//returns combined array.
  		return join;
  	}
	
	/*
	 * checks whether all the items of arr1 are in arr2.
	 * @param arr1 the first array.
	 * @param arr2 the second array.
	 * @return returns true if all items of arr1 are present in arr2, false otherwise.
	 */

  	public static <T> boolean lessThanOrEqualTo(T[] arr1, T[] arr2)
  	{
  		//checks for null or empty array.
  		if (arr1 == null || arr1.length == 0)
  			return true;

  		int i = 0; //the index for arr2.
  		
  		//traverse and compares the items arr1 to arr2.
  		for (T item:arr1)
  		{
  			while (i < arr2.length && item != arr2[i])
  				i++;
  			if (i == arr2.length)
  				return false;
  			i = 0;
  		}
  		//returns true if items pass all tests.
  		return true;
  	}
  	
  	/*
  	 * checks the given array for repeated items.
  	 * @param arr the array to be tested.
  	 * @return the number of repeated items in the array.
  	 */
  
  	public static  <T> int repeatedItems(T[] arr)
  	{
  		//the array that holds the repeated items.
  		T[] dup = (T[])Array.newInstance(arr.getClass().getComponentType(), arr.length);
  		int i = 0; //the number of repeated items..
  		int j = 0; //the index for dup.
  		int cycle = 0; //the number of cycles.
  		T pre = dup[0]; //the previous item.
  		
  		//traverses the array and checks if the items are equal.
  		for (T cur:arr)
  		{
  			if (cur.equals(pre) && cycle > 0)
  			{
  				T[] temp = (T[])Array.newInstance(arr.getClass().getComponentType(), 1);
  				Array.set(temp, 0, cur);
  				//adds the item to the repeated list if equal to the previous item.
  				if (!lessThanOrEqualTo(temp, dup))
  				{
  					Array.set(dup, i, cur);
		  			i++;
		  		}
  			}
  			//updates the pre variable.
  			pre = cur;
  			//increments the cycle variable
  			cycle++;
  		}
  		//returns the number of repeated items.
  		return i;
  	}
  	
  	public static void main(String[] args)
  	{
  		System.out.println("Welcome to the tester\n"
  				+ "============================\n\n");
  		System.out.println("We create arrays of integers and characters:\n\n"
  				+ "arr1 = {1, 2, 3, 4, 5, 6, 7}\n"
  				+ "arr2 = {1, 3, 2, 5, 4, 8, 6, 7, 4}\n"
  				+ "arr3 = {5, 13, 15, 16, 24}\n"
  				+ "arr4 = {a, b, c}\n"
  				+ "arr5 = {a, g, f}\n"
  				+ "arr6 = {c, d, e}\n"
  				+ "dup1 = {1, 2, 2, 2, 3, 4, 4, 7, 8}\n"
  				+ "dup2 = {'a', 'a', 'b', 'f', 'f', 'h'}\n");
  		Integer[] arr1 = {1, 2, 3, 4, 5, 6, 7};
  		Integer[] arr2 = {1, 3, 2, 5, 4, 8, 6, 7, 4};
  		Integer[] arr3 = {5, 13, 15, 16, 24};
  		Integer[] dup1 = {1, 2, 2, 2, 3, 4, 4, 7, 8};
  		Character[] dup2 = {'a', 'a', 'b', 'f', 'f', 'h'};
  		Character[] arr4 = {'a', 'b', 'f'};
  		Character[] arr5 = {'a', 'g', 'f'};
  		Character[] arr6 = {'c', 'd', 'e'};
  		
  		System.out.println("Testing the isSorted method...");
  		
  		System.out.println("We test arr1...");
  		if (isSorted(arr1))
  			System.out.println("The list is sorted.");
  		else
  			System.out.println("The list is not sorted");
  		
  		System.out.println("We test arr2...");
  		if (isSorted(arr2))
  			System.out.println("The list is sorted.");
  		else
  			System.out.println("The list is not sorted");
  		
  		System.out.println("We test arr3...");
  		if (isSorted(arr4))
  			System.out.println("The list is sorted.");
  		else
  			System.out.println("The list is not sorted");
  		
  		System.out.println("We test arr4...");
  		if (isSorted(arr5))
  			System.out.println("The list is sorted.");
  		else
  			System.out.println("The list is not sorted");
  		
  		System.out.println("\nisSorted test complete! Now we move on to merge...\n");
  		
  		Integer[] join = merge(arr1, arr3);
  		System.out.println("We merge arr1 and arr3...");
  		System.out.print("The merged array is:");
  		for (int item:join)
  			System.out.print(" " + item);
  		System.out.println("");
  		
  		Character[] join2 = merge(arr4, arr6);
  		System.out.println("We merge arr4 and arr6...");
  		System.out.print("The merged array is:");
  		for (char item:join2)
  			System.out.print(" " + item);
  		System.out.println("");
  		
  		System.out.println("\nmerge test complete! Now we move on to lessThanOrEqualTo...\n");
  		
  		System.out.println("We compare arr1 to arr2...");
  		if (lessThanOrEqualTo(arr1, arr2))
  			System.out.println("arr1 <= arr2");
  		else
  			System.out.println("arr1 !<= arr2");
  		
  		System.out.println("We compare arr1 to arr1...");
  		if (lessThanOrEqualTo(arr1, arr1))
  			System.out.println("arr1 <= arr1");
  		else
  			System.out.println("arr1 !<= arr1");
  		
  		System.out.println("We compare arr2 to arr3...");
  		if (lessThanOrEqualTo(arr2, arr3))
  			System.out.println("arr2 <= arr3");
  		else
  			System.out.println("arr2 !<= arr3");
  		
  		System.out.println("We compare arr4 to arr5...");
  		if (lessThanOrEqualTo(arr4, arr5))
  			System.out.println("arr4 <= arr5");
  		else
  			System.out.println("arr4 !<= arr5");
  		
  		System.out.println("We compare arr4 to arr4...");
  		if (lessThanOrEqualTo(arr4, arr4))
  			System.out.println("arr4 <= arr4");
  		else
  			System.out.println("arr4 !<= arr4");
  		
  		System.out.println("\nlessThanEqualTo test complete! Now we move on to repeatedItems...\n");
  		
  		System.out.println("We test arr1 for duplicates...");
  		System.out.println("The number of repeated items is " + repeatedItems(arr1));
  		
  		System.out.println("We test arr2 for duplicates...");
  		System.out.println("The number of repeated items is " + repeatedItems(arr2));
  		
  		System.out.println("We test dup1 for duplicates...");
  		System.out.println("The number of repeated items is " + repeatedItems(dup1));
  		
  		System.out.println("We test arr4 for duplicates...");
  		System.out.println("The number of repeated items is " + repeatedItems(arr4));
  		
  		System.out.println("We test dup2 for duplicates...");
  		System.out.println("The number of repeated items is " + repeatedItems(dup2));
  		
  		System.out.println("\nrepeatedItems test complete!\n"
  				+ "\nThis concludes the Test, the Program worked!!! ^_^");
  	}
}