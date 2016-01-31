package grades;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * The point where the user enters a name.
 */
public class Home {
    public TextField name;
    public Button enter;

    @Override
    public String toString() {
        return name.getText();
    }

    public void loadScreen() {
        try {
            // If nothing entered use unknown
            if (name.getText().equals("") || name.getText().equals("Enter your name:")) {
                name.setText("unknown");
            }
            Main.get().attachStudent(new Student(name.getText()));
        } catch (Exception error) {
            Utils.alert(error);
        }
    }

    /** Set up the system to create a student */
    public void onContinue(ActionEvent event) { // Action is not used
        loadScreen();
    }

    /** Allow support for ENTER */
    public void onEnter(Event event) {
        KeyEvent key = (KeyEvent) event;
        if (key.getCode() == KeyCode.ENTER) {
            loadScreen();
        }
    }
}
