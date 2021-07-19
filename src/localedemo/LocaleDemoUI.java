/*
 * LocaleDemoUI.java
 *
 * Created on 2006/10/16, 15:07
 */

package localedemo;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.time.*;
import java.time.chrono.*;
import java.time.format.*;
import java.time.temporal.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 *
 * @author  naoto
 */
public class LocaleDemoUI extends javax.swing.JFrame {

    private final int CUSTOM_STYLE = 1000; // for SimpleDateFormat
    private int dateTimeStyle = DateFormat.FULL;
    private DateFormat df = DateFormat.getDateTimeInstance(dateTimeStyle, dateTimeStyle, Locale.getDefault());

    // for 310
    private DateTimeFormatter izdt = DateTimeFormatter.ISO_ZONED_DATE_TIME.withLocale(Locale.getDefault());
    private DateTimeFormatter ldd = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.getDefault());
    private DateTimeFormatter ldt = DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL).withLocale(Locale.getDefault());
    private DateTimeFormatter pdt = DateTimeFormatter.ofPattern("", Locale.getDefault());
    private DateTimeFormatter rfc1123dt = DateTimeFormatter.RFC_1123_DATE_TIME.withLocale(Locale.getDefault());
    private Chronology chrono = Chronology.ofLocale(Locale.getDefault());
    private final Chronology[] availChronos = Chronology.getAvailableChronologies().toArray(new Chronology[0]);

    private final javax.swing.Timer dateTimeTimer;

    private final LocaleItem[] liArray = new LocaleItem[Locale.getAvailableLocales().length];
    private final Map<String, TimeZone> tzMap = new HashMap<>();

    // icons
    static final ImageIcon dukeIcon
        = new ImageIcon(Toolkit.getDefaultToolkit()
                        .createImage(LocaleDemoUI.class.getClassLoader()
                                     .getResource("localedemo/images/intl-duke45.gif")));
    static final ImageIcon unicodeIcon
        = new ImageIcon(Toolkit.getDefaultToolkit()
                        .createImage(LocaleDemoUI.class.getClassLoader()
                                     .getResource("localedemo/images/unicode.gif")));

    static final ImageIcon hostIcon
        = new ImageIcon(Toolkit.getDefaultToolkit()
                        .createImage(LocaleDemoUI.class.getClassLoader()
                                     .getResource("localedemo/images/host.jpg")));

    static final ImageIcon spiIcon
        = new ImageIcon(Toolkit.getDefaultToolkit()
                        .createImage(LocaleDemoUI.class.getClassLoader()
                                     .getResource("localedemo/images/spi.jpg")));
    static final ImageIcon fallbackIcon
        = new ImageIcon(Toolkit.getDefaultToolkit()
                        .createImage(LocaleDemoUI.class.getClassLoader()
                                     .getResource("localedemo/images/fallback.png")));

    private static final int NUMBERSTYLE   = 0;
    private static final int INTEGERSTYLE  = 1;
    private static final int CURRENCYSTYLE = 2;
    private static final int PERCENTSTYLE  = 3;
    private int numberStyle = NUMBERSTYLE;

    private static final int DATETIMEPANEL     = 0;
    private static final int NUMBERPANEL       = 1;
    private static final int LOCALENAMEPANEL   = 2;
    private static final int CURRENCYNAMEPANEL = 3;
    private static final int TZNAMEPANEL       = 4;
    private static final int THREETENPANEL     = 5;
    private int currentPanel;

    /** Creates new form LocaleDemoUI */
    public LocaleDemoUI() {
        this.dateTimeTimer = new javax.swing.Timer(1000, (ActionEvent ae) -> {
            switch (currentPanel) {
                case DATETIMEPANEL:
                    drawDateTimeFormatText();
                    break;
                case THREETENPANEL:
                    draw310Text();
                    break;
            }
        });
        initComponents();
        dateTimeTimer.start();
        Arrays.sort(liArray);

        TableRowSorter<TableModel> trs = new TableRowSorter<>(jTable1.getModel());
        trs.toggleSortOrder(0);
        trs.setSortsOnUpdates(true);
        jTable1.setRowSorter(trs);

        String[] availTZ = TimeZone.getAvailableIDs();
        for (String tz: availTZ) {
            tzMap.put(tz, TimeZone.getTimeZone(tz));
        }

        trs = new TableRowSorter<>(jTable2.getModel());
        trs.toggleSortOrder(0);
        trs.setSortsOnUpdates(true);
        jTable2.setRowSorter(trs);

        trs = new TableRowSorter<>(jTable3.getModel());
        trs.toggleSortOrder(0);
        trs.setSortsOnUpdates(true);
        jTable3.setRowSorter(trs);

        jTable1.setRowHeight(28);
        jTable2.setRowHeight(28);
        jTable3.setRowHeight(28);

        ((TitledBorder)(jPanel3.getBorder())).setTitle("Number of Available Locales: " + liArray.length);

        refreshPanel(currentPanel);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                buttonGroup1 = new javax.swing.ButtonGroup();
                buttonGroup2 = new javax.swing.ButtonGroup();
                buttonGroup3 = new javax.swing.ButtonGroup();
                Locale[] avail = Locale.getAvailableLocales();

                for (int i = 0; i < avail.length; i ++) {
                        liArray[i] = new LocaleItem(avail[i]);
                }
                Arrays.sort(liArray);
                localeComboBox = new JComboBox(liArray);
                ;
                localeComboBox.setSelectedItem(new LocaleItem(Locale.getDefault()));
                localeComboBox.setRenderer(new LocaleCellRenderer());
                jLabel1 = new javax.swing.JLabel();
                functionTabPane = new javax.swing.JTabbedPane();
                jPanel1 = new javax.swing.JPanel();
                jPanel7 = new javax.swing.JPanel();
                jRadioButton1 = new javax.swing.JRadioButton();
                jRadioButton2 = new javax.swing.JRadioButton();
                jRadioButton3 = new javax.swing.JRadioButton();
                jRadioButton4 = new javax.swing.JRadioButton();
                jRadioButton9 = new javax.swing.JRadioButton();
                jTextField2 = new javax.swing.JTextField();
                jPanel8 = new javax.swing.JPanel();
                jLabel2 = new javax.swing.JLabel();
                jPanel13 = new javax.swing.JPanel();
                jScrollPane4 = new javax.swing.JScrollPane();
                jList1 = new JList(new DefaultListModel());
                jPanel14 = new javax.swing.JPanel();
                jScrollPane5 = new javax.swing.JScrollPane();
                jList2 = new JList(new DefaultListModel());
                jLabel8 = new javax.swing.JLabel();
                jLabel9 = new javax.swing.JLabel();
                jLabel10 = new javax.swing.JLabel();
                jLabel11 = new javax.swing.JLabel();
                jLabel12 = new javax.swing.JLabel();
                jLabel13 = new javax.swing.JLabel();
                jPanel2 = new javax.swing.JPanel();
                jLabel3 = new javax.swing.JLabel();
                jTextField1 = new javax.swing.JTextField();
                jPanel9 = new javax.swing.JPanel();
                jRadioButton5 = new javax.swing.JRadioButton();
                jRadioButton6 = new javax.swing.JRadioButton();
                jRadioButton7 = new javax.swing.JRadioButton();
                jRadioButton8 = new javax.swing.JRadioButton();
                jPanel10 = new javax.swing.JPanel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                jLabel7 = new javax.swing.JLabel();
                jLabel14 = new javax.swing.JLabel();
                jLabel15 = new javax.swing.JLabel();
                jLabel16 = new javax.swing.JLabel();
                jLabel17 = new javax.swing.JLabel();
                jLabel18 = new javax.swing.JLabel();
                jLabel19 = new javax.swing.JLabel();
                jLabel20 = new javax.swing.JLabel();
                jLabel21 = new javax.swing.JLabel();
                jLabel22 = new javax.swing.JLabel();
                jLabel23 = new javax.swing.JLabel();
                jLabel24 = new javax.swing.JLabel();
                jLabel25 = new javax.swing.JLabel();
                jPanel4 = new javax.swing.JPanel();
                jPanel3 = new javax.swing.JPanel();
                jScrollPane1 = new javax.swing.JScrollPane();
                jTable3 = new javax.swing.JTable();
                jLabel27 = new javax.swing.JLabel();
                jTextField3 = new javax.swing.JTextField();
                jLabel29 = new javax.swing.JLabel();
                jLabel34 = new javax.swing.JLabel();
                jPanel5 = new javax.swing.JPanel();
                jPanel11 = new javax.swing.JPanel();
                jScrollPane2 = new javax.swing.JScrollPane();
                jTable1 = new javax.swing.JTable();
                jPanel6 = new javax.swing.JPanel();
                jPanel12 = new javax.swing.JPanel();
                jScrollPane3 = new javax.swing.JScrollPane();
                jTable2 = new javax.swing.JTable();
                jPanel15 = new javax.swing.JPanel();
                jLabel26 = new javax.swing.JLabel();
                isoZoneDateTimeLabel = new javax.swing.JLabel();
                jLabel28 = new javax.swing.JLabel();
                localizedDateTimeLabel = new javax.swing.JLabel();
                Arrays.sort(availChronos);
                chronoComboBox = new javax.swing.JComboBox(availChronos);
                jLabel30 = new javax.swing.JLabel();
                jLabel31 = new javax.swing.JLabel();
                patternField = new javax.swing.JTextField();
                jLabel32 = new javax.swing.JLabel();
                jLabel33 = new javax.swing.JLabel();
                patternLabel = new javax.swing.JLabel();
                rfc1123Label = new javax.swing.JLabel();
                localeInstalledButton = new javax.swing.JRadioButton();
                localeCustomButton = new javax.swing.JRadioButton();
                langTagField = new javax.swing.JTextField();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("Locale Demo");

                localeComboBox.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                localeComboBox.setMaximumRowCount(16);
                localeComboBox.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                localeItemStateChanged(evt);
                        }
                });
                localeComboBox.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                localeComboBoxActionPerformed(evt);
                        }
                });

                jLabel1.setText("Locale:");

                functionTabPane.addChangeListener(new javax.swing.event.ChangeListener() {
                        public void stateChanged(javax.swing.event.ChangeEvent evt) {
                                functionTabPaneStateChanged(evt);
                        }
                });

                jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Style"));

                buttonGroup1.add(jRadioButton1);
                jRadioButton1.setSelected(true);
                jRadioButton1.setText("Full");
                jRadioButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
                jRadioButton1.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                dateTimeStyleChanged(evt);
                        }
                });

                buttonGroup1.add(jRadioButton2);
                jRadioButton2.setText("Long");
                jRadioButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
                jRadioButton2.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                dateTimeStyleChanged(evt);
                        }
                });

                buttonGroup1.add(jRadioButton3);
                jRadioButton3.setText("Medium");
                jRadioButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
                jRadioButton3.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                dateTimeStyleChanged(evt);
                        }
                });

                buttonGroup1.add(jRadioButton4);
                jRadioButton4.setText("Short");
                jRadioButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
                jRadioButton4.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                dateTimeStyleChanged(evt);
                        }
                });

                buttonGroup1.add(jRadioButton9);
                jRadioButton9.setText("Custom");
                jRadioButton9.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                dateTimeStyleChanged(evt);
                        }
                });

                jTextField2.setText("MM/dd/yy HH:mm:ss");
                jTextField2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jTextField2ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
                jPanel7.setLayout(jPanel7Layout);
                jPanel7Layout.setHorizontalGroup(
                        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jRadioButton1)
                                .addGap(37, 37, 37)
                                .addComponent(jRadioButton2)
                                .addGap(34, 34, 34)
                                .addComponent(jRadioButton3)
                                .addGap(35, 35, 35)
                                .addComponent(jRadioButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel7Layout.setVerticalGroup(
                        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton1)
                                        .addComponent(jRadioButton2)
                                        .addComponent(jRadioButton3)
                                        .addComponent(jRadioButton4)
                                        .addComponent(jRadioButton9)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Formatted Date and Time"));

                jLabel2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N

                javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
                jPanel8.setLayout(jPanel8Layout);
                jPanel8Layout.setHorizontalGroup(
                        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
                                .addContainerGap())
                );
                jPanel8Layout.setVerticalGroup(
                        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                );

                jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Month names"));

                jList1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                jScrollPane4.setViewportView(jList1);

                javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
                jPanel13.setLayout(jPanel13Layout);
                jPanel13Layout.setHorizontalGroup(
                        jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                );
                jPanel13Layout.setVerticalGroup(
                        jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                );

                jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Day names"));

                jList2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                jScrollPane5.setViewportView(jList2);

                javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
                jPanel14.setLayout(jPanel14Layout);
                jPanel14Layout.setHorizontalGroup(
                        jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                );
                jPanel14Layout.setVerticalGroup(
                        jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                );

                jLabel8.setText("Eras: ");

                jLabel9.setText("AM, PM:");

                jLabel10.setText("LocalPatternChars:");

                jLabel11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

                jLabel12.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(11, 11, 11)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)))
                                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE))
                                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );

                functionTabPane.addTab("Date and Time", jPanel1);

                jLabel3.setText("Number to format: ");

                jTextField1.setText("1234567.89");
                jTextField1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jTextField1ActionPerformed(evt);
                        }
                });

                jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Style"));

                buttonGroup2.add(jRadioButton5);
                jRadioButton5.setSelected(true);
                jRadioButton5.setText("Number");
                jRadioButton5.setToolTipText("Generic Number formatting");
                jRadioButton5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
                jRadioButton5.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                numberStyleChanged(evt);
                        }
                });

                buttonGroup2.add(jRadioButton6);
                jRadioButton6.setText("Integer");
                jRadioButton6.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
                jRadioButton6.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                numberStyleChanged(evt);
                        }
                });

                buttonGroup2.add(jRadioButton7);
                jRadioButton7.setText("Currency");
                jRadioButton7.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
                jRadioButton7.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                numberStyleChanged(evt);
                        }
                });

                buttonGroup2.add(jRadioButton8);
                jRadioButton8.setText("Percent");
                jRadioButton8.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
                jRadioButton8.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                numberStyleChanged(evt);
                        }
                });

                javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
                jPanel9.setLayout(jPanel9Layout);
                jPanel9Layout.setHorizontalGroup(
                        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jRadioButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton8)
                                .addContainerGap(770, Short.MAX_VALUE))
                );
                jPanel9Layout.setVerticalGroup(
                        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton5)
                                        .addComponent(jRadioButton6)
                                        .addComponent(jRadioButton7)
                                        .addComponent(jRadioButton8))
                                .addContainerGap(33, Short.MAX_VALUE))
                );

                jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Formatted Number"));

                jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

                jLabel5.setText("Positive number: ");

                jLabel6.setText("Negative number: ");

                jLabel7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

                javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
                jPanel10.setLayout(jPanel10Layout);
                jPanel10Layout.setHorizontalGroup(
                        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                                .addContainerGap())
                );
                jPanel10Layout.setVerticalGroup(
                        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jLabel14.setText("Exponent Separator:");

                jLabel15.setText("Infinity:");

                jLabel16.setText("NaN:");

                jLabel17.setText("Pattern Separator:");

                jLabel18.setText("Per Mille:");

                jLabel19.setText("Zero Digit:");

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel17)
                                                        .addComponent(jLabel16)
                                                        .addComponent(jLabel15)
                                                        .addComponent(jLabel14)
                                                        .addComponent(jLabel18)
                                                        .addComponent(jLabel19))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                                                        .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                                                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                                                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                                                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                                                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))))
                                .addContainerGap())
                );
                jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel14)
                                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel15)
                                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel16)
                                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel17)
                                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel18)
                                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(336, 336, 336))
                );

                functionTabPane.addTab("Number formats", jPanel2);

                jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

                jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18))); // NOI18N

                jTable3.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                                "Locale ID", "Name"
                        }
                ) {
                        Class[] types = new Class [] {
                                java.lang.String.class, java.lang.String.class
                        };
                        boolean[] canEdit = new boolean [] {
                                false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types [columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                jScrollPane1.setViewportView(jTable3);

                jLabel27.setText("Custom: ");

                jTextField3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jTextField3ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(41, 41, 41)
                                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 227, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1))
                                .addContainerGap())
                );
                jPanel3Layout.setVerticalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel29)
                                        .addComponent(jLabel34))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );

                javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );
                jPanel4Layout.setVerticalGroup(
                        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );

                functionTabPane.addTab("Locale names", jPanel4);

                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                                "Code", "Country", "Currency Symbol", "Numeric Code", "Default Fraction Digits", "Display Name"
                        }
                ) {
                        Class[] types = new Class [] {
                                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
                        };
                        boolean[] canEdit = new boolean [] {
                                false, false, false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types [columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                jScrollPane2.setViewportView(jTable1);

                javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
                jPanel11.setLayout(jPanel11Layout);
                jPanel11Layout.setHorizontalGroup(
                        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE))
                );
                jPanel11Layout.setVerticalGroup(
                        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                );

                javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
                jPanel5.setLayout(jPanel5Layout);
                jPanel5Layout.setHorizontalGroup(
                        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );
                jPanel5Layout.setVerticalGroup(
                        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );

                functionTabPane.addTab("Currency names", jPanel5);

                jTable2.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                                "TimeZone ID", "Long", "Short", "Long(DST)", "Short(DST)", "Long(Generic)", "Short(Generic)"
                        }
                ) {
                        Class[] types = new Class [] {
                                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                        };
                        boolean[] canEdit = new boolean [] {
                                false, false, false, false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types [columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                jScrollPane3.setViewportView(jTable2);

                javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
                jPanel12.setLayout(jPanel12Layout);
                jPanel12Layout.setHorizontalGroup(
                        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE))
                );
                jPanel12Layout.setVerticalGroup(
                        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                );

                javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
                jPanel6.setLayout(jPanel6Layout);
                jPanel6Layout.setHorizontalGroup(
                        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );
                jPanel6Layout.setVerticalGroup(
                        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );

                functionTabPane.addTab("TimeZone names", jPanel6);

                jLabel26.setText("isoZoneDateTime:");

                jLabel28.setText("localizedDateTime:");

                selectChrono();
                chronoComboBox.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                chronoStateChanged(evt);
                        }
                });

                jLabel30.setText("Chronology:");

                jLabel31.setText("Pattern:");

                patternField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                patternFieldActionPerformed(evt);
                        }
                });

                jLabel32.setText("pattern:");

                jLabel33.setText("rfc1123");

                javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
                jPanel15.setLayout(jPanel15Layout);
                jPanel15Layout.setHorizontalGroup(
                        jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addComponent(chronoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(patternField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(isoZoneDateTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(localizedDateTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(rfc1123Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                                .addComponent(patternLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(454, Short.MAX_VALUE))
                );
                jPanel15Layout.setVerticalGroup(
                        jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(chronoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel30)
                                        .addComponent(jLabel31)
                                        .addComponent(patternField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel26)
                                        .addComponent(isoZoneDateTimeLabel))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel28)
                                        .addComponent(localizedDateTimeLabel))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel32)
                                        .addComponent(patternLabel))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel33)
                                        .addComponent(rfc1123Label))
                                .addContainerGap(304, Short.MAX_VALUE))
                );

                functionTabPane.addTab("310", jPanel15);

                buttonGroup3.add(localeInstalledButton);
                localeInstalledButton.setSelected(true);
                localeInstalledButton.setText("Installed");
                localeInstalledButton.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                localeInstalledButtonItemStateChanged(evt);
                        }
                });
                localeInstalledButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                localeInstalledButtonActionPerformed(evt);
                        }
                });

                buttonGroup3.add(localeCustomButton);
                localeCustomButton.setText("Custom");
                localeCustomButton.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                localeCustomButtonItemStateChanged(evt);
                        }
                });
                localeCustomButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                localeCustomButtonActionPerformed(evt);
                        }
                });

                langTagField.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                langTagFieldActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(functionTabPane)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(localeInstalledButton)
                                                        .addComponent(localeCustomButton))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(localeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(langTagField, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(localeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(localeInstalledButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(langTagField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(localeCustomButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(functionTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 509, Short.MAX_VALUE)
                                .addContainerGap())
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void localeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localeComboBoxActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_localeComboBoxActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        refreshPanel(NUMBERPANEL);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void functionTabPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_functionTabPaneStateChanged
        dateTimeTimer.stop();
        currentPanel = functionTabPane.getSelectedIndex();
        switch (currentPanel) {
            case DATETIMEPANEL:
            case THREETENPANEL:
                dateTimeTimer.start();
                break;
        }
        refreshPanel(currentPanel);
    }//GEN-LAST:event_functionTabPaneStateChanged

    private void dateTimeStyleChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dateTimeStyleChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            JRadioButton selected = (JRadioButton)evt.getItem();
            String buttonText = selected.getText();
            switch (buttonText) {
                case "Full":
                    dateTimeStyle = DateFormat.FULL;
                    break;
                case "Long":
                    dateTimeStyle = DateFormat.LONG;
                    break;
                case "Medium":
                    dateTimeStyle = DateFormat.MEDIUM;
                    break;
                case "Short":
                    dateTimeStyle = DateFormat.SHORT;
                    break;
                case "Custom":
                    dateTimeStyle = CUSTOM_STYLE;
                    break;                    
            }

            refreshPanel(DATETIMEPANEL);
        }
    }//GEN-LAST:event_dateTimeStyleChanged

    private void numberStyleChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_numberStyleChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            JRadioButton selected = (JRadioButton)evt.getItem();
            String buttonText = selected.getText();
            switch (buttonText) {
                case "Number":
                    numberStyle = NUMBERSTYLE;
                    break;
                case "Integer":
                    numberStyle = INTEGERSTYLE;
                    break;
                case "Currency":
                    numberStyle = CURRENCYSTYLE;
                    break;
                case "Percent":
                    numberStyle = PERCENTSTYLE;
                    break;
            }

            refreshPanel(NUMBERPANEL);
        }
    }//GEN-LAST:event_numberStyleChanged

    private void localeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_localeItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (localeInstalledButton.isSelected()) {
                chrono = Chronology.ofLocale(currentLocale());
                selectChrono();
                refreshPanel(currentPanel);
            } else {
                localeInstalledButton.setSelected(true);
            }
        }
    }//GEN-LAST:event_localeItemStateChanged

    private void chronoStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chronoStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            chrono = (Chronology)evt.getItem();
            refreshPanel(currentPanel);
        }
    }//GEN-LAST:event_chronoStateChanged

    private void patternFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patternFieldActionPerformed
        // TODO add your handling code here:
        pdt = DateTimeFormatter.ofPattern(patternField.getText(), currentLocale());
    }//GEN-LAST:event_patternFieldActionPerformed

        private void localeCustomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localeCustomButtonActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_localeCustomButtonActionPerformed

        private void localeInstalledButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localeInstalledButtonActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_localeInstalledButtonActionPerformed

        private void localeInstalledButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_localeInstalledButtonItemStateChanged
                // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            chrono = Chronology.ofLocale(currentLocale());
            selectChrono();
            refreshPanel(currentPanel);
        }
        }//GEN-LAST:event_localeInstalledButtonItemStateChanged

        private void localeCustomButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_localeCustomButtonItemStateChanged
                // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            chrono = Chronology.ofLocale(currentLocale());
            selectChrono();
            refreshPanel(currentPanel);
        }
        }//GEN-LAST:event_localeCustomButtonItemStateChanged

        private void langTagFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langTagFieldActionPerformed
            // TODO add your handling code here:
            if (localeCustomButton.isSelected()) {
                chrono = Chronology.ofLocale(currentLocale());
                selectChrono();
                refreshPanel(currentPanel);
            } else {
                localeCustomButton.setSelected(true);
            }
        }//GEN-LAST:event_langTagFieldActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        refreshPanel(currentPanel);
    }//GEN-LAST:event_jTextField2ActionPerformed

        private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
                // TODO add your handling code here:
		jLabel34.setText(Locale.forLanguageTag(jTextField3.getText()).getDisplayName());
        }//GEN-LAST:event_jTextField3ActionPerformed

    private Locale currentLocale() {
        Locale l;

        if (localeInstalledButton.isSelected()) {
            LocaleItem li = (LocaleItem)localeComboBox.getSelectedItem();
            l = li.getLocale();
        } else {
            l = Locale.forLanguageTag(langTagField.getText());
        }

        System.out.println(l);
        return l;
    }

    private void refreshPanel(int index) {
        Locale l = currentLocale();
        functionTabPane.getSelectedComponent().applyComponentOrientation(ComponentOrientation.getOrientation(l));

        switch (index) {
            case DATETIMEPANEL:
                if (dateTimeStyle == CUSTOM_STYLE) {
                    df = new SimpleDateFormat(jTextField2.getText(), l);
                } else {
                    df = DateFormat.getDateTimeInstance(dateTimeStyle, dateTimeStyle, l);
                }
                drawDateTimeSymbols(l);
                drawDateTimeFormatText();
                break;
            case NUMBERPANEL:
                String num = jTextField1.getText();
//                NumberFormat nfParse = NumberFormat.getNumberInstance();
                NumberFormat nfParse = new DecimalFormat("#,##0.###", new DecimalFormatSymbols());

                Number n;
                Number m;

                try {
                    n = nfParse.parse(num);
                    m = nfParse.parse("-"+num);
                } catch (ParseException ex) {
                    jTextField1.setText("");
                    break;
                }

                NumberFormat nf;
                switch (numberStyle) {
                    default:
                    case NUMBERSTYLE:
                        nf = NumberFormat.getNumberInstance(l);
                        break;
                    case INTEGERSTYLE:
                        nf = NumberFormat.getIntegerInstance(l);
                        break;
                    case CURRENCYSTYLE:
                        nf = NumberFormat.getCurrencyInstance(l);
                        break;
                    case PERCENTSTYLE:
                        nf = NumberFormat.getPercentInstance(l);
                        break;
                }
                jLabel4.setText(nf.format(n));
                jLabel7.setText(nf.format(m));
                if (nf instanceof DecimalFormat) {
                    DecimalFormatSymbols dfs = ((DecimalFormat)nf).getDecimalFormatSymbols();
                    jLabel20.setText(dfs.getExponentSeparator());
                    jLabel21.setText(dfs.getInfinity());
                    jLabel22.setText(dfs.getNaN());
                    jLabel23.setText(Character.toString(dfs.getPatternSeparator()));
                    jLabel24.setText(Character.toString(dfs.getPerMill()));
                    jLabel25.setText(Character.toString(dfs.getZeroDigit()));
                }
                break;
            case LOCALENAMEPANEL:
                DefaultTableModel dtm = (DefaultTableModel)jTable3.getModel();
                dtm.setRowCount(0);
                String[] row = new String[2];
                for (LocaleItem locItem: liArray) {
                    Locale curLocale = locItem.getLocale();
                    row[0] = curLocale.toString();
                    row[1] = curLocale.getDisplayName(l);
                    dtm.insertRow(0, row);
                }
                break;
            case CURRENCYNAMEPANEL:
                dtm = (DefaultTableModel)jTable1.getModel();
                dtm.setRowCount(0);
                row = new String[6];
                String[] isoCtries = Locale.getISOCountries();
                Arrays.sort(isoCtries);
                for (Currency c: Currency.getAvailableCurrencies()) {
                    String code = c.getCurrencyCode();
                    String ctry = code.substring(0, 2);
                    row[0] = code;
                    row[1] = (Arrays.binarySearch(isoCtries, ctry) >= 0 ?
                              new Locale("", ctry).getDisplayCountry(l) :"(n/a)");
                    row[2] = c.getSymbol(l);
                    row[3] = Integer.toString(c.getNumericCode());
                    row[4] = Integer.toString(c.getDefaultFractionDigits());
                    row[5] = c.getDisplayName(l);
                    dtm.insertRow(0, row);
                }
                break;
            case TZNAMEPANEL:
                Set<String> tzs = tzMap.keySet();
                dtm = (DefaultTableModel)jTable2.getModel();
                dtm.setRowCount(0);
                row = new String[7];
                for (String id: tzs) {
                    row[0] = id;
                    row[1] = tzMap.get(id).getDisplayName(false, TimeZone.LONG, l);
                    row[2] = tzMap.get(id).getDisplayName(false, TimeZone.SHORT, l);
                    row[3] = tzMap.get(id).getDisplayName(true, TimeZone.LONG, l);
                    row[4] = tzMap.get(id).getDisplayName(true, TimeZone.SHORT, l);
                    row[5] = tzMap.get(id).toZoneId().getDisplayName(TextStyle.FULL, l);
                    row[6] = tzMap.get(id).toZoneId().getDisplayName(TextStyle.SHORT, l);
                    dtm.insertRow(0, row);
                }
                break;
            case THREETENPANEL:
                izdt = izdt.withLocale(l).withChronology(chrono);
                ldd = ldd.withLocale(l).withChronology(chrono);
                ldt = ldt.withLocale(l).withChronology(chrono);
                pdt = DateTimeFormatter.ofPattern(patternField.getText()).withLocale(l);
                rfc1123dt = rfc1123dt.withLocale(l);
                draw310Text();
                break;
        }
    }

    private void drawDateTimeFormatText() {
        Date d = new Date();
        jLabel2.setText(df.format(d));
    }

    private void drawDateTimeSymbols(Locale l) {
        DefaultListModel dlm1 = (DefaultListModel)jList1.getModel();
        DefaultListModel dlm2 = (DefaultListModel)jList2.getModel();
        dlm1.clear();
        dlm2.clear();
        jLabel11.setText("");
        jLabel12.setText("");
        jLabel13.setText("");

        if (df instanceof SimpleDateFormat) {
            DateFormatSymbols dfs = ((SimpleDateFormat)df).getDateFormatSymbols();
            Calendar cal = df.getCalendar();
            String[] sa;
            Map<String, Integer> map;
                map = cal.getDisplayNames(Calendar.ERA, (dateTimeStyle == DateFormat.FULL ? Calendar.LONG : Calendar.SHORT), l);
            if (map != null) {
                StringBuilder sb = new StringBuilder();
                Map<Integer, String> revmap = new HashMap<>();
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    revmap.put(entry.getValue(), entry.getKey());
                }
                for (int index = 0; index < revmap.size(); index ++) {
                    sb.append(revmap.get(index)).append("  ");
                }
                jLabel11.setText(sb.toString());
                sa = dfs.getAmPmStrings();
                jLabel12.setText(sa[0]+", "+sa[1]);
                jLabel13.setText(dfs.getLocalPatternChars());
                String[] sa2;
                if (dateTimeStyle == DateFormat.FULL || dateTimeStyle == DateFormat.LONG) {
                    sa = dfs.getMonths();
                    sa2 = dfs.getWeekdays();
                } else {
                    sa = dfs.getShortMonths();
                    sa2 = dfs.getShortWeekdays();
                }

                for (String s: sa) {
                    dlm1.addElement(s);
                }
                for (int index = cal.getFirstDayOfWeek(); ;) {
                    dlm2.addElement(sa2[index]);
                    index = (index == Calendar.SATURDAY ? Calendar.SUNDAY : index+1);
                    if (index == cal.getFirstDayOfWeek()) {
                        break;
                    }
                }
            }
        }
    }

    private void draw310Text() {
        TemporalAccessor taDateTime = ZonedDateTime.now();
        TemporalAccessor taChronoDate = taDateTime;
        if (chrono instanceof JapaneseChronology) {
            taChronoDate = ((JapaneseChronology)chrono).dateNow();
        } else if (chrono instanceof ThaiBuddhistChronology) {
            taChronoDate = ((ThaiBuddhistChronology)chrono).dateNow();
//        } else if (chrono instanceof HijrahChrono) {
//            taChronoDate = ((HijrahChrono)chrono).dateNow();
        }
        isoZoneDateTimeLabel.setText(izdt.format(taDateTime));
        localizedDateTimeLabel.setText(ldd.format(taChronoDate) + " " + ldt.format(taDateTime));
        patternLabel.setText(pdt.format(taDateTime));
        rfc1123Label.setText(rfc1123dt.format(taDateTime));
    }

    private void selectChrono() {
        for (int chronoIndex = 0; chronoIndex < availChronos.length; chronoIndex++) {
            if (availChronos[chronoIndex].equals(chrono)) {
System.out.println(availChronos[chronoIndex]);
                chronoComboBox.setSelectedIndex(chronoIndex);
                break;
            }
        }
    }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.ButtonGroup buttonGroup1;
        private javax.swing.ButtonGroup buttonGroup2;
        private javax.swing.ButtonGroup buttonGroup3;
        private javax.swing.JComboBox chronoComboBox;
        private javax.swing.JTabbedPane functionTabPane;
        private javax.swing.JLabel isoZoneDateTimeLabel;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel12;
        private javax.swing.JLabel jLabel13;
        private javax.swing.JLabel jLabel14;
        private javax.swing.JLabel jLabel15;
        private javax.swing.JLabel jLabel16;
        private javax.swing.JLabel jLabel17;
        private javax.swing.JLabel jLabel18;
        private javax.swing.JLabel jLabel19;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel20;
        private javax.swing.JLabel jLabel21;
        private javax.swing.JLabel jLabel22;
        private javax.swing.JLabel jLabel23;
        private javax.swing.JLabel jLabel24;
        private javax.swing.JLabel jLabel25;
        private javax.swing.JLabel jLabel26;
        private javax.swing.JLabel jLabel27;
        private javax.swing.JLabel jLabel28;
        private javax.swing.JLabel jLabel29;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel30;
        private javax.swing.JLabel jLabel31;
        private javax.swing.JLabel jLabel32;
        private javax.swing.JLabel jLabel33;
        private javax.swing.JLabel jLabel34;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JList jList1;
        private javax.swing.JList jList2;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel10;
        private javax.swing.JPanel jPanel11;
        private javax.swing.JPanel jPanel12;
        private javax.swing.JPanel jPanel13;
        private javax.swing.JPanel jPanel14;
        private javax.swing.JPanel jPanel15;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JPanel jPanel6;
        private javax.swing.JPanel jPanel7;
        private javax.swing.JPanel jPanel8;
        private javax.swing.JPanel jPanel9;
        private javax.swing.JRadioButton jRadioButton1;
        private javax.swing.JRadioButton jRadioButton2;
        private javax.swing.JRadioButton jRadioButton3;
        private javax.swing.JRadioButton jRadioButton4;
        private javax.swing.JRadioButton jRadioButton5;
        private javax.swing.JRadioButton jRadioButton6;
        private javax.swing.JRadioButton jRadioButton7;
        private javax.swing.JRadioButton jRadioButton8;
        private javax.swing.JRadioButton jRadioButton9;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JScrollPane jScrollPane4;
        private javax.swing.JScrollPane jScrollPane5;
        private javax.swing.JTable jTable1;
        private javax.swing.JTable jTable2;
        private javax.swing.JTable jTable3;
        private javax.swing.JTextField jTextField1;
        private javax.swing.JTextField jTextField2;
        private javax.swing.JTextField jTextField3;
        private javax.swing.JTextField langTagField;
        private javax.swing.JComboBox localeComboBox;
        private javax.swing.JRadioButton localeCustomButton;
        private javax.swing.JRadioButton localeInstalledButton;
        private javax.swing.JLabel localizedDateTimeLabel;
        private javax.swing.JTextField patternField;
        private javax.swing.JLabel patternLabel;
        private javax.swing.JLabel rfc1123Label;
        // End of variables declaration//GEN-END:variables

}
