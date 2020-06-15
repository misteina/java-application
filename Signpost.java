package package1;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.*;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DateFormat;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Signpost extends JFrame implements ActionListener {

    private JButton jButton2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JTextField jTextField1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JFileChooser filechooser;
    private JFileChooser filechooser1;
    private JFileChooser filechooser2;
    private JFileChooser filechooser3;
    private JProgressBar progressbar;
    private Timer timer1;
    private Timer timer;
    private ArrayList<String> list;
    private ArrayList<String> array;
    private File[] files;
    private File file1;
    private Image image1;
    private File imagefile;
    private BufferedImage temp1;
    private BufferedImage bufferedImage;
    private Graphics2D graphics2D;


    public Signpost() {
        initComponents();
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {
        jScrollPane1 = new JScrollPane();
        progressbar = new JProgressBar();
        jTable1 = new JTable();
        jButton2 = new JButton("Write");
        jLabel1 = new JLabel("GTSign");
        jLabel2 = new JLabel("Waiting...");
        jTextField1 = new JTextField();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu("File");
        jMenuItem1 = new JMenuItem("Open file...");
        jMenuItem2 = new JMenuItem("Exit");
        jMenu2 = new JMenu("About");
        jMenuItem3 = new JMenuItem("GTSign");
        jMenuItem4 = new JMenuItem("Load list...");
        list = new ArrayList<>();
        array = new ArrayList<>();
        timer = new Timer(1000, progress);
        timer1 = new Timer();
        filechooser = new JFileChooser();
        filechooser1 = new JFileChooser();
        filechooser2 = new JFileChooser();
        filechooser3 = new JFileChooser();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jPanel5 = new JPanel();

        setIconImage(new ImageIcon(getClass().getResource("/package1/icon.jpg")).getImage());
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GTSign");
        setJMenuBar(jMenuBar1);
        setPreferredSize(new Dimension(1010, 550));
        setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(new Point((screenSize.width - 1010) / 2, (screenSize.height - 550) / 2));

        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem4);
        jMenu1.add(jMenuItem2);
        jMenuBar1.add(jMenu1);
        jMenu2.add(jMenuItem3);
        jMenuBar1.add(jMenu2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [200][2],
            new String [] {
                "Image File", "Locations"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });


        jTable1.setRowHeight(20);
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTable1.setCellSelectionEnabled(false);
        jTable1.setGridColor(new java.awt.Color(204, 204, 204));
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(570);
        jTable1.setShowVerticalLines(true);
        jTable1.setShowHorizontalLines(true);
        jTable1.setBackground(new java.awt.Color(255, 255, 255));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG","jpg");
        FileNameExtensionFilter filter1 = new FileNameExtensionFilter("TXT", "txt");

        filechooser.setFileFilter(filter);
        filechooser2.setFileFilter(filter1);
        filechooser3.setFileFilter(filter1);
        filechooser.setMultiSelectionEnabled(true);
        filechooser.setAcceptAllFileFilterUsed(false);
        filechooser2.setAcceptAllFileFilterUsed(false);
        filechooser3.setAcceptAllFileFilterUsed(false);
        filechooser1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        jButton2.addActionListener(this);
        jMenuItem1.addActionListener(this);
        jMenuItem2.addActionListener(this);
        jMenuItem3.addActionListener(this);
        jMenuItem4.addActionListener(this);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);


        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField1.setEditable(false);
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);


        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                "Status", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.BOTTOM,
                null, new java.awt.Color(102, 102, 102)));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                "Current City", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.BOTTOM,
                null, new java.awt.Color(102, 102, 102)));

        progressbar.setVisible(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, 40, 40, 40)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel5, 40, 40, 40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(66, 66, 66))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(10, 32)
                .addComponent(jButton2)
                .addContainerGap())
        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10 , 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, 70, 70, 70)
                .addGap(6, 6, 6)
                .addComponent(jPanel4, 90, 90, 90)
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == jMenuItem1) {
             for (int i = 0; i < 200; i++) {
                 jTable1.setValueAt(null, i, 0);
             }
             jLabel2.setText("Waiting...");
             int returnVal = filechooser.showOpenDialog(this);
             if (returnVal == JFileChooser.APPROVE_OPTION) {
                  files = filechooser.getSelectedFiles();
                  for (int j = 0; j < files.length; j++) {
                      jTable1.setValueAt(files[j].getName(), j, 0);
                  }
             }
         }
         if (e.getSource() == jMenuItem2) {
             int value = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit",
                     JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
             if (value == JOptionPane.YES_OPTION) {
                 System.exit(0);
             }
         }
         if (e.getSource() == jMenuItem3) {
             JOptionPane.showMessageDialog(this, "This software was created by EYINA.\n"
                     + "Unauthorized distribution or acquisition of this product is prohibited.\n"
                     + "Contact: 08100478999\n                                                  "
                     + "   (c) 2013", "About GTSign", JOptionPane.PLAIN_MESSAGE);
         }
         if (e.getSource() == jMenuItem4) {
             for (int i = 0; i < 200; i++) {
                 jTable1.setValueAt(null, i, 1);
             }
             jLabel2.setText("Waiting...");
             list.clear();
             int returnVal = filechooser2.showOpenDialog(this);
             if (returnVal == JFileChooser.APPROVE_OPTION) {
                 file1 = filechooser2.getSelectedFile();
                 try {Scanner scan = new Scanner(file1);
                         while (scan.hasNext()) {
                             list.add(scan.nextLine());
                             list.trimToSize();
                             for (int r = 0; r < list.size(); r++) {
                                 jTable1.setValueAt(list.get(r), r, 1);
                                 jTextField1.setText(file1.getName().replaceAll(".txt", ""));
                             }
                         }
                 } catch (Exception ex) {
                     Toolkit.getDefaultToolkit().beep();
                     JOptionPane.showMessageDialog(this, "    Operation failed.", "Message", JOptionPane.ERROR_MESSAGE);
                   }
             }
         }


         if (e.getSource() == jButton2) {
             if (jTable1.getValueAt(0, 0) == null) {
                 Toolkit.getDefaultToolkit().beep();
                 JOptionPane.showMessageDialog(this, "      No Image files loaded", "Message", JOptionPane.INFORMATION_MESSAGE);
             }
             else if (jTable1.getValueAt(0, 1) == null) {
                 Toolkit.getDefaultToolkit().beep();
                 JOptionPane.showMessageDialog(this, "      No locations loaded", "Message", JOptionPane.INFORMATION_MESSAGE);
             }
             else if (new File(files[0].getParent() + "/" + jTextField1.getText()).exists()) {
                 Toolkit.getDefaultToolkit().beep();
                 JOptionPane.showMessageDialog(this, jTextField1.getText() + " pictures may have been processed", "Message", JOptionPane.INFORMATION_MESSAGE);
             }
             else if (files.length > list.size()) {
                 Toolkit.getDefaultToolkit().beep();
                 JOptionPane.showMessageDialog(this, "   Incomplete list detected", "Message", JOptionPane.INFORMATION_MESSAGE);
             }
             else if (!files[0].getParentFile().getName().equals(jTextField1.getText())) {
                 Toolkit.getDefaultToolkit().beep();
                 JOptionPane.showMessageDialog(this, "   You selected an incorrect list", "Message", JOptionPane.INFORMATION_MESSAGE);
             }
             else {timer.start();
                   timer1.schedule(new Mainprocess(), 0);
             }

         }
    }

    class Mainprocess extends TimerTask {
        @Override
        public void run() {
            JOptionPane.showMessageDialog(new Signpost(), "Maximum processing time:  " + (files.length * 5) + " seconds", "Message", JOptionPane.INFORMATION_MESSAGE);
            try {for (int i = 0; i < files.length; i++) {
                    String period = Datetaken(i);
                    int location = Integer.parseInt(jTable1.getValueAt(i, 0).toString());
                    image1 = ImageIO.read(files[i]);
                    temp1 = resizeDraw(image1, 643, 482);
                    graphics2D.setColor(new java.awt.Color(246, 97, 2));
                    graphics2D.drawRect(0, 452, 643, 30);
                    graphics2D.fillRect(0, 452, 643, 30);
                    graphics2D.setColor(Color.WHITE);
                    graphics2D.setFont(new java.awt.Font("Tahoma", 1, 15));
                    graphics2D.drawString(jTable1.getValueAt(location - 1, 1).toString(), 10, 472);
                    graphics2D.setColor(Color.YELLOW);
                    graphics2D.drawString(jTextField1.getText().toString() + "//" + period, 10, 442);
                    graphics2D.dispose();
                    new File(files[0].getParent() + "/" + jTextField1.getText()).mkdir();
                    imagefile = new File(files[0].getParent() + "/" + jTextField1.getText() + "/" + location + ".JPG");
                    ImageIO.write(temp1, "jpg", imagefile);
                }
            }
            catch (Exception ex) {
                 Toolkit.getDefaultToolkit().beep();
                 timer.stop();
                 progressbar.setVisible(false);
                 jLabel2.setVisible(true);
                 jLabel2.setText("Failed!");
                 jButton2.setEnabled(true);
                 JOptionPane.showMessageDialog(new Signpost(), "Operation failed", "Message", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    ActionListener progress = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            jButton2.setEnabled(false);
            jLabel2.setVisible(false);
            progressbar.setVisible(true);
            progressbar.setIndeterminate(true);
            if (new File(files[0].getParent() + "/" + jTextField1.getText()).exists() && new File(files[0].getParent() + "/" + jTextField1.getText()).list().length == files.length) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(new Signpost(), jTextField1.getText() + " photos completed!", "Message", JOptionPane.INFORMATION_MESSAGE);
                jButton2.setEnabled(true);
                progressbar.setVisible(false);
                jLabel2.setVisible(true);
                jLabel2.setText("Completed!");
                timer.stop();

            }
        }
    };

    public String Datetaken(int i) {
        Date date;
        String period = null;
            try {
                Metadata metadata = ImageMetadataReader.readMetadata(files[i]);
                Directory directory = metadata.getDirectory(ExifSubIFDDirectory.class );
                date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_DIGITIZED );
                DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.ENGLISH);
                df.format(date);
                String month = df.getCalendar().getDisplayName(Calendar.MONTH , Calendar.LONG, Locale.UK);
                int day = df.getCalendar().get(Calendar.DAY_OF_MONTH);
                int year = df.getCalendar().get(Calendar.YEAR);
                period = month + " " + day + " " + year;
            } catch (    ImageProcessingException | IOException ex) {
                Toolkit.getDefaultToolkit().beep();
                progressbar.setVisible(false);
                jLabel2.setText("Failed!");
                JOptionPane.showMessageDialog(new Signpost(), "Operation failed", "Message", JOptionPane.ERROR_MESSAGE);
            }
        return period;
    }

    public BufferedImage resizeDraw(final Image image, int width, int height) {
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawImage(image, 0, 0, width, height, null);
        return bufferedImage;
    }


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signpost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Signpost().setVisible(true);
            }
        });
    }
}
