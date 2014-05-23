/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Renderer;

import java.text.SimpleDateFormat;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author usuario
 */
public class DateRenderer extends DefaultTableCellRenderer{
    
    public DateRenderer() { 
        setHorizontalAlignment(SwingConstants.CENTER); 
    } 
    
    @Override
    public void setValue(Object value) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        setText((value == null) ? "" : dateFormat.format(value));
    }
    
}
