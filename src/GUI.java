import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame frame; // It's a window
    JPanel panel;//A rectangular region inside
    JPanel fillerPanel;
    JLabel label; //A rectangular region inside
    JLabel cost1;
    JLabel cost2;
    JButton cookieButton;
    JButton upgradeButton1;
    JButton upgradeButton2;
    int counter = 0;
    Game cookies;
    ActionListener guiUpdate;
    Timer updateTimer;

    public GUI(){
        this.cookies = new Game();
        frame = new JFrame();
        panel = new JPanel();
        fillerPanel = new JPanel();
        label = new JLabel("Loading");
        cost1 = new JLabel("Upgrade Cost: " + cookies.upgrade1Cost);
        cost2 = new JLabel("Upgrade Cost: " + cookies.upgrade2Cost);
        cookieButton = new JButton("COOKIE");
        upgradeButton1 = new JButton("MUCHO CLICK");
        upgradeButton2 = new JButton("SLOW COOK");
        cookieButton.addActionListener(this);
        upgradeButton1.addActionListener(e -> {
            cookies.buyUpgrade1();
        });
        upgradeButton2.addActionListener(e -> {
            cookies.buyUpgrade2();
        });
        guiUpdate = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Cookies: " + cookies.cookieCounter);
                cost1.setText("Upgrade Cost: " + cookies.upgrade1Cost);
                cost2.setText("Upgrade Cost: " + cookies.upgrade2Cost);

                //figure out the name of the label
                //set the text of the label to something
                }
            };
            updateTimer = new Timer(500,guiUpdate);//delay, the thing to do.
            updateTimer.start();



        //first need to add the label to the panel
        //panel.add(label);//each element needs to be added to our panel after creation
        //PROPERTIES
        panel.setSize(400,100);
        panel.setLayout(new GridLayout(2,3));
        //ADDING STUFF
        panel.add(cookieButton);
        panel.add(upgradeButton1);
        panel.add(upgradeButton2);
        panel.add(label);
        panel.add(cost1);
        panel.add(cost2);
        panel.setBackground(Color.PINK);

        fillerPanel.setSize(400,400);
        fillerPanel.setBackground(Color.PINK);


        //next, we add the panel to the frame
        frame.add(panel);
        frame.add(fillerPanel);


        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        cookies.click();
        label.setText("Cookies: " + cookies.cookieCounter);
    }
}
/*
TODO:
Change the button colors. (figure it out)
Add more upgrades (you'll need to change your grid)
~5-10
They need to be unique and do different things

**BONUS POINTS**
Change your buttons to cookie images or some other image

 */