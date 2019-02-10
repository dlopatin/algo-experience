package com.dlopatin.codeforce.div2.r538;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * http://codeforces.com/contest/1114/problem/A
 */
public class A {

    private static final Set<Character> A = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer xyz = new StringTokenizer(reader.readLine());
            StringTokenizer abc = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(xyz.nextToken());
            int y = Integer.parseInt(xyz.nextToken());
            int z = Integer.parseInt(xyz.nextToken());
            int a = Integer.parseInt(abc.nextToken());
            int b = Integer.parseInt(abc.nextToken());
            int c = Integer.parseInt(abc.nextToken());
            int leftX = a - x;
            int leftXY = leftX + b - y;
            int leftXYZ = leftXY + c - z;
            System.out.println(leftX >= 0 && leftXY >= 0 && leftXYZ >= 0 ? "Yes" : "No");
        }
    }
}