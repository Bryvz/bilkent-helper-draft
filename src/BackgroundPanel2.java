import javax.swing.*;
import java.awt.*;

public class BackgroundPanel2 extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel2() {
        try {
            // İkinci arka plan PNG dosyasını yükler
            backgroundImage = new ImageIcon("backgrounds/background2.png").getImage();
        } catch (Exception e) {
            System.out.println("Background2 resmi yüklenemedi.");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}