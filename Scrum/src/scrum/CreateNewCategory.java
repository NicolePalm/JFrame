/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;

public class CreateNewCategory extends javax.swing.JFrame {

    private InfDB idb;
    public CreateNewCategory(InfDB idb) {
        initComponents();
        this.idb = idb;
        this.jErrorMessage.setVisible(false);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTyp = new javax.swing.JComboBox<>();
        jCategoryName = new javax.swing.JTextField();
        jCreateButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jErrorMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTyp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jobb", "Fritid" }));

        jCategoryName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCategoryNameActionPerformed(evt);
            }
        });

        jCreateButton.setText("Skapa kategori");
        jCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreateButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Kategorinamn");

        jErrorMessage.setText("Kategori finns redan!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jErrorMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCreateButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTyp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jTyp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCreateButton)
                    .addComponent(jErrorMessage))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCategoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCategoryNameActionPerformed
       
    }//GEN-LAST:event_jCategoryNameActionPerformed

    private void jCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreateButtonActionPerformed
        try{
           String name = jCategoryName.getText();
           String type = jTyp.getSelectedItem().toString();
           ArrayList<String>names = new ArrayList<String>();
           names = idb.fetchColumn("select CATEGORYNAME from CATEGORY");
           String id = idb.getAutoIncrement("CATEGORY","CATEGORY_ID");
           String sql = "INSERT INTO CATEGORY(CATEGORY_ID,CATEGORYNAME,CATEGORYTYPE) VALUES ("+id+",'"+name+"','"+type+"')";
           boolean matchingName = false;
           for(String name_ : names){
           if(name_.equals(name)){
           this.jErrorMessage.setVisible(true);
           matchingName = true;
           }
           }
           if(matchingName == false){
             idb.insert(sql);
             dispose();
           }
         
       }
       catch(InfException e){
           System.out.println(e.getMessage());
       }
    }//GEN-LAST:event_jCreateButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jCategoryName;
    private javax.swing.JButton jCreateButton;
    private javax.swing.JLabel jErrorMessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> jTyp;
    // End of variables declaration//GEN-END:variables
}
