package br.com.controlextras.tela;

import br.com.controlextras.data.CargoDAO;
import br.com.controlextras.data.FuncHoraExtraDAO;
import br.com.controlextras.data.FuncionarioDAO;
import br.com.controlextras.data.HoraExtraDAO;
import br.com.controlextras.modelo.Cargo;
import br.com.controlextras.modelo.FuncHoraExtra;
import br.com.controlextras.modelo.Funcionario;
import br.com.controlextras.modelo.HoraExtra;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TelaInscHoraExtra extends javax.swing.JDialog {

    DefaultTableModel dtmHorasExtras;
    DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public TelaInscHoraExtra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        preencherComboCargo();
        carregaFuncionario();   
        atualizaLista();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlDadosFuncionario = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblDataNascimento = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblSalario = new javax.swing.JLabel();
        lblTipoFuncionario = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        txtSalario = new javax.swing.JFormattedTextField();
        cmbTipoFuncionario = new javax.swing.JComboBox();
        txtDataNascimento = new javax.swing.JFormattedTextField();
        pnlHoraExtras = new javax.swing.JPanel();
        lblPesquisa = new javax.swing.JLabel();
        txtPesquisaData = new javax.swing.JTextField();
        scrHorasExtras = new javax.swing.JScrollPane();
        String colunas[] = {"ID", "Data", "Começo", "Término", "Observação", "Criador"};
        dtmHorasExtras = new DefaultTableModel(colunas, 0){
            // Sobrescreva isCellEditable para impedir a edição de linhas específicas
            @Override
            public boolean isCellEditable(int row, int column) {
                // Impede a edição das linhas 0 e 1
                return false;
            }
        };
        //atualizaLista();
        tblHorasExtras = new javax.swing.JTable();
        btnInscrever = new javax.swing.JButton();
        btnVerDetalhes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inscrever em Horas Extras");
        setResizable(false);

        pnlContainer.setBackground(new java.awt.Color(23, 24, 31));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(11, 135, 112));
        lblTitulo.setText("DADOS DO FUNCIONÁRIO");

        pnlDadosFuncionario.setBackground(new java.awt.Color(49, 77, 74));

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(23, 24, 31));
        lblNome.setLabelFor(txtNome);
        lblNome.setText("Nome:");

        lblDataNascimento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDataNascimento.setForeground(new java.awt.Color(23, 24, 31));
        lblDataNascimento.setLabelFor(txtDataNascimento);
        lblDataNascimento.setText("Data de nascimento:");

        lblCpf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCpf.setForeground(new java.awt.Color(23, 24, 31));
        lblCpf.setLabelFor(txtCpf);
        lblCpf.setText("CPF:");

        lblSalario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSalario.setForeground(new java.awt.Color(23, 24, 31));
        lblSalario.setLabelFor(txtSalario);
        lblSalario.setText("Salário:");

        lblTipoFuncionario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTipoFuncionario.setForeground(new java.awt.Color(23, 24, 31));
        lblTipoFuncionario.setLabelFor(cmbTipoFuncionario);
        lblTipoFuncionario.setText("Função ou encargo:");

        txtNome.setEnabled(false);
        txtNome.setNextFocusableComponent(txtDataNascimento);

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setEnabled(false);
        txtCpf.setNextFocusableComponent(cmbTipoFuncionario);

        txtSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtSalario.setEnabled(false);

        cmbTipoFuncionario.setToolTipText("Selecione");
        cmbTipoFuncionario.setEnabled(false);
        cmbTipoFuncionario.setNextFocusableComponent(txtSalario);

        txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        txtDataNascimento.setEnabled(false);
        txtDataNascimento.setNextFocusableComponent(txtCpf);

        javax.swing.GroupLayout pnlDadosFuncionarioLayout = new javax.swing.GroupLayout(pnlDadosFuncionario);
        pnlDadosFuncionario.setLayout(pnlDadosFuncionarioLayout);
        pnlDadosFuncionarioLayout.setHorizontalGroup(
            pnlDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDadosFuncionarioLayout.createSequentialGroup()
                        .addComponent(lblSalario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlDadosFuncionarioLayout.createSequentialGroup()
                        .addGroup(pnlDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(lblCpf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDadosFuncionarioLayout.createSequentialGroup()
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTipoFuncionario))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosFuncionarioLayout.createSequentialGroup()
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                                .addComponent(lblDataNascimento)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );
        pnlDadosFuncionarioLayout.setVerticalGroup(
            pnlDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosFuncionarioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataNascimento)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosFuncionarioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCpf)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSalario)))
                    .addGroup(pnlDadosFuncionarioLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(pnlDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTipoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTipoFuncionario))))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        lblNome.getAccessibleContext().setAccessibleDescription("Nome");
        txtNome.getAccessibleContext().setAccessibleName("Nome");
        txtNome.getAccessibleContext().setAccessibleDescription("Nome do funcionário");
        txtCpf.getAccessibleContext().setAccessibleDescription("CPF do funcionário");
        txtSalario.getAccessibleContext().setAccessibleDescription("Salário do funcionário");
        cmbTipoFuncionario.getAccessibleContext().setAccessibleDescription("Tipo de funcionário");
        txtDataNascimento.getAccessibleContext().setAccessibleDescription("Data de nascimento do funcionário");

        pnlHoraExtras.setBackground(new java.awt.Color(49, 77, 74));
        pnlHoraExtras.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Horas Extras disponíveis", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(11, 135, 112))); // NOI18N

        lblPesquisa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPesquisa.setForeground(new java.awt.Color(23, 24, 31));
        lblPesquisa.setText("Pesquisar por Data:");

        txtPesquisaData.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPesquisaDataCaretUpdate(evt);
            }
        });
        txtPesquisaData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaDataKeyPressed(evt);
            }
        });

        tblHorasExtras.setModel(dtmHorasExtras);
        scrHorasExtras.setViewportView(tblHorasExtras);

        btnInscrever.setMnemonic(KeyEvent.VK_I);
        btnInscrever.setText("Inscrever na Hora Extra");
        btnInscrever.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscreverActionPerformed(evt);
            }
        });

        btnVerDetalhes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVerDetalhes.setForeground(new java.awt.Color(51, 51, 255));
        btnVerDetalhes.setText("Ver Detalhes da HE");
        btnVerDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalhesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHoraExtrasLayout = new javax.swing.GroupLayout(pnlHoraExtras);
        pnlHoraExtras.setLayout(pnlHoraExtrasLayout);
        pnlHoraExtrasLayout.setHorizontalGroup(
            pnlHoraExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoraExtrasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHoraExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrHorasExtras)
                    .addGroup(pnlHoraExtrasLayout.createSequentialGroup()
                        .addComponent(lblPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisaData, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnInscrever)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHoraExtrasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVerDetalhes)))
                .addContainerGap())
        );
        pnlHoraExtrasLayout.setVerticalGroup(
            pnlHoraExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHoraExtrasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHoraExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPesquisa)
                    .addComponent(txtPesquisaData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInscrever))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrHorasExtras, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerDetalhes))
        );

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlContainerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pnlDadosFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlContainerLayout.createSequentialGroup()
                                .addGap(217, 217, 217)
                                .addComponent(lblTitulo)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContainerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlHoraExtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDadosFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlHoraExtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaDataKeyPressed
        // TODO add your handling code here
    }//GEN-LAST:event_txtPesquisaDataKeyPressed

    private void btnInscreverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscreverActionPerformed
        // TODO add your handling code here:
        int selecao = tblHorasExtras.getSelectedRow();
        if(selecao == -1 ){
            JOptionPane.showMessageDialog(null, "Selecione uma Hora Extra.", 
                "HE não selecionada", JOptionPane.WARNING_MESSAGE);
        } else {
            
            int resposta = mensageInscrever(selecao);
            if(resposta == 0){
                int idHe = (int) dtmHorasExtras.getValueAt(selecao, 0);
                
                FuncHoraExtra funcHe = new FuncHoraExtra();
                funcHe.setFuncId(TelaInicial.funcionario.getId());
                funcHe.setHeId(idHe);
                inscreveHoraExtra(funcHe);
                atualizaLista();
            } else {
                tblHorasExtras.clearSelection();
            }
        }    
    }//GEN-LAST:event_btnInscreverActionPerformed

    private void txtPesquisaDataCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPesquisaDataCaretUpdate
        // TODO add your handling code here:
        String data = txtPesquisaData.getText();
        if(data.length()==0){
            atualizaLista();
        }else {
            buscarData(data);
        }
    }//GEN-LAST:event_txtPesquisaDataCaretUpdate

    private void btnVerDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalhesActionPerformed
        // TODO add your handling code here:
        int resp = tblHorasExtras.getSelectedRow();
        if(resp == -1 ){
            JOptionPane.showMessageDialog(null, "Selecione uma Hora Extra.", 
                        "HE não selecionada", JOptionPane.WARNING_MESSAGE);
        } else {
            detalharHoraExtra(resp);
        }
    }//GEN-LAST:event_btnVerDetalhesActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInscHoraExtra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            TelaInscHoraExtra dialog = new TelaInscHoraExtra(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInscrever;
    private javax.swing.JButton btnVerDetalhes;
    private javax.swing.JComboBox cmbTipoFuncionario;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblTipoFuncionario;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlDadosFuncionario;
    private javax.swing.JPanel pnlHoraExtras;
    private javax.swing.JScrollPane scrHorasExtras;
    private javax.swing.JTable tblHorasExtras;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtDataNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisaData;
    private javax.swing.JFormattedTextField txtSalario;
    // End of variables declaration//GEN-END:variables

    private void atualizaLista() {
        dtmHorasExtras.setRowCount(0);
        tblHorasExtras.setRowSorter(new TableRowSorter(dtmHorasExtras));
        HoraExtraDAO horaExtraDao = new HoraExtraDAO();
        Map<Integer, HoraExtra> listaHe = horaExtraDao.getHoraExtra();
        
        List<HoraExtra> listaNaoInscritos = listaHe.values().stream()
                                            .filter(h -> !h.isInscrito())
                                            .sorted(Comparator.comparingInt(HoraExtra::getId).reversed()) // Ordena pelo ID
                                            .collect(Collectors.toList()
        );
        
        for (HoraExtra he: listaNaoInscritos) {
            FuncionarioDAO funcionarioDao = new FuncionarioDAO();
            Funcionario funcCriador = funcionarioDao.getFuncionario(he.getCriador().getId());
            Object[] linha = {he.getId(), he.getData().format(dataFormatada), 
                                he.getHoraInicio(), he.getHoraFim(),
                                he.getObservacao(), funcCriador.getNome()};
            dtmHorasExtras.addRow(linha);
        }  
        tblHorasExtras.setRowSorter(new TableRowSorter(dtmHorasExtras));
    }

    private void carregaFuncionario() {
        txtNome.setText(TelaInicial.funcionario.getNome());
        txtDataNascimento.setText(TelaInicial.funcionario.getDataNascimento().format(dataFormatada));
        txtCpf.setText(TelaInicial.funcionario.getCpf());
        
        DecimalFormat df = new DecimalFormat("#.00");
        String numeroFormatado = df.format(TelaInicial.funcionario.getSalario());
        txtSalario.setText(numeroFormatado);
        CargoDAO cargoDao = new CargoDAO();
        Cargo cargo = cargoDao.getCargo(TelaInicial.funcionario.getCargo().getId());
        cmbTipoFuncionario.setSelectedItem(cargo);
    }
    
    private void buscarData(String data) {
        
        dtmHorasExtras.setRowCount(0);
        tblHorasExtras.setRowSorter(new TableRowSorter(dtmHorasExtras));
        HoraExtraDAO horaExtraDao = new HoraExtraDAO();
        Map<Integer, HoraExtra> listaHe = horaExtraDao.getHoraExtra();
        
        List<HoraExtra> listaNaoInscritos = listaHe.values().stream()
                                            .filter(h -> !h.isInscrito())
                                            .sorted(Comparator.comparingInt(HoraExtra::getId).reversed()) // Ordena pelo ID
                                            .collect(Collectors.toList()
        );
        
        for (HoraExtra he: listaNaoInscritos) {
            if(he.getData().format(dataFormatada).startsWith(data)){
        
                FuncionarioDAO funcionarioDao = new FuncionarioDAO();
                Funcionario funcCriador = funcionarioDao.getFuncionario(he.getCriador().getId());
                Object[] linha = {he.getId(), he.getData().format(dataFormatada), 
                                    he.getHoraInicio(), he.getHoraFim(),
                                    he.getObservacao(), funcCriador.getNome()};
                dtmHorasExtras.addRow(linha);
            }
        }

    }
    
    private void inscreveHoraExtra(FuncHoraExtra funcHe) {
        FuncHoraExtraDAO funcHeDao = new FuncHoraExtraDAO();
        funcHeDao.inserir(funcHe);
        
        HoraExtraDAO heDao = new HoraExtraDAO();
        heDao.inscrever(funcHe.getHeId());
    }
    
    private int mensageInscrever(int selecao) {
        int id = (int) dtmHorasExtras.getValueAt(selecao, 0);
       
        String data = (String) dtmHorasExtras.getValueAt(selecao, 1);
        LocalTime inicio = (LocalTime) dtmHorasExtras.getValueAt(selecao, 2);
        LocalTime termino = (LocalTime) dtmHorasExtras.getValueAt(selecao, 3);
        String criador = (String) dtmHorasExtras.getValueAt(selecao, 5);

        String mensagem = """
                          Deseja se inscrever na Hora Extra Selecionada: 
                          ID: """ + id
                            + "\nData: " + data
                            + "\nInício: " + inicio
                            + "\nTérmino: " + termino
                            + "\nCriada por: " + criador;
        Object[] opcoes = {"Sim", "Não"};
  
        int resposta = JOptionPane.showOptionDialog(null, mensagem, 
            "Inscrever-se na Hora Extra?", JOptionPane.DEFAULT_OPTION, 
            JOptionPane.WARNING_MESSAGE,null, 
            opcoes, opcoes[1]);
        
        return resposta;
    }
    
    private void preencherComboCargo() {
        CargoDAO cargoDao = new CargoDAO();
        List<Cargo> lista = cargoDao.getCargo();
        
        for (Cargo c : lista){
            cmbTipoFuncionario.addItem(c);
        }
    }
    
    private void detalharHoraExtra(int selecao) {
        int id = (int) dtmHorasExtras.getValueAt(selecao, 0);

        HoraExtraDAO horaExtraDao = new HoraExtraDAO();
        HoraExtra he = horaExtraDao.getHoraExtra(id);
        
        FuncionarioDAO funcionarioDao = new FuncionarioDAO();
        Funcionario funcionario = funcionarioDao.getFuncionario(he.getCriador().getId());
        String mensagem = "<html><body>" +
                "<b><span>ID: </span></b>" + id + "<br>" +
                "<b><span>Data: </span></b>" + he.getData().format(dataFormatada) + "<br>" +
                "<b><span>Início: </span></b>" + he.getHoraInicio().toString() + "<br>" +
                "<b><span>Termino: </span></b>" + he.getHoraInicio().toString() + "<br>" +
                "<b><span>Criada por: </span></b>" + funcionario.getNome() + "<br>" +
                "<b>Observação: <span style='color:blue;'>"+ he.getObservacao() + "</span></b>" +
                "</body></html>";

        JOptionPane.showMessageDialog(
            null, 
            mensagem, 
            "Detalhes da Hora Extra", 
            JOptionPane.INFORMATION_MESSAGE
        );

        tblHorasExtras.clearSelection();
    }
}