package model.unmodifiableCollections;

public class Student {

    private final String name;
    private final StringBuilder studentNotes;

    public Student(String name, StringBuilder studentNotes) {
        this.name = name;
        this.studentNotes = studentNotes == null ? null : new StringBuilder(studentNotes);
    }

    public String getName() {
        return name;
    }

    public StringBuilder getStudentNotes() {
        return new StringBuilder(studentNotes);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentNotes=" + studentNotes +
                '}';
    }
}
