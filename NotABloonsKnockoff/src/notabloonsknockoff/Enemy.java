
package notabloonsknockoff;
import java.awt.*;
import java.util.ArrayList;
import java.awt.Toolkit;

public class Enemy {
    private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public static Image Bloons;
    private int x;
    private int y;
    private static NotABloonsKnockoff mainClassInst;
    private Board.Placement isblock = null;
    private int movemeter;
    private int PastPositionX;
    private int PastPositionY;
    private boolean isactive;
    private int health;
    private int damage;
    private int cashdrop;
    private double speed;
    private double PersonalTimecount;
    
    
    public Enemy(int _x, int _y) {
        x = _x;
        y = _y;
        isactive = false;
    }
    
    public Enemy(int _x, int _y, Board.Placement _block, int _health2, int _damage, double _speed) {
        x = _x;
        y = _y;
        isblock = _block;
        movemeter = 10;
        PastPositionX = 0;
        PastPositionY = 0;
        isactive = true;
        health = _health2;
        damage = _damage;
        cashdrop = -25;
        speed = (_speed * 1/8);
        PersonalTimecount = 0;
    }
    
    public static void Create(int _x2, int _y2, int _health, int _damage2, double _speed2) {
        //if(_block2 == Board.Placement.PATHWAY)
        {
            Enemy enemy = new Enemy(_x2,_y2, Board.Placement.PATHWAY, _health, _damage2, _speed2);
            enemies.add(enemy);
        }
    }
    
    public static void Draw(Graphics2D g) {
        for(Enemy enemy : enemies)
        {
            if(enemy.isactive && enemy.isblock == Board.Placement.PATHWAY)
            {
                drawImage(g,Bloons,enemy.x,enemy.y,0.0,0.03,0.03);
            }
        }
    }
    
     public static void Reset() {
        enemies.clear();
        //Enemy enemy = new Enemy(10,10);
        //enemies.add(enemy);
        
    }
    
     public static void drawImage(Graphics2D g,Image image,int xpos,int ypos,double rot,double xscale,
            double yscale) {
        int width = image.getWidth(mainClassInst);
        int height = image.getHeight(mainClassInst);
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.drawImage(image,-width/2,-height/2,
        width,height,mainClassInst);
        g.scale( 1.0/xscale,1.0/yscale);
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
      
    public static void Move(double timecount, double framerate) {
        //// "break;" cancels the rest of the code in the method/any code going to be done
        //if you want to make different levels, I suggest using points on the map in cordination with the user's screen as "turning points"
        //these "turning points," will tell the ai when to turn/when to move in a different direction withought hardcoding the entire pathway
        for(Enemy enemy : enemies)
        {
            enemy.PersonalTimecount += timecount;
            if(enemy.isactive)
            {
                //System.out.println(enemy.PersonalTimecount);
                if((enemy.PersonalTimecount * 10) >= ((framerate * enemy.speed) * 10))
                {
                    if(enemy.x <= 0 || Board.ReternFuturePCE(enemy.x + enemy.movemeter, enemy.y) == Board.Placement.PATHWAY && enemy.PastPositionX != enemy.x + enemy.movemeter)
                    {
                            enemy.PastPositionX = enemy.x;
                            enemy.x += enemy.movemeter; 
                            //break;
                    }
                    else if(Board.ReternFuturePCE(enemy.x - enemy.movemeter, enemy.y) == Board.Placement.PATHWAY && enemy.PastPositionX != enemy.x - enemy.movemeter)
                    {
                            enemy.PastPositionX = enemy.x;
                            enemy.x -= enemy.movemeter;  
                            enemy.PastPositionY = 0;
                            //break;
                    }
                    else if(Board.ReternFuturePCE(enemy.x, enemy.y + enemy.movemeter) == Board.Placement.PATHWAY && enemy.y + enemy.movemeter < Window.getHeight2() && enemy.PastPositionY != enemy.y + enemy.movemeter)
                    {                    
                            enemy.PastPositionY = enemy.y;
                            enemy.y += enemy.movemeter;  
                            //break;
                    }
                    else if(Board.ReternFuturePCE(enemy.x, enemy.y - enemy.movemeter) == Board.Placement.PATHWAY && enemy.y - enemy.movemeter > 45)
                    {
                        enemy.PastPositionY = Window.getYNormal(0);
                        if(enemy.PastPositionY != enemy.y - enemy.movemeter)
                        {
                            enemy.PastPositionY = enemy.y;
                            enemy.y -= enemy.movemeter;        
                            //break;
                        }
                    }
                    else
                    {
                        NotABloonsKnockoff.changeHealth(enemy.damage);
                        enemy.isactive = false;
                    }
                    //System.out.println(PersonalTimecount);
                    enemy.PersonalTimecount = 0;
                }
                
            }

        }
        
    }
      
    public void ChangeisBlock() {
        isblock = Board.ReternFuturePCE(x,y);
    }
    
    public static ArrayList<Enemy> getEnemies(){
        if(enemies.size() != 0)
        {
            return enemies;
        }
        else
        {
            return(null);
        }
    }
    
    public void ChangeSpeed(double _spood) {
        speed += _spood;
    }
    
    public void ChangeHealth(int _damage, Enemy enemy) {
        health -= _damage;
        NotABloonsKnockoff.changeCash(enemy.cashdrop);
        if(health <= 0)
            isactive = false;
    }
    
    public int getXpos() {
        return(x);
    }
    
    public int getYpos() {
        return(y);
    }
    
    public boolean getIsActive() {
        return(isactive);
    }
    
    public void setIsActive(boolean _boolean) {
        isactive = _boolean;
    }
    
    public static void Die() {
        for(int i = 0; i < enemies.size(); i++)
        {
            if(!enemies.get(i).isactive)
            {
                //NotABloonsKnockoff.changeCash(enemies.get(i).cashdrop);
                enemies.remove(i);
                i--;
            }
        }
    }
    
    
}
