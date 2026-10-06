package com.example.kt5;

public final class Task5KthWord {
    private Task5KthWord() {
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        int q = scanner.nextInt();
        DynamicWordTrie trie = new DynamicWordTrie();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < q; i++) {
            String operation = scanner.next();

            switch (operation) {
                case "ADD" -> trie.add(scanner.next());
                case "REMOVE" -> trie.remove(scanner.next());
                case "KTH" -> {
                    String prefix = scanner.next();
                    int k = scanner.nextInt();
                    String result = trie.kth(prefix, k);
                    output.append(result == null ? "NONE" : result)
                        .append('\n');
                }
                default -> throw new IllegalArgumentException(operation);
            }
        }

        System.out.print(output);
    }
}
