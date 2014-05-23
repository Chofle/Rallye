/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rallye;

import Renderer.ImageRenderer;
import Renderer.TimeRenderer;
import java.awt.Color;
//import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import rallye.entities.Categoria;
import rallye.entities.Inscripcion;

/**
 *
 * @author usuario
 */
public class Main extends javax.swing.JFrame {
    ModeloTabla modelo = new ModeloTabla();
    private boolean editarregistro = false;
    private int selectedRow;
    /**
     * Creates new form NewJFrame
     */
    public Main() {
        initComponents();
        //Inicialmente el panelDetalle no será editable.
        panelDetalle1.editableFalse();
        
        //Asignar al panel principal (JFrame) color de fondo. 
        rootPane.getContentPane().setBackground(new Color(206,227,246));
        
        //Asignar la lista de datos a la tabla
        modelo.setDataList(list1);
        jTable1.setModel(modelo);
        
        //Centrar el contenido
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        //jTable1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new TimeRenderer());
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new ImageRenderer());
        
        //Cambiar ancho de columnas
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(45);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(5);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(10);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(10);
        //Sólo se podrá seleccionar una fila 
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Detectar cambio de selección de la tabla
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            
            
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int indiceFilaSeleccionada = jTable1.getSelectedRow();
                if(indiceFilaSeleccionada>-1){
                    Inscripcion inscripcion = list1.get(indiceFilaSeleccionada);
                    panelDetalle1.setInscripcion(inscripcion);
                    panelDetalle1.showData(); 
                }
            }
        });      
   }
    
   public void guardarNuevo(){
        //Crear un nuevo objeto de la clase entidad 
        Inscripcion inscripcion = new Inscripcion(); 
        
        //Rellenar sus datos 
        panelDetalle1.setInscripcion(inscripcion);
        panelDetalle1.setData();
       
        entityManager1.getTransaction().begin(); 
        //Almacenar el objeto en la BD 
        entityManager1.persist(inscripcion); 
        entityManager1.getTransaction().commit(); 

        //Añadir el objeto al final de la lista de datos 
        list1.add(inscripcion); 
        //Informar al JTable que se ha insertado una fila al final 
        modelo.fireTableRowsInserted(list1.size()-1, list1.size()-1);
    }
   
    public void guardarModificado(){
        //Obtener el índice de la fila seleccionada en la tabla
        selectedRow = jTable1.getSelectedRow();
        
        //Obtener el objeto desde la lista de datos, conociendo su posición
        Inscripcion inscripcion = list1.get(selectedRow);
        panelDetalle1.setData();
        
        entityManager1.getTransaction().begin();
        //Almacenar el objeto en la BD
        entityManager1.merge(inscripcion);
        entityManager1.getTransaction().commit();
 
        //Añadir el objeto al final de la lista de datos
        list1.set(selectedRow, inscripcion);
        //Informar al JTable que se ha modificado la fila seleccionada
        modelo.fireTableRowsUpdated(selectedRow, selectedRow);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager1 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("RallyePU").createEntityManager();
        query1 = java.beans.Beans.isDesignTime() ? null : entityManager1.createQuery("SELECT f FROM Inscripcion f");
        list1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : query1.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelDetalle1 = new rallye.PanelDetalle();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        Nuevo = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        Borrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(206, 227, 246));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDetalle1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelDetalle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 58, -1, -1));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);

        Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new.jpg"))); // NOI18N
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(Nuevo);

        Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.jpg"))); // NOI18N
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        jToolBar1.add(Editar);

        Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.jpg"))); // NOI18N
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(Guardar);

        Borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.jpg"))); // NOI18N
        Borrar.setFocusable(false);
        Borrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Borrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });
        jToolBar1.add(Borrar);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        //Limpiar panel detalle y habilitarlo para que sea editable.
        panelDetalle1.cleanData();
        panelDetalle1.editableTrue();
    }//GEN-LAST:event_NuevoActionPerformed

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
        //Obtener el índice de la fila seleccionada en la tabla 
        selectedRow = jTable1.getSelectedRow(); 
        if(selectedRow>-1){
            int seleccion = JOptionPane.showConfirmDialog(rootPane, "¿Deseas eliminar el elemento seleccionado?", "Eliminar registro",JOptionPane.YES_NO_OPTION);
            if(seleccion == JOptionPane.YES_OPTION){
                //Obtener el objeto desde la lista de datos, conociendo su posición 
                Inscripcion inscripcion = list1.get(selectedRow);
                //Iniciar una transacción con la BD 
                entityManager1.getTransaction().begin(); 
                //Eliminar el objeto 
                entityManager1.remove(inscripcion); 
                //Finalizar la transacción actualizando la BD 
                entityManager1.getTransaction().commit();
                //Eliminar el objeto de la lista de datos 
                list1.remove(inscripcion); 
                //Informar al JTable que se ha eliminado una fila 
                modelo.fireTableRowsDeleted(selectedRow, selectedRow);
                //Limpiar panel de registros.
                panelDetalle1.cleanData();         
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se ha selecionado ninguna fila de la tabla", null, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/icons/information.png"));
        }
    }//GEN-LAST:event_BorrarActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        if(editarregistro == false){
            guardarNuevo();
        } else {
            guardarModificado();
        }
        int idCategoria = panelDetalle1.getCategoria().getCodCategoria();
        Categoria categoria = entityManager1.find(Categoria.class, idCategoria);
        System.out.println(categoria.getNombre());
    }//GEN-LAST:event_GuardarActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        if(selectedRow>-1){
            editarregistro = true;
            panelDetalle1.editableTrue();
        }
    }//GEN-LAST:event_EditarActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Borrar;
    private javax.swing.JButton Editar;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Nuevo;
    private javax.persistence.EntityManager entityManager1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private java.util.List<Inscripcion> list1;
    private rallye.PanelDetalle panelDetalle1;
    private javax.persistence.Query query1;
    // End of variables declaration//GEN-END:variables
}