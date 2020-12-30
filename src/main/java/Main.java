import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        Scanner in = new Scanner(System.in);
        ReaderNumbers reader = new ReaderNumbers(new File("file.txt"));
        System.out.println(
                "Menu operations:\n" +
                "distinct numbers- 1\n" +
                "paired numbers- 2\n" +
                "all numbers - 3");

        for ( ; ; ){
            String inputStr = in.next();
            if (inputStr.equals("1")){
                Set<Integer> numbersSet = new HashSet<>();
                numbersSet.addAll(reader.getNumbersAsList());
                System.out.println(numbersSet.toString());
            }
            if(inputStr.equals("2")){
                List<Integer> list = reader.getNumbersAsList();
                Stream<Integer> stream = list.stream();
                stream
                        .filter(i -> i % 2 == 0)
                        .forEach(i -> System.out.print(i + " "));
                System.out.println();
            }

            if(inputStr.equals("3")){
                int[] numbers = reader.getNumbers();
                Map<Integer, String> map = new HashMap<>();
                map.put(0, "First");
                map.put(1, "Second");
                map.put(2, "Third");
                map.put(3, "Forth");
                map.put(4, "Five");
                map.put(5, "Six");
                map.put(6, "Seven");

                //Використовується ітератор тут
                for (Iterator<Integer> it = map.keySet().iterator(); it.hasNext(); ) {
                    int index = it.next();
                    System.out.println(map.get(index) + " element - " + numbers[index]);
                }
            }

            if (inputStr.equals("quit")){
                in.close();
                break;
            }
        }
        try(BufferedWriter br = new BufferedWriter(new FileWriter(new File("output.txt")))) {
            String result = (double)(System.currentTimeMillis() - startTime) + " milliseconds was a user session";
            System.out.println(result);
            br.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
