package how2j_0907;
/*
练习-完成一个完整的记事本界面
 */


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestGUI48 {
    public static void main(String[] args) {

        JFrame f = new JFrame("记事本");
        f.setSize(400, 400);
        f.setLocation(200, 200);

        JMenuBar mb = new JMenuBar();

        JMenu document = new JMenu("文件(A)");
        JMenu editor = new JMenu("编辑(E)");
        JMenu layout = new JMenu("格式(O)");
        JMenu viewing = new JMenu("查看(V)");
        JMenu help = new JMenu("帮助(H)");

        // 文件项
        document.add(new JMenuItem("新建(N)                         Ctrl+N"));
        document.add(new JMenuItem("打开(O)                         Ctrl+O"));
        document.add(new JMenuItem("保存(S)                         Ctrl+S"));
        document.add(new JMenuItem("另存为(N)"));
        document.addSeparator();
        document.add(new JMenuItem("页面设置(U)"));
        document.add(new JMenuItem("打印(P)                         Ctrl+P"));
        document.addSeparator();
        document.add(new JMenuItem("退出(X)"));
        // 编辑项
        editor.add(new JMenuItem("撤销(U)                         Ctrl+Z"));
        editor.addSeparator();
        editor.add(new JMenuItem("剪切(T)                         Ctrl+X"));
        editor.add(new JMenuItem("复制(C)                         Ctrl+C"));
        editor.add(new JMenuItem("粘贴(P)                         Ctrl+V"));
        editor.add(new JMenuItem("删除(L)                             Del"));
        editor.addSeparator();
        editor.add(new JMenuItem("查找(F)                         Ctrl+F"));
        editor.add(new JMenuItem("查找下一个(N)                    F3"));
        editor.add(new JMenuItem("替换(R)                         Ctrl+H"));
        editor.add(new JMenuItem("转到(G)                         Ctrl+G"));
        editor.addSeparator();
        editor.add(new JMenuItem("全选(A)                         Ctrl+A"));
        editor.add(new JMenuItem("时间/日期(D)                       F5"));
        //格式
        layout.add(new JMenuItem("自动换行(W)            "));
        layout.add(new JMenuItem("字体(F)"));
        //查看
        viewing.add(new JMenuItem("状态栏(S)"));
        //帮助
        help.add(new JMenuItem("查看帮助(H)"));
        help.add(new JMenuItem("关于记事本(A)"));

        mb.add(document);
        mb.add(editor);
        mb.add(layout);
        mb.add(viewing);
        mb.add(help);
        JTextArea ta = new JTextArea();
        ta.setLineWrap(true);
        JScrollPane sp = new JScrollPane(ta);

        f.setContentPane(sp);
        f.setJMenuBar(mb);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}

