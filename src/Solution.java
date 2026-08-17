class Solution {
    private static class Node {
        int length;
        char leftChar;
        char rightChar;
        int prefix;
        int suffix;
        int best;

        Node(char c) {
            length = 1;
            leftChar = c;
            rightChar = c;
            prefix = 1;
            suffix = 1;
            best = 1;
        }

        Node(Node left, Node right) {
            length = left.length + right.length;
            leftChar = left.leftChar;
            rightChar = right.rightChar;

            prefix = left.prefix;
            if (left.prefix == left.length && left.rightChar == right.leftChar) {
                prefix = left.length + right.prefix;
            }

            suffix = right.suffix;
            if (right.suffix == right.length && left.rightChar == right.leftChar) {
                suffix = right.length + left.suffix;
            }

            best = Math.max(left.best, right.best);
            if (left.rightChar == right.leftChar) {
                best = Math.max(best, left.suffix + right.prefix);
            }
        }
    }

    private char[] values;
    private Node[] tree;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        values = s.toCharArray();
        tree = new Node[4 * values.length];
        build(1, 0, values.length - 1);

        int[] answer = new int[queryIndices.length];
        for (int i = 0; i < queryIndices.length; i++) {
            int index = queryIndices[i];
            values[index] = queryCharacters.charAt(i);
            update(1, 0, values.length - 1, index);
            answer[i] = tree[1].best;
        }
        return answer;
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(values[start]);
            return;
        }
        int middle = start + (end - start) / 2;
        build(node * 2, start, middle);
        build(node * 2 + 1, middle + 1, end);
        tree[node] = new Node(tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(int node, int start, int end, int index) {
        if (start == end) {
            tree[node] = new Node(values[index]);
            return;
        }
        int middle = start + (end - start) / 2;
        if (index <= middle) {
            update(node * 2, start, middle, index);
        } else {
            update(node * 2 + 1, middle + 1, end, index);
        }
        tree[node] = new Node(tree[node * 2], tree[node * 2 + 1]);
    }
}
