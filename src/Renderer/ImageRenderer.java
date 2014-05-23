
package Renderer;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class ImageRenderer  extends DefaultTableCellRenderer {
    //Centrar el contenido.
    public ImageRenderer() { 
        setHorizontalAlignment(SwingConstants.CENTER); 
    } 
    
    @Override
    protected void setValue(Object aValue) {
        System.out.println(aValue);
        if ((boolean)aValue == true) {
            setIcon(new ImageIcon( getClass().getResource("../icons/true.png")));
        }else{
            setIcon(new ImageIcon( getClass().getResource("../icons/false.png")));
        }
    }
}
