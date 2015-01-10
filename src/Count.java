import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Count {
    public static void main(String[] args) throws Exception {
        TreeMap<Character, Integer> hashMap = new TreeMap<Character, Integer>();
        File file = new File("D:/TextWithLetters.txt");
        Scanner scanner = new Scanner(file,"utf-8");
        PrintStream out = new PrintStream(new FileOutputStream("D:/OutputCountSymbols.txt"));
        System.setOut(out);
        long lStartTime = new Date().getTime();
        while (scanner.hasNext()) {
            char[] chars = scanner.nextLine().toLowerCase().toCharArray();
            for (Character c : chars) {
                if(!Character.isLetter(c)){
                    continue;
                }
                else if (hashMap.containsKey(c)) {
                    hashMap.put(c, hashMap.get(c) + 1);
                } else {
                    hashMap.put(c, 1);
                }
            }
        }
        long lEndTime = new Date().getTime();
        long difference = lEndTime - lStartTime;
        System.out.println("Elapsed milliseconds: " + difference);
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}