import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kimjonghak on 2016. 5. 9..
 */
public class UserInterface {
    private final int totalWidth = 1400;
    private final int totalHeight = 650;
    private final int MonthWidth = 700;
    CalculateDate CalendarForShow = new CalculateDate();
    JFrame MainFrame;
    JLabel currentMonth;
    JLabel currentYear;
    drawCalendar drawCalendar;
    JButton SaveButton;
    JTextArea ToDoList;

    void ShowInterFace(){
        MainFrame = new JFrame("DailyToDo");

        currentMonth = new JLabel(String.format("%02d", CalendarForShow.getCurrentMonth()));
        currentMonth.setFont(new Font(null, 0, 60));
        currentMonth.setBounds(315, 50, 100, 100);
        currentYear = new JLabel(String.format("%04d", CalendarForShow.getCurrentYear()));
        currentYear.setFont(new Font(null, 0, 20));
        currentYear.setBounds(327, 0, 100, 100);
        MainFrame.add(currentMonth);
        MainFrame.add(currentYear);

        JButton beforeMonth = new JButton("<");
        JButton nextMonth = new JButton(">");
        beforeMonth.setBounds(250, 80, 50, 50);
        beforeMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalendarForShow.beforeMonth();
                currentMonth.setText(String.format("%02d", CalendarForShow.getCurrentMonth()));
                showCalendar(CalendarForShow.getCalendar());
            }
        });
        nextMonth.setBounds(410, 80, 50, 50);
        nextMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalendarForShow.nextMonth();
                currentMonth.setText(String.format("%02d", CalendarForShow.getCurrentMonth()));
                showCalendar(CalendarForShow.getCalendar());
            }
        });
        MainFrame.add(beforeMonth);
        MainFrame.add(nextMonth);

        JButton beforeYear = new JButton("<<");
        JButton nextYear = new JButton(">>");
        beforeYear.setBounds(282, 40, 25, 25);
        beforeYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalendarForShow.beforeYear();
                currentYear.setText(String.format("%04d", CalendarForShow.getCurrentYear()));
                showCalendar(CalendarForShow.getCalendar());
            }
        });
        nextYear.setBounds(395, 40, 25, 25);
        nextYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalendarForShow.nextYear();
                currentYear.setText(String.format("%04d", CalendarForShow.getCurrentYear()));
                showCalendar(CalendarForShow.getCalendar());
            }
        });
        MainFrame.add(nextYear);
        MainFrame.add(beforeYear);

        DayofWeek weekLine;
        weekLine = new DayofWeek();
        weekLine.setBounds(0, 150, MonthWidth/7, 40);

        MainFrame.setLayout(null);

        for(int i = 0; i < 7; i++){
            MainFrame.add(weekLine.getContainer(i));
        }

        drawCalendar = new drawCalendar();
        showCalendar(CalendarForShow.getCalendar());

        SaveButton = new JButton("Save");
        SaveButton.setBounds(totalWidth - 110, 50, 100, 50);
        MainFrame.add(SaveButton);

        ToDoList = new JTextArea();
        ToDoList.setBounds(MonthWidth + 20, 110, totalWidth - MonthWidth - 30, totalHeight - 150);
        MainFrame.add(ToDoList);


        MainFrame.setSize(totalWidth, totalHeight);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setVisible(true);
    }

    public void showCalendar(int[][] calendar){
        drawCalendar.setClickableCalendar(calendar);
        drawCalendar.setBounds(0, 190, MonthWidth/7, 70);

        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                MainFrame.add(drawCalendar.getClickableDate(i, j));
            }
        }

    }
}


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

    JPanel getContainer(int index){
        return Container[index];
    }

    void setBounds(int x, int y, int width, int height){
        for(int i = 0; i < DayNumberOfAWeek; i++){
            Container[i].setBounds(x + (i*width), y, width, height);
        }
    }
}

class drawCalendar{
    private JButton[][] ClickableCalendar;

    drawCalendar(){
        ClickableCalendar = new JButton[6][7];
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                ClickableCalendar[i][j] = new JButton();
            }
        }
    }

    public void setClickableCalendar(int[][] currentMonth){
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                if(currentMonth[i][j] != 0) {
                    ClickableCalendar[i][j].setText(String.valueOf(currentMonth[i][j]));
                } else {
                    ClickableCalendar[i][j].setText("");
                }
            }
        }
    }

    void setBounds(int x, int y, int width, int height){
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++) {
                ClickableCalendar[i][j].setBounds(x + (j * width), y + (i * height), width, height);
            }
        }
    }

    JButton getClickableDate(int indexX, int indexY){
        return ClickableCalendar[indexX][indexY];
    }
}