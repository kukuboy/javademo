package Print;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class RedirectOutputStream {
    public static void main(String[] args){
        try {
            PrintStream out = System.out;
            PrintStream ps=new PrintStream("./log.txt");
            System.setOut(ps);
            int age = 18;
            System.out.println("年龄变量成功定义，初始值为18");
            String sex="女";
            System.out.println("性别变量成功定义，初始值为女");
            System.out.println("年龄和性别分别为:"+age+sex);
            System.setOut(out);
            System.out.println("程序运行完毕，请查看日志文件");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
