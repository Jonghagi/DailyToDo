import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Kimjonghak on 2016. 5. 20..
 */
public class Record {
    private FileOutputStream output;
    private FileInputStream input;
    private final String filePath = "./ToDoList/";
    public void WriteMemo(String Date, String MemoContents) throws IOException {
        output = new FileOutputStream(filePath + Date + ".txt", true);
        output.write(MemoContents.getBytes());
        output.close();
    }

    public String ReadMemo(String Date) throws IOException {
        try {
            input = new FileInputStream(filePath + Date + ".txt");
            byte[] buffer = new byte[1024];
            input.read(buffer);
            return new String(buffer);
        } catch (IOException e){
            File f1 = new File(filePath + Date + ".txt");
            f1.createNewFile();
            return "";
        }

    }
}
