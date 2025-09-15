import javax.swing.*;

public class Work extends Activity implements iActivity {
    private String Typetask;

    public Work(String name, int duration, String Typetask) {
        super(name, duration);
        this.Typetask = Typetask;
    }

    @Override
    public void setDisplayDetails() {
        JOptionPane.showInputDialog(getBasicDetails() + Typetask);
    }
}