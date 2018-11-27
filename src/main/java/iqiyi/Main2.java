package iqiyi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split(" ");
        int N = Integer.valueOf(str1[0]);//食物个数
        int[] A = new int[N];

        int M = Integer.valueOf(str1[1]);
        int P = Integer.valueOf(str1[2]);
        String[] str2 = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.valueOf(str2[i]);
        }

        for (int j = 0; j < M; ++j) {
            String[] line = sc.nextLine().split(" ");
            int index = Integer.valueOf(line[1]);
            if (line[0].equals("B")) {
                A[index - 1]--;
            }
            if (line[0].equals("A")) {
                A[index - 1]++;
            }
        }

        int res = 1;
        for (int i = 0; i < N; ++i) {
            if (A[i] > A[P - 1]) res++;
        }


        System.out.println(res);
    }
}