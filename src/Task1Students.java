import homework.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1Students {

  /*
    Создайте список учеников с баллами.

    Попросите пользователя ввести минимальный проходной балл.

    Выведите список учеников согласно следующим условиям:

    каждый ученик выведен в отдельной строке
    баллы каждого ученика выше минимального проходного
    ученики отсортированы по убыванию среднего балла
    в списке не больше 10 учеников (извините, конкурс)

    Для обработки и вывода результата используйте потоки (Stream).
   */
  public static void main(String[] args) {
    List<Student> student = fillList();

    System.out.println(student);
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите минимальный проходной балл:");
    int minScore = scanner.nextInt();
    //считаем сколько студентов прошло отбор
    int studentCount = (int) student.stream()
        .filter(s -> s.getScore() > minScore)
        .sorted((o1, o2) -> Integer.compare(o2.getScore(), o1.getScore()))
        .limit(10)
            .count();
    //выводим сколько студентов прошло отбор
    System.out.println("Количество студентов прошедших отбор: "+studentCount);
    System.out.println("==========================================");
    //выводим студентов прошедших отбор
    student.stream()
        .filter(s -> s.getScore() > minScore)
        .sorted((o1, o2) -> Integer.compare(o2.getScore(), o1.getScore()))
        .limit(10)
        .forEach(System.out::println);
  }

  private static List<Student> fillList() {
    List<Student> result = new ArrayList<>();
    result.add(new Student("Бовша Альберт Рустамович", 99));
    result.add(new Student("Богатикова Антонина Дмитриевна", 101));
    result.add(new Student("Горохов Степан Леонидович", 75));
    result.add(new Student("Гусев Александр Семенович", 43));
    result.add(new Student("Дзугаев Ахсарбек Станиславович", 130));
    result.add(new Student("Загибалов Павел Дмитриевич", 76));
    result.add(new Student("Землянов Константин Александрович", 67));
    result.add(new Student("Игумеников Степан Владимирович", 99));
    result.add(new Student("Каламбетов Даниил Эдуардович", 88));
    result.add(new Student("Карданова Аида Аскеровна", 80));
    result.add(new Student("Кашина Оксана Алексеевна", 95));
    result.add(new Student("Киреев Кирилл Александрович", 100));
    result.add(new Student("Коротких Анна Алексеевна", 0));
    result.add(new Student("Кудряшов Дмитрий Романович", 200));
    result.add(new Student("Мамлеева Аделина Ринатовна", 90));
    result.add(new Student("Паршин Егор Ильич", 15));
    return result;
  }
}
