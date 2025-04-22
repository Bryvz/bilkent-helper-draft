import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TutoringPage extends BackgroundPanel {
    public TutoringPage(AppFrame frame) {
        setLayout(new BorderLayout());

        // Ekran boyutuna göre margin ayarla
        int marginX = (int) (Toolkit.getDefaultToolkit().getScreenSize().width * 0.04);
        int marginY = (int) (Toolkit.getDefaultToolkit().getScreenSize().height * 0.05);
        setBorder(BorderFactory.createEmptyBorder(marginY, marginX, marginY, marginX));

        // Sol üst köşe – Başlık
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);

// Sol: Başlık
        JLabel topLeftLabel = new JLabel("BILKENT HELPER | TUTORING");
        topLeftLabel.setFont(new Font("Avenir Next", Font.PLAIN, 20));
        topLeftLabel.setForeground(Color.WHITE);
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setOpaque(false);
        leftPanel.add(topLeftLabel);
        topPanel.add(leftPanel, BorderLayout.WEST);

// Sağ: Geri butonu
        ImageIcon backIcon = new ImageIcon("logos/go-back-logo.png");
        JButton backBtn = new JButton(backIcon);
        backBtn.setContentAreaFilled(false);
        backBtn.setBorderPainted(false);
        backBtn.setFocusPainted(false);
        backBtn.setOpaque(false);
        backBtn.setPreferredSize(new Dimension(40, 40));
        backBtn.addActionListener(e -> frame.showPage("main"));

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setOpaque(false);
        rightPanel.add(backBtn);
        topPanel.add(rightPanel, BorderLayout.EAST);

// Top panel'i ana sayfaya ekle
        add(topPanel, BorderLayout.NORTH);
    }

    class Tutor{
        private String name,email;
        private double gpa;
        private ArrayList<String> coursesGiven;

        Tutor(String name, double gpa, String email)
        {
            this.name=name;
            this.email=email;
            this.gpa=gpa;
            this.coursesGiven=new ArrayList<String>();
        }

        public void AddCourse(String course)
        {
            coursesGiven.add(course);
        }

        public String getName()
        {
            return this.name;
        }
        public String getEmail()
        {
            return this.email;
        }
        public double getGpa()
        {
            return this.gpa;
        }
        public ArrayList<String> getCoursesGiven()
        {
            return this.coursesGiven;
        }
    }
}