
package notabloonsknockoff;
import java.awt.*;
import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
import java.io.*;
import javax.imageio.ImageIO;

public class Board {
    private static final File Map = new File("./MadeBTDMap.png");
    private static BufferedImage BI = null;
    public enum Placement {PATHWAY, GRASS};
    private static Placement blockE = null;
    private static Placement blockT = null;
    
    public static void getPCE(int x, int y) {
        
            try{
               BI = ImageIO.read(Map);
           }catch(IOException e){}      
         
            if(x < 700)
            {
                int zcolor = BI.getRGB(x,y);
                //Color col = new Color(zcolor);
                //int g = (zcolor>>8) & 0xff;

                if(((zcolor>>8)&0xff) > 200)
                {
                    blockE = Placement.GRASS;
                }
                else if (((zcolor>>24)&0xff) > 200)
                {
                    blockE = Placement.PATHWAY;

                }
                else
                {
                    blockE = null;
                }
            }
        
    }
    
    public static void getPCT(int x, int y) {
        
            try{
               BI = ImageIO.read(Map);
           }catch(IOException e){}      
         
            if(x < 700)
            {
                int zcolor = BI.getRGB(x,y);
                //Color col = new Color(zcolor);
                //int g = (zcolor>>8) & 0xff;

                if(((zcolor>>8)&0xff) > 200)
                {
                    blockT = Placement.GRASS;
                }
                else if (((zcolor>>24)&0xff) > 200)
                {
                    blockT = Placement.PATHWAY;

                }
                else
                {
                    blockT = null;
                }
            }
        
    }
    
    public static Placement getBlockE() {
        return(blockE);
    }
    
    public static Placement getBlockT() {
        return(blockT);
    }
    
    public static int ReternPC(int x, int y)
    {
         try{
            BI = ImageIO.read(Map);
        }catch(IOException e){}
         
        int zcolor = BI.getRGB(x,y);
        return(zcolor);
    }
    
    public static Placement ReternFuturePCE(int x, int y)
    {   
        getPCE(x,y);
        return(blockE);
    }
}
