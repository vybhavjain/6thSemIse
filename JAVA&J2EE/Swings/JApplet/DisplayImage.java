import java.awt.*;  
import java.applet.*;  
  
  
public class DisplayImage extends Applet {  
  
  Image picture;  
  
  public void init() {  
    picture = getImage(getDocumentBase(),"C:\\Users\\Admin\\Desktop\\Java Prgms\\Swings\\JApplet\\java.jpg");  
  }  
    
  public void paint(Graphics g) {  
    g.drawImage(picture, 30,30, this);  
  }  
      
  }  