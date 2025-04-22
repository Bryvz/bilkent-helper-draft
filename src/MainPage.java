import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPage extends BackgroundPanel {
    public MainPage(AppFrame frame) {
        setLayout(new GridLayout(3, 2, 10, 10));

        JButton page1 = new JButton("Page 1");
        JButton page2 = new JButton("Page 2");
        JButton page3 = new JButton("Page 3");
        JButton page4 = new JButton("Page 4");
        JButton page5 = new JButton("Page 5");

        page1.addActionListener(e -> frame.showPage("page1"));
        page2.addActionListener(e -> frame.showPage("page2"));
        page3.addActionListener(e -> frame.showPage("page3"));
        page4.addActionListener(e -> frame.showPage("page4"));
        page5.addActionListener(e -> frame.showPage("page5"));

        add(page1);
        add(page2);
        add(page3);
        add(page4);
        add(page5);
    }
}