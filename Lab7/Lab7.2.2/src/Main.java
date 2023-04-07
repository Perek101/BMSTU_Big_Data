public class Main {
    /*
    8. Напечатать квитанцию об оплате телеграммы, если стоимость одного слова задана.
     */
    public static void main(String[] args) {
        int k=2;
        String str="Token holders are an important part of web3 protocols as they play a crucial role in the functioning and success of the network.";
        System.out.println("стоимость одного слова:" + k+"\nВаш текст: "+ str);
        System.out.println("\nСтоимость равна:" + str.split("\\s").length*k);
    }
}