/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labaims;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ncoba
 */
public class LabAims extends javax.swing.JFrame {
    
    String name = "annonymous";
    
    Timer t1;
    int 
        xAxis = 185, yAxis = 135, color, duration, count=30,
        scoreCurrent = 0, scoreHighest = 0;
    
    boolean pause = false, start = false;
    
    Color
        enemyA,
        enemyB,
        enemyC;
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    JScrollPane pane = new JScrollPane(table);
    
    String[] tmpList = null;
    Path currentRelativePath = Paths.get("");
    String s = currentRelativePath.toAbsolutePath().toString()+"/bin/";
    File directory = new File(s);
    File scoreboard = new File(s+"scoreboard.txt"); 
    File cosmetic = new File(s+"cosmetic.txt"); 
    
    Scanner scan1, scan2;
    
    BufferedWriter out;
    
    ArrayList<Integer> stack = new ArrayList<Integer>();
    Object[] list;
    Object[] row;
    Object[] tmpRow;
    
    Pattern p = Pattern.compile("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$");
    Matcher m;
    
    String 
        colorLMB = "#FF0000",
        colorMMB = "#00FFFF",
        colorRMB = "#FFC0CB";
    
    String 
        content = "",
        tmp = "";
    
    public LabAims() {
        initComponents();
        
        setLayout(null);
        
        model.addColumn("Score");
        model.addColumn("Player");
        model.addColumn("Timestamp");
        
        model.setRowCount(0);
        directory.mkdirs();
        try {
            cosmetic.createNewFile();
            scoreboard.createNewFile();
            scan1 = new Scanner(scoreboard);
            
        } catch (IOException ex) {
            System.out.println("already printed");
        }
        try {
            scan2 = new Scanner(cosmetic);
            while (scan2.hasNextLine()) {
                String currLine = scan2.nextLine();
                tmpList = currLine.split(" ");
                if(currLine.contains("lmb")){
                    colorLMB = tmpList[1];
                }else if(currLine.contains("mmb")){
                    colorMMB = tmpList[1];
                }else if(currLine.contains("lmb")){
                    colorRMB = tmpList[1];
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LabAims.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        enemyA = Color.decode(colorLMB);
        enemyB = Color.decode(colorMMB);
        enemyC = Color.decode(colorRMB);

        
        
        b1.setBackground(enemyA);
        b1.setPreferredSize(new Dimension(15,15));
        b1.setEnabled(false);
        b1.setLocation(xAxis, yAxis);
        
        b2.setBackground(enemyA);
        b2.setPreferredSize(new Dimension(15,15));
        b3.setBackground(enemyB);
        b3.setPreferredSize(new Dimension(15,15));
        b4.setBackground(enemyC);
        b4.setPreferredSize(new Dimension(15,15));
        Score();
        
        setTitle("LabAims");
        setSize(400, 400);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        help = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        b2 = new javax.swing.JButton();
        l4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        b3 = new javax.swing.JButton();
        l5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        b4 = new javax.swing.JButton();
        l6 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        b1 = new javax.swing.JButton();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Play = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        Cosmetic = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        help.setMinimumSize(new java.awt.Dimension(150, 75));
        help.setPreferredSize(new java.awt.Dimension(300, 75));
        help.setLayout(new java.awt.GridLayout(3, 2));

        b2.setFocusable(false);
        b2.setMaximumSize(new java.awt.Dimension(15, 15));
        b2.setMinimumSize(new java.awt.Dimension(15, 15));
        b2.setPreferredSize(new java.awt.Dimension(15, 15));
        b2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b2MousePressed(evt);
            }
        });
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        jPanel1.add(b2);

        help.add(jPanel1);

        l4.setText("left-click enemies");
        l4.setMaximumSize(new java.awt.Dimension(150, 16));
        l4.setMinimumSize(new java.awt.Dimension(150, 16));
        l4.setPreferredSize(new java.awt.Dimension(150, 16));
        help.add(l4);

        b3.setFocusable(false);
        b3.setMaximumSize(new java.awt.Dimension(15, 15));
        b3.setMinimumSize(new java.awt.Dimension(15, 15));
        b3.setPreferredSize(new java.awt.Dimension(15, 15));
        b3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b3MousePressed(evt);
            }
        });
        jPanel2.add(b3);

        help.add(jPanel2);

        l5.setText("middle-click enemies");
        l5.setMaximumSize(new java.awt.Dimension(150, 16));
        l5.setMinimumSize(new java.awt.Dimension(150, 16));
        l5.setPreferredSize(new java.awt.Dimension(150, 16));
        help.add(l5);

        b4.setFocusable(false);
        b4.setMaximumSize(new java.awt.Dimension(15, 15));
        b4.setMinimumSize(new java.awt.Dimension(15, 15));
        b4.setPreferredSize(new java.awt.Dimension(15, 15));
        b4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b4MousePressed(evt);
            }
        });
        jPanel3.add(b4);

        help.add(jPanel3);

        l6.setText("right-click enemies");
        l6.setMaximumSize(new java.awt.Dimension(150, 16));
        l6.setMinimumSize(new java.awt.Dimension(150, 16));
        l6.setPreferredSize(new java.awt.Dimension(150, 16));
        help.add(l6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(400, 400));

        l1.setText("Current Score:");

        b1.setText("jButton1");
        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b1MousePressed(evt);
            }
        });

        l2.setText("Highest Score:");

        l3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l3.setText("Time left (seconds): 30");

        Play.setText("Play");
        Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Start New");
        jMenuItem1.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenuItem1MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Play.add(jMenuItem1);

        jMenuItem2.setText("Resume Or Pause");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Play.add(jMenuItem2);

        jMenuItem3.setText("Scoreboard");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Play.add(jMenuItem3);

        jMenuBar1.add(Play);

        Cosmetic.setText("Cosmetic");
        Cosmetic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CosmeticActionPerformed(evt);
            }
        });

        jMenuItem4.setText("Set Left Click Enemy's Color");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        Cosmetic.add(jMenuItem4);

        jMenuItem5.setText("Set Middle Click Enemy's Color");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        Cosmetic.add(jMenuItem5);

        jMenuItem6.setText("Set Right Click Enemy's Color");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        Cosmetic.add(jMenuItem6);

        jMenuBar1.add(Cosmetic);

        Help.setText("Help");
        Help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpActionPerformed(evt);
            }
        });

        jMenuItem7.setText("Guide");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        Help.add(jMenuItem7);

        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(l3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l2)
                .addGap(41, 41, 41)
                .addComponent(l3)
                .addGap(38, 38, 38)
                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void Score(){
        row = null;
        
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>(25);
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        
        while (scan1.hasNextLine()) {
            try{
                tmpList = scan1.nextLine().split(" ");
                row = new Object[] {Integer.valueOf(tmpList[0]), tmpList[1], tmpList[2]};
                stack.add(Integer.valueOf(tmpList[0]));
            }catch(Exception e){
                
            }
        }
        Collections.sort(stack, Collections.reverseOrder());
        System.out.println(Arrays.toString(stack.toArray()));
        scoreHighest = stack.get(0);
        l2.setText("Highest Score: "+scoreHighest);
    }
    
    private void GameOver() {
        System.out.println(count/10+":"+count%10);
        l3.setText(String.valueOf("Time left (seconds): "+count/10+""+count%10));
        if(count == 0){
            t1.cancel();
            buttonState(false);
            b1.setLocation(xAxis = 185, yAxis = 135);
            l3.setText("Times Up!");
            Score();
            try {
                String pattern = "YYYYMMddHHmm";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(new Date());
                out = new BufferedWriter(new FileWriter(scoreboard, true));
                if(scoreCurrent > 0){
                    out.append("\n"+scoreCurrent+" "+name+" "+date);
                    out.flush();
                }
            } catch (Exception e) {
            }
        }
    }
    
    public void colorState(){
        try {
            scan2 = new Scanner(cosmetic);
            while (scan2.hasNextLine()) {
                String currLine = scan2.nextLine();
                tmpList = currLine.split(" ");
                if(currLine.contains("lmb")){
                    colorLMB = tmpList[1];
                }else if(currLine.contains("mmb")){
                    colorMMB = tmpList[1];
                }else if(currLine.contains("lmb")){
                    colorRMB = tmpList[1];
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LabAims.class.getName()).log(Level.SEVERE, null, ex);
        }
        b2.setBackground(enemyA);
        b3.setBackground(enemyB);
        b4.setBackground(enemyC);
        enemyA = Color.decode(colorLMB);
        enemyB = Color.decode(colorMMB);
        enemyC = Color.decode(colorRMB);
    }
    
    public void buttonState(boolean state){
        b1.setSelected(state);
        b1.setEnabled(state);
        b1.setFocusable(state);
    }
    
    private void b1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MousePressed
        // TODO add your handling code here:
        xAxis = ThreadLocalRandom.current().nextInt(50, 350); 
        yAxis = ThreadLocalRandom.current().nextInt(50, 285);
        color = ThreadLocalRandom.current().nextInt(0, 3);  
        System.out.println(color);
        
        if(b1.isEnabled() == true){
            if(evt.getButton()==1){         
                if(b1.getBackground() == enemyA){
                    scoreCurrent += 100;
                    b1.setLocation(xAxis, yAxis);

                }else{
                    scoreCurrent -= 1000;
                    b1.setLocation(xAxis, yAxis);
                }
                l1.setText("Current Score: "+scoreCurrent);
            }else if(evt.getButton()==2){         
                if(b1.getBackground() == enemyB){
                    scoreCurrent += 100;
                    b1.setLocation(xAxis, yAxis);

                }else{
                    scoreCurrent -= 1000;
                    b1.setLocation(xAxis, yAxis);
                }
                l1.setText("Current Score: "+scoreCurrent);
            }else if(evt.getButton()==3){         
                if(b1.getBackground() == enemyC){
                    scoreCurrent += 100;
                    b1.setLocation(xAxis, yAxis);

                }else{
                    scoreCurrent -= 1000;
                    b1.setLocation(xAxis, yAxis);
                }
                l1.setText("Current Score: "+scoreCurrent);
            }
            if(color == 0){
                b1.setBackground(enemyA);
            }else if(color == 1){
                b1.setBackground(enemyB);
            }else if(color == 2){
                b1.setBackground(enemyC);
            }
        }
    }//GEN-LAST:event_b1MousePressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(pause == true){
            pause = false;
        }
        
        count = 30;
        l1.setText("Current Score: ");
        scoreCurrent = 0;
        Score();
        
        try{
            t1.cancel();
        }
        catch(Exception ex){
            
        }
        b1.setEnabled(true);
        t1 = new Timer();
        t1.schedule(new TimerTask() {
            @Override
            public void run() {
                if(pause == false){
                   count--; 
                }
                GameOver();
            }
        }, 0, 1_000);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem1MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenuItem1MenuKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItem1MenuKeyPressed
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        if(pause == true){
            pause = false;
            buttonState(true);
            
        }else if(pause == false){
            pause = true;
            buttonState(false);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try{
            tmp = JOptionPane.showInputDialog("What Hex Color?");
            m = p.matcher(tmp);
            scan2 = new Scanner(cosmetic);
            if(m.matches()){
                enemyB = Color.decode(tmp);
                while (scan2.hasNextLine()) {
                    content = content.concat(scan2.nextLine() + "\n");
                }
                try{
                    content = content.replaceAll("mmb "+colorMMB, "mmb "+tmp);
                    out = new BufferedWriter(new FileWriter(cosmetic));
                    System.out.println(content);
                    out.write(content);
                    out.close();
                    colorMMB = tmp;
                } catch (Exception e) {
                }
            }else{
            }
        }catch(Exception e){
            
        }
        colorState();
        //call an update tutorial
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlayActionPerformed

    private void CosmeticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CosmeticActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CosmeticActionPerformed

    private void HelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_HelpActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        directory.mkdirs();
        ArrayList<Object> tab = new ArrayList<Object>();
        row = null;
        try {
            scoreboard.createNewFile();
        } catch (IOException ex) {
            System.out.println("already printed");
        }
        try {
            scan1 = new Scanner(scoreboard);
            while (scan1.hasNextLine()) {
                try{
                    tmpList = scan1.nextLine().split(" ");
                    row = new Object[] {new Integer(Integer.valueOf(tmpList[0])), tmpList[1], tmpList[2]};
                    model.addRow(row);
                }catch(Exception e){
                    
                }
            }
        } catch (Exception e) {
        }
        System.out.print(model.getDataVector());
        table.setAutoCreateRowSorter(true);
        JOptionPane.showMessageDialog(null, pane);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try{
            tmp = JOptionPane.showInputDialog("What Hex Color?");
            m = p.matcher(tmp);
            scan2 = new Scanner(cosmetic);
            if(m.matches()){
                enemyB = Color.decode(tmp);
                while (scan2.hasNextLine()) {
                    content = content.concat(scan2.nextLine() + "\n");
                }
                try{
                    content = content.replaceAll("mmb "+colorLMB, "mmb "+tmp);
                    out = new BufferedWriter(new FileWriter(cosmetic));
                    System.out.println(content);
                    out.write(content);
                    out.close();
                    colorLMB = tmp;
                } catch (Exception e) {
                }
            }else{
            }
        }catch(Exception e){
            
        }
        colorState();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        try{
            tmp = JOptionPane.showInputDialog("What Hex Color?");
            m = p.matcher(tmp);
            scan2 = new Scanner(cosmetic);
            if(m.matches()){
                enemyB = Color.decode(tmp);
                while (scan2.hasNextLine()) {
                    content = content.concat(scan2.nextLine() + "\n");
                }
                try{
                    content = content.replaceAll("mmb "+colorRMB, "mmb "+tmp);
                    out = new BufferedWriter(new FileWriter(cosmetic));
                    System.out.println(content);
                    out.write(content);
                    out.close();
                    colorRMB = tmp;
                } catch (Exception e) {
                }
            }else{
            }
        }catch(Exception e){
            
        }
        colorState();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void b2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_b2MousePressed

    private void b3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_b3MousePressed

    private void b4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b4MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_b4MousePressed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        
        JOptionPane.showMessageDialog(null, help);
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LabAims.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LabAims.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LabAims.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LabAims.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LabAims().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Cosmetic;
    private javax.swing.JMenu Help;
    private javax.swing.JMenu Play;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JPanel help;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    // End of variables declaration//GEN-END:variables
}
