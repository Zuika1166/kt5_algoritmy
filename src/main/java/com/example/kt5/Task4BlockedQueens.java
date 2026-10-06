package com.example.kt5;

public final class Task4BlockedQueens {
    private Task4BlockedQueens() {
    }

    public static long countSolutions(int n, int[][] blockedCells) {
        int[] blocked = new int[n];

        for (int[] cell : blockedCells) {
            blocked[cell[0] - 1] |= 1 << (cell[1] - 1);
        }

        int allColumns = (1 << n) - 1;

        return search(
            0,
            n,
            allColumns,
            blocked,
            0,
            0,
            0
        );
    }

    private static long search(
        int row,
        int n,
        int allColumns,
        int[] blocked,
        int columns,
        int diagonalLeft,
        int diagonalRight
    ) {
        if (row == n) {
            return 1;
        }

        int available = allColumns
            & ~(columns | diagonalLeft | diagonalRight | blocked[row]);

        long count = 0;

        while (available != 0) {
            int position = available & -available;
            available -= position;

            count += search(
                row + 1,
                n,
                allColumns,
                blocked,
                columns | position,
                ((diagonalLeft | position) << 1) & allColumns,
                (diagonalRight | position) >>> 1
            );
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int b = scanner.nextInt();
        int[][] blocked = new int[b][2];

        for (int i = 0; i < b; i++) {
            blocked[i][0] = scanner.nextInt();
            blocked[i][1] = scanner.nextInt();
        }

        System.out.println(countSolutions(n, blocked));
    }
}
