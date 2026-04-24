import javafx.beans.property.*;

public class Student {
    private IntegerProperty roll;
    private StringProperty name, branch;
    private DoubleProperty marks;

    public Student(int r, String n, String b, double m) {
        roll = new SimpleIntegerProperty(r);
        name = new SimpleStringProperty(n);
        branch = new SimpleStringProperty(b);
        marks = new SimpleDoubleProperty(m);
    }

    public IntegerProperty rollProperty() { return roll; }
    public StringProperty nameProperty() { return name; }
    public StringProperty branchProperty() { return branch; }
    public DoubleProperty marksProperty() { return marks; }
}
