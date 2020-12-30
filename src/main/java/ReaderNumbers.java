import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderNumbers {
    private int[] numbers;

    public ReaderNumbers(File file){
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String str = br.readLine();
            String[] strNumbers = str.split(" ");

            int count = strNumbers.length;
            numbers = new int[count];
            for (int i = 0; i < count; i++) {
                //System.out.println(strNumbers[i]);
                numbers[i] = Integer.parseInt(strNumbers[i]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] getNumbers() {
        return numbers;
    }

    public List<Integer> getNumbersAsList(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        return list;
    }
}
