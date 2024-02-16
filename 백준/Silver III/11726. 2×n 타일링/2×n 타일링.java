import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static long d[];
        
    public static void main(String args[]) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bf.readLine());
        d = new long[length+1];
        System.out.println(calculate(length));
    };

    static long calculate(int length){
        if (length == 0 || length == 1){
            return 1;
        }
        if (d[length] > 0) return d[length];
        
        d[length] = calculate(length-1) + calculate(length-2);
        d[length] %= 10007;
        return d[length];
    }
}