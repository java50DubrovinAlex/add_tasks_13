package add_tasks_13;

import java.util.ArrayList;

public class ShootingRating {
	/**
	 * Accepts array of "hitting" values, returns the "rate" 
	 * @param hittingResults - array of numbers, each number in range [0 to 10]
	 * @return the rate of shooting - the lower rate [0 to 10] of 70% of best hits (see example in main)
	 */
	public static int rateShooting(int[] hittingResults) {
		// TODO
		int index = 0;
		int hitCounter = 0;	
		int res = 0;
		int[] helper = new int [hittingResults.length + 1];
		for(int i = 0; i < hittingResults.length; i++) {
			hitCounter++;
			helper[hittingResults[i]] += 1; 
		}
		int bestHitIndex = hitCounter - hitCounter * 7 / 10;
		for(int i = 0; i < helper.length;i++) {
			if(helper[i] != 0) {
				index +=helper[i];
				if(index >= bestHitIndex) {
					res = i;
					break;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// Testing example
		int[] hittingResults = {4,3,6,7,2,9,9,4,10,8};
		// The length is 10, so 70% of best hits is 7 best values.
		// So, we can ignore 3 worst values: 2,3,4
		// The next value is 4. This is the result.
		if (rateShooting(hittingResults) != 4) {
			System.out.println("Test failed");
			return;
		}
		System.out.println("Success");
	}
}