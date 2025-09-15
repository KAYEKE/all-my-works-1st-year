import javax.swing.*;
public class Sleep extends Activity implements iActivity{
    private boolean deepSleep;

    public Sleep(String name, int duration, String deepSleep){
        super(name,duration);
        this.deepSleep= Boolean.parseBoolean(deepSleep);
    }

    public Sleep(String sleeping, int duration, boolean b) {
    }

    @Override
    public void setDisplayDetails(){
        JOptionPane.showInputDialog(getBasicDetails()+deepSleep);

    }

}
