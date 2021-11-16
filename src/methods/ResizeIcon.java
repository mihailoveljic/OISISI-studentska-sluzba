package methods;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ResizeIcon {
	
	//Preuzeto sa https://stackoverflow.com/questions/36957450/fit-size-of-an-imageicon-to-a-jbutton
	
	public static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	    Image img = icon.getImage();  
	    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}
}
