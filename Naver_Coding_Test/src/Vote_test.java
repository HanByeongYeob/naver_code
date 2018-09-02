import java.util.*;

public class Vote_test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> vote = new ArrayList<String>();
		String name;
		
		while(scanner.hasNext()) {
			name = scanner.next();
			if(name.length()<51)
				vote.add(name);
			
		}
		scanner.close();
		
		HashMap<String, Integer> voteResult = new HashMap<String, Integer>();
		for(int idx = 0; idx<vote.size(); idx++) {
			if(voteResult.containsKey(vote.get(idx))) {
				voteResult.put(vote.get(idx), voteResult.get(vote.get(idx))+1);
			}else{
				voteResult.put(vote.get(idx), 1);
			}
			
		}
		
		Set<String> keys = voteResult.keySet();
		Collection values = voteResult.values();
		Iterator<String> it = keys.iterator();
		ArrayList<String> result = new ArrayList<String>();
		while(it.hasNext()) {
			String key = it.next();
			if(voteResult.get(key) == Collections.max(values)) {
				result.add(key);
			}
		}
		
		Collections.sort(result);
		for(int i = 0; i<result.size();i++)
		System.out.println(result.get(i));
	}
}
