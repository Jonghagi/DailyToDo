import javax.swing.*;

/**
 * Created by Kimjonghak on 2016. 5. 9..
 */
public class UserInterface {
    JFrame MainFrame;

    void ShowFrame(){
        MainFrame = new JFrame();
        MainFrame.setSize(100, 100);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setVisible(true);
    }
}
