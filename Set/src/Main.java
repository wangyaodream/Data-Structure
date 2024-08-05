import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("D:/Downloads/pride-and-prejudice.txt", words1);
        System.out.println("Total words:" + words1.size());

        BSTSet<String> set1 = new BSTSet<>();
        for (String word: words1) {
            set1.add(word);
        }

        System.out.println(set1.getSize());
    }
}