package grades;

import java.util.Objects;

/**
 * The class that represents a course that the student is taken
 */
public class Course {
    // Name of the course
    private String name;
    // The number of units for this course
    private double unit;
    // The grade percentage
    private double grade;

    public Course(String name, double unit, double grade) throws Exception {
        this.name = Utils.checkNull(name);
        this.unit = unit;
        this.grade = grade;
    }

    /** Get the name of the course */
    public String getName() {
        return name;
    }

    /** Get the letter value of the grade */
    public char getGrade() {
        if (grade >= 90) {
            return 'A';
        } else if (grade >= 80) {
            return 'B';
        } else if (grade >= 70) {
            return 'C';
        } else if (grade >= 60) {
            return 'D';
        }
        return 'F';
    }

    /** Get the unit for this class */
    public double getUnit() {
        return unit;
    }

    /** Get the grade percent */
    public int getGradeNumber() {
        switch (getGrade()) {
            case 'A':
                return 4;
            case 'B':
                return 3;
            case 'C':
                return 2;
            case 'D':
                return 1;
            default:
                return 0;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Course course = (Course) other;
        return Double.compare(course.unit, unit) == 0 && grade == course.grade && Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unit, grade);
    }

    @Override
    public String toString() {
        return String.format("%s \tUnit: %s \tGrade: %s \tLetter Grade: %s", name, unit, grade, getGrade());
    }
}
