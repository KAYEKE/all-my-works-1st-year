import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {
        int originalNumber = Integer.parseInt(JOptionPane.showInputDialog("enter a number"));
        int calculatedAnswer = originalNumber * 2;
        JOptionPane.showMessageDialog(null, "the answer is " + calculatedAnswer);
    }
}
