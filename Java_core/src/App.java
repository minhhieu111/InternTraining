import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {

    public static ArrayList<Person> getPerson() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("user1", 10, "Male"));
        persons.add(new Person("user2", 15, "FeMale"));
        persons.add(new Person("user3", 80, "Other"));
        persons.add(new Person("user4", 61, "Male"));
        persons.add(new Person("user5", 40, "FeMale"));
        persons.add(new Person("user6", 56, "Other"));
        persons.add(new Person("user7", 70, "FeMale"));
        persons.add(new Person("user8", 41, "Male"));
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

    public static ArrayList<Person> getOldest(ArrayList<Person> per) {
        int maxAge = per.stream().mapToInt(Person::getAge).max().orElse(-1);
        return per.stream()
                .filter(p -> p.getAge() == maxAge)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Person> getYoungest(ArrayList<Person> per) {
        int maxAge = per.stream().mapToInt(Person::getAge).min().orElse(-1);
        return per.stream()
                .filter(p -> p.getAge() == maxAge)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void countByGender(ArrayList<Person> persons) {
        long personFemale = persons.stream().filter(p -> p.getGender().equals("FeMale")).count();
        long personMale = persons.stream().filter(p -> p.getGender().equals("Male")).count();
        long personOther = persons.stream().filter(p -> p.getGender().equals("Other")).count();

        System.out.println("Number of female: " + personFemale);
        System.out.println("Number of male: " + personMale);
        System.out.println("Number of other: " + personOther);
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Person> allPerson = getPerson();

        // 1.1
        System.out.println("1.1");
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
        // 1.2
        System.out.println("1.2");
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        double personAvg = 0;
        do {
            System.out.println(
                    "Choose group to calculate:" + "\n" + "1.Children" + "\n" + "2.middleAge" + "\n" + "3.elder");

            int a = scanner.nextInt();
            scanner.nextLine();

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

        // 1.3
        System.out.println("1.3");
        ArrayList<Person> getOldest = getOldest(allPerson);
        ArrayList<Person> getYoungest = getYoungest(allPerson);

        System.out.println("Oldest person: ");
        getOldest.forEach(System.out::println);

        System.out.println("Youngest person: ");
        getYoungest.forEach(System.out::println);

        // 1.4
        System.out.println("1.4");
        countByGender(allPerson);
        // 1.5
        System.out.println("1.5");
        System.out.println("New user: ");
        System.out.println("Name: ");
        String name = scanner.nextLine();
        int age = -1;
        do {
            System.out.println("Age: ");
            age = scanner.nextInt();
            scanner.nextLine();
        } while (age < 0 || age > 120);

        System.out.println("Gender: ");
        String gender = scanner.nextLine();
        allPerson.add(new Person(name, age, gender));
        allPerson.forEach(System.out::println);

        // 1.6
        System.out.println("1.6");
        System.out.println("Sort by age: ");
        allPerson.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);
        // 1.7
        System.out.println("1.7");
        System.out.println("sound: ");
        allPerson.forEach(p -> {
            if (p.getGender().equals("Male")) {
                System.out.println(p);
                System.out.println("Hey boy!");
            } else if (p.getGender().equals("FeMale")) {
                System.out.println(p);
                System.out.println("Hey girl!");
            } else {
                System.out.println(p);
                System.out.println("Hey man!");
            }

        });
    };

}
