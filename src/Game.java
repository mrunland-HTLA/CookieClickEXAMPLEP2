import java.util.Timer;
import java.util.TimerTask;

public class Game {
    protected int cookieCounter;
    private int cookiesPerClick;
    private int cookiesPerSecond;
    protected int upgrade1Cost;
    protected int upgrade2Cost;

    public Game() {
        this.cookieCounter = 0;
        this.cookiesPerClick = 1;
        this.cookiesPerSecond = 0;
        this.upgrade1Cost = 5;
        this.upgrade2Cost = 25;

        Timer  timer = new Timer();
        TimerTask slow = new TimerTask() {
            @Override
            public void run() {
                slowCookie();
            }
        };
        timer.schedule(slow, 0, 1000);

    }

    public void slowCookie() {
        this.cookieCounter+=cookiesPerSecond;
    }


    public void click() {
        cookieCounter+=cookiesPerClick;
    }

    public void buyUpgrade1() {
        if(cookieCounter > upgrade1Cost ) {
            cookieCounter -= upgrade1Cost;
            cookiesPerClick++;
            upgrade1Cost += cookiesPerClick;
        }
    }

    public void buyUpgrade2() {
        if(cookieCounter > upgrade2Cost ) {
            cookieCounter -= upgrade2Cost;
            cookiesPerSecond++;
            upgrade2Cost += cookiesPerSecond;
        }
    }



}