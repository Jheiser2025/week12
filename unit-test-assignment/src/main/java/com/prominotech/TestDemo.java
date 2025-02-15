package com.prominotech;

import java.util.Random;

public class TestDemo {
	public int addPositive(int a, int b) {
		// Check if both parameters are positive
		if (a > 0 && b > 0) {
			// Return the sum of a and b
			return a + b;
		} else {
			// Throw IllegalArgumentException if either parameter is zero or negative
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}


	// New multiplyPositive method
	public int multiplyPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a * b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}

	// 4-1

	// Package-private method getRandomInt
	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}

	 public int randomNumberSquared() {
		// Get a random number between 1 and 10
		int result = getRandomInt();
		// Return the square of the random number
		return result * result;

	}


}