public class Main {

    /*
    7.	В зависимости от признака (0 или 1) в каждой строке текста удалить указанный символ везде,
        где он встречается, или вставить его после k-гo символа.
     */
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        char ch ='a';
        String str = "sdfsf dsfa asd adasd asd";

        int k=0; //признак

        int k1=5; //позиция K
        if(k==0) {
            //String regex = "[-]";
            System.out.println("sdfsf dsfa asd adasd asd".replaceAll("[-" + ch + "]", ""));
        }
        k=1;
        if (k==1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str).insert(k1,ch);

            System.out.println(stringBuilder);
        }

    }
}