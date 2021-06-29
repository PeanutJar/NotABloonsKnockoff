
package notabloonsknockoff;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Tower {
    
    private static ArrayList<Tower> towers = new ArrayList<Tower>();
    private ArrayList<Tower> BuffableTPersonal = new ArrayList<Tower>();
    public enum Type {HOMER, WARIO, SNIPER, FARM, POTION, ICE_MONKEY, CHOMPER, BASIC};
    public static Image Wario;
    public static Image Sniper;
    public static Image Farm;
    public static Image Potion;
    public static Image Ice_Monkey;
    public static Image Chomper;
    public static Image Homer;
    public static Image Basic;
    private static NotABloonsKnockoff mainClassInst;
    private int x;
    private int y;
    private Type type;
    private Board.Placement isblock = null;
    private int range;
    private int damage;
    private double AttackCooldown;
    private int cost;
    static Graphics2D g;
    private int OriginalDamage;
    private int SelectRange;
    private int Speedbuff;
    private int Damagebuff;
    private int MoneyValue;
    
    
    public Tower(int _x, int _y, Type _type, Board.Placement _block, int _range, int _damage, double _AttackCooldown, int _cost, int _selectrange) {
        x = _x;
        y = _y;
        type = _type;
        isblock = _block;
        range = _range;
        damage = _damage;
        AttackCooldown = _AttackCooldown;
        cost = _cost;
        OriginalDamage = _damage;
        SelectRange = _selectrange;
        
        if(type == Type.WARIO || type == Type.POTION)
        {
            Speedbuff = 10;
            Damagebuff = 10;
        }
        else
        {
            Speedbuff = 0;
            Damagebuff = 0;
        }
        
        if(type == Type.FARM)
        {
            MoneyValue = -25;
        }
        else
        {
            MoneyValue = 0;
        }
        
    }
    
    public static void Create(int x, int y, Type _type2, Board.Placement _block2, int _range2,int _damage2, double _AttackCooldown2, int _cost2, int _selectrange2) {
        if(_block2 == Board.Placement.GRASS)
        {
            if(_cost2 <= NotABloonsKnockoff.getCash())
            {
                Tower tower = new Tower(x,y, _type2, _block2, _range2, _damage2, _AttackCooldown2, _cost2, _selectrange2);
                towers.add(tower);
                tower.changeCost(tower.cost);
                //System.out.println(tower.BuffableTPersonal.size());
                
                /*
                if(tower.type != Type.POTION && tower.type != Type.WARIO && tower.type != Type.FARM)  ///adds tower to array list if added after support towers
                {
                    for(Tower t : towers)
                    {
                        if(t.type == Type.POTION || t.type == Type.WARIO)
                        {
                            t.BuffableTPersonal.add(tower);
                            System.out.println(t.BuffableTPersonal.size() + "a");
                        }
                    }
                }
                else if(tower.type == Type.POTION || tower.type == Type.WARIO) //adds towers to array lost if they were created before support tower
                {
                    for(Tower t : towers)
                    {
                        if(t.type != Type.POTION && t.type != Type.WARIO && t.type != Type.FARM)
                        {
                            tower.BuffableTPersonal.add(t);
                        }
                    }
                    System.out.println(tower.BuffableTPersonal.size() + "b");
                }
                
                */
            }
        }
    }
    
    public static void Draw(Graphics2D g) {
        for(Tower tower : towers)
        {
            if(tower.isblock == Board.Placement.GRASS)
            {
                if(tower.type == Type.HOMER)
                drawImage(g,Homer,tower.x,tower.y,0.0,0.5,0.5 );
                else if(tower.type == Type.WARIO)
                drawImage(g,Wario,tower.x,tower.y,0.0,0.09,0.09 );
                else if(tower.type == Type.SNIPER)
                drawImage(g,Sniper,tower.x,tower.y,0.0,0.1,0.1 );
                else if(tower.type == Type.FARM)
                drawImage(g,Farm,tower.x,tower.y,0.0,0.5,0.5 );
                else if(tower.type == Type.POTION)
                drawImage(g,Potion,tower.x,tower.y,0.0,0.5,0.5 );
                else if(tower.type == Type.ICE_MONKEY)
                drawImage(g,Ice_Monkey,tower.x,tower.y,0.0,0.5,0.5 );
                else if(tower.type == Type.CHOMPER)
                drawImage(g,Chomper,tower.x,tower.y,0.0,0.3,0.3 );
                else if(tower.type == Type.BASIC)
                drawImage(g,Basic,tower.x,tower.y,0.0,0.1,0.1 );
            }
        }
    }
    
    public static void Reset() {
        towers.clear();
    }
    
    public static void DrawUpgrades(Tower tower, Graphics2D g) {
        for(int i = 0; i < 3; i++)
        {
            int size = 120;
            g.setColor(Color.RED);
            g.drawRect(735,size + ((size * i)* 7/4), size, size);
        }
        
        g.setColor(Color.RED);
        g.drawRect(735,680, 120, 30);
        
        if(tower.type == Type.WARIO)
        {
            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Attack", 770, 150);
            g.drawString("Speed", 770, 175);
            g.drawString("Buff", 780, 205);
            g.drawString("Upgrade", 760, 235);
            
            g.drawString("Damage", 762, 360);
            g.drawString("Buff", 780, 390);
            g.drawString("Upgrade", 760, 420);
            
            g.drawString("Tower", 770, 570);
            g.drawString("Cost", 780, 600);
            g.drawString("Reduction", 760, 630);
            
            g.setColor(Color.blue);
            g.drawString("Cost: $" + (tower.cost * 1/3), 752, 255); 
            
            g.drawString("Cost: $" + (tower.cost * 1/3), 752, 440); 
        }
        else if(tower.type == Type.SNIPER)
        {
            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Attack", 770, 150);
            g.drawString("Speed", 770, 180);
            g.drawString("Upgrade", 760, 210);  
            
            g.drawString("Damage", 762, 360);
            g.drawString("Upgrade", 760, 390);
            
            g.setColor(Color.blue);
            g.drawString("Cost: $" + (tower.cost * 1/3), 752, 235); 
            
            g.drawString("Cost: $" + (tower.cost * 1/3), 752, 425); 
            
            //tower.BuffTower("AttackSpeed", 0.1);
        }
        else if(tower.type == Type.FARM)
        {
            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Banana", 764, 150);
            g.drawString("Production", 755, 180);
            g.drawString("Upgrade", 760, 210);  
            
            g.drawString("Banana", 762, 360);
            g.drawString("Value", 769, 390);
            g.drawString("Upgrade", 760, 420);
            
            g.setColor(Color.blue);
            g.drawString("Cost: $" + (tower.cost * 1/3), 752, 235); 
            
            g.drawString("Cost: $" + (tower.cost * 1/3), 752, 448); 
        }
        else if(tower.type == Type.POTION)
        {
            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Attack", 770, 150);
            g.drawString("Speed", 770, 175);
            g.drawString("Buff", 780, 205);
            g.drawString("Upgrade", 760, 235);
            
            g.drawString("Damage", 762, 360);
            g.drawString("Buff", 780, 390);
            g.drawString("Upgrade", 760, 420);
            
            g.setColor(Color.blue);
            g.drawString("Cost: $" + (tower.cost * 1/3), 752, 255); 
            
            g.drawString("Cost: $" + (tower.cost * 1/3), 752, 440); 
        }
        else if(tower.type == Type.ICE_MONKEY)
        {
            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Attack", 770, 150);
            g.drawString("Speed", 770, 180);
            g.drawString("Upgrade", 760, 210);  
            
            g.drawString("Damage", 762, 360);
            g.drawString("Upgrade", 760, 390);
            
            g.setColor(Color.blue);
            g.drawString("Cost: $" + (tower.cost * 1/3), 752, 235); 
            
            g.drawString("Cost: $" + (tower.cost * 1/3), 752, 425); 
        }
        else if(tower.type == Type.CHOMPER)
        {
            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Attack", 770, 150);
            g.drawString("Speed", 770, 180);
            g.drawString("Upgrade", 760, 210);  
            
            g.drawString("Damage", 762, 360);
            g.drawString("Upgrade", 760, 390);
            
            g.setColor(Color.blue);
            g.drawString("Cost: $" + (tower.cost * 1/3), 752, 235); 
            
            g.drawString("Cost: $" + (tower.cost * 1/3), 752, 425); 
        }
        else if(tower.type == Type.HOMER)
        {
            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Attack", 770, 150);
            g.drawString("Speed", 770, 180);
            g.drawString("Upgrade", 760, 210);  
            
            g.drawString("Damage", 762, 360);
            g.drawString("Upgrade", 760, 390);
            
            g.setColor(Color.blue);
            g.drawString("Cost: $" + (tower.cost * 1/3), 752, 235); 
            
            g.drawString("Cost: $" + (tower.cost * 1/3), 752, 425); 
        }
        else if(tower.type == Type.BASIC)
        {
            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Attack", 770, 150);
            g.drawString("Speed", 770, 180);
            g.drawString("Upgrade", 760, 210);  
            
            g.drawString("Damage", 762, 360);
            g.drawString("Upgrade", 760, 390);
            
            g.setColor(Color.blue);
            g.drawString("Cost: $" + (tower.cost * 1/3), 752, 235); 
            
            g.drawString("Cost: $" + (tower.cost * 1/3), 752, 425); 
        }
        
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Sell: $" + (tower.cost * 2/3), 750, 700);
    }
    
    public static void SetUpgrade(Tower tower, int mousex, int mousey) {
        if(NotABloonsKnockoff.cash - (tower.cost * 1/3) >= 0)
        {
            if(tower.type == Type.WARIO)
            {
                if(mousex <= 855 && mousex >= 735 && mousey <= 240 && mousey >= 120)
                {
                    tower.BuffTower("MoarSpeed", 10);
                    tower.changeCost(tower.cost * 1/3);
                }
                else if(mousex <= 855 && mousex >= 735 && mousey <= 447 && mousey >= 330)
                {
                    tower.BuffTower("MoarDamage", 10);
                    tower.changeCost(tower.cost * 1/3);
                }
            }
            else if(tower.type == Type.SNIPER)
            {          
                if(mousex <= 855 && mousex >= 735 && mousey <= 240 && mousey >= 120)
                {
                    tower.BuffTower("AttackSpeed", 2);
                    tower.changeCost(tower.cost * 1/3);
                }
                else if(mousex <= 855 && mousex >= 735 && mousey <= 447 && mousey >= 330)
                {
                    tower.BuffTower("Damage", 10);
                    tower.changeCost(tower.cost * 1/3);
                }
            }
            else if(tower.type == Type.FARM)
            {
               if(mousex <= 855 && mousex >= 735 && mousey <= 240 && mousey >= 120)
                {
                    tower.BuffTower("MoarBanana", 20);
                    tower.changeCost(tower.cost * 1/3);
                }
                else if(mousex <= 855 && mousex >= 735 && mousey <= 447 && mousey >= 330)
                {
                    tower.BuffTower("RichBanana", -5);
                    tower.changeCost(tower.cost * 1/3);
                }
            }
            else if(tower.type == Type.POTION)
            {
                if(mousex <= 855 && mousex >= 735 && mousey <= 240 && mousey >= 120)
                {
                    tower.BuffTower("MoarSpeed", 10);
                    tower.changeCost(tower.cost * 1/3);
                }
                else if(mousex <= 855 && mousex >= 735 && mousey <= 447 && mousey >= 330)
                {
                    tower.BuffTower("MoarDamage", 10);
                    tower.changeCost(tower.cost * 1/3);
                }
            }
            else if(tower.type == Type.ICE_MONKEY)
            {
               if(mousex <= 855 && mousex >= 735 && mousey <= 240 && mousey >= 120)
                {
                    tower.BuffTower("AttackSpeed", 3);
                    tower.changeCost(tower.cost * 1/3);
                }
               else if(mousex <= 855 && mousex >= 735 && mousey <= 447 && mousey >= 330)
                {
                    tower.BuffTower("Damage", 20);
                    tower.changeCost(tower.cost * 1/3);
                }
            }
            else if(tower.type == Type.CHOMPER)
            {
                if(mousex <= 855 && mousex >= 735 && mousey <= 240 && mousey >= 120)
                {
                    tower.BuffTower("AttackSpeed", 3);
                    tower.changeCost(tower.cost * 1/3);
                }
                else if(mousex <= 855 && mousex >= 735 && mousey <= 447 && mousey >= 330)
                {
                    tower.BuffTower("Damage", 20);
                    tower.changeCost(tower.cost * 1/3);
                }
            }
            else if(tower.type == Type.HOMER)
            {
                if(mousex <= 855 && mousex >= 735 && mousey <= 240 && mousey >= 120)
                {
                    tower.BuffTower("AttackSpeed", 2);
                    tower.changeCost(tower.cost * 1/3);
                }
                else if(mousex <= 855 && mousex >= 735 && mousey <= 447 && mousey >= 330)
                {
                    tower.BuffTower("Damage", 2);
                    tower.changeCost(tower.cost * 1/3);
                }
            }
            else if(tower.type == Type.BASIC)
            {
                if(mousex <= 855 && mousex >= 735 && mousey <= 240 && mousey >= 120)
                {
                    tower.BuffTower("AttackSpeed", 3);
                    tower.changeCost(tower.cost * 1/3);
                }
                else if(mousex <= 855 && mousex >= 735 && mousey <= 447 && mousey >= 330)
                {
                    tower.BuffTower("Damage", 10);
                    tower.changeCost(tower.cost * 1/3);
                }
            }
        }
        
        if(mousex <= 855 && mousex >= 735 && mousey <= 710 && mousey >= 680)
        {
            tower.changeCost(-(tower.cost * 2/3));
            for(Tower _tower : towers)
            {
                if(_tower.type == Type.WARIO || _tower.type == Type.POTION)
                {
                    if(_tower.BuffableTPersonal.size() != 0)
                    {
                        for(int gw = 0; gw < _tower.BuffableTPersonal.size(); gw++)
                        {
                            if(tower == tower.BuffableTPersonal.get(gw)) 
                            {
                                _tower.BuffableTPersonal.remove(tower);  
                                break;
                            }
                        }
                    }
                }
            }
            towers.remove(tower);
        }
        
    }
    
      
    public static void Range(int timecount, double framerate) {    
        PassiveAttack(timecount, framerate);
        for(Tower tower : towers)
        {         
            for(Enemy enemy : Enemy.getEnemies())
            {
                if(timecount % (tower.AttackCooldown*framerate) == ((tower.AttackCooldown*framerate)-1))
                {
                    if(enemy.getXpos() < tower.x + tower.range && enemy.getXpos() > tower.x - tower.range && enemy.getYpos() < tower.y + tower.range && enemy.getYpos() > tower.y - tower.range)
                    {
                        if(tower.type == Type.ICE_MONKEY)
                        {
                            enemy.ChangeSpeed(0.5);
                            //System.out.println("tee");
                        }
                        enemy.ChangeHealth(tower.damage, enemy);
                        //enemy.setIsActive(false);
                    } 
                }
            }
        }
        
    }
    
    public static void PassiveAttack(int timecount, double framerate) {
        for(Tower tower : towers)
        {
            if(timecount % (tower.AttackCooldown*framerate) == ((tower.AttackCooldown*framerate)-1))
            {
                if(tower.type == Type.FARM)
                {
                    NotABloonsKnockoff.changeCash(tower.MoneyValue);
                }
                else if(tower.type == Type.POTION)
                {
                    for(int i = 0; i < towers.size(); i++)
                    {
                        if(towers.get(i).type != Type.WARIO && towers.get(i).type != Type.POTION && towers.get(i).type != Type.FARM)
                        {
                            if(towers.get(i).x < tower.x + tower.range && towers.get(i).x > tower.x - tower.range && towers.get(i).y < tower.y + tower.range && towers.get(i).y >tower.y - tower.range)
                            {
                                if(tower.BuffableTPersonal.size() != 0)
                                {
                                    //System.out.println(tower.BuffableTPersonal.size());
                                    //System.out.println("me");
                                    
                                    for(int gw = 0; gw < tower.BuffableTPersonal.size(); gw++)
                                    {
                                        if(towers.get(i) == tower.BuffableTPersonal.get(gw)) 
                                        {
                                            //System.out.println("monkey");
                                            //return;                                        
                                        }
                                        else
                                        {
                                            towers.get(i).BuffTower("Damage",tower.Damagebuff);
                                            tower.addBuffTower(towers.get(i));
                                            //System.out.println("bug");
                                        }
                                    }
                                }
                                else
                                {
                                    towers.get(i).BuffTower("Damage",tower.Damagebuff);
                                    tower.addBuffTower(towers.get(i));
                                    //System.out.println("be");
                                    //System.out.println("bug");
                                }
                                ////for the potion and wario towers/////ignore[[for towers that can be buffed, create an array of 
                                //buffertowers(towers that give buffs),each slot in the array wil have a null tower pointer.
                                //then make a for loop that goes through each existing tower. If the tower is a potion or wario 
                                //tower, then make a pointer in the array list point toward that tower.]] ////ignore                              
                                //create an array for buffedtowers(towers that can be buffed (so not support towers)),each slot in
                                //the array wil have a null tower pointer.
                                //then make a for loop that goes through each existing tower. If the tower is not a support 
                                //tower, then make a pointer in the array list point toward that tower.
                                //ignore[[Do the same with the wario/potion tower (make the array list, etc.)]]//ignore. 
                                //*****************************************************//*****************************************************
                                //create an array for buffedtowers(towers that can be buffed (so not support towers)),each slot in
                                //the array wil have a null tower pointer.
                                //then make a for loop that goes through each existing tower. If the tower is not a support 
                                //tower, then make a pointer in the array list point toward that tower.
                                //When the wario/Potion tower 
                                //is checking if there is a tower to buff in their range, there will be a quick check if any of
                                //the about to be buffed towers are already in the support tower's array list. If so, it will not
                                //buffed. 
                                //*****************************************************//*****************************************************
                            }
                        }
                    }
                }
            }
            if(tower.type == Type.WARIO)
            {
                for(int i = 0; i < towers.size(); i++)
                    {
                        if(towers.get(i).type != Type.WARIO && towers.get(i).type != Type.POTION && towers.get(i).type != Type.FARM)
                        {
                            if(towers.get(i).x < tower.x + tower.range && towers.get(i).x > tower.x - tower.range && towers.get(i).y < tower.y + tower.range && towers.get(i).y >tower.y - tower.range)
                            {
                                if(tower.BuffableTPersonal.size() != 0)
                                {
                                    //System.out.println(tower.BuffableTPersonal.size() + "W");
                                    //System.out.println("me");
                                    
                                    for(int gw = 0; gw < tower.BuffableTPersonal.size(); gw++)
                                    {
                                        if(towers.get(i) == tower.BuffableTPersonal.get(gw))
                                        {
                                            //System.out.println("monkey"  + "W");
                                            //return;                                        
                                        }
                                        else
                                        {
                                            towers.get(i).BuffTower("Damage",tower.Damagebuff);
                                            tower.addBuffTower(towers.get(i));
                                            //System.out.println("bug"  + "W");
                                        }
                                    }
                                }
                                else
                                {
                                    towers.get(i).BuffTower("Damage",tower.Damagebuff);
                                    tower.addBuffTower(towers.get(i));
                                    //System.out.println("be"  + "W");
                                }
                            }
                        }
                    }
            }
            
        }
    }
    
    private void changeCost(int _cost) {
        NotABloonsKnockoff.changeCash(_cost);
    }
    
    public static ArrayList<Tower> getTowers(){
        if(towers.size() != 0)
        {
            return towers;
        }
        else
        {
            return(null);
        }
    }
    
    public int getXpos() {
        return(x);
    }
    
    public int getYpos() {
        return(y);
    }
    
    public int getRange() {
        return(range);
    }
    
    public int getSelectRange() {
        return(SelectRange);
    }
    
    public double getCooldown() {
        return(AttackCooldown);
    }
    
    private void BuffTower(String _string, double _number) {
        if(_string == "Damage")
        {
            //if(damage + _number <= OriginalDamage + 30)
            {
                damage += _number;
                //System.out.println("bee");
            }
        }
        else if(_string == "AttackSpeed")
        {
            AttackCooldown -= (_number/10);
            //System.out.println("bee");
        }
        else if(_string == "MoarBanana")
        {
            AttackCooldown -= (_number/10);
            System.out.println("bee");
        }
        else if(_string == "RichBanana")
        {
            MoneyValue += _number;
            System.out.println("gee");
        }
        else if(_string == "MoarSpeed")
        {
            Speedbuff += _number;
            //System.out.println("bee");
        }
        else if(_string == "MoarDamage")
        {
            Damagebuff += _number;
            //System.out.println("bee");
        }
    }
    
    private void addBuffTower(Tower _toweradd) {
        BuffableTPersonal.add(_toweradd);
        //System.out.println("yee");
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
    
    
}
