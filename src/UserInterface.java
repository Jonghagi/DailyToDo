import javax.swing.*;
import java.awt.*;

/**
 * Created by Kimjonghak on 2016. 5. 9..
 */
public class UserInterface {
    JFrame MainFrame;
    JPanel SelectMonthSection;

    void ShowInterFace(){

        MainFrame = new JFrame("DailyToDo");
        MainFrame.setSize(500, 500);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setVisible(true);

        SelectMonthSection = new JPanel();

    }
}


/*
    TODO:
      1. Component Return
      2. Set Size
 */

class DayofWeek {
    private JLabel[] NameofDay;
    private JPanel[] Container;
    private final int DayNumberOfAWeek = 7;
    DayofWeek(){
        NameofDay = new JLabel[7];
        Container = new JPanel[7];
        NameofDay[0] = new JLabel("SUN");
        NameofDay[1] = new JLabel("MON");
        NameofDay[2] = new JLabel("TUE");
        NameofDay[3] = new JLabel("WED");
        NameofDay[4] = new JLabel("TUR");
        NameofDay[5] = new JLabel("FRI");
        NameofDay[6] = new JLabel("SAT");

        for(int i = 0; i < DayNumberOfAWeek; i++){
            NameofDay[i].setForeground(Color.white);
            Container[i] = new JPanel();
            Container[i].add(NameofDay[i]);
            Container[i].setBackground(Color.gray);
        }

        Container[0].setBackground(Color.red);
        Container[6].setBackground(Color.blue);

    }
}
