import javax.swing.*;
import java.awt.*;

public class StorePage extends BackgroundPanel {
    public StorePage(AppFrame frame) {
        setLayout(new BorderLayout());
        add(new JLabel("Page 1", JLabel.CENTER), BorderLayout.CENTER);
    }
}