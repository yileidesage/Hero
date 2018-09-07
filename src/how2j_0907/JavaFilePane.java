package how2j_0907;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JavaFilePane extends JPanel {
    public JavaFilePane(File file) {
        this.setLayout(new BorderLayout());
        String fileContent = getFileContent(file);
        JTextArea ta = new JTextArea();
        ta.setText(fileContent);
        this.add(ta);
    }

    private String getFileContent(File f) {
        String fileContent = null;
        try (FileReader fr = new FileReader(f)) {
            char[] all = new char[(int) f.length()];
            fr.read(all);
            fileContent = new String(all);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return fileContent;
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();

        f.setSize(400, 300);

        f.setContentPane(new JavaFilePane(new File("E:/project/j2se/src/gui/JavaFilePane.java")));
        f.setVisible(true);

    }

}
