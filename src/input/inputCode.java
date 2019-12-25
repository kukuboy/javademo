package input;
import java.util.Scanner;

public class inputCode {
    public static void main (String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入你的身份证号");
        String line = scanner.nextLine();
        System.err.println("抱歉你的年龄太大了");
    }
}
