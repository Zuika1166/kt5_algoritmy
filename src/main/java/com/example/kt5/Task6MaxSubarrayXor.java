package com.example.kt5;

public final class Task6MaxSubarrayXor {
    private Task6MaxSubarrayXor() {
    }

    public static int maxSubarrayXor(int[] numbers) {
        BinaryTrie trie = new BinaryTrie((numbers.length + 1) * 31 + 1);
        trie.add(0);

        int prefix = 0;
        int best = 0;

        for (int number : numbers) {
            prefix ^= number;
            best = Math.max(best, trie.bestXor(prefix));
            trie.add(prefix);
        }

        return best;
    }

    private static final class BinaryTrie {
        private final int[] zero;
        private final int[] one;
        private int nodes = 1;

        BinaryTrie(int capacity) {
            zero = new int[capacity];
            one = new int[capacity];
        }

        void add(int value) {
            int node = 0;

            for (int bit = 29; bit >= 0; bit--) {
                int current = (value >>> bit) & 1;

                if (current == 0) {
                    if (zero[node] == 0) {
                        zero[node] = nodes++;
                    }

                    node = zero[node];
                } else {
                    if (one[node] == 0) {
                        one[node] = nodes++;
                    }

                    node = one[node];
                }
            }
        }

        int bestXor(int value) {
            int node = 0;
            int result = 0;

            for (int bit = 29; bit >= 0; bit--) {
                int current = (value >>> bit) & 1;

                if (current == 0) {
                    if (one[node] != 0) {
                        result |= 1 << bit;
                        node = one[node];
                    } else {
                        node = zero[node];
                    }
                } else {
                    if (zero[node] != 0) {
                        result |= 1 << bit;
                        node = zero[node];
                    } else {
                        node = one[node];
                    }
                }
            }

            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println(maxSubarrayXor(numbers));
    }
}
