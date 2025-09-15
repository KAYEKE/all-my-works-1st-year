import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Declare variables
        String name, surname, emailAddress, studentNo;
        short mark1, mark2, assignment, exam;



        // Collect user details using JOptionPane
        name = JOptionPane.showInputDialog(null, "Please enter the name:");
        surname = JOptionPane.showInputDialog(null, "Please enter the surname:");
        emailAddress = JOptionPane.showInputDialog(null, "Please enter the email address:");
        studentNo = JOptionPane.showInputDialog(null, "Please enter the student number:");

        // Collect marks - Ensure conversion from String to Short
        mark1 = Short.parseShort(JOptionPane.showInputDialog(null, "Please enter mark1:"));
        mark2 = Short.parseShort(JOptionPane.showInputDialog(null, "Please enter mark2:"));
        assignment = Short.parseShort(JOptionPane.showInputDialog(null, "Please enter assignment mark:"));
        exam = Short.parseShort(JOptionPane.showInputDialog(null, "Please enter exam mark:"));

        // Calculate the DP (classwork) mark
        double dpMark = calculateDpMark(mark1, mark2, assignment);

        // Calculate the final mark
        double finalMark = calculateFinalMark(dpMark, exam);

        // Determine the grade
        String grade;
        if (finalMark >= 0 && finalMark <= 46) {
            grade = "Fail";
        } else if (finalMark >= 47 && finalMark <= 49) {
            grade = "Supplementary (Supp)";
        } else if (finalMark >= 50 && finalMark <= 69) {
            grade = "Pass";
        } else if (finalMark >= 70) {
            grade = "Excellent Pass";
        } else {
            grade = "Invalid Mark";
        }

        // Display the results
        JOptionPane.showMessageDialog(null,
                "Student Details:\n" +
                        "Name: " + name + "\n" +
                        "Surname: " + surname + "\n" +
                        "Email Address: " + emailAddress + "\n" +
                        "Student Number: " + studentNo + "\n\n" +
                        "Marks:\n" +
                        "Mark1: " + mark1 + "\n" +
                        "Mark2: " + mark2 + "\n" +
                        "Assignment: " + assignment + "\n" +
                        "Exam: " + exam + "\n\n" +
                        "DP Mark: " + dpMark + "\n" +
                        "Final Mark: " + finalMark + "\n" +
                        "Grade: " + grade);

        FullTime fullTime=new FullTime();
        fullTime.getName();
        fullTime.getSurname();
        fullTime.getEmailAddress();
        fullTime.getStudentNo();
        fullTime.getMark1();
        fullTime.getMark2();
        fullTime.getAssignment();
        fullTime.getExam();
        fullTime.setHoursPerweek(hoursPerweek);
    }

    /**
     * Method to calculate the DP (classwork) mark.
     * It takes the three inputs: mark1, mark2, and assignment,
     * and calculates their average.
     */
    public static double calculateDpMark(short mark1, short mark2, short assignment) {
        return (double) (mark1 + mark2 + assignment) / 3;
    }

    /**
     * Method to calculate the final mark.
     * It combines the DP mark (40%) and the exam mark (60%).
     */
    public static double calculateFinalMark(double dpMark, short exam) {
        return (dpMark * 0.4) + (exam * 0.6);
    }
}