import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        String s = "";
        String cleanedString = "";
        StringBuilder stringBuilder =new StringBuilder();
        HashMap<String, Integer> wordFrequencyMap = new HashMap<>();
        while ( true ) {
            s = scanner.nextLine();
            if ( s.isEmpty() )
                break;
            cleanedString = s.replaceAll("[!?.,—;]", "").toLowerCase();
            stringBuilder.append(cleanedString);
            words.addAll(Arrays.asList(cleanedString.split(" ")));
        }
        for (int i=0; i<words.size(); i++){
            if (words.get(i).isEmpty()){
                words.remove(i);
            }
        }


        for (String word : words) {
            if (wordFrequencyMap.containsKey(word)) {
                wordFrequencyMap.put(word, wordFrequencyMap.get(word) + 1);
            } else {
                wordFrequencyMap.put(word, 1);
            }
        }

        for (String key : wordFrequencyMap.keySet()) {
            System.out.println(key + " : " + wordFrequencyMap.get(key));
        }

        //повторяеомсть букв
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
       // System.out.println(stringBuilder);
        for (int i=0; i<stringBuilder.length(); i++){
            char curChar = stringBuilder.charAt(i);
            if (charFrequencyMap.containsKey(curChar)) {
                charFrequencyMap.put(curChar, charFrequencyMap.get(curChar) + 1);
            } else {
                charFrequencyMap.put(curChar, 1);
            }
        }
        for (char key : charFrequencyMap.keySet()) {
            System.out.println(key + " : " + charFrequencyMap.get(key));
        }
        scanner.close();



    }

}