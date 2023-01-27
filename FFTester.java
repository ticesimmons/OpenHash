//import java.io.IOException;

public class FFTester {

    public static void main(String[] args) {
        
        FileFunctionality  ff = new FileFunctionality();

        //for some reason, 
        //when both statements are present it prints the first one twice

        try {
            System.out.println(ff.fileParse("FF test file 1.txt"));

        } catch (Exception e) {
            // TODO: handle exception
        }

        try {
            System.out.println(ff.fileParse("FF test file 2.txt"));

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
