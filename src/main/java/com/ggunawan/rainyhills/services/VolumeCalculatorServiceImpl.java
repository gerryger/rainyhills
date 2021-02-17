package com.ggunawan.rainyhills.services;

import org.springframework.stereotype.Service;

/*
 * Handles any business logic including water volume calculation
 */
@Service
public class VolumeCalculatorServiceImpl implements VolumeCalculatorService {

	/*
	 * Calculates volumes of water in rainy hills problem.
	 * Algorithms:
	 * 	- create 2 int arrays (maxLeft & maxRight) to store highest left and highest right of every element
	 * 	- calculate highest left value of every element and store it in maxLeft array
	 * 		- first element of maxLeft array will be hills[0] as this is the left most part of the hills array
	 * 		- loop from the second until the last element of the hills array
	 * 		- update maxLeft by finding the highest value between current element and the maxLeft value of element on the left
	 * 	- calculate highest right value of every element and store it in maxRight array
	 * 		- first element of maxRight array will be hills[n-1] as this is the right most part of the hills array
	 * 		- loop from the second last element (n-2) until the first element of the hills array
	 * 		- update maxRight by finding the highest value between current element and the maxRight value of element on the right
	 * 	- calculate water volume
	 * 		- loop through hills array from first to last element
	 * 		- for every element, find the minimum value between maxLeft and maxRight minus current element and add this value to total amount
	 * 		  of water stored
	 * 
	 * Time complexity: O(n) since only one traversal of the array is needed
	 * Space complexity: O(n) since 2 extra arrays are needed
	 * 
	 * @param hills before rain in the form of arrays of integers
	 * @return positive integer or 0 representing volume of water after rain
	 */
	@Override
	public Integer calculateVolume(int[] hills) {
		
		int n = hills.length;
		int volume = 0;
		
		// water volume can only be calculated by calculating minimum value between maxLeft and maxRight 
		// of the current element subtracted by itself so it's not possible to count the volume
		// if hills length is less than 3. Directly return volume 0.
		if (n < 3) {
			return 0;
		}
		
		// prepare 2 arrays to store maxLeft and maxRight of every element in hills array
		int[] maxLeft = new int[n];
		int[] maxRight = new int[n];
		
		// calculating maxLeft of every element
		maxLeft[0] = hills[0];
		for(int i = 1 ; i < n ; i++) {
			maxLeft[i] = Math.max(maxLeft[i-1], hills[i]);
		}
		
		// calculating maxRight of every element
		maxRight[n-1] = hills[n-1];
		for(int j = n - 2 ; j >= 0 ; j--) {
			maxRight[j] = Math.max(maxRight[j+1], hills[j]);
		}
		
		// calculate total volume.
		int [] remainedAt = new int[n];
		for(int k = 0 ; k < n ; k++) {
			int remaining = Math.min(maxLeft[k], maxRight[k]) - hills[k];
			remainedAt[k] = remaining;
			volume += remaining;
		}
		
		return volume;
	}

}
