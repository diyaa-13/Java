package Experiment-10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.beans.property.*;

import java.sql.*;

public class JdbcFX extends Application {

    TextField rollField = new TextField();
    TextField nameField = new TextField();
    TextField branchField = new TextField();
    TextField marksField = new TextField();

    TableView<Student> table = new TableView<>();
    ObservableList<Student> data = FXCollections.observableArrayList();

    Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/college_db?useSSL=false&allowPublicKeyRetrieval=true",
            "root",
            "stargirl15"
        );
    }

    @Override
    public void start(Stage stage) {

        // Form
        GridPane form = new GridPane();
        form.setPadding(new Insets(10));
        form.setHgap(10);
        form.setVgap(10);

        form.add(new Label("Roll"), 0, 0);
        form.add(rollField, 1, 0);

        form.add(new Label("Name"), 0, 1);
        form.add(nameField, 1, 1);

        form.add(new Label("Branch"), 0, 2);
        form.add(branchField, 1, 2);

        form.add(new Label("Marks"), 0, 3);
        form.add(marksField, 1, 3);

        // Table
        TableColumn<Student, Integer> col1 = new TableColumn<>("Roll");
        col1.setCellValueFactory(c -> c.getValue().rollProperty().asObject());

        TableColumn<Student, String> col2 = new TableColumn<>("Name");
        col2.setCellValueFactory(c -> c.getValue().nameProperty());

        TableColumn<Student, String> col3 = new TableColumn<>("Branch");
        col3.setCellValueFactory(c -> c.getValue().branchProperty());

        TableColumn<Student, Double> col4 = new TableColumn<>("Marks");
        col4.setCellValueFactory(c -> c.getValue().marksProperty().asObject());

        table.getColumns().addAll(col1, col2, col3, col4);
        table.setItems(data);

        // Buttons
        Button insertBtn = new Button("Insert");
        Button viewBtn = new Button("View");
        Button updateBtn = new Button("Update");
        Button deleteBtn = new Button("Delete");

        HBox buttons = new HBox(10, insertBtn, viewBtn, updateBtn, deleteBtn);

        // Actions
        insertBtn.setOnAction(e -> insert());
        viewBtn.setOnAction(e -> load());
        updateBtn.setOnAction(e -> update());
        deleteBtn.setOnAction(e -> delete());

        VBox root = new VBox(10, form, buttons, table);
        root.setPadding(new Insets(10));

        stage.setScene(new Scene(root, 600, 500));
        stage.setTitle("JDBC JavaFX App");
        stage.show();
    }

    void insert() {
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students VALUES (?, ?, ?, ?)"
            );
            ps.setInt(1, Integer.parseInt(rollField.getText()));
            ps.setString(2, nameField.getText());
            ps.setString(3, branchField.getText());
            ps.setDouble(4, Double.parseDouble(marksField.getText()));
            ps.executeUpdate();
            load();
        } catch (Exception e) { e.printStackTrace(); }
    }

    void load() {
        data.clear();
        try (Connection con = getConnection()) {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM students");
            while (rs.next()) {
                data.add(new Student(
                    rs.getInt("roll_no"),
                    rs.getString("name"),
                    rs.getString("branch"),
                    rs.getDouble("marks")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    void update() {
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE students SET name=?, branch=?, marks=? WHERE roll_no=?"
            );
            ps.setString(1, nameField.getText());
            ps.setString(2, branchField.getText());
            ps.setDouble(3, Double.parseDouble(marksField.getText()));
            ps.setInt(4, Integer.parseInt(rollField.getText()));
            ps.executeUpdate();
            load();
        } catch (Exception e) { e.printStackTrace(); }
    }

    void delete() {
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM students WHERE roll_no=?"
            );
            ps.setInt(1, Integer.parseInt(rollField.getText()));
            ps.executeUpdate();
            load();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Model class
    public static class Student {
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
}