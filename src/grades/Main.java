package grades;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static Main main;
    private Student student;
    private Stage stage;

    /** Get this instance */
    public static Main get() {
        return main;
    }

    public String getTitle() {
        if (student != null) return student.getName() + " - Student Grades";
        return "Student Grades";
    }

    /** Get the student */
    public Student getStudent() {
        if (student == null) {
            throw new RuntimeException("Student is null...");
        }
        return student;
    }

    /** Attach a student and load section to add classes */
    public void attachStudent(Student student) throws Exception {
        this.student = student;
        Parent seen = FXMLLoader.load(Main.class.getResource("controllers/student.fxml"));
        stage.hide();
        stage.setScene(new Scene(seen, 375, 250));
        stage.setTitle(getTitle());
        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {
        main = this;
        this.stage = stage;
        Parent root = FXMLLoader.load(Main.class.getResource("controllers/home.fxml"));
        root.setUserData(Main.get()); // Attach root to userdata
        stage.setTitle(getTitle());
        stage.setScene(new Scene(root, 200, 100));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
