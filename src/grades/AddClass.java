package grades;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * This class is the GUI part that add a class to the students list.
 */
public class AddClass {
    // Label and field for course name
    public Label labelName;
    public TextField name;
    // Label and field for units
    public Label labelUnits;
    public TextField units;
    // Label and field for grade
    public Label labelGrade;
    public TextField grade;
    // Button to add class
    public Button add;

    /** Add the class to the students list */
    public void addClass(ActionEvent actionEvent) {
        try {
            // Validation
            String name = this.name.getText();
            double units = Double.valueOf(this.units.getText());

            // Cut off % and extra space
            while (this.grade.getText().startsWith("%")) {
                this.grade.setText(this.grade.getText().substring(1));
            }

            while (this.grade.getText().endsWith("%")) {
                this.grade.setText(this.grade.getText().substring(0, this.grade.getText().length() - 1));
            }

            double grade = Double.valueOf(this.grade.getText());
            Course course = new Course(name, units, grade);
            Main.get().getStudent().addCourse(course);

            // Show confirmation
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("The following course was added");
            alert.setTitle("Course Added");
            alert.setContentText(course.toString());
            alert.show();

            // Allow the box to be used again
            this.name.clear();
            this.units.clear();
            this.grade.clear();
        } catch (NumberFormatException error) { // Number error
            Utils.alert(error, "Check your input, there was an error.");
        } catch (Exception error) { // General Errors
            Utils.alert(error);
        }
    }
}
