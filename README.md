# POO-Seguimiento6

## Operaciones CRUD
https://github.com/darbelaezm/POO-Seguimiento6/blob/main/friends/Contacts.java
```java
package friends;

public class Friends {
    public static void main(String[] args) {
       Contacts form = new Contacts();
        form.setVisible(true);
    }
}

package friends;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;

public class Contacts extends javax.swing.JFrame {

    public Contacts() {
        initComponents();
    }
    private void initComponents() {

        createbtn = new javax.swing.JButton();
        readbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtnumber = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        createbtn.setText("Create");
        createbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createbtnActionPerformed(evt);
            }
        });

        readbtn.setText("Read");
        readbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readbtnActionPerformed(evt);
            }
        });

        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });

        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });

        clearbtn.setText("Clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });

        exitbtn.setText("Exit");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Name:");

        jLabel2.setText("Number:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(clearbtn)
                        .addGap(56, 56, 56)
                        .addComponent(exitbtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createbtn)
                        .addGap(18, 18, 18)
                        .addComponent(readbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updatebtn)
                        .addGap(18, 18, 18)
                        .addComponent(deletebtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtname)
                            .addComponent(txtnumber, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createbtn)
                    .addComponent(readbtn)
                    .addComponent(updatebtn)
                    .addComponent(deletebtn))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearbtn)
                    .addComponent(exitbtn))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void readbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readbtnActionPerformed
        try {
                    
			String nameNumberString;
			String name;
                        String newName = String.valueOf(txtname.getText());
			long number;
			int index;

			File file = new File("C:\\Users\\Daniela Arbelaez\\OneDrive\\Documentos\\NetBeansProjects\\AddFriend\\friendsContact.txt");

			if (!file.exists()) {
				file.createNewFile();
			}


			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			boolean found = false;

			while (raf.getFilePointer() < raf.length()) {

				nameNumberString = raf.readLine();

				String[] lineSplit = nameNumberString.split("!");

				name = lineSplit[0];
				number = Long.parseLong(lineSplit[1]);
                                
                                if (name.equals(newName)){
                                    
                                txtname.setText(String.valueOf(name));
                                txtnumber.setText(String.valueOf(number));
                                found = true;
                                break; // No need to continue checking if the name is found
                                }                                                               
                           }
                        
                        if (!found){
                        JOptionPane.showMessageDialog(null,"There's no record with the name " + newName);
                        }
        }
               			catch (IOException ioe){
				System.out.println(ioe);
			}
			catch (NumberFormatException nef){
                                System.out.println(nef);
                        }
    }//GEN-LAST:event_readbtnActionPerformed

    private void createbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createbtnActionPerformed
      try {
			String newName = String.valueOf(txtname.getText());
			long newNumber = Long.parseLong(txtnumber.getText());

			String nameNumberString;
			String name;
			long number;
			int index;

			File file = new File("C:\\Users\\Daniela Arbelaez\\OneDrive\\Documentos\\NetBeansProjects\\AddFriend\\friendsContact.txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			boolean found = false;

			while (raf.getFilePointer() < raf.length()) {
				nameNumberString = raf.readLine();
				String[] lineSplit
					= nameNumberString.split("!");

				name = lineSplit[0];
				number = Long.parseLong(lineSplit[1]);

				if (name == newName || number == newNumber) {
					found = true;
                                        System.out.println(" The record exists. ");
					break;
				}
			}

			if (found == false) {
				nameNumberString = newName + "!" + String.valueOf(newNumber);
				raf.writeBytes(nameNumberString);
				raf.writeBytes(System.lineSeparator());
				JOptionPane.showMessageDialog(null," The friend " + newName + " was added. ");
				raf.close();
			}
			else {
				raf.close();	
                                JOptionPane.showMessageDialog(null," Input name or number does already exists. ");
			}
		}
		catch (IOException ioe) {
			System.out.println(ioe);
		}
		catch (NumberFormatException nef) {
			System.out.println(nef);
		}
    }//GEN-LAST:event_createbtnActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        txtname.setText("");
        txtnumber.setText("");
    }//GEN-LAST:event_clearbtnActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        try {
             String newName = String.valueOf(txtname.getText());
             long newNumber = Long.parseLong(txtnumber.getText());
 
            String nameNumberString;
            String name;
            long number;
            int index;
 
            File file = new File("C:\\Users\\Daniela Arbelaez\\OneDrive\\Documentos\\NetBeansProjects\\AddFriend\\friendsContact.txt");
             if (!file.exists()) { 
                file.createNewFile();
            }
 
            RandomAccessFile raf
                = new RandomAccessFile(file, "rw");
            boolean found = false;
 
            while (raf.getFilePointer() < raf.length()) {
                 nameNumberString = raf.readLine();
                 String[] lineSplit
                    = nameNumberString.split("!");
 
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
 
                if (name == newName
                    || number == newNumber) {
                    found = true;
                    break;
                }
            }
             if (found) {
                 File tmpFile = new File("temp.txt");
                 RandomAccessFile tmpraf
                    = new RandomAccessFile(tmpFile, "rw");
                 raf.seek(0);
 
                while (raf.getFilePointer()
                       < raf.length()) {
                     nameNumberString = raf.readLine();
                     index = nameNumberString.indexOf('!');
                    name = nameNumberString.substring(
                        0, index);
 
                    if (name.equals(newName)) {
                                                 nameNumberString
                            = newName + "!"
                              + String.valueOf(newNumber);
                    } 
                    tmpraf.writeBytes(nameNumberString);
                    tmpraf.writeBytes(System.lineSeparator());
                }
                
                raf.seek(0);
                tmpraf.seek(0);
 
                while (tmpraf.getFilePointer()
                       < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
 
                raf.setLength(tmpraf.length());
 
                tmpraf.close();
                raf.close(); 
                tmpFile.delete();
                JOptionPane.showMessageDialog(null," Friend updated. ");               
            }
             else {
                raf.close();
                JOptionPane.showMessageDialog(null," Input name or number does not exists. ");                
            }
        } 
        catch (IOException ioe) {
            System.out.println(ioe);
        } 
        catch (NumberFormatException nef) {
            System.out.println(nef);
        }
    }//GEN-LAST:event_updatebtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        try { 
            String newName = String.valueOf(txtname.getText());
 
            String nameNumberString;
            String name;
            long number;
            int index;
 
            File file = new File("C:\\Users\\Daniela Arbelaez\\OneDrive\\Documentos\\NetBeansProjects\\AddFriend\\friendsContact.txt");
 
            if (!file.exists()) {
 
                file.createNewFile();
            }

            RandomAccessFile raf
                = new RandomAccessFile(file, "rw");
            boolean found = false;
 
            while (raf.getFilePointer() < raf.length()) {
 
                nameNumberString = raf.readLine();
 
                String[] lineSplit
                    = nameNumberString.split("!");
 
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
 
                if (name.equals(newName)) {
                    found = true;
                    break;
                }
            }
 
            if (found) {
 
                File tmpFile = new File("temp.txt");
 
                RandomAccessFile tmpraf
                    = new RandomAccessFile(tmpFile, "rw");
 
                raf.seek(0);
 
                while (raf.getFilePointer()
                       < raf.length()) {
 
                    nameNumberString = raf.readLine();
 
                    index = nameNumberString.indexOf('!');
                    name = nameNumberString.substring(
                        0, index);
 
                    if (name.equals(newName)) { 
                        continue;
                    }
 
                    tmpraf.writeBytes(nameNumberString);
 
                    tmpraf.writeBytes(
                        System.lineSeparator());
                }
 
                raf.seek(0);
                tmpraf.seek(0);
 
                while (tmpraf.getFilePointer()
                       < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
 
                raf.setLength(tmpraf.length());
 
                tmpraf.close();
                raf.close();
 
                tmpFile.delete();
                JOptionPane.showMessageDialog(null," Friend deleted.  ");               
            }
 
            else {    
                JOptionPane.showMessageDialog(null," Input name does not exists. ");                
            }
        }
 
        catch (IOException ioe) {
            System.out.println(ioe);
        }
    }//GEN-LAST:event_deletebtnActionPerformed

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
            java.util.logging.Logger.getLogger(Contacts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contacts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contacts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contacts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Contacts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton createbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton exitbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton readbtn;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnumber;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
```
## Interfaz de Usuario
![image](https://github.com/darbelaezm/POO-Seguimiento6/assets/143208551/2000a34b-bb5a-45e5-91a7-532738ca1637)

## Diagrama de Clases
![image](https://github.com/darbelaezm/POO-Seguimiento6/assets/143208551/22b8ead8-7182-4691-acfe-9f05204a52f9)

## Diagrama de Casos de Uso
![image](https://github.com/darbelaezm/POO-Seguimiento6/assets/143208551/eefee590-c5a2-4328-a9ff-fb7c5e46fea5)

