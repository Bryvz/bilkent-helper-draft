import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
    CardLayout cardLayout;
    JPanel cards;
    private final int MIN_WIDTH = 1200;
    private final int MIN_HEIGHT = 800;

    public AppFrame() {
        setTitle("Bilkent Helper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tam ekran yapılandırması


        setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));



        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        cards.add(new WelcomePage(this), "welcome");
        cards.add(new EntrancePage(this), "entrance");
        cards.add(new LoginPage(this), "login");
        cards.add(new SignUpPage(this), "signup");
        cards.add(new MainPage(this), "main");
        cards.add(new MapPage(this), "page1");
        cards.add(new TutoringPage(this), "page2");
        cards.add(new StorePage(this), "page3");
        cards.add(new SurveyPage(this), "page4");
        cards.add(new ProfilePage(this), "page5");


        add(cards);
        setVisible(true);

        showPage("welcome");
    }


    public void showPage(String name) {
        cardLayout.show(cards, name);
    }
}
