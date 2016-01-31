package grades;

import javafx.scene.control.Alert;

public class Utils {
    /** Util class no instance needed */
    private Utils() {}

    /** Check if the value is null */
    public static <T> T checkNull(T var) throws NullPointerException {
        return checkNull(var, "null");
    }

    /** Check if the value is null */
    public static <T> T checkNull(T var, String message) throws NullPointerException {
        if (var == null) {
            throw new NullPointerException(message);
        }
        return var;
    }

    /** Create a new error box based on exception */
    public static void alert(Exception error, String message) {
        error.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(message);
        alert.setTitle(error.getClass().getName());
        //alert.setContentText(message);
        alert.show();
    }

    /** Create a new error box based on exception */
    public static void alert(Exception error) {
        alert(error, error.getMessage());
    }
}
