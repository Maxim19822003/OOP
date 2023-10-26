/*
import tree_family.human.Gender;
import tree_family.human.Human;
import tree_family.tree.TreeFamily;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TreeFamily katsman = new TreeFamily("Katsman");

        Human vasya = new Human(katsman,"Кацман", "Василий", Gender.Male);
        vasya.setBirthday(LocalDate.of(1901, 1, 12));
        vasya.setDeathday(LocalDate.of(1986, 9, 14));
        System.out.println(vasya);
        Human vasya1 = new Human(katsman,"Кацман", "Василий", Gender.Male); // 2 раза добавить того же самого не получится
        Human sara = new Human(katsman,"Кацман", "Сара", Gender.Female);
        sara.setBirthday(LocalDate.of(1912, 6, 26));
        sara.setDeathday(LocalDate.of(1962, 12, 18));

        sara.setSpouse(vasya); // Добавляем супруга Саре
        System.out.println(vasya.getSpouse()); // Васе Сара тоже добавилась супругой

        Human dushik = new Human(katsman,"Кацман", "Андрей", Gender.Male);
        dushik.setBirthday(LocalDate.of(1932, 11, 6));
        dushik.setDeathday(LocalDate.of(2008, 5, 11));
        System.out.println(dushik.getAge());

        vasya.setChild(dushik);// Андрей - сын Сары и Васи
        sara.setChild(dushik);
        System.out.println(sara.getChildren());
        System.out.println(dushik.getParents()); // Андрею добавились оба родителя

        Human nastya = new Human(katsman,"Петрова", "Анастасия", Gender.Female);
        nastya.setSpouse(dushik);

        Human mila = new Human(katsman,"Кацман", "Людмила", Gender.Female);
        mila.setBirthday(LocalDate.of(1986, 8, 9));
        nastya.setChild(mila);
        dushik.setChild(mila);
        mila.setLastname("Васильева"); // вышла замуж

        System.out.println(mila.getParents()); // Родители Людмилы

        System.out.println(mila.getId()); // должно быть 6
        System.out.println(dushik.getChildren()); // Людмила уже Васильева
        nastya.setChild(mila); // пытаюсь добавить ребенка второй раз
        System.out.println(nastya.getChildren()); // не выходит...

        System.out.println(katsman.allMembers());
    }
}
*/
import tree_family.human.Gender;
import tree_family.human.Human;
import tree_family.tree.TreeFamily;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TreeFamily rothschildFamily = new TreeFamily("Rothschild");

        Human john = new Human(rothschildFamily, "Rothschild", "John", Gender.Male);
        john.setBirthday(LocalDate.of(1901, 1, 12));
        john.setDeathday(LocalDate.of(1986, 9, 14));

        Human sarah = new Human(rothschildFamily, "Rothschild", "Sarah", Gender.Female);
        sarah.setBirthday(LocalDate.of(1912, 6, 26));
        sarah.setDeathday(LocalDate.of(1962, 12, 18));

        sarah.setSpouse(john);
        Human andrew = new Human(rothschildFamily, "Rothschild", "Andrew", Gender.Male);
        andrew.setBirthday(LocalDate.of(1932, 11, 6));
        andrew.setDeathday(LocalDate.of(2008, 5, 11));

        john.setChild(andrew);
        sarah.setChild(andrew);

        Human anastasia = new Human(rothschildFamily, "Petrova", "Anastasia", Gender.Female);
        anastasia.setSpouse(andrew);

        Human emily = new Human(rothschildFamily, "Rothschild", "Emily", Gender.Female);
        emily.setBirthday(LocalDate.of(1986, 8, 9));
        anastasia.setChild(emily);
        andrew.setChild(emily);
        emily.setLastname("Johnson");

        System.out.println(emily.getParents());
        System.out.println(emily.getId());
        System.out.println(andrew.getChildren());
        anastasia.setChild(emily);
        System.out.println(anastasia.getChildren());
        System.out.println(rothschildFamily.allMembers());
    }
}