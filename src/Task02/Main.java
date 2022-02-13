package Task02;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Human {
    int age;
    String firstName;
    String lastName;
    LocalDate birthDate;
    int weight;
    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weight +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Human human0 = new Human(10, "Someone", "Young", LocalDate.of(2011, 11, 26), 40);
        Human human1 = new Human(21, "Oleg", "Stetsuk", LocalDate.of(2001, 11, 26), 70);
        Human human2 = new Human(100, "Michael", "Jackson", LocalDate.of(1922, 2, 12), 60);
        Human human3 = new Human(60, "Barack", "Obama", LocalDate.of(1961, 8, 4), 85);
        List<Human> list = new ArrayList<>();
        list.add(human0);
        list.add(human1);
        list.add(human2);
        list.add(human3);

        Stream<Human> stream = list.stream();
        var printStream = stream.sorted(Comparator.comparing(Human::getFirstName).reversed());
        printStream.forEach(System.out::println);

        stream = list.stream();
        printStream = stream.sorted(Comparator.comparing(Human::getFirstName).reversed())
                .filter(human -> human.age > 20);
        printStream.forEach(System.out::println);

        stream = list.stream();
        printStream = stream.sorted(Comparator.comparing(Human::getFirstName).reversed())
                .filter(human -> human.age > 20)
                .limit(3);
        printStream.forEach(System.out::println);

        stream = list.stream();
        var reducedString = stream.sorted(Comparator.comparing(Human::getFirstName).reversed())
                .filter(human -> human.age > 20)
                .limit(3)
                .map(human -> human.getFirstName())
                .reduce((prev, next) -> (prev + " " + next));;

        System.out.println(reducedString.get());
    }
}
