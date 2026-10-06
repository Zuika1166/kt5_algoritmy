package com.example.kt5;

public final class Task2PrefixDictionary {
    private Task2PrefixDictionary() {
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        int q = scanner.nextInt();
        DynamicWordTrie trie = new DynamicWordTrie();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < q; i++) {
            String operation = scanner.next();
            String value = scanner.next();

            switch (operation) {
                case "ADD" -> trie.add(value);
                case "REMOVE" -> trie.remove(value);
                case "COUNT" ->
                    output.append(trie.countPrefix(value)).append('\n');
                default -> throw new IllegalArgumentException(operation);
            }
        }

        System.out.print(output);
    }
}
