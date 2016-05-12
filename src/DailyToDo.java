/**
 * Created by Kimjonghak on 2016. 5. 9..
 */
public class DailyToDo {
    public static void main(String args[]){
        UserInterface UI;
        UI = new UserInterface();
        UI.ShowInterFace();
        CalculateDate cd;
        cd = new CalculateDate();
        cd.Test();
        cd.beforeMonth();
        cd.Test();
    }
}
