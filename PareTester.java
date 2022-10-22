import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class PareTester {

    private int totalFlags = 0;
    private String aresult;


    private final char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
    'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
    'y', 'z', 'A', 'B', 'C', 'D' , 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
    'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    private int p = chars.length;

    private String generateString(){
        Random q = new Random();
        Stream<Character> testStream = Stream.of(chars[q.nextInt(p)], chars[q.nextInt(p)],
        chars[q.nextInt(p)], chars[q.nextInt(p)], chars[q.nextInt(p)], chars[q.nextInt(p)],
        chars[q.nextInt(p)], chars[q.nextInt(p)], chars[q.nextInt(p)]
        );

        String result = testStream.collect(Collector.of(
        StringBuilder::new,
        StringBuilder::append,
        StringBuilder::append,
        StringBuilder::toString));

        aresult = result;
        return result;
    }
    
    public void tester(int tries) {
		OpenHash tester = new OpenHash();
        int flags = 0;
	    int i = 0;
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        int sixes = 0;
        int sevens = 0;
        int eights = 0;
        int nines = 0;
        int tens = 0;
        int moreThanTen = 0;
	    	
		System.out.println("initiating flag tester...");
        System.out.println("for " + generateString());
        try {
            Thread.sleep(3000);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }


		long startTime = System.nanoTime();
		
		while (i < tries) {
            tester.addToHash(generateString());
			if (tester.getKeyForStr() >= 10000){
				//System.out.println("flag: " + i);
                flags++;
				
                switch (tester.getSome()) {
                    case 0:
                        zeros++;
                        break;
                    case 1:
                        ones++;
                        break;
                    case 2:
                        twos++;
                        break;
                    case 3:
                        threes++;
                        break;
                    case 4:
                        fours++;
                        break;
                    case 5:
                        fives++;
                        break;
                    case 6:
                        sixes++;
                        break;
                    case 7:
                        sevens++;
                        break;
                    case 8:
                        eights++;
                        break;
                    case 9:
                        nines++;
                        break;
                    case 10:
                        tens++;
                        break;
                    default:
                        break;                       

                }

			}
			i++;
		 }
		long estimatedTime = System.nanoTime() - startTime;

        totalFlags += flags;
		System.out.println("operation took " + (estimatedTime / 1000000) + " miliseconds");
		System.out.println("ran " + i + " times");
		System.out.println("counted " + flags + " flags");
        System.out.println("0s: " + zeros);
        System.out.println("1s: " + ones);
        System.out.println("2s: " + twos);
        System.out.println("3s: " + threes);
        System.out.println("4s: " + fours);
        System.out.println("5s: " + fives);
        System.out.println("6s: " + sixes);
        System.out.println("7s: " + sevens);
        System.out.println("8s: " + eights);
        System.out.println("9s: " + nines);
        System.out.println("10s: " + tens);
        System.out.println("10+: " + moreThanTen);


        System.out.println("...finished flag testing");

	}

    public int getFlags() {
        return totalFlags;
        
    }

    public String getResult(){
        return aresult;
    }
}

