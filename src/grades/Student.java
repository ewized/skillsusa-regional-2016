package grades;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Set;

public class Student {
    private String name;
    private Set<Course> courses = new HashSet<>();
    //
    public static Student student;
    public Label header;
    public TextArea list;
    public Button add;

    public Student() {
        student = this;
    }

    public Student(String name) throws Exception {
        this.name = Utils.checkNull(name);
        if (name.length() == 0) {
            throw new Exception("Name must not be blank.");
        }
    }

    /** Get the number of classes */
    public int getClasses() {
        return courses.size();
    }

    /** Get the total number of units */
    public double getUnits() {
        return courses.stream().mapToDouble(Course::getUnit).sum();
    }

    /** Get the total number of grade points */
    public double getGrades() {
        return courses.stream().mapToDouble(Course::getGradeNumber).sum();
    }

    /** Caculate and get the GPA of this students classes */
    public double getGPA() {
        return getGrades() / getClasses();
    }

    /** Get the name of this student */
    public String getName() {
        return name;
    }

    /** Generate the header to display the grades */
    public String generateHeader() {
        return "Classes: " + getClasses() + "    -    Units: " + getUnits() + "    -    GPA: " + getGPA();
    }

    /** Generate GUI list of text */
    public String generateText() {
        String tmp = "";

        for (Course course : courses) {
            tmp += course.toString() + "\n";
        }

        return tmp;
    }

    /** Add a course and update the display */
    public void addCourse(Course course) {
        courses.add(Utils.checkNull(course, "Course is null..."));
        System.out.println(course);
        student.list.setText(generateText());
        student.header.setText(generateHeader());
    }

    /** WHen the button is clicked */
    public void addCourse(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("controllers/add_class.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 200, 250));
        stage.setResizable(false);
        stage.setTitle("Add Course");
        stage.show();
    }
}
