import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.*;
import java.util.ArrayList;

public class TutoringPage extends BackgroundPanel {

    private ArrayList<Tutor> tutors;
    public TutoringPage(AppFrame frame) {
        this.tutors=new ArrayList<>();
        setLayout(new BorderLayout());

        // Ekran boyutuna göre margin ayarla
        int marginX = (int) (Toolkit.getDefaultToolkit().getScreenSize().width * 0.04);
        int marginY = (int) (Toolkit.getDefaultToolkit().getScreenSize().height * 0.05);
        setBorder(BorderFactory.createEmptyBorder(marginY, marginX, marginY, marginX));

        // Sol üst köşe – Başlık
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setOpaque(false);

// Sol: Başlık
        JLabel topLeftLabel = new JLabel("BILKENT HELPER | TUTORING                      ");
        topLeftLabel.setFont(new Font("Avenir Next", Font.PLAIN, 20));
        topLeftLabel.setForeground(Color.WHITE);
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setOpaque(false);
        leftPanel.add(topLeftLabel);
        topPanel.add(leftPanel);
        //Favorites,Arrange, Lectures Buttons

        JButton filterByButton = new JButton("Filter By");
        filterByButton.setOpaque(false);
        filterByButton.setFocusPainted(false);
        filterByButton.setFocusable(false);
        filterByButton.setContentAreaFilled(false);
        filterByButton.setBorderPainted(false);
        filterByButton.setForeground(Color.WHITE);

        JButton arrangeButton = new JButton("Arrange");
        arrangeButton.setOpaque(false);
        arrangeButton.setFocusPainted(false);
        arrangeButton.setFocusable(false);
        arrangeButton.setContentAreaFilled(false);
        arrangeButton.setBorderPainted(false);
        arrangeButton.setForeground(Color.WHITE);

        JButton lecturesButton = new JButton("Lectures");
        lecturesButton.setOpaque(false);
        lecturesButton.setFocusPainted(false);
        lecturesButton.setFocusable(false);
        lecturesButton.setContentAreaFilled(false);
        lecturesButton.setBorderPainted(false);
        lecturesButton.setForeground(Color.WHITE);

        topPanel.add(filterByButton);
        topPanel.add(arrangeButton);
        topPanel.add(lecturesButton);
        // Arama çubuğu ve butonu
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setOpaque(false);

        JTextField searchField = new JTextField(20);
        searchField.setText("Search...");
        searchField.setFont(new Font("Avenir Next", Font.PLAIN, 14));
        searchField.setOpaque(false);

        ImageIcon searchIcon = new ImageIcon("logos/search-icon.png");
        Image scaledImage = searchIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon scaledSearchIcon = new ImageIcon(scaledImage);
        JButton searchButton = new JButton(scaledSearchIcon);
        searchButton.setPreferredSize(new Dimension(40, 40));
        searchButton.setContentAreaFilled(false);
        searchButton.setBorderPainted(false);
        searchButton.setFocusPainted(false);
        searchButton.setOpaque(false);

        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        topPanel.add(searchPanel);
// Sağ: Menu butonu
        ImageIcon backIcon = new ImageIcon("logos/menu-logo.png");
        JButton backBtn = new JButton(backIcon);
        backBtn.setContentAreaFilled(false);
        backBtn.setBorderPainted(false);
        backBtn.setFocusPainted(false);
        backBtn.setOpaque(false);
        backBtn.setPreferredSize(new Dimension(40, 40));
        backBtn.addActionListener(e -> frame.showPage("main")); //TODO:PROFIL

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setOpaque(false);
        rightPanel.add(backBtn);
        topPanel.add(rightPanel, BorderLayout.EAST);

    

// Top panel'i ana sayfaya ekle
        add(topPanel, BorderLayout.NORTH);

//TUTORS AND FILTER PANELS
        JPanel middlePanel = new JPanel(new GridLayout(1,2));
        middlePanel.setOpaque(false);

        JPanel tutorsPanel = new JPanel();
        tutorsPanel.setOpaque(false);

        JPanel filterMoverPanel = new JPanel();
        filterMoverPanel.setOpaque(false);

        JPanel filterPanel = new JPanel(new GridLayout(3, 1));
        filterPanel.setOpaque(false);

        JPanel byPanel = new JPanel(new GridLayout(3,2));
        byPanel.setOpaque(false);

        JLabel title = new JLabel();
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Avenir Next", Font.PLAIN, 20));
        title.setText("Search");
        JLabel empty1 = new JLabel("");
        JLabel empty2 = new JLabel("");
        JLabel empty3 = new JLabel("");
        JLabel empty4 = new JLabel("");
        JLabel empty5 = new JLabel("");

        JLabel subTitle = new JLabel();
        subTitle.setForeground(Color.WHITE);
        subTitle.setFont(new Font("Avenir Next", Font.PLAIN, 14));
        subTitle.setText("By Lecture or Code");

        JMenu lecturesMenu = new JMenu("Lectures");
        lecturesMenu.setForeground(Color.WHITE);
        JMenu codeMenu = new JMenu("Code");
        codeMenu.setForeground(Color.WHITE);

        byPanel.add(title);
        byPanel.add(empty1);
        byPanel.add(subTitle);
        byPanel.add(empty2);
        byPanel.add(lecturesMenu);
        byPanel.add(codeMenu);

        JPanel filterbyPanel = new JPanel(new GridLayout(4,2));
        filterbyPanel.setOpaque(false);

        JLabel title2 = new JLabel();
        title2.setForeground(Color.WHITE);
        title2.setFont(new Font("Avenir Next", Font.PLAIN, 20));
        title2.setText("Filters");

        JLabel subtitle2 = new JLabel();
        subtitle2.setForeground(Color.WHITE);
        subtitle2.setFont(new Font("Avenir Next", Font.PLAIN, 14));
        subtitle2.setText("Minimum Semester Count");

        JLabel subtitle3 = new JLabel();
        subtitle3.setForeground(Color.WHITE);
        subtitle3.setFont(new Font("Avenir Next", Font.PLAIN, 14));
        subtitle3.setText("Minimum GPA");

        JLabel subtitle4 = new JLabel();
        subtitle4.setForeground(Color.WHITE);
        subtitle4.setFont(new Font("Avenir Next", Font.PLAIN, 14));
        subtitle4.setText("Minimum Price");

        JButton semesterButton = new JButton();
        JButton gpaButton = new JButton();
        JButton priceButton = new JButton();

        filterbyPanel.add(title2);
        filterbyPanel.add(empty3);
        filterbyPanel.add(subtitle2);
        filterbyPanel.add(semesterButton);
        filterbyPanel.add(subtitle3);
        filterbyPanel.add(gpaButton);
        filterbyPanel.add(subtitle4);
        filterbyPanel.add(priceButton);


        JPanel arrangePanel = new JPanel(new GridLayout(4,3));
        arrangePanel.setOpaque(false);

        JLabel title3 = new JLabel();
        title3.setForeground(Color.WHITE);
        title3.setFont(new Font("Avenir Next", Font.PLAIN, 20));
        title3.setText("Arrangement");

        JLabel sub1 = new JLabel();
        sub1.setForeground(Color.WHITE);
        sub1.setFont(new Font("Avenir Next", Font.PLAIN, 14));
        sub1.setText("Price");

        JLabel sub2 = new JLabel();
        sub2.setForeground(Color.WHITE);
        sub2.setFont(new Font("Avenir Next", Font.PLAIN, 14));
        sub2.setText("Stars");

        JLabel sub3 = new JLabel();
        sub3.setForeground(Color.WHITE);
        sub3.setFont(new Font("Avenir Next", Font.PLAIN, 14));
        sub3.setText("GPA");

        JButton priceInc = new JButton("Increasing");
        JButton priceDec = new JButton("Decreasing");
        JButton starsInc = new JButton("Increasing");
        JButton starsDec = new JButton("Decreasing");
        JButton gpaInc = new JButton("Increasing");
        JButton gpaDec = new JButton("Decreasing");

        arrangePanel.add(title3);
        arrangePanel.add(empty4);
        arrangePanel.add(empty5);
        arrangePanel.add(sub1);
        arrangePanel.add(priceInc);
        arrangePanel.add(priceDec);
        arrangePanel.add(sub2);
        arrangePanel.add(starsInc);
        arrangePanel.add(starsDec);
        arrangePanel.add(sub3);
        arrangePanel.add(gpaInc);
        arrangePanel.add(gpaDec);

        filterPanel.add(byPanel);
        filterPanel.add(filterbyPanel);
        filterPanel.add(arrangePanel);
        
        tutorsPanel.setLayout(new BoxLayout(tutorsPanel, BoxLayout.Y_AXIS));
        tutorsPanel.setOpaque(false);

        JScrollPane tutorsScrollPane = new JScrollPane(tutorsPanel);
        tutorsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tutorsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        tutorsScrollPane.setOpaque(false);
        tutorsScrollPane.getViewport().setOpaque(false);
        tutorsScrollPane.setBorder(BorderFactory.createEmptyBorder());

        tutorsScrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(80, 80, 80); // scrollbar tutamaç rengi (koyu gri)
                this.trackColor = new Color(30, 30, 30); // scrollbar arka planı (daha koyu)
            }
            
            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }
        });

        Tutor t1 = new Tutor("Mehmet Önal", 2.9, "mehmet.onal@bilkent.edu.tr", "Available", 100);
        t1.AddCourse("MATH101");
        t1.AddCourse("CS102");

        Tutor t2 = new Tutor("Ayşe Yılmaz", 3.4, "ayse.yilmaz@bilkent.edu.tr", "Busy", 80);
        t2.AddCourse("PHYS101");

        Tutor t3 = new Tutor("Can Demir", 3.8, "can.demir@bilkent.edu.tr", "Available", 60);
        t3.AddCourse("CS201");
        t3.AddCourse("CS202");

        Tutor t4 = new Tutor("Elif Kaya", 2.7, "elif.kaya@bilkent.edu.tr", "Available", 90);
        t4.AddCourse("CHEM101");

        Tutor t5 = new Tutor("Burak Şahin", 3.0, "burak.sahin@bilkent.edu.tr", "Busy", 70);
        t5.AddCourse("MATH102");

        tutors.add(t1);
        tutors.add(t2);
        tutors.add(t3);
        tutors.add(t4);
        tutors.add(t5);

        for (Tutor tutor : tutors) {
            tutorsPanel.add(tutor);
            tutorsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Tutorlar arasında boşluk
        }


        middlePanel.add(tutorsScrollPane);


        filterMoverPanel.add(filterPanel,BorderLayout.EAST);
        middlePanel.add(filterMoverPanel);

        add(middlePanel,BorderLayout.CENTER);
    }

    class Tutor extends JPanel {
        private String name;
        private double gpa;
        private String email;
        private String status;
        private int tutoringHours;
        private ArrayList<String> coursesGiven;
    
        public Tutor(String name, double gpa, String email, String status, int tutoringHours) {
            this.name = name;
            this.gpa = gpa;
            this.email = email;
            this.status = status;
            this.tutoringHours = tutoringHours;
            this.coursesGiven = new ArrayList<>();
    
            // Görünen panel tasarımı
            setLayout(new BorderLayout());
            setMaximumSize(new Dimension(800, 150)); // Kartın maksimum boyutu
            setBackground(new Color(0, 0, 0, 150)); // Hafif şeffaf koyu
            setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
            setOpaque(true);
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
            // Sol taraf: Fotoğraf alanı (placeholder)
            JPanel imagePanel = new JPanel();
            imagePanel.setPreferredSize(new Dimension(100, 100));
            imagePanel.setBackground(Color.LIGHT_GRAY);
            imagePanel.setOpaque(true);
    
            // Orta taraf: Bilgiler
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            infoPanel.setOpaque(false);
    
            JLabel nameLabel = new JLabel(name + " | GPA: " + gpa);
            nameLabel.setForeground(Color.WHITE);
            nameLabel.setFont(new Font("Avenir Next", Font.BOLD, 16));
    
            JLabel emailLabel = new JLabel(email);
            emailLabel.setForeground(Color.LIGHT_GRAY);
            emailLabel.setFont(new Font("Avenir Next", Font.PLAIN, 14));
    
            JLabel departmentLabel = new JLabel("Department: Example Department (3rd year)");
            departmentLabel.setForeground(Color.LIGHT_GRAY);
            departmentLabel.setFont(new Font("Avenir Next", Font.PLAIN, 14));
    
            infoPanel.add(nameLabel);
            infoPanel.add(emailLabel);
            infoPanel.add(departmentLabel);
    
            // Sağ taraf: Dersler listesi
            JPanel coursesPanel = new JPanel();
            coursesPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            coursesPanel.setOpaque(false);
    
            for (String course : coursesGiven) {
                JLabel courseLabel = new JLabel(course);
                courseLabel.setForeground(Color.WHITE);
                courseLabel.setFont(new Font("Avenir Next", Font.PLAIN, 14));
                courseLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
                coursesPanel.add(courseLabel);
            }
    
            add(imagePanel, BorderLayout.WEST);
            add(infoPanel, BorderLayout.CENTER);
            add(coursesPanel, BorderLayout.EAST);
        }
    
        public void AddCourse(String course) {
            coursesGiven.add(course);
        }
    
        public String getName() { return name; }
        public double getGpa() { return gpa; }
        public String getEmail() { return email; }
        public String getStatus() { return status; }
        public int getTutoringHours() { return tutoringHours; }
        public ArrayList<String> getCoursesGiven() { return coursesGiven; }
    }
    
}