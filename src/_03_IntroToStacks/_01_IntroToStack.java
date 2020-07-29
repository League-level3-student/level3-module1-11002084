package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		Stack<Double> doubleStack = new Stack<Double>();
		
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		Random rand = new Random();
		
		for(int i=0; i<100; i++) {
			doubleStack.push(rand.nextDouble() * 100);
		}
		
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive.
		
		int firstNumber = Integer.parseInt(JOptionPane.showInputDialog("Input an integer between 0 and 100, end-points inclusive"));
		int secondNumber = Integer.parseInt(JOptionPane.showInputDialog("Input another integer between 0 and 100, end-points inclusive"));
		
		int greaterNumber = 0;
		int lesserNumber = 0;
		
		if(firstNumber >= secondNumber) {
			greaterNumber = firstNumber;
			lesserNumber = secondNumber;
		}
		else if(firstNumber < secondNumber) {
			greaterNumber = secondNumber;
			lesserNumber = firstNumber;
		}
		
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		double poppedValue;
		
		System.out.println("Popping Values...");
		System.out.println("Values between " + lesserNumber + " and " + greaterNumber + " (end-points not inclusive) in the stack are:");
		for(int i=0; i<doubleStack.size(); i++) {
			poppedValue = doubleStack.pop();
			
			if(poppedValue < greaterNumber && poppedValue > lesserNumber) {
				System.out.println(poppedValue);
			}
		}
		
		
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
