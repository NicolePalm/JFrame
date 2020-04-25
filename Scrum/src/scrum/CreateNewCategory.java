package scrum;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTyp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Formal", "Informal" }));

        jCategoryName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCategoryNameActionPerformed(evt);
            }
        });

        jCreateButton.setText("Create category");
        jCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreateButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Categoryname");

        jErrorMessage.setText("That category does already exist");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jErrorMessage)
                    .addComponent(jButton1)
                    .addComponent(jTyp, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(115, 115, 115))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCreateButton)
                            .addComponent(jCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jTyp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCreateButton)
                    .addComponent(jErrorMessage))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCategoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCategoryNameActionPerformed
       
    }//GEN-LAST:event_jCategoryNameActionPerformed

    private void jCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreateButtonActionPerformed
        try{
           String name = jCategoryName.getText();
           if(name.length() <= 35){
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
           if(matchingName == false && Validation.inmatningFnuttar(name) && Validation.inmatningFnuttar(type)){
             idb.insert(sql);
             dispose();
           }
           }
           else{
               JOptionPane.showMessageDialog(null, "Categoryname can only be 35 characters");
               jCategoryName.requestFocus();
           }
         
       }
       catch(InfException e){
           System.out.println(e.getMessage());
       }
    }//GEN-LAST:event_jCreateButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jCategoryName;
    private javax.swing.JButton jCreateButton;
    private javax.swing.JLabel jErrorMessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> jTyp;
    // End of variables declaration//GEN-END:variables
}
