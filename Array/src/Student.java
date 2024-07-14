public class Student {
    private String name;
    private int score;

    public Student(String studentName, int studentScore) {
        name = studentName;
        score = studentScore;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {
        Array<Student> students = new Array<>(20);
        students.addLast(new Student("Alice", 98));
        students.addLast(new Student("Bob", 74));
        students.addLast(new Student("Charlie", 85));
        System.out.println(students);
    }
}
