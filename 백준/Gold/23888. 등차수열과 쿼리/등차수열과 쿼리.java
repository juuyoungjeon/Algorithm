import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.System.*;

public class Main {
    static long a;
    static long d;
    static long ans_2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
        a = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        long a1 = Math.max(a, d);
        long d1 = Math.min(a, d);
        ans_2 = gcd(a1, d1);//2번쿼리 답이 연속된 두항이상이면 무조건 답이 이거.
        String str1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(str1);
        int T = Integer.parseInt(st1.nextToken());
        for (int i = 0; i < T; i++) {
            String str2 = br.readLine();
            StringTokenizer st2 = new StringTokenizer(str2);
            int type = Integer.parseInt(st2.nextToken());
            long l = Integer.parseInt(st2.nextToken());
            long r = Integer.parseInt(st2.nextToken());
            if(type==1) {
                String s = String.valueOf(((a+(l-1)*d)+(a+(r-1)*d))*(r-l+1)/2);
                bw.write(s);
                bw.newLine();
            }
            else {
                if(l==r) {
                    String s = String.valueOf((a+(l-1)*d));
                    bw.write(s);
                    bw.newLine();
                }
                else {
                    String s = String.valueOf(ans_2);
                    bw.write(s);
                    bw.newLine();
                }
            }
        }
        bw.close();
    }
    public static long gcd(long A, long B){//A가 큰거, B가 작은거.
        if(B==0) return A;
        while (true){
            if(A%B==0) break;
            long tmp = B;
            B=A%B;
            A=tmp;
        }
        return B;
    }

}