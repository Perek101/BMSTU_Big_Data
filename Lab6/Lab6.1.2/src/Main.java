import java.util.Stack;
/*
8.	Задана строка, состоящая из символов '(', ')', '[', ']', '{', '}'.
    Проверить правильность расстановки скобок. Использовать стек.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String str = "(', ')[', ']{', '}";
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<=str.length()-1;i++){
            stack.push(str.charAt(i));
            //System.out.println(str.charAt(i));
        }
       // System.out.println(stack);
        int a=-1;
        for (int i=0; i<stack.size()-5; i+=6){
            a=-1;
            if(stack.get(i)=='(' || stack.get(i)=='{' || stack.get(i)=='['){
                if(stack.get(i)=='(' && stack.elementAt(i+5)==')'){
                    System.out.println("correct" + stack.get(i) + " " + stack.elementAt(i+5));
                    a=1;
                    continue;
                }
                if(stack.get(i)=='{' && stack.elementAt(i+5)=='}'){
                    System.out.println("correct" + stack.get(i) + " " + stack.elementAt(i+5));
                    a=2;
                    continue;
                }
                if(stack.get(i)=='[' && stack.elementAt(i+5)==']'){
                    System.out.println("correct" + stack.get(i) + " " + stack.elementAt(i+5));
                    a=3;
                }
                if(a==-1){
                    System.out.println("incorrect");
                }
            }

        }
    }
}