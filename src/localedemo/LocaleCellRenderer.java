/*
 * Copyright (c) 2006, 2021, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
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

class LocaleCellRenderer extends JLabel implements ListCellRenderer<Object> {
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

        switch (item.getAdapterType()) {
            case JRE -> setIcon(LocaleDemoUI.dukeIcon);
            case CLDR -> setIcon(LocaleDemoUI.unicodeIcon);
            case HOST -> setIcon(LocaleDemoUI.hostIcon);
            case SPI -> setIcon(LocaleDemoUI.spiIcon);
            case FALLBACK -> setIcon(LocaleDemoUI.fallbackIcon);
        }
        return this;
    }
}
