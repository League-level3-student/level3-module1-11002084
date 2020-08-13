import java.util.Random;
import java.util.Stack;

public class CheckpointTwo {
	public static void main(String[] args) {
		Stack<Integer> intStack = new Stack<Integer>();
		Random rand = new Random();
		
		for(int i=0; i<10; i++) {
			intStack.push(rand.nextInt(100));
		}
		
		int total = 0;
		for(int i=0; i<10; i++) {
			total += intStack.pop();
		}
		System.out.println(total);
		System.out.println(intStack.size());
	}
}
