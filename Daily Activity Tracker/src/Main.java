import javax.swing.*;
public class Main {

    public static void main(String[] args){
        Work work = new Work("working",240, "coding");
        Sleep sleep= new Sleep("Sleeping", 439, true);

        work.setDisplayDetails();
        sleep.setDisplayDetails();
    }
}