package com.example.kt5;

public final class Task3TwoUnique {
    private Task3TwoUnique() {
    }

    public static int[] findUnique(int[] numbers) {
        int xor = 0;

        for (int number : numbers) {
            xor ^= number;
        }

        int distinguishingBit = xor & -xor;
        int first = 0;
        int second = 0;

        for (int number : numbers) {
            if ((number & distinguishingBit) == 0) {
                first ^= number;
            } else {
                second ^= number;
            }
        }

        if (first <= second) {
            return new int[]{first, second};
        }

        return new int[]{second, first};
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int[] result = findUnique(numbers);
        System.out.println(result[0] + " " + result[1]);
    }
}
