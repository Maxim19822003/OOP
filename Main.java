
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