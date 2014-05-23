package rallye;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import rallye.entities.Inscripcion;

public class ModeloTabla extends AbstractTableModel{
    List<Inscripcion> list;
    private final int COLUMNAS = 5;

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Escudería";
            case 1:
                return "Piloto";
            case 2:
                return "Categoría";
            case 3:
                return "Tiempo";
            case 4:
                return "Autorizado";
            default:
                return "";
        }
    }
    
    
    
    public void setDataList(List<Inscripcion> list){
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Inscripcion inscripcion =  list.get(rowIndex);
      switch(columnIndex){
          case 0:
              return inscripcion.getEscuderia(); 
          case 1:
              return inscripcion.getPiloto();
          case 2:
              return inscripcion.getCategoria();
          case 3:
              return inscripcion.getTiempo();
          case 4:
              return inscripcion.getAutorizado();
          default:
                return null;
      }
    }
    
}
