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
	int x;
	int y;
	private boolean printOp = false;
	
	final char[] restKeyTable = {'Z', 'T', 'V', 'A', 'B', 'C', 'X', 'F', 'H', 'Q'};
	final char[] key1Table = {':', '@', '!', '$', '%', '&', '^', '#', '?', '/'}; 
	
	private HashMap<String, Integer> hash = new HashMap<>();
	private HashMap<Integer, String> strHash = new HashMap<>();
	private HashMap<Integer, Integer> intOrigPostHash = new HashMap<>();
	private HashMap<String, Integer> strOrigPostHash = new HashMap<>();
	private ArrayList<Integer> origIntList = new ArrayList<>();
	private ArrayList<String> origStrList = new ArrayList<>();
	
	
	public OpenHash() {
		
	}
	
	/**
	public OpenHash(int origSum) {
		this.origSum = origSum;
		postSum = 0;
		stringPostSum = "";
		stringOrigSum = "";
	}
	
	public OpenHash(int origSum, int postSum) {
		this.origSum = origSum;
		this.postSum = postSum;
		stringPostSum = "";
		stringOrigSum = "";
	}
	
	public OpenHash(int origSum, int postSum, String stringOrigSum) {
		this.origSum = origSum;
		this.postSum = postSum;
		this.stringOrigSum = stringOrigSum;
		stringPostSum = "";
	}
	
	public OpenHash(int origSum, int postSum, String stringOrigSum, String stringPostSum) {
		this.origSum = origSum;
		this.postSum = postSum;
		this.stringOrigSum = stringOrigSum;
		this.stringPostSum = stringPostSum;
	}
	
	*
	*/
	
	
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
		
		printOp("processInt");
	}
	
	
	private int concatenateDigits(ArrayList<Integer> digits, int forA){		
			int resultA = 0;
		    for (int i = 0; (i) < digits.size(); i++) {       /// 10 * num + other nums
			    resultA += (digits.get(i) * (forA));
			    forA *= 10;
		    }
		   System.out.println(resultA); 
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
		int keyLength = 3;
		int sum = 0;
		int forA = 1;
		char key2;
		char key3;
		char key4;
		
		origStrList.add(strSum);
		
		stringOrigSum = origStrList.get(origStrList.indexOf(strSum));
		strValue = origStrList.get(origStrList.indexOf(strSum));
		
		//algorithm
		
		//turns String strSum into a list of characters
		if (strSum.length() >= 4)
		{
			rand(strSum.length());
			for (int i = y; (i) <= x; i++) {
				s.add(strSum.charAt(i));
				System.out.println(s);
			
				//casts chars to to ints and adds them to a list 	
			}

			rand(s.size());
			for (int i = 0; (i) <= s.size(); i++) {
				a.add(intPare(s.get(i)));
				System.out.println(a);
			}
		} else if (strSum.length() < 4){
			return;
		}
		
		firstProcessResult = concatenateDigits(a, forA);
	
		postSum = firstProcessResult;
		
		keyForStr = postSum;
		
		/**
		 * 
		key1 = key1Table[postSum];
		key2 = restKeyTable[keyGen.nextInt(10)];
		key3 = restKeyTable[keyGen.nextInt(10)];
		key4 = restKeyTable[keyGen.nextInt(10)];
		 
		//keyForStr = key1 + "" +  key2 + "" + key3 + "" + key4;
		
		while (hash.containsKey(keyForStr) == true) {
			key2 = restKeyTable[keyGen.nextInt(10)];
			key3 = restKeyTable[keyGen.nextInt(10)];
			key4 = restKeyTable[keyGen.nextInt(10)];
			//keyForStr = key1 + "" +  key2 + "" + key3 + "" + key4;
		}
		*/
		
		strHash.put(keyForStr, strValue);
		strOrigPostHash.put(stringOrigSum, postSum);
		
		printOp("processString");
	}
	
	/**
	 * 
	 * 
	 * @param 
	 * @return 
	 *
	public boolean verify() {
		
		if () {
			return true;
		} else {
			return false;
		}
	}
	*/
	
	public void addToHash(int originalSum) {
		processInt(originalSum);
	}
	
	public void addToHash(String originalString) {
		processString(originalString);
	}
	
	private void rand(int size) {
		Random r = new Random();
		int[] ints = new int[size];
		for (int i = 0; i < size; i++) {
			ints[i] = i;
		}
		
		int z = r.nextInt(size);
		x = z;
		
		while ((z - 3) < 1) {
			z = r.nextInt(size);
			x  = z - 1;
		}
		if (x >= 1) {
			x -= 1;
		}
		y = x - 3;
		
	}
	
	
	private int intPare(int sum) {
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
	 * allows manual assignment of original sum
	 * @param sum to be assigned
	 */
	public void setOrigSum(int sum) {
		origSum = sum;
	}
	
	/**
	 * allows manual assignment of post process sum
	 * @param sum to be assigned
	 *
	public void setPostSum(int sum) {
		postSum = sum;
		printOp("setPostSum");
	}
	*/
	
	/**
	 * 
	 * @param sum
	 * @return
	 */
	public int getIntOrigSum() {
		printOp("getorigSum");
		return origSum;
	}
	
	/**
	 * 
	 * @param sum
	 * @return
	 */
	public int getIntPostSum() {
		printOp("getPostSum");
		return postSum;
	}
	
	
	//string versions
	
	/**
	 * 
	 * @param sum
	 */
	public void setOrigSum(String sum) {
		stringOrigSum = sum;
		printOp("setOrigSumString");
	}
	
	/**
	 * allows manual assignment of post process sum as string
	 * @param sum to be assigned
	 */
	public void setPostSum(String sum) {
		//stringPostSum = sum;
		printOp("setPostSumString");
	}
	
	/**
	 * 
	 * @return
	 */
	public String getOrigSum() {
		printOp("getOrigSumString");
		return stringOrigSum;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPostSum() {
		printOp("getPostSumString");
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
	

	
// section below is the program feedback section which
// has no relevance to the main function of the program
	
	/**
	 * sets whether task completion feedback is enabled
	 * @param option
	 */
	public void setPrintOption(boolean option) {
		printOp = option;	
		printOp("setPrintOption");
	}
	
	/**
	 * if task feedback(printOp) is turned on(true), will print
	 * feedback related to any public method that this called
	 * used for testing
	 * 
	 * @param methodToPrint string name of method who's feedback will be printed
	 */
	private void printOp(String methodToPrint) {
		String s = methodToPrint;
		
	// if setPrintOption method called this method // if the user is turning printing on or off
		if (s.toLowerCase() == "setprintoption") {
			if (printOp) {
				System.out.println("task feedback enabled");
			} else {
				System.out.println("task feedback disabled");
			}
			
		// if this method is called by any method other than setPrintOp			
		} else if (s.toLowerCase() != "setprintop"){
				if (printOp = false) {
					return;
				} 
				else if (s.toLowerCase() == "process"){
					System.out.println("sum successfully processed");
				}
				else if (s.toLowerCase() == "setpostsum") {
					System.out.println("post sum set to " + postSum);
				}
				else if (s.toLowerCase() == "setorigsum") {
					System.out.println("original sum set to " + origSum);
				} 
				else if (s.toLowerCase() == "getorigsum") {
					System.out.println("original sum set to " + origSum);
				} 
				else {
					return;
				}
		}
		
	}
	
}
	
