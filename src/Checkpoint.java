import java.util.ArrayList;
import java.util.Random;

public class Checkpoint {
	public static void main(String[] args) {
		ArrayList<Cow> cows = new ArrayList<Cow>();
		Random rand = new Random();
		
		for(int i=0; i<rand.nextInt(10) + 1; i++) {
			cows.add(new Cow());
		}
		
		for(int i=0; i<cows.size(); i++) {
			cows.get(i).feed();
		}
	}
}

class Cow {
    public void feed(){
    	System.out.println("The cow has been fed some grass.");
    }
}
