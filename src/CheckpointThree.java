import java.util.ArrayList;
import java.util.HashMap;

public class CheckpointThree {
	public static void main(String[] args) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		ArrayList<String> keys = new ArrayList<String>();
		
		hashMap.put("tree", "Baum");
		keys.add("tree");
		hashMap.put("newspaper", "Zeitung");
		keys.add("newspaper");
		hashMap.put("shirt", "Hemden");
		keys.add("shirt");
		hashMap.put("jacket", "Jacke");
		keys.add("jacket");
		hashMap.put("horse", "Pferd");
		keys.add("horse");
		
		for(int i=0; i<hashMap.size(); i++) {
			System.out.println("Key: " + keys.get(i) + "    Value: " + hashMap.get(keys.get(i)));
		}
	}
}
