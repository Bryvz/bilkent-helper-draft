import javax.swing.*;
import java.awt.*;

public class ProfilePage extends BackgroundPanel {
    public ProfilePage(AppFrame frame) {
        setLayout(new BorderLayout());
        add(new JLabel("Page 1", JLabel.CENTER), BorderLayout.CENTER);
    }
}