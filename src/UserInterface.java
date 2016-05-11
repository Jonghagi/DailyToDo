import javax.swing.*;
import java.awt.*;

/**
 * Created by Kimjonghak on 2016. 5. 9..
 */
public class UserInterface {
    private final int totalWidth = 1400;
    private final int totalHeight = 630;
    private final int MonthWidth = 700;
    JFrame MainFrame;
    JPanel SelectMonthSection;

    void ShowInterFace(){
        MainFrame = new JFrame("DailyToDo");

        DayofWeek weekLine;
        weekLine = new DayofWeek();
        weekLine.setBounds(0, 100, MonthWidth/7, 40);

        MainFrame.setLayout(null);

        for(int i = 0; i < 7; i++){
            MainFrame.add(weekLine.returnContainer(i));
        }
        MainFrame.setSize(totalWidth, totalHeight);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setVisible(true);


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

    JPanel returnContainer(int index){
        return Container[index];
    }

    void setBounds(int x, int y, int width, int height){
        for(int i = 0; i < DayNumberOfAWeek; i++){
            Container[i].setBounds(x + (i*width), y, width, height);
        }
    }
}
