import javax.swing.*;
import java.awt.*;

public class MapPage extends BackgroundPanel {
    public MapPage(AppFrame frame) {
        setLayout(new BorderLayout());
        add(new JLabel("Page 1", JLabel.CENTER), BorderLayout.CENTER);
    }
}