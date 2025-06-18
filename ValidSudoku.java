// Time Complexity - O(1)
// Space complexity - O(1)
// solved on Leetcode - yes
// Did you face any issues- no
// The algorithm validates a Sudoku board by ensuring each digit from '1' to '9' appears only once in each row, column, and 3×3 sub-box. It uses three arrays of HashSet<Character> to track the digits seen so far in each of these three scopes. As it iterates through each cell, it skips '.' and checks whether the digit has already appeared in the corresponding row, column, or box — if yes, it returns false; otherwise, it adds the digit to the respective sets.
class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> columns = new ArrayList<>();
        List<Set<Character>> boxes = new ArrayList<>();

        // Initialize 9 sets for rows, columns, and boxes
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            columns.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val == '.') continue; // skip empty cells

                // Check row
                if (rows.get(i).contains(val)) return false;
                rows.get(i).add(val);

                // Check column
                if (columns.get(j).contains(val)) return false;
                columns.get(j).add(val);

                // Check 3x3 sub-box
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (boxes.get(boxIndex).contains(val)) return false;
                boxes.get(boxIndex).add(val);
            }
        }

        return true;
    }
}
