package tree_family.human;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import tree_family.tree.TreeFamily;

public class Human {
    private int id;
    private TreeFamily family;
    private String lastname;
    private String name;

    private LocalDate birthday;
    private LocalDate deathday;
    private Gender gender;
    private Map<String, Human> parents;
    private List<Human> children;
    private Human spouse;
    

public Human(TreeFamily family, String lastname, String name, Gender gender) {
        this.lastname = lastname;
        this.name = name;
        this.gender = gender;
        Map<String, Human> parents = new HashMap<>();
        this.parents = parents;
        List<Human> children = new ArrayList<>();
        this.children = children;
        this.family = family;
        family.addMember(this);
    }

    public String getAge() {
        if (this.deathday == null) {
            return Integer.toString(Period.between(this.birthday, LocalDate.now()).getYears());
        }
        else {
            StringBuilder stringBuilder = new StringBuilder(this.lastname);
            stringBuilder.append(" ").append(this.name).append(" скончался(лась) в возрасте");
            stringBuilder.append(Period.between(this.birthday, this.deathday).getYears());
            stringBuilder.append(" лет");
            return stringBuilder.toString();
        }
    }

    public String getId() {
        StringBuilder stringBuilder = new StringBuilder("Id ");
        stringBuilder.append(this.name).append(" - ").append(this.id);
        return stringBuilder.toString();
    }

    public String getLastname() { return lastname; }

    public String getName() { return name; }

    public LocalDate getBirthday() { return birthday; }

    public LocalDate getDeathday() { return deathday; }

    public Gender getGender() { return gender; }

    public String getParents() {
        StringBuilder stringBuilder = new StringBuilder("Родители: ");
        stringBuilder.append(this.parents);
        return stringBuilder.toString();
    }

    public String getChildren() {
        StringBuilder stringBuilder = new StringBuilder("Дети: ");
        stringBuilder.append(this.children);
        return stringBuilder.toString();
    }

    public String getSpouse() {
        StringBuilder stringBuilder = new StringBuilder("Супруг(а): ");
        stringBuilder.append(this.spouse);
        return stringBuilder.toString();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setDeathday(LocalDate deathday) {
        this.deathday = deathday;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    private void setParent(Human human) {
        if (human.gender == Gender.Male) {
            this.parents.put("отец",human);
        }
        else this.parents.put("мать",human);
    }

    public void setChild(Human human) { 
        if(!children.contains(human)) {
            this.children.add(human);
            human.setParent(this);
        }
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
        spouse.spouse = this;
    }

    @Override
    public String toString() {
        return "Фамилия: " + lastname + ", имя: " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return family == human.family && lastname.equals(human.getLastname()) && name.equals(human.getName()) && gender.equals(human.gender);
    }

    @Override
    public int hashCode() {
        return 19 * family.hashCode() + 82 * lastname.hashCode() + 20 * name.hashCode() + 03 * gender.hashCode();
    }
}