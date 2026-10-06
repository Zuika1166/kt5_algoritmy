package com.example.kt5;

import java.util.ArrayList;
import java.util.List;

public final class Task1Parentheses {
    private Task1Parentheses() {
    }

    public static List<String> generate(int pairs) {
        List<String> result = new ArrayList<>();
        char[] current = new char[pairs * 2];
        generate(pairs, 0, 0, 0, current, result);
        return result;
    }

    private static void generate(
        int pairs,
        int position,
        int opened,
        int closed,
        char[] current,
        List<String> result
    ) {
        if (position == current.length) {
            result.add(new String(current));
            return;
        }

        if (opened < pairs) {
            current[position] = '(';
            generate(
                pairs,
                position + 1,
                opened + 1,
                closed,
                current,
                result
            );
        }

        if (closed < opened) {
            current[position] = ')';
            generate(
                pairs,
                position + 1,
                opened,
                closed + 1,
                current,
                result
            );
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        StringBuilder output = new StringBuilder();

        for (String sequence : generate(n)) {
            output.append(sequence).append('\n');
        }

        System.out.print(output);
    }
}
