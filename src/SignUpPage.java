import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpPage extends BackgroundPanel {

    public SignUpPage(AppFrame frame) {
        setLayout(new BorderLayout());

        int marginX = (int) (Toolkit.getDefaultToolkit().getScreenSize().width * 0.04);
        int marginY = (int) (Toolkit.getDefaultToolkit().getScreenSize().height * 0.05);
        setBorder(BorderFactory.createEmptyBorder(marginY, marginX, marginY, marginX));

        // Üst panel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);

        JLabel topLeftLabel = new JLabel("BILKENT HELPER | SIGN UP");
        topLeftLabel.setFont(new Font("Avenir Next", Font.PLAIN, 20));
        topLeftLabel.setForeground(Color.WHITE);
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setOpaque(false);
        leftPanel.add(topLeftLabel);
        topPanel.add(leftPanel, BorderLayout.WEST);

        ImageIcon backIcon = new ImageIcon("logos/go-back-logo.png");
        JButton backBtn = new JButton(backIcon);
        backBtn.setContentAreaFilled(false);
        backBtn.setBorderPainted(false);
        backBtn.setFocusPainted(false);
        backBtn.setOpaque(false);
        backBtn.setPreferredSize(new Dimension(40, 40));
        backBtn.addActionListener(e -> frame.showPage("entrance"));

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setOpaque(false);
        rightPanel.add(backBtn);
        topPanel.add(rightPanel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // Ortadaki kutu
        JPanel mainBox = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.BLACK);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 60, 60);
                g2.dispose();
            }
        };
        mainBox.setOpaque(false);
        mainBox.setPreferredSize(new Dimension(400, 600));
        mainBox.setLayout(new GridLayout(3, 1));

        // Başlık
        JPanel topSection = new JPanel(new GridBagLayout());
        topSection.setOpaque(false);
        JLabel entranceLabel = new JLabel("SIGN UP");
        entranceLabel.setFont(new Font("Avenir Next", Font.PLAIN, 22));
        entranceLabel.setForeground(Color.WHITE);
        topSection.add(entranceLabel);

        // Ortadaki textfieldlar
        JPanel middleSection = new JPanel(new GridBagLayout());
        middleSection.setOpaque(false);
        JPanel fieldPanel = new JPanel();
        fieldPanel.setOpaque(false);
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
        fieldPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Email TextField
        RoundedTextField emailField = new RoundedTextField(250, 55);
        emailField.setFont(new Font("Avenir Next", Font.PLAIN, 14));
        emailField.setForeground(Color.WHITE);
        emailField.setCaretColor(Color.WHITE);
        emailField.setText("Email:");

        // Password TextField (Şifre)
        RoundedPasswordField passwordField = new RoundedPasswordField(250, 55);
        passwordField.setFont(new Font("Avenir Next", Font.PLAIN, 14));
        passwordField.setForeground(Color.WHITE);
        passwordField.setCaretColor(Color.WHITE);
        passwordField.setEchoChar((char) 0); // Şifre kısmındaki gizli noktalar kaldırıldı
        passwordField.setText(""); // Şifre kısmındaki gizli noktayı kaldırdım

        // Password: yazısını text field içine yerleştir
        passwordField.setText("Password:");  // Text field içine yerleştirildi

        // Şifre alanına görsel buton ekle
        ImageIcon icon = new ImageIcon("logos/go-logo3.png");
        if (icon.getIconWidth() == -1 || icon.getIconHeight() == -1) {
            System.out.println("Resim yüklenemedi!");
        } else {
            System.out.println("Resim başarıyla yüklendi!");
        }

        JButton enterBtn = new JButton();


        enterBtn.setPreferredSize(new Dimension(55, 55)); // Boyut 60x60 olarak ayarlandı
        enterBtn.setContentAreaFilled(true);
        enterBtn.setBorderPainted(false);
        enterBtn.setFocusPainted(true);
        enterBtn.setOpaque(false);
        enterBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        enterBtn.setIcon(icon);
        enterBtn.addActionListener(e -> frame.showPage("main"));

        // Yuvarlak buton
        enterBtn.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(c.getBackground());
                g2.fillOval(0, 0, c.getWidth(), c.getHeight());
                g2.dispose();
            }
        });

        // Şifre alanına butonu ekle
        JPanel passwordFieldContainer = new JPanel(null);
        passwordFieldContainer.setOpaque(false);
        passwordFieldContainer.setPreferredSize(new Dimension(250, 55));

        // Butonun Bilkent logosu ile text field'lar arasına yerleştirilmesi
        passwordField.setBounds(0, 0, 250, 55); // Text field'ın boyutunu ayarla
        enterBtn.setBounds(195, 0, 55, 55); // Bilkent logosu ile text field'lar arasına yerleştirildi
        enterBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordFieldContainer.add(enterBtn);
        passwordFieldContainer.add(passwordField);
        // Buton burada ekleniyor

        passwordField.addActionListener(e -> frame.showPage("main"));

        fieldPanel.add(emailField);
        fieldPanel.add(Box.createVerticalStrut(15));
        fieldPanel.add(passwordFieldContainer);
        middleSection.add(fieldPanel);

        // Alt bölüm
        JPanel bottomSection = new JPanel(new GridBagLayout());
        bottomSection.setOpaque(false);
        JPanel bottomInner = new JPanel();
        bottomInner.setLayout(new BoxLayout(bottomInner, BoxLayout.Y_AXIS));
        bottomInner.setOpaque(false);
        bottomInner.setAlignmentX(Component.CENTER_ALIGNMENT);

        ImageIcon logoIcon = new ImageIcon("logos/bilkent-logo.png");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setPreferredSize(new Dimension(100, 100));
        logoLabel.setMaximumSize(new Dimension(100, 100));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel infoLabel = new JLabel("You can sign up only with Bilkent Mail");
        infoLabel.setFont(new Font("Avenir Next", Font.PLAIN, 14));
        infoLabel.setForeground(Color.LIGHT_GRAY);
        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        bottomInner.add(logoLabel);
        bottomInner.add(Box.createVerticalStrut(10));
        bottomInner.add(infoLabel);
        bottomSection.add(bottomInner);

        mainBox.add(topSection);
        mainBox.add(middleSection);
        mainBox.add(bottomSection);

        JPanel centerHolder = new JPanel(new GridBagLayout());
        centerHolder.setOpaque(false);
        centerHolder.add(mainBox);
        add(centerHolder, BorderLayout.CENTER);
    }

    // Yuvarlak köşeli TextField
    class RoundedTextField extends JTextField {
        public RoundedTextField(int width, int height) {
            setPreferredSize(new Dimension(width, height));
            setOpaque(false);
            setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.BLACK);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
            super.paintComponent(g);
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(2));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, getHeight(), getHeight());
            g2.dispose();
        }
    }

    // Yuvarlak köşeli PasswordField (Şifre alanı)
    class RoundedPasswordField extends JPasswordField {
        public RoundedPasswordField(int width, int height) {
            setPreferredSize(new Dimension(width, height));
            setOpaque(false);
            setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.BLACK);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
            super.paintComponent(g);
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(2));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, getHeight(), getHeight());
            g2.dispose();
        }
    }
}

