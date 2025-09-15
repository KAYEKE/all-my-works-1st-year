import javax.swing.JOptionPane;
public class Main {

    public static void main(String[] args) {
        double radius;
        double area;
        double Pi = 3.142;

        radius = Double.parseDouble(JOptionPane.showInputDialog("Enter radius"));
        area = Math.PI * radius * radius;
        JOptionPane.showMessageDialog(null, area);

    }

}