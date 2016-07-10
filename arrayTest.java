//Created by Joseph Bender
//Deliverable #4

//import statements
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;

public class arrayTest{//begin arrayTest class

	//This test class tests that the array returned from billify() is one index larger than the original
	//Since the array returned from billify() appends the sum of all the squared elements to the end of the new array,
	//the returned array should have one more element than the array that was passed into it
	
	@Test
	public void lengthTest() {
		
		//create new random object to generate random numbers
		//to be used for array lengths and contents
		Random r = new Random();
		
		//create two dimensional array
		//individual arrays will be passed one by one to billify()
		int[][] multi = new int[100][];
		
		//create another new two dimensional array to hold squared arrays returned from billify()
		int[][] newMulti = new int[100][];
		
		//for each index of the multidimensional array, initialize an array with size between 1 and 100
		for(int x = 0; x < multi.length; x++){
			
			//call random object to assign array lengths
			multi[x] = new int[r.nextInt((101 - 1)) + 1];
		
		}//end for loop
		
		
		//iterate through two dimensional array and assign random numbers
		for(int i = 0; i < multi.length; i++)
	    {
			for(int y = 0; y < multi[i].length; y++){
				
				//call random object to populate arrays
				multi[i][y] = r.nextInt((101 - 1)) + 1;
			
			}//end inner for
	   
	    }//end outer for
		
		//declare boolean to represent property test
		Boolean indicator = null;
		
		//pass arrays one by one into billify(), store result in new 2D array
		for(int i = 0; i < multi.length; i++)
	    {
			//copy returned squared array into new 2D array
			newMulti[i] = billify(multi[i]);
			
			//if the new array is not one index larger than original, change boolean to false
			if(newMulti[i].length == multi[i].length){
				
				//if arrays are equal size, fail the test
				indicator = false;
				
			//if the new array is one index larger than the original,
			//set Boolean to true
			}else if(newMulti[i].length == multi[i].length+1){
				
				//if all returned arrays are one element larger than the originals, pass the test
				indicator = true;
				
			}//end if-else statement
			
	    }//end for loop
		
		//If the boolean is true, and all returned arrays were one index larger than their original,
		//then assertTrue and the test is a success
		assertTrue(indicator);
		
	}//end lengthTest() method
	
	
	//This test class tests that in all of the arrays returned from billify(),
	//the final element (sum of all the squares) is the largest element.
	//Unless it is a one element array, which is also accounted for.
	
	@Test
	public void sumTest() {
		
		//create new random object to generate random numbers
		//to be used for array lengths and contents
		Random r = new Random();
		
		//create two dimensional array
		//individual arrays will be passed one by one to billify()
		int[][] multi = new int[100][];
		
		//create another new two dimensional array to hold squared arrays returned from billify()
		int[][] newMulti = new int[100][];
		
		//for each index of the multidimensional array, initialize an array with size between 1 and 100
		for(int x = 0; x < multi.length; x++){
			
			//call random object to assign array lengths
			multi[x] = new int[r.nextInt((101 - 1)) + 1];
		
		}//end for loop
		
		
		//iterate through two dimensional array and assign random numbers
		for(int i = 0; i < multi.length; i++)
	    {
			for(int y = 0; y < multi[i].length; y++){
				
				//call random object to populate arrays
				multi[i][y] = r.nextInt((101 - 1)) + 1;
			
			}//end inner for
	   
	    }//end outer for
		
		//declare boolean to represent property test
		Boolean indicator = true;
		
		//pass arrays one by one into billify(), store result in new 2D array
		for(int i = 0; i < multi.length; i++)
	    {
			//copy returned squared array into new 2D array
			newMulti[i] = billify(multi[i]);
			
			//declare variable to keep track of the largest value in array
			int largestElement = 0;
			
			//iterate through each element in the array
			for(int g = 0; g < newMulti[i].length; g++){
				
				//if the current element is larger than the previously stored largest element
				if(newMulti[i][g] >= largestElement){
					
					//store newer largest element
					largestElement = newMulti[i][g];
					
				}//end if statement
				
			}//end for loop
			
			//if the largest element in the array is not the sum appended to the end
			if(largestElement != newMulti[i][newMulti[i].length-1]){
				
					//set boolean as false, and test will fail
					indicator = false;
					
			}//end if statement
			
	    }//end for loop
		
		//If the boolean is true, then the last element of each array (the sum) was the largest.
		//Therefore, assertTrue because the test is a success
		assertTrue(indicator);
			
	}//end sumTest() method
	
	//This test class tests that the billify() method is pure.
	//This means that if the same array is passed into billify() two separate times,
	//the returned array will be identical in both instances
	
	@Test
	public void purityTest() {
		//create new random object to generate random numbers
		//to be used for array lengths and contents
		Random r = new Random();
		
		//create two dimensional array
		//individual arrays will be passed one by one to billify()
		int[][] multi = new int[100][];
		
		//create another new two dimensional array to hold squared arrays returned from billify()
		int[][] newMulti = new int[100][];
		
		//create another new two dimensional array to compare two runs of the output 
		int[][] compareMulti = new int[100][];
		
		//for each index of the multidimensional array, initialize an array with size between 1 and 100
		for(int x = 0; x < multi.length; x++){
			
			//call random object to assign array lengths
			multi[x] = new int[r.nextInt((101 - 1)) + 1];
		
		}//end for loop
		
		
		//iterate through two dimensional array and assign random numbers
		for(int i = 0; i < multi.length; i++)
	    {
			for(int y = 0; y < multi[i].length; y++){
				
				//call random object to populate arrays
				multi[i][y] = r.nextInt((101 - 1)) + 1;
			
			}//end inner for
	   
	    }//end outer for
		
		
		//declare boolean to represent property test
		Boolean indicator = true;
		
		//pass arrays one by one into billify(), store result in new 2D array
		for(int i = 0; i < multi.length; i++)
	    {
			//copy returned squared array into new 2D array
			newMulti[i] = billify(multi[i]);
			
	    }//end for loop
		
		//pass arrays one by one into billify() once again, store result in a different 2D array
		for(int i = 0; i < multi.length; i++)
	    {
			//copy returned squared array into new 2D array
			compareMulti[i] = billify(multi[i]);
			
	    }//end for loop
		
		//for loop to test purity of billify() method
		for(int q = 0; q < newMulti.length; q++){
			
			//testing every element of every array
			for(int v = 0; v < newMulti[q].length; v++){
				
				//if the elements in the two processed arrays do not match
				if(newMulti[q][v] != compareMulti[q][v]){
					
					//set boolean to false, which would fail the test
					indicator = false;
					
				}//end if
				
			}//end inner for
			
		}//end outer for
		
		//If the boolean is true, then the last element of each array (the sum) was the largest.
		//Therefore, assertTrue because the test is a success
		assertTrue(indicator);
		
	}//end purityTest() method
	
	//billify() method that takes in an array argument, squares all the elements,
	//appends the sum of all the squares to the end of the array,
	//and returns it to the call
	
	public int[] billify(int[] x){
		
		//clone array passed in as argument to new array to work with
		int[] workingArray = x.clone();
		
		//initialize accumulator to store sum of new squared array
		int sumofarray = 0;
		
		//initialize accumulator to keep track of length of array
		int lastIndex = 0;
		
		//for each element in the array, square it and store in original index
		for(int a = 0; a < workingArray.length; a++){
			
			//squaring each element
			workingArray[a] = workingArray[a]*workingArray[a];
			
			//storing sum of squared array
			sumofarray += workingArray[a];
			
		}//end for loop
		
		//create a new array one length longer than squared array
		int[] updatedArray = new int[workingArray.length+1];
		
		//copy all squared values into new array that is one element longer
		for(int b = 0; b < workingArray.length; b++){
			
			//copying elements
			updatedArray[b]=workingArray[b];
			
			//keep track of which is the last element in the array
			lastIndex = b;
			
		}//end for loop
		
		//store the sum of the array in the final element
		updatedArray[lastIndex+1]= sumofarray;
		
		//return the new squared array with sum appended as last element
		return updatedArray;
		
	}//end billify() method

}//end arrayTest class
