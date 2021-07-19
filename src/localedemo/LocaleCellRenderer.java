/*
 * LocaleCellRenderer.java
 *
 * Created on 2007/04/20, 11:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package localedemo;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

class LocaleCellRenderer extends JLabel implements ListCellRenderer {
    public LocaleCellRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList list,
                                                  Object value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        LocaleItem item = (LocaleItem) value;
        setText(item.toString());
/*
        Set<LocaleItem> newLocales = PigDemo.this.newLocales;
        if (newLocales.contains(item)) {
            setForeground(Color.BLUE);
            setIcon(PigDemo.dukeIcon);
        } else if (!newLocales.isEmpty()) {
            setIcon(PigDemo.javaIcon);
        } else {
            // When there are no remote locales, remote the icons.
            setIcon(null);
        }
        LocaleItem current = PigDemo.this.current;
        ComponentOrientation o = current.getOrientation();
        applyComponentOrientation(o);
 
        if (item.isJRELocale()) {
            setIcon(LocaleDemoUI.dukeIcon);
        } else {
            setIcon(LocaleDemoUI.unicodeIcon);
        }
*/
        switch (item.getAdapterType()) {
            case JRE:
                setIcon(LocaleDemoUI.dukeIcon);
                break;
            case CLDR:
                setIcon(LocaleDemoUI.unicodeIcon);
                break;
            case HOST:
                setIcon(LocaleDemoUI.hostIcon);
                break;
            case SPI:
                setIcon(LocaleDemoUI.spiIcon);
	        break;
	    case FALLBACK:
		setIcon(LocaleDemoUI.fallbackIcon);
                break;
        }
        return this;
    }
}
