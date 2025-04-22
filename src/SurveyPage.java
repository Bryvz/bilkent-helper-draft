import javax.swing.*;
import java.awt.*;

public class SurveyPage extends BackgroundPanel {
    public SurveyPage(AppFrame frame) {
        setLayout(new BorderLayout());
        add(new JLabel("Page 1", JLabel.CENTER), BorderLayout.CENTER);
    }
}