package com.example.kt5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AlgorithmsTest {
    @Test
    void parenthesesAreGeneratedInLexicographicOrder() {
        assertEquals(
            List.of(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"
            ),
            Task1Parentheses.generate(3)
        );
    }

    @Test
    void parenthesesHandleSinglePair() {
        assertEquals(
            List.of("()"),
            Task1Parentheses.generate(1)
        );
    }

    @Test
    void prefixDictionarySupportsAddRemoveAndCount() {
        DynamicWordTrie trie = new DynamicWordTrie();

        trie.add("apple");
        trie.add("app");
        trie.add("ape");
        trie.add("bat");

        assertEquals(3, trie.countPrefix("ap"));
        assertEquals(2, trie.countPrefix("app"));
        assertEquals(1, trie.countPrefix("b"));
        assertEquals(0, trie.countPrefix("cat"));

        trie.remove("app");

        assertEquals(2, trie.countPrefix("ap"));
        assertEquals(1, trie.countPrefix("app"));
    }

    @Test
    void twoUniqueNumbersAreFoundAndSorted() {
        assertArrayEquals(
            new int[]{3, 5},
            Task3TwoUnique.findUnique(
                new int[]{1, 2, 1, 3, 2, 5}
            )
        );
    }

    @Test
    void twoUniqueNumbersHandleZero() {
        assertArrayEquals(
            new int[]{0, 7},
            Task3TwoUnique.findUnique(
                new int[]{4, 0, 6, 4, 7, 6}
            )
        );
    }

    @Test
    void queensCountClassicBoard() {
        assertEquals(
            2,
            Task4BlockedQueens.countSolutions(
                4,
                new int[][]{}
            )
        );
    }

    @Test
    void queensRespectBlockedCells() {
        assertEquals(
            1,
            Task4BlockedQueens.countSolutions(
                4,
                new int[][]{{1, 2}}
            )
        );
    }

    @Test
    void queensCanHaveNoSolution() {
        assertEquals(
            0,
            Task4BlockedQueens.countSolutions(
                1,
                new int[][]{{1, 1}}
            )
        );
    }

    @Test
    void kthWordUsesLexicographicOrderAndPrefixRule() {
        DynamicWordTrie trie = new DynamicWordTrie();

        trie.add("app");
        trie.add("apple");
        trie.add("ape");
        trie.add("bat");

        assertEquals("ape", trie.kth("ap", 1));
        assertEquals("app", trie.kth("ap", 2));
        assertEquals("apple", trie.kth("ap", 3));
        assertNull(trie.kth("ap", 4));
    }

    @Test
    void kthWordUpdatesAfterRemoval() {
        DynamicWordTrie trie = new DynamicWordTrie();

        trie.add("app");
        trie.add("apple");
        trie.add("ape");
        trie.remove("app");

        assertEquals("ape", trie.kth("ap", 1));
        assertEquals("apple", trie.kth("ap", 2));
        assertNull(trie.kth("app", 2));
    }

    @Test
    void maxSubarrayXorFindsBestFragment() {
        assertEquals(
            31,
            Task6MaxSubarrayXor.maxSubarrayXor(
                new int[]{3, 10, 5, 25, 2, 8}
            )
        );
    }

    @Test
    void maxSubarrayXorCanUseInnerFragment() {
        assertEquals(
            15,
            Task6MaxSubarrayXor.maxSubarrayXor(
                new int[]{8, 1, 2, 12}
            )
        );
    }

    @Test
    void maxSubarrayXorHandlesZeros() {
        assertEquals(
            0,
            Task6MaxSubarrayXor.maxSubarrayXor(
                new int[]{0, 0, 0}
            )
        );
    }
}
