import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * used for general pre and post processing int verification
 * also acts as a container for sums
 * 
 * will eventually be obsolete but is a basic and quick development solution
 * meant to minimize confusing or unclear logic errors
 * 
 * needs to be simple and have a very low chance of causing errors
 * to be useful
 * 
 * still probably won't be useful though
 * 
 * @author SimmonsTice
 *
 */
public class OpenHash {
	private int origSum;
	private int postSum;
	private int value;
	private String strValue;
	private String stringOrigSum;
	private String keyForInt;
	private int keyForStr;
	private char key1;
	private int x;
	private int y;
	private int some;
	
	final char[] restKeyTable = {'Z', 'T', 'V', 'A', 'B', 'C', 'X', 'F', 'H', 'Q'};
	final char[] key1Table = {':', '@', '!', '$', '%', '&', '^', '#', '?', '/'}; 
	
	private HashMap<String, Integer> hash = new HashMap<>();
	private HashMap<Integer, String> strHash = new HashMap<>();
	private HashMap<Integer, Integer> intOrigPostHash = new HashMap<>();
	private HashMap<String, Integer> strOrigPostHash = new HashMap<>();
	private ArrayList<Integer> origIntList = new ArrayList<>();
	private ArrayList<String> origStrList = new ArrayList<>();
	
	
	//constructor 
	public OpenHash() {
		
	}
	
	
	/**
	 * generates 4 character key to hash value(sum)
	 * adds sum and key to hash
	 * 
	 * @param sum to be processed
	 */
	private void processInt(int sum) {
		Random keyGen = new Random();
		int firstProcessResult = 0;
		char key2;
		char key3;
		char key4;
		
		origIntList.add(sum);
		
		origSum = origIntList.get(origIntList.indexOf(sum));
		value = origIntList.get(origIntList.indexOf(sum));
		
		//algorithm
		firstProcessResult = intPare(sum);
		
		postSum = firstProcessResult;
	
		key1 = key1Table[postSum];
		key2 = restKeyTable[keyGen.nextInt(10)];
		key3 = restKeyTable[keyGen.nextInt(10)];
		key4 = restKeyTable[keyGen.nextInt(10)];
		 
		keyForInt = key1 + "" +  key2 + "" + key3 + "" + key4;
		
		while (hash.containsKey(keyForInt) == true) {
			key2 = restKeyTable[keyGen.nextInt(10)];
			key3 = restKeyTable[keyGen.nextInt(10)];
			key4 = restKeyTable[keyGen.nextInt(10)];
			keyForInt = key1 + "" +  key2 + "" + key3 + "" + key4;
		}
		
		hash.put(keyForInt, value);
		intOrigPostHash.put(origSum, postSum);
		
	}
	
	
	private int concatenateDigits(ArrayList<Integer> digits, int forA){		
			int resultA = 0;
		    for (int i = 0; (i) < digits.size(); i++) {       /// 10 * num + other nums
			    resultA += (digits.get(i) * (forA));
			    forA *= 10;
		    } 
		   return resultA;
		}
	
	
	/**
	 * processes given string using simple algorithm, probably
	 * 
	 * @param string to be processed
	 * @return string result of process
	 */
	private void processString(String strSum) {
		Random keyGen = new Random();
		//list of characters from strSum
		ArrayList<Character> s = new ArrayList<>();
		//characters from arraylist s casted to integers
		ArrayList<Integer> a = new ArrayList<>();
		
		
		int firstProcessResult = 0;
		int forA = 1;
		
		origStrList.add(strSum);
		
		stringOrigSum = origStrList.get(origStrList.indexOf(strSum));
		strValue = origStrList.get(origStrList.indexOf(strSum));
		
		//algorithm
		
		//turns String strSum into a list of characters
		if (strSum.length() >= 4)
		{
			rand(strSum.length());
			for (int i = 0; i < strSum.length(); i++) {
				s.add(strSum.charAt(i));
				//System.out.println(s);
			
				//casts chars to to ints and adds them to a list 	
			}
			
			rand(s.size());
			
			for (int i = y; i <= x; i++)  { //see dev_problems.md concering this for loop
				some = intPare((s.get(i) * keyGen.nextInt(1, 100)));
				a.add(some);
				//System.out.println(a);
			}
		} else if (strSum.length() < 4){
			return;
		}
		
		firstProcessResult = concatenateDigits(a, forA);
	
		postSum = firstProcessResult;
		
		keyForStr = postSum;
		
		strHash.put(keyForStr, strValue);
		strOrigPostHash.put(stringOrigSum, postSum);
		
	}
	
	
	public void addToHash(int originalSum) {
		processInt(originalSum);
	}
	
	public void addToHash(String originalString) {
		processString(originalString);
	}
	

	/**
	 * designates indexes with which cover a random 4 digit space within an array
	 * 
	 * @param size length of source array
	 */
	private void rand(int size) {
		Random r = new Random();
		int[] ints = new int[size];
		// makes an array of length size, with every value being equal to it's index
		for (int i = 0; i < size; i++) {
			ints[i] = i;
		}
		
		//generates a random index of the ints array
		x = r.nextInt(ints.length) - 1;

		//ensures that using y will not cause an out of bounds exception to occur  
		if (x < 3){
			x = 3;
		} 

		y = x - 3;
		
	}
	
	
	/**
	 * an algorithm to reduce an int to an expected size
	 * @param sum num to be reduced
	 * @return will always return an int that is between 0 and 9
	 */
	public int intPare(int sum) {
		int reSum = sum;
		if (sum >= 10) {
			while (sum > 10) {
				if (sum % 2 == 0) {
					sum /= 2;
				} else if (sum % 2 == 1) {
					sum += 1;
					sum /= 2;
				}
				reSum = sum;
			}
		} else if (sum == 0 || sum >= 1 && sum < 10) {
			reSum = sum;
		} else {
			System.out.println("algorithm currently does not support this number");
			return 0;
		}
		
		return reSum;
	}
	
	
// getters and setters
	
	public char getKey1() {
		return key1;
	}
	
	/**
	 * allows manual assignment of post process sum
	 * @param sum to be assigned
	 *
	public void setPostSum(int sum) {
		postSum = sum;
	}
	*/
	
	/**
	 * 
	 * @param sum
	 * @return
	 */
	public int getIntOrigSum() {
		return origSum;
	}
	
	/**
	 * 
	 * @param sum
	 * @return
	 */
	public int getIntPostSum() {
		return postSum;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getOrigSum() {
		return stringOrigSum;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPostSum() {
		return "";
	}
	
	public HashMap<String, Integer> getHash() {
		return hash;
	}
	
	public HashMap<Integer, String> getStrHash(){
		return strHash;
	}
	
	public HashMap<Integer, Integer> getIntOrigPostHash(){
		return intOrigPostHash;
	}
	
	public ArrayList<Integer> getOrigIntList(){
		return origIntList;
	}
	
	public ArrayList<String> getOrigStrList(){
		return origStrList;
	}

	/**
	 * allows manual assignment of original sum
	 * @param sum to be assigned
	 */
	public void setOrigSum(int sum) {
		origSum = sum;
	}
	
		/**
	 * 
	 * @param sum
	 */
	public void setOrigSum(String sum) {
		stringOrigSum = sum;
	}
	
	/**
	 * allows manual assignment of post process sum as string
	 * @param sum to be assigned
	 */
	public void setPostSum(String sum) {
		//stringPostSum = sum;
	}

	public int getKeyForStr(){
		return keyForStr;
	}

	public int getSome(){
		return some;
	}
	
}
	
