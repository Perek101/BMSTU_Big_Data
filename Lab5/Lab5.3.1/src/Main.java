import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        String s = "";
        StringBuilder stringBuilder = new StringBuilder();
       while ( true ) {
            s = scanner.nextLine();
            if ( s.isEmpty() )
                break;
            stringBuilder.append(s.toLowerCase()+ "\n");
            //System.out.print("\n"+s.toLowerCase());
           // words.addAll(Arrays.asList(s.split("[^A-Za-z0-9_]")));
        }
       /* for (int i=0; i<words.size(); i++){
            if (words.get(i).isEmpty()){
                words.remove(i);
            }
            words.set(i, words.get(i).toLowerCase());
        }
        for (int i=0; i<words.size(); i++){
            System.out.println(words.get(i));
        }
        s.*/
        //scanner.close();
        System.out.println(stringBuilder);
    }

}