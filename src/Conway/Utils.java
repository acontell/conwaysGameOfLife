package Conway;

import java.util.function.BiConsumer;

class Utils {

    static void goOverMatrix(boolean[][] matrix, int start, int end, int start2, int end2, BiConsumer<Integer, Integer> f) {
        for (int i = start; i < end; i++) {
            for (int j = start2; j < end2; j++) {
                f.accept(i, j);
            }
        }
    }

    static void goOverMatrix(boolean[][] matrix, int start, int end, BiConsumer<Integer, Integer> f) {
        goOverMatrix(matrix, start, end, start, end, f);
    }

    static void goOverMatrix(boolean[][] matrix, BiConsumer<Integer, Integer> f) {
        goOverMatrix(matrix, 0, matrix.length, 0, matrix[0].length, f);
    }
}
