
package Otras_Clases;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class Clase_CellRender extends JCheckBox implements TableCellRenderer{
    private final JComponent component = new JCheckBox();

    /** Constructor de clase */
    public Clase_CellRender() {
        setOpaque(true);
    }

    @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
      //Color de fondo de la celda
      ( (JCheckBox) component).setBackground( new Color(167,218,251) );//[167,218,251]
      
      //obtiene valor boolean y coloca valor en el JCheckBox
      boolean b = ((Boolean) value).booleanValue();
      ( (JCheckBox) component).setSelected( b );
      
      return ( (JCheckBox) component);
  }
}
