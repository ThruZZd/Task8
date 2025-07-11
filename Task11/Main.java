import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static HashMap<String, Integer> wordMap = new HashMap<>();
    private static final String INPUT = "bible";
    private static final String OUTPUT = "output";

    public static void main(String[] args){
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(INPUT));

            String line;

            while((line = reader.readLine()) != null){
                String[] words = line.replaceAll("\\p{Punct}", "").split("\\s+");

                for(String word : words){
                    if(word.length() > 1){
                        if(Character.isUpperCase(word.charAt(0))){
                            addWord(word);
                        }else{
                            subtractWord(word);
                        }
                    }
                }
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        handleOutput();


    }

    private static void addWord(String word){
        word = word.toUpperCase();
        if(wordMap.containsKey(word)){
            wordMap.put(word, wordMap.get(word) + 1);
        }else{
            wordMap.put(word, 1);
        }
    }

    private static void subtractWord(String word){
        word = word.toUpperCase();
        if(wordMap.containsKey(word)){
            wordMap.put(word, wordMap.get(word) - 1);
        }
    }

    private static void handleOutput(){

        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(wordMap.entrySet());
        sorted.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT));

        for(Map.Entry<String, Integer> entry : sorted){
            if(entry.getValue() > 0){
                String op = entry.getKey() + ": " + entry.getValue();
                System.out.println(op);
                writer.write(op+"\n");
            }
        }

        writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

  

    }
    
}
