/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;



import entidade.Funcionario;
import entidade.Usuario;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.FuncionarioDAO;
import persistencia.UsuarioSistemaDAO;

/**
 *
 * @author aluno
 */
public class frmFuncionarioPesquisa extends javax.swing.JInternalFrame {
    
    private JDesktopPane principal;
    /**
     * Creates new form frmTipoAssociadoPesquisa
     */
    public frmFuncionarioPesquisa() {
        initComponents();
    }
    
    public frmFuncionarioPesquisa(JDesktopPane principal){
        this();
        this.principal = principal;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();
        cmbCategoria = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

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

        setTitle("Pesquisa Funcionário");

        btnFechar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblResultado);

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Almoxarifado", "Sistema" }));
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        jLabel1.setText("Mostrar usuário do:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnFechar)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        try {
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }//GEN-LAST:event_btnFecharActionPerformed

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        try {
            switch(cmbCategoria.getSelectedIndex()){
                case 0: preencherTelaAlmox(); break;
                case 1: preencherTelaSist(); break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_cmbCategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblResultado;
    // End of variables declaration//GEN-END:variables

    private void preencherTelaAlmox() {
        try {
            
            Vector<String> cabecalho = new Vector<>();
            cabecalho.add("Código");
            cabecalho.add("Nome");
            cabecalho.add("Matrícula");
            
            Vector detalhe = new Vector<>();
            for (Funcionario funcionario : new FuncionarioDAO().listar()) {
                Vector<String> linha = new Vector<>();
                linha.add(funcionario.getId()+ "");
                linha.add(funcionario.getNome());
                linha.add(funcionario.getMatricula());
                
                detalhe.add(linha);
            }
            
            
            
            tblResultado.setModel(new DefaultTableModel(detalhe, cabecalho));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void preencherTelaSist() {
        try {
            
            
            Vector<String> cabecalho = new Vector<>();
            cabecalho.add("Código do Usuário");
            cabecalho.add("E-mail");
            cabecalho.add("Senha");
            cabecalho.add("Código do Funcionário");
            cabecalho.add("CPF");
            
            Vector detalhe = new Vector<>();
            for (Usuario usuarioSis : new UsuarioSistemaDAO().listar()) {
                Vector<String> linha = new Vector<>();
                linha.add(usuarioSis.getIdUsuario() + "");
                linha.add(usuarioSis.getEmail());
                linha.add(usuarioSis.getSenha());
                linha.add(usuarioSis.getFuncionario().getId() + "");
                linha.add(usuarioSis.getCpf() + "");
                detalhe.add(linha);
            }
//            for (Funcionario funcionario : new FuncionarioDAO().listar()) {
//                Vector<String> linha = new Vector<>();
//                
//                detalhe.add(linha);
//            }
            
            tblResultado.setModel(new DefaultTableModel(detalhe, cabecalho));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    

}
