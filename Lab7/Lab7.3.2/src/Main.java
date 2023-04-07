public class Main {
    /*
    8.	На основании правила кодирования, описанного в предыдущем примере, расшифровать заданный набор символов.
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");
        StringBuilder stringBuilder1= new StringBuilder();
        StringBuilder stringBuilder2= new StringBuilder();
        StringBuilder stringBuilder3= new StringBuilder();
        StringBuilder stringBuilder4 = new StringBuilder();
        String str = "Hello world!";
        for (int i=3;i<str.length()+3; i+=3){
            stringBuilder1.append(str.charAt(i-3));
            stringBuilder2.append(str.charAt(i-2));
            stringBuilder3.append(str.charAt(i-1));


        }
        System.out.println(str.length()+3);
        System.out.println("1: "+ stringBuilder1);
        System.out.println("2: "+ stringBuilder2);
        System.out.println("3: "+ stringBuilder3);



        //расшифровка
        for (int i=0; i<(stringBuilder1.length()+stringBuilder2.length()+stringBuilder3.length())/3; i++){

            System.out.print(""+stringBuilder1.charAt(i)+ stringBuilder2.charAt(i) + stringBuilder3.charAt(i));

        }
    }
}