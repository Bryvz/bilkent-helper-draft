import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel() {

        try {
            // İkinci arka plan PNG dosyasını yükler
            backgroundImage = ImageIO.read(new File("backgrounds/background-1.png"));
        } catch (IOException e) {
            System.out.println("Background2 resmi yüklenemedi.");
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            // Panelin genişliğini ve yüksekliğini alıyoruz
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // Resmi, panelin genişliğine ve yüksekliğine uyduracak şekilde çiziyoruz
            g.drawImage(backgroundImage, 0, 0, panelWidth, panelHeight, this);
        }
    }
}
