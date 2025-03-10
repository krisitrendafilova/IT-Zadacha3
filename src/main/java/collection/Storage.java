package collection;
import models.Student;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static Storage instance = null;
    private List<Student> students;

    public Storage() {
        students = new ArrayList<>();
    }

    public List<Student> getStudent() {
        return new ArrayList<>(students);
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public void addVote(Student st) {
        // Проверяваме дали студент със същия fNumber вече съществува.
        for (Student student : students) {
            if (student.getfNumber().equals(st.getfNumber())) {
                student.setVote(); // Увеличаваме гласа
                return; // Излизаме от метода
            }
        }
        // Ако не е намерен студент със същия fNumber, добавяме новия
        students.add(st);
    }

}
