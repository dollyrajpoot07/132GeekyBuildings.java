// Given an array arr[] consisting of N integers, where each array element represents the 
// height of a building situated on the X co-ordinates, the task is to check if it is possible 
// to select 3 buildings, such that the third selected building is taller than the first selected 
// building and shorter than the second selected building.

// Input: arr[] = {4, 7, 11, 5, 13, 2}
// Output: Yes


import java.io.*;
import java.util.*;

class 132GeekyBuilding { 

static String recreationalSpot(int arr[], int N) {
	if (N < 3) {
		return "No";
	}

	int preMin[] = new int[N];
	preMin[0] = arr[0];

	for(int i = 1; i < N; i++) {
		preMin[i] = Math.min(preMin[i - 1], arr[i]);
	}

	Stack<Integer> stack = new Stack<Integer>();

	for(int j = N - 1; j >= 0; j--) {

		if (arr[j] > preMin[j])	{
			
			while (stack.empty() == false &&
				stack.peek() <= preMin[j]) {
				stack.pop();
			}
			if (stack.empty() == false &&
				stack.peek() < arr[j]) {
				return "Yes";
			}
		
			stack.push(arr[j]);
		}
	}

	return "No";
}

public static void main(String[] args) {
	
	int arr[] = { 4, 7, 11, 5, 13, 2 };
	int size = arr.length;

	System.out.println(recreationalSpot(arr, size));
}
}
