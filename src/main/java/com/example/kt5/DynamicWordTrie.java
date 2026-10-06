package com.example.kt5;

import java.util.Arrays;

final class DynamicWordTrie {
    private int[] firstEdge = new int[16];
    private int[] subtreeSize = new int[16];
    private boolean[] terminal = new boolean[16];
    private int[] edgeTo = new int[16];
    private int[] edgeNext = new int[16];
    private char[] edgeChar = new char[16];
    private int nodeCount = 1;
    private int edgeCount;

    void add(String word) {
        int node = 0;
        subtreeSize[node]++;

        for (int i = 0; i < word.length(); i++) {
            node = getOrCreateChild(node, word.charAt(i));
            subtreeSize[node]++;
        }

        terminal[node] = true;
    }

    void remove(String word) {
        int node = 0;
        subtreeSize[node]--;

        for (int i = 0; i < word.length(); i++) {
            node = findChild(node, word.charAt(i));
            subtreeSize[node]--;
        }

        terminal[node] = false;
    }

    int countPrefix(String prefix) {
        int node = findNode(prefix);
        return node == -1 ? 0 : subtreeSize[node];
    }

    String kth(String prefix, int k) {
        int node = findNode(prefix);

        if (node == -1 || subtreeSize[node] < k) {
            return null;
        }

        StringBuilder result = new StringBuilder(prefix);

        while (true) {
            if (terminal[node]) {
                if (k == 1) {
                    return result.toString();
                }

                k--;
            }

            int edge = firstEdge[node];

            while (edge != 0) {
                int child = edgeTo[edge];
                int count = subtreeSize[child];

                if (count >= k) {
                    result.append(edgeChar[edge]);
                    node = child;
                    break;
                }

                k -= count;
                edge = edgeNext[edge];
            }
        }
    }

    private int findNode(String value) {
        int node = 0;

        for (int i = 0; i < value.length(); i++) {
            node = findChild(node, value.charAt(i));

            if (node == -1) {
                return -1;
            }
        }

        return node;
    }

    private int findChild(int node, char character) {
        int edge = firstEdge[node];

        while (edge != 0 && edgeChar[edge] < character) {
            edge = edgeNext[edge];
        }

        if (edge != 0 && edgeChar[edge] == character) {
            return edgeTo[edge];
        }

        return -1;
    }

    private int getOrCreateChild(int node, char character) {
        int previous = 0;
        int edge = firstEdge[node];

        while (edge != 0 && edgeChar[edge] < character) {
            previous = edge;
            edge = edgeNext[edge];
        }

        if (edge != 0 && edgeChar[edge] == character) {
            return edgeTo[edge];
        }

        int child = createNode();
        int newEdge = createEdge(child, character, edge);

        if (previous == 0) {
            firstEdge[node] = newEdge;
        } else {
            edgeNext[previous] = newEdge;
        }

        return child;
    }

    private int createNode() {
        ensureNodeCapacity(nodeCount + 1);
        return nodeCount++;
    }

    private int createEdge(int child, char character, int next) {
        ensureEdgeCapacity(edgeCount + 2);
        int edge = ++edgeCount;
        edgeTo[edge] = child;
        edgeChar[edge] = character;
        edgeNext[edge] = next;
        return edge;
    }

    private void ensureNodeCapacity(int required) {
        if (required <= firstEdge.length) {
            return;
        }

        int capacity = Math.max(required, firstEdge.length * 2);
        firstEdge = Arrays.copyOf(firstEdge, capacity);
        subtreeSize = Arrays.copyOf(subtreeSize, capacity);
        terminal = Arrays.copyOf(terminal, capacity);
    }

    private void ensureEdgeCapacity(int required) {
        if (required <= edgeTo.length) {
            return;
        }

        int capacity = Math.max(required, edgeTo.length * 2);
        edgeTo = Arrays.copyOf(edgeTo, capacity);
        edgeNext = Arrays.copyOf(edgeNext, capacity);
        edgeChar = Arrays.copyOf(edgeChar, capacity);
    }
}
