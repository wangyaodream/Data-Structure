public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 4, 3, 8, 7, 2, 1};
        for(int num: nums)
            bst.add(num);

        bst.preOrder();
    }
}