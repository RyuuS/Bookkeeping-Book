import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        T t =new T();
        t.f();
        System.out.println(t.s);

    }
}
class T{
    int s = 0;
     public void f(){
         s = 15;
     }

}
