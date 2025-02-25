import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static ArrayList<Person> getPerson() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("user1", 10, "Male"));
        persons.add(new Person("user2", 15, "FeMale"));
        persons.add(new Person("user3", 20, "Other"));
        persons.add(new Person("user4", 30, "Male"));
        persons.add(new Person("user5", 40, "FeMale"));
        persons.add(new Person("user6", 60, "Other"));
        persons.add(new Person("user7", 70, "FeMale"));
        persons.add(new Person("user8", 80, "Male"));
        persons.add(new Person("user9", 90, "Other"));
        persons.add(new Person("user10", 90, "Male"));
        return persons;
    }

    public static double AgeAverange(ArrayList<Person> personAge) {
        return personAge.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Person> allPerson = getPerson();

        ArrayList<Person> children = new ArrayList<>();
        ArrayList<Person> middleAgeds = new ArrayList<>();
        ArrayList<Person> elders = new ArrayList<>();
        allPerson.forEach((per) -> {
            if (per.getAge() < 18) {
                children.add(per);
            } else if (per.getAge() > 18 && per.getAge() <= 60) {
                middleAgeds.add(per);
            } else {
                elders.add(per);
            }
        });
        System.out.println("List children:");
        children.forEach((child) -> System.out.println(child));
        System.out.println("List middleAgeds:");
        middleAgeds.forEach((middleAged) -> System.out.println(middleAged));
        System.out.println("List elders:");
        elders.forEach((elder) -> System.out.println(elder));
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        double personAvg = 0;
        do {
            System.out.println(
                    "Choose group to calculate:" + "\n" + "1.Children" + "\n" + "2.middleAge" + "\n" + "3.elder");

            int a = scanner.nextInt();

            switch (a) {
                case 1 -> {
                    personAvg = AgeAverange(children);
                    check = false;
                }
                case 2 -> {
                    personAvg = AgeAverange(middleAgeds);
                    check = false;
                }
                case 3 -> {
                    personAvg = AgeAverange(elders);
                    check = false;
                }
                default -> System.out.println("Nhap sai");
            }
        } while (check);
        System.out.println("Group age averange: " + personAvg);
    };

}
