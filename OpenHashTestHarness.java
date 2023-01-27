
public class OpenHashTestHarness {
	
	  		public static void main(String[] args) {
	  		   System.out.println("Testing started");
	  	
	  		 OpenHash testSum = new OpenHash();

	  	     //implement after original class is largely completed
	  	     testSum.addToHash(1);
	  	     assert (testSum.getIntOrigSum() == 1) : "Assert (testSum.getIntOrigSum(1) == 1) failed";
	  	     assert (testSum.getIntPostSum() == 1) : "Assert (testSum.getIntPostSum(1) == 1) failed";
	  	     assert (testSum.getKey1() == '@') : "Assert (testSum.getIntPostSum(1) == @) failed";
	  	     //testSum.addToHash(0);
	  	     //testSum.addToHash(1);
	  	     testSum.addToHash(2);
	  	     testSum.addToHash(3);
	  	     testSum.addToHash(4);
	  	     testSum.addToHash(5);
	  	     testSum.addToHash(6);
	  	     testSum.addToHash(7);
	  	     testSum.addToHash(8);
	  	     testSum.addToHash(9);
	  	     testSum.addToHash(14);
	  	     testSum.addToHash(12341414);
	  	     testSum.addToHash(5121);

			PareTester tester = new PareTester();	
			FileFunctionality ff = new FileFunctionality();
			FileFunctionality ff2 = new FileFunctionality();


			testSum.addToHash("Test");
			testSum.addToHash("Test ing");
			testSum.addToHash(tester.getResult());
			
			try {
			testSum.addToHash(ff.fileParse("FF test file 1.txt"));
			} 
			catch (Exception e){
				// TODO: handle exception
			}

			try {
				testSum.addToHash(ff2.fileParse("FF test file 2.txt"));
				} 
				catch (Exception e){
					// TODO: handle exception
				}

			//testSum.addToHash(tester.getResult());
			//testSum.addToHash(tester.getResult());
			//testSum.addToHash("beeepis");
			//testSum.addToHash("asdkhbfkhjfkhjf");
			
		//	PareTester tester = new PareTester();

		//	tester.tester(3000);
		//	tester.tester(3000);
		//	tester.tester(3000);
		//	tester.tester(3000);


		//	System.out.println("\n total flags: " + tester.getFlags());
		//	System.out.println("err sum: " + testSum.getErrSum());


			//PareTester.tester(100000);
			//PareTester.tester(100000);
			//PareTester.tester(100000);
			
	  	     // testSum.addToHash(-3);
	  	     // assert (testSum.#(0, 1) == 1) : "Assert (testSum.#(0, 1) == 1) failed";
	  	     // assert (testSum.#(0, 99) == 99) : "Assert (testSum.#(0, 99) == 99) failed";
	  	     // assert (testSum.#(1, 0) == 60) : "Assert (testSum.#(1, 0) == 60) failed";
	  	     // assert (testSum.#(5, 0) == 300) : "Assert (testSum.#(5, 0) == 300) failed";
	  	     // assert (testSum.#(2, 30) == 150) : "Assert (testSum.#(2, 30) == 150) failed";
	  	     
	  	     //System.out.println(testSum.getIntOrigPostHash());
	  	     //System.out.println(testSum.getOrigIntList());
	  	     //System.out.println(testSum.getOrigStrList());
	  	     //System.out.println(testSum.getHash());
	  	     System.out.println(testSum.getStrHash());
	  	    
	  	     System.out.println("Testing completed");
	  		}
		}
