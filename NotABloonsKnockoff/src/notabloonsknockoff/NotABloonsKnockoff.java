
package notabloonsknockoff;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class NotABloonsKnockoff extends JFrame implements Runnable {

    
    public static Image image;
    public static Graphics2D g;
    
    Image Map;
    Image Menu1;
    Image Menu2;
    Image Menu3;
    Image Info;
    
    private static int health;
    static int cash;
    static boolean GetReady;
    
    double framerate = 25.0;
    int mouseX;
    int mouseY;
    int timecount;
    int djbf;
    int ppof;
    int pastpprof;
    int wave;
    double wavespeed;
    int butter;
    int mouseX2;
    int mouseY2;
    boolean upgradeactive;
    Tower _tower;
    boolean whyyyyy;
    boolean InfoActive;
    int L;
    
    
    Thread relaxer;

    static NotABloonsKnockoff frame;
    public static void main(String[] args) {        
        GraphicsDevice Device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        frame = new NotABloonsKnockoff();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public static void changeHealth(int _damage) {
        health -=_damage;
    }
    
    public static void changeCash(int _money) {
        cash -= _money;
    }
    
    public static int getCash() {
        return(cash);
    }
    
    public static boolean GetReadyReceive() {
        return(GetReady);
    }

    public NotABloonsKnockoff() {
        addMouseListener(new MouseAdapter()     {
            public void mousePressed(MouseEvent e) {
                
                if (e.BUTTON1 == e.getButton()) {
                    //left button
// location of the cursor.
                    int xpos = e.getX();
                    int ypos = e.getY();
                                  
                if(!GetReady)  
                {
                    if(!upgradeactive)
                    {
                        if(Tower.getTowers() != null)
                        {
                            for(Tower tower : Tower.getTowers())
                            {
                                if(mouseX2 <= tower.getXpos() + tower.getSelectRange() && mouseX2 >= tower.getXpos() - tower.getSelectRange() && mouseY2 <= tower.getYpos() + tower.getSelectRange() && mouseY2 >= tower.getYpos() - tower.getSelectRange())
                                {
                                    upgradeactive = true;
                                    _tower = tower;                               
                                }
                            }
                        }
                    }
                    else if(upgradeactive)
                    {
                        Tower.SetUpgrade(_tower, mouseX2, mouseY2);
                        if(mouseX2 >= 727 && mouseX2 <= 744 && mouseY2 <= 90 && mouseY2 >= 74)
                        {
                            upgradeactive = false;
                            _tower = null;                               
                        }
                    }
                }
                if(GetReady && !InfoActive)
                {
                    if(mouseX2 >= 170 && mouseY2 >= 400 && mouseX2 <= 500 && mouseY2 <= 490)
                    {
                        GetReady = false;
                    }
                    else if(mouseX2 >= 155 && mouseY2 >= 550 && mouseX2 <= 510 && mouseY2 <= 670)
                    {
                        InfoActive = true;
                    }
                }
                else if(InfoActive)
                {
                    if(mouseX2 >= 45 && mouseY2 >= 95 && mouseX2 <= 108 && mouseY2 <= 145)
                    {
                        InfoActive = false;
                        L = 1;
                    }
                    else if(mouseX2 >= 60 && mouseY2 >= 505 && mouseX2 <= 200 && mouseY2 <= 645)
                    {
                        L--;
                        if(L <= 0)
                        {
                            L = 8;
                        }
                    }
                    else if(mouseX2 >= 670 && mouseY2 >= 505 && mouseX2 <= 810 && mouseY2 <= 645)
                    {
                        L++;
                        if(L >= 9)
                        {
                            L = 1;
                        }
                    }
                }
                    
                }
                if (e.BUTTON2 == e.getButton()) {
                    //scroll wheel
                    
                }
                if (e.BUTTON3 == e.getButton()) {

                    reset();
                    }
                
                repaint();
            }
        });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
          mouseX = e.getX();
          mouseY = e.getY();
        repaint();
        
        //System.out.println(mouseX);
        //System.out.println(mouseY);
        if(!GetReady)
        {
            if(!upgradeactive)
            {
                if(mouseX >= 0 && mouseX < Window.getX(700) && mouseY <= Window.getHeight2() && mouseY >= 0)
                {
                    Board.getPCT(mouseX, mouseY);
                }

                if(mouseX >= 750 && mouseX <= 830 && mouseY >= 70 && mouseY <= 130)
                {
                    //g.drawRect(Window.getX(730),Window.getY(0),80,80);
                    //wario
                    //Tower.Create(50,50,Tower.Type.HOMER,Board.getBlock2(),130,15,0.1,-500);
                    butter = 1;

                }
                else if(mouseX >= 760 && mouseX <= 830 && mouseY >= 160 && mouseY <= 220)
                {
                    //g.drawRect(Window.getX(740),Window.getY(90),70,70);
                    //sniper
                    //Tower.Create(50,50,Tower.Type.HOMER,Board.getBlock2(),130,15,0.1,-500);
                    butter = 2;
                }
                else if(mouseX >= 730 && mouseX <= 855 && mouseY >= 243 && mouseY <= 280)
                {
                    //g.drawRect(Window.getX(710),Window.getY(170),130,50);
                    //farm
                    //Tower.Create(50,50,Tower.Type.HOMER,Board.getBlock2(),130,15,0.1,-500);
                    butter = 3;
                }
                else if(mouseX >= 760 && mouseX <= 830 && mouseY >= 300 && mouseY <= 365)
                {
                    //g.drawRect(Window.getX(740),Window.getY(230),70,70);
                    //potion
                    //Tower.Create(50,50,Tower.Type.HOMER,Board.getBlock2(),130,15,0.1,-500);
                    butter = 4;
                }
                else if(mouseX >= 760 && mouseX <= 830 && mouseY >= 380 && mouseY <= 455)
                {
                    //g.drawRect(Window.getX(740),Window.getY(310),70,80);
                    //ice monkey
                    //Tower.Create(50,50,Tower.Type.HOMER,Board.getBlock2(),130,15,0.1,-500);
                    butter = 5;
                }
                else if(mouseX >= 760 && mouseX <= 830 && mouseY >= 472 && mouseY <= 535)
                {
                    //g.drawRect(Window.getX(740),Window.getY(400),70,70);
                    //chomper
                    //Tower.Create(50,50,Tower.Type.HOMER,Board.getBlock2(),130,15,0.1,-500);
                    butter = 6;
                }
                else if(mouseX >= 760 && mouseX <= 830 && mouseY >= 550 && mouseY <= 606)
                {
                    //g.drawRect(Window.getX(740),Window.getY(480),70,60);
                    //homer
                    //Tower.Create(50,50,Tower.Type.HOMER,Board.getBlock2(),130,15,0.1,-500);
                    butter = 7;
                }
                else if(mouseX >= 760 && mouseX <= 830 && mouseY >= 620 && mouseY <= 695)
                {
                    //g.drawRect(Window.getX(740),Window.getY(550),70,80);
                    //basic
                    //Tower.Create(50,50,Tower.Type.HOMER,Board.getBlock2(),130,15,0.1,-500);
                    butter = 8;
                }
            }
        }
        
        
        //upgradeactive = false;
        

        
      }
    });
    addMouseListener(new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.BUTTON1 == e.getButton()) {
                //System.out.println(e.getX() + "   " + e.getY());
            if(!GetReady)
            {
                if(!upgradeactive)
                {
                    if(mouseX >= 0 && mouseX < Window.getX(700) && mouseY <= Window.getHeight2() && mouseY >= 0)
                    {         
                        if(butter == 1)
                        {
                            Tower.Create(mouseX,mouseY,Tower.Type.WARIO,Board.getBlockT(),70,0,0,350,70);
                        }
                        else if(butter == 2)
                        {
                            Tower.Create(mouseX,mouseY,Tower.Type.SNIPER,Board.getBlockT(),Window.getWidth2(),10,1,120,30);
                        }
                        else if(butter == 3)
                        {
                             Tower.Create(mouseX,mouseY,Tower.Type.FARM,Board.getBlockT(),0,0,5,300,50);
                        }
                        else if(butter == 4)
                        {
                           Tower.Create(mouseX,mouseY,Tower.Type.POTION,Board.getBlockT(),65,0,0.8,180,65);
                        }
                        else if(butter == 5)
                        {
                           Tower.Create(mouseX,mouseY,Tower.Type.ICE_MONKEY,Board.getBlockT(),40,10,0.5,140,40);
                        }
                        else if(butter == 6)
                        {
                            Tower.Create(mouseX,mouseY,Tower.Type.CHOMPER,Board.getBlockT(),70,20,0.4,130,70);
                        }
                        else if(butter == 7)
                        {
                             Tower.Create(mouseX,mouseY,Tower.Type.HOMER,Board.getBlockT(),130,15,0.1,500,130);
                        }
                        else if(butter == 8)
                        {
                            Tower.Create(mouseX,mouseY,Tower.Type.BASIC,Board.getBlockT(),100,20,0.3,100,100);
                        }

                    }
                    mouseX = -10000;
                    mouseY = -10000;
                    butter = 0;
                }  
            }
            
            }
            repaint();
        }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
        public void mouseClicked(MouseEvent e) {

            
            repaint();
            
        }
    });
    
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {
          mouseX2 = e.getX();
          mouseY2 = e.getY();
          repaint();
          
          //System.out.println(mouseX2 + "XX");
          //System.out.println(mouseY2 + "YY");
          
          //Board.getPC(mouseX, mouseY);
          
          /*
        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
               
                if(e.VK_1 == e.getKeyCode()) {
                    
                }
                else if(e.VK_2 == e.getKeyCode()) {
                    
                }
                else if(e.VK_3 == e.getKeyCode()) {
                    
                }
                else if(e.VK_4 == e.getKeyCode()) {
                    
                }
                else if(e.VK_5 == e.getKeyCode()) {
                    
                }
                else if(e.VK_6 == e.getKeyCode()) {
                    
                }
                else if(e.VK_7== e.getKeyCode()) {
                    
                }
                else if(e.VK_8 == e.getKeyCode()) {
                    
                }
                else if(e.VK_9 == e.getKeyCode()) {
                    
                }
                
               

                repaint();
            }

        });
*/

          
        repaint();
      }
    });
    
    addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                
     /*          
                if(e.VK_1 == e.getKeyCode()) {
                    Tower.Create(mouseX,mouseY,Tower.Type.HOMER,Board.getBlock(),130,15,0.1,-500);
                }
                else if(e.VK_2 == e.getKeyCode()) {
                     Tower.Create(mouseX,mouseY,Tower.Type.WARIO,Board.getBlock(),70,0,0,-350);
                }
                else if(e.VK_3 == e.getKeyCode()) {
                     Tower.Create(mouseX,mouseY,Tower.Type.SNIPER,Board.getBlock(),Window.getWidth2(),10,1,-120);
                }
                else if(e.VK_4 == e.getKeyCode()) {
                     Tower.Create(mouseX,mouseY,Tower.Type.FARM,Board.getBlock(),0,0,1,-300);
                }
                else if(e.VK_5 == e.getKeyCode()) {
                     Tower.Create(mouseX,mouseY,Tower.Type.POTION,Board.getBlock(),65,0,0.8,-180);
                }
                else if(e.VK_6 == e.getKeyCode()) {
                     Tower.Create(mouseX,mouseY,Tower.Type.ICE_MONKEY,Board.getBlock(),40,30,0.5,-140);
                }
                else if(e.VK_7== e.getKeyCode()) {
                     Tower.Create(mouseX,mouseY,Tower.Type.CHOMPER,Board.getBlock(),60,20,0.4,-130);
                }
                else if(e.VK_8 == e.getKeyCode()) {
                     Tower.Create(mouseX,mouseY,Tower.Type.BASIC,Board.getBlock(),100,10,0.3,-100);
                }
                else if(e.VK_9 == e.getKeyCode()) {
                     //Enemy.Create(mouseX,mouseY,Board.getBlock());
                }
   */
                
               
                repaint();
            }

        });

        init();
        start();
    }
    
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }



////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            Drawing.setDrawingInfo(g,this);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
        g.setColor(Color.cyan);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.LIGHT_GRAY);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.red);
        g.drawPolyline(x, y, 5);

        if(Window.animateFirstTime)
        {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        
        if(!GetReady)
        {
            g.drawImage(Map,Window.getX(0),Window.getY(0),
                700,Window.getHeight2(),this);

            Color newCol = new Color (188,150,90);

            if(!upgradeactive)
            {
                g.setColor(newCol);
                g.fillRect(Window.getX(700),Window.getY(0),150,Window.getHeight2());

                g.setColor(Color.RED);
                g.drawRect(Window.getX(730),Window.getY(0),80,80);
                g.drawImage(Tower.Wario,Window.getX(730),Window.getY(0),
                    80,80,this);

                g.drawRect(Window.getX(740),Window.getY(90),70,70);
                g.drawImage(Tower.Sniper,Window.getX(750),Window.getY(90),
                    50,70,this);

                g.drawRect(Window.getX(710),Window.getY(170),130,50);
                g.drawImage(Tower.Farm,Window.getX(710),Window.getY(170),
                    130,50,this);

                g.drawRect(Window.getX(740),Window.getY(230),70,70);
                g.drawImage(Tower.Potion,Window.getX(740),Window.getY(230),
                    70,70,this);

                g.drawRect(Window.getX(740),Window.getY(310),70,80);
                g.drawImage(Tower.Ice_Monkey,Window.getX(755),Window.getY(310),
                    40,80,this);

                g.drawRect(Window.getX(740),Window.getY(400),70,70);
                g.drawImage(Tower.Chomper,Window.getX(750),Window.getY(400),
                   50,70,this);

                g.drawRect(Window.getX(740),Window.getY(480),70,60);
                g.drawImage(Tower.Homer,Window.getX(745),Window.getY(480),
                   60,60,this);

                g.drawRect(Window.getX(740),Window.getY(550),70,80);
                g.drawImage(Tower.Basic,Window.getX(760),Window.getY(550),
                   40,80,this);
            }

            Enemy.Draw(g);
            Tower.Draw(g);
            

            if(!upgradeactive)
            {
                if(butter == 1)
                {
                    g.drawImage(Tower.Wario,mouseX-40,mouseY-40,80,80,this);
                }
                else if(butter == 2)
                {
                    g.drawImage(Tower.Sniper,mouseX-25,mouseY-25,50,70,this);
                }
                else if(butter == 3)
                {
                    g.drawImage(Tower.Farm,mouseX-65,mouseY-25,130,50,this);
                }
                else if(butter == 4)
                {
                    g.drawImage(Tower.Potion,mouseX-35,mouseY-35,70,70,this);
                }
                else if(butter == 5)
                {
                    g.drawImage(Tower.Ice_Monkey,mouseX-20,mouseY-40,40,80,this);
                }
                else if(butter == 6)
                {
                    g.drawImage(Tower.Chomper,mouseX-25,mouseY-35,50,70,this);
                }
                else if(butter == 7)
                {
                    g.drawImage(Tower.Homer,mouseX-30,mouseY-30,60,60,this);
                }
                else if(butter == 8)
                {
                    g.drawImage(Tower.Basic,mouseX-20,mouseY-40,40,80,this);
                }
            }

            if(upgradeactive)
            {
                g.setColor(newCol);
                g.fillRect(Window.getX(700),Window.getY(0),150,Window.getHeight2());
                Tower.DrawUpgrades(_tower,g); 
                Drawing.drawSquare(Window.getX(610),Window.getYNormal(440),45,3,11,Color.RED);
                Drawing.drawSquare(Window.getX(530),Window.getYNormal(735),135,3,11,Color.RED);
            }



            //g.setColor(Color.BLUE);
            //g.fillRect(mouseX-40,mouseY-40,80,80);

            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.PLAIN, 40));
            g.drawString("Wave: " + (wave + 1), Window.getWidth2()*1/10, Window.getHeight2() * 1/10);

            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.PLAIN, 40));
            g.drawString("Health: " + health, Window.getWidth2()*3/8, Window.getHeight2() * 1/10);

            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.PLAIN, 40));
            g.drawString("Cash: " + cash, Window.getWidth2()*5/7, Window.getHeight2() * 1/10);
        }   
        else if(GetReady && !InfoActive)
        {
             g.drawImage(Menu1,Window.getX(0),Window.getY(0),
                850,Window.getHeight2(),this);
        }
        
        if(GetReady && !InfoActive)
        {
            if(mouseX2 >= 245 && mouseY2 >= 400 && mouseX2 <= 575 && mouseY2 <= 500)
            {
                g.drawImage(Menu2,Window.getX(0),Window.getY(0),
                850,Window.getHeight2(),this);
            }
            else if(mouseX2 >= 230 && mouseY2 >= 550 && mouseX2 <= 585 && mouseY2 <= 670)
            {
                g.drawImage(Menu3,Window.getX(0),Window.getY(0),
                850,Window.getHeight2(),this);
            }
        }
        else if(InfoActive)
        {
            g.drawImage(Info,Window.getX(0),Window.getY(0),
                850,Window.getHeight2(),this);
            
            if(L == 1)
            {
                g.drawImage(Tower.Wario,240,105,400,400,this);
                g.setColor(Color.black);
                g.setFont(new Font("Arial", Font.PLAIN, 40));
                g.drawString("Wario", 390, Window.getHeight2() * 1/10);
                
                g.setFont(new Font("Arial", Font.PLAIN, 30));
                g.drawString("''Wah''", 390, Window.getHeight2() * 8/10);
                
                g.drawString("The Wario Tower is a support", 245, 550);
                g.drawString("tower that can buff other towers", 240, 580);
            }
            else if(L == 2)
            {
                g.drawImage(Tower.Sniper,330,170,170,250,this);
                g.setColor(Color.black);
                g.setFont(new Font("Arial", Font.PLAIN, 40));
                g.drawString("Sniper", 390, Window.getHeight2() * 1/10);
                
                g.setFont(new Font("Arial", Font.PLAIN, 30));
                g.drawString("''Boom, headshot.''", 320, Window.getHeight2() * 8/10);
                
                g.drawString("Honestly, did you expect", 280, 550);
                g.drawString("anything different?", 320, 580);
            }
            else if(L == 3)
            {
                g.drawImage(Tower.Farm,240,220,400,148,this);
                g.setColor(Color.black);
                g.setFont(new Font("Arial", Font.PLAIN, 40));
                g.drawString("Banana Farm", 330, Window.getHeight2() * 1/10);
                
                g.setFont(new Font("Arial", Font.PLAIN, 30));
                g.drawString("''mmm, banana, mmm - Customer''", 210, Window.getHeight2() * 8/10);
                
                g.drawString("The Banana Farm Tower will", 245, 550);
                g.drawString("generate Cash over time", 270, 580);
            }
            else if(L == 4)
            {
                g.drawImage(Tower.Potion,280,160,300,300,this);g.setColor(Color.black);
                g.setFont(new Font("Arial", Font.PLAIN, 40));
                g.drawString("PopFizz", 380, Window.getHeight2() * 1/10);
                
                g.setFont(new Font("Arial", Font.PLAIN, 30));
                g.drawString("''MOTION OF THE POTION''", 250, Window.getHeight2() * 8/10);
                
                g.drawString("The Potion Tower is a support", 245, 550);
                g.drawString("tower that can buff other towers,", 240, 580);
                g.drawString("but the effect will wear off", 280, 610);
                
            }
            else if(L == 5)
            {
                g.drawImage(Tower.Ice_Monkey,380,170,125,250,this);
                g.setColor(Color.black);
                g.setFont(new Font("Arial", Font.PLAIN, 40));
                g.drawString("Ice Monkey", 360, Window.getHeight2() * 1/10);
                
                g.setFont(new Font("Arial", Font.PLAIN, 30));
                g.drawString("''Help me''", 370, Window.getHeight2() * 8/10);
                
                g.drawString("We decided to put a refrigerator", 245, 550);
                g.drawString("and Skrat from Ice Age together", 250, 580);
                g.drawString("to create the ultimate", 300, 610);
                g.drawString("slowing machine!", 330, 640);
            }
            else if(L == 6)
            {
                g.drawImage(Tower.Chomper,350,175,170,250,this);
                g.setColor(Color.black);
                g.setFont(new Font("Arial", Font.PLAIN, 40));
                g.drawString("Hot Rod Chomper", 300, Window.getHeight2() * 1/10);
                
                g.setFont(new Font("Arial", Font.PLAIN, 30));
                g.drawString("''OOOH YEEEEEEEAH''", 280, Window.getHeight2() * 8/10);
                
                g.drawString("Zombies don't want to get close", 230, 550);
                g.drawString("or they WILL lose their head", 250, 580);
            }
            else if(L == 7)
            {
                g.drawImage(Tower.Homer,320,175,250,250,this);
                g.setColor(Color.black);
                g.setFont(new Font("Arial", Font.PLAIN, 40));
                g.drawString("Homper Samsum", 310, Window.getHeight2() * 1/10);
                
                g.setFont(new Font("Arial", Font.PLAIN, 30));
                g.drawString("''Doh!''", 400, Window.getHeight2() * 8/10);
                
                g.drawString("The Homper Samsum Tower fires", 220, 550);
                g.drawString("deadly shots at high speeds", 250, 580);
            }
            else if(L == 8)
            {
                g.drawImage(Tower.Basic,380,170,125,250,this);
                g.setColor(Color.black);
                g.setFont(new Font("Arial", Font.PLAIN, 40));
                g.drawString("Stormtrooper", 340, Window.getHeight2() * 1/10);
                
                g.setFont(new Font("Arial", Font.PLAIN, 30));
                g.drawString("''I don't get paid enough for this''", 230, Window.getHeight2() * 8/10);
                g.drawString("Your basic unit", 340, 550);

            }
        }

        gOld.drawImage(image, 0, 0, null);
    }
////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = 1/framerate;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        Tower.Reset();
        Enemy.Reset();
        timecount = 0;
        djbf = 0;
        pastpprof = 20;
        wave = 0;
        health = 100;
        wavespeed = 3;
        cash = 200;
        mouseX = -10000;
        mouseY = -10000;
        mouseX2 = -1000;
        mouseY2 = -1000;
        upgradeactive = false;
        _tower = null;
        whyyyyy = false;
        GetReady = true;
        InfoActive = false;
        L = 1;

    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {
        if (Window.animateFirstTime) {
            Window.animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
           
            Map = Toolkit.getDefaultToolkit().getImage("./MadeBTDMap.png");
            Menu1 = Toolkit.getDefaultToolkit().getImage("./MadeBTDMenuPt1.png");
            Menu2 = Toolkit.getDefaultToolkit().getImage("./MadeBTDMenuPt2.png");
            Menu3 = Toolkit.getDefaultToolkit().getImage("./MadeBTDMenuPt3.png");
            Info = Toolkit.getDefaultToolkit().getImage("./MadeBTDTowerInfo.png");
            Tower.Wario = Toolkit.getDefaultToolkit().getImage("./T-Posing_Wario.png");
            Tower.Sniper = Toolkit.getDefaultToolkit().getImage("./Sniper.png");
            Tower.Farm = Toolkit.getDefaultToolkit().getImage("./Banana_Farm.JPG");
            Enemy.Bloons = Toolkit.getDefaultToolkit().getImage("./Bloons.JPG");
            Tower.Potion = Toolkit.getDefaultToolkit().getImage("./Pop_Fizz.png");
            Tower.Ice_Monkey = Toolkit.getDefaultToolkit().getImage("./Ice_Monkey.png");
            Tower.Chomper = Toolkit.getDefaultToolkit().getImage("./HOT_ROD_CHOMPEEER.png");
            Tower.Homer = Toolkit.getDefaultToolkit().getImage("./Homer_Sampson.png");
            Tower.Basic = Toolkit.getDefaultToolkit().getImage("./Dart_Monkey.png");
            
            
            
            reset();
        }
        
        Enemy.Die();
        
        if(Tower.getTowers() != null)
        {
            if(timecount % (int)(3*framerate) == ((int)(3*framerate)-1) && djbf == 0)
            {
                Enemy.Create(-32,369,20, 10, 1); 
                djbf++;
                ppof++;
            }
            
            else if(timecount % (wavespeed*framerate) == ((wavespeed*framerate)-1))
            {
                if(ppof >= 20)
                {   //369 = y  x = -32
                    Enemy.Create(-32,369,pastpprof + ppof, 10, 1);  
                    pastpprof+=ppof;
                    ppof=0;
                    wave++;
                    wavespeed -= 0.1;
                    
                }
                else
                Enemy.Create(-32,369, pastpprof, 10, 1);  
                ppof++;
            }

        }
        
        if(Enemy.getEnemies() != null)
        {
            Enemy.Move(1, framerate);
        }
                
        
        if(Enemy.getEnemies() != null && Tower.getTowers() != null)
        {           
            Tower.Range(timecount, framerate);           
        }

        timecount++;

    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }

}

////////////////////////////////////////////////////////////////////////////
class Drawing {
    private static Graphics2D g;
    private static NotABloonsKnockoff mainClassInst;

    public static void setDrawingInfo(Graphics2D _g,NotABloonsKnockoff _mainClassInst) {
        g = _g;
        mainClassInst = _mainClassInst;
    }
////////////////////////////////////////////////////////////////////////////
    public static void drawCircle(int xpos,int ypos,double rot,double xscale,double yscale,Color color)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.setColor(color);
        g.fillOval(-10,-10,20,20);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
////////////////////////////////////////////////////////////////////////////
    public static void drawSquare(int xpos,int ypos,double rot,int xscale,int yscale,Color color)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.setColor(color);
        g.fillRect(-20,-20,2,2);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
////////////////////////////////////////////////////////////////////////////
    public static void drawImage(Image image,int xpos,int ypos,double rot,double xscale,
            double yscale) {
        int width = image.getWidth(mainClassInst);
        int height = image.getHeight(mainClassInst);
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.drawImage(image,-width/2,-height/2,
        width,height,mainClassInst);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }  

}
