
package Renderer;

import java.text.SimpleDateFormat;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class TimeRenderer extends DefaultTableCellRenderer{
   
    public TimeRenderer() { 
        setHorizontalAlignment(SwingConstants.CENTER); 
    } 
    
    @Override
    public void setValue(Object value) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss.SSS");

        setText((value == null) ? "" : timeFormat.format(value));
    }
}
