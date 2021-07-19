/*
 * LocaleDemo.java
 *
 * Created on 2006/10/16, 15:31
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package localedemo;

import java.util.List;
import java.util.Locale;

/**
 *
 * @author naoto
 */
public class LocaleDemo {
    
    public static void main(final String[] s) {
        System.out.println(java.util.Locale.getDefault());
        java.awt.EventQueue.invokeLater(() -> {
            new LocaleDemoUI().setVisible(true);
        });
    }
}
