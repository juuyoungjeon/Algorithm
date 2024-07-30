import java.io.*;
import java.util.*;

public class Main {
    
    public static List<Integer> sol(List<Integer> arr1, List<Integer> arr2, List<Integer> res) {
        // 두 배열 중 하나라도 비어 있으면 결과 반환
        if (arr1.isEmpty() || arr2.isEmpty()) {
            return res;
        }
        
        // arr1과 arr2에서 각각 가장 큰 값과 그 인덱스를 찾음
        int tmp1 = Collections.max(arr1);
        int tmp2 = Collections.max(arr2);
        int idx1 = arr1.indexOf(tmp1);
        int idx2 = arr2.indexOf(tmp2);

        // 두 값이 같으면 결과에 추가하고 그 이후 부분으로 재귀 호출
        if (tmp1 == tmp2) {
            res.add(tmp1);
            return sol(arr1.subList(idx1 + 1, arr1.size()), arr2.subList(idx2 + 1, arr2.size()), res);
        }
        // tmp1이 더 크면 arr1에서 제거하고 재귀 호출
        else if (tmp1 > tmp2) {
            arr1.remove(idx1);
            return sol(arr1, arr2, res);
        }
        // tmp2가 더 크면 arr2에서 제거하고 재귀 호출
        else {
            arr2.remove(idx2);
            return sol(arr1, arr2, res);
        }
    }

    public static void main(String[] args) throws IOException {
        // 빠른 입출력 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 처리
        int n = Integer.parseInt(br.readLine());
        List<Integer> arr1 = new ArrayList<>();
        String[] input1 = br.readLine().split(" ");
        for (String s : input1) {
            arr1.add(Integer.parseInt(s));
        }

        int m = Integer.parseInt(br.readLine());
        List<Integer> arr2 = new ArrayList<>();
        String[] input2 = br.readLine().split(" ");
        for (String s : input2) {
            arr2.add(Integer.parseInt(s));
        }

        // 함수 호출
        List<Integer> ans = sol(arr1, arr2, new ArrayList<>());

        // 결과 출력
        bw.write(ans.size() + "\n");
        for (int i : ans) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}