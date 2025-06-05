package ExerciseClasses;

public class Person {

    private String firstName, lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if(age >= 0 && age <= 100){
            this.age = age;
            return;
        }

        this.age = 0;
    }

    public boolean isTeen(){
        return age > 12 && age < 20;
    }

    public String getFullName(){
        if(firstName.isEmpty() && lastName.isEmpty())
            return "";
        else if (firstName.isEmpty())
            return lastName;
        else if (lastName.isEmpty())
            return firstName;
        return firstName + " " + lastName;
    }
}
