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
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TelaHoraExtrasInscrito extends javax.swing.JDialog {

    DefaultTableModel dtmHorasExtras;
    DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public TelaHoraExtrasInscrito(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        preencherComboCargo();
        carregaFuncionario();
        carregaTotalHE();
    }
    
    public TelaHoraExtrasInscrito(java.awt.Frame parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();
        preencherComboCargo();
        carregaFuncionario(id);
        carregaTotalHE();
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
        txtId = new javax.swing.JTextField();
        pnlHoraExtras = new javax.swing.JPanel();
        lblMes = new javax.swing.JLabel();
        scrHorasExtras = new javax.swing.JScrollPane();
        String colunas[] = {"ID", "Data", "Começo", "Término", "Criador", "Aprovada"};
        dtmHorasExtras = new DefaultTableModel(colunas, 0){
            // Sobrescreva isCellEditable para impedir a edição de linhas específicas
            @Override
            public boolean isCellEditable(int row, int column) {
                // Impede a edição das linhas 0 e 1
                return false;
            }
        };
        tblHorasExtras = new javax.swing.JTable();
        btnFiltrar = new javax.swing.JButton();
        cmbMes = new javax.swing.JComboBox<>();
        lblAno = new javax.swing.JLabel();
        cmbAno = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtResposta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Horas Extras Realizadas");
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

        txtId.setEditable(false);
        txtId.setEnabled(false);

        javax.swing.GroupLayout pnlDadosFuncionarioLayout = new javax.swing.GroupLayout(pnlDadosFuncionario);
        pnlDadosFuncionario.setLayout(pnlDadosFuncionarioLayout);
        pnlDadosFuncionarioLayout.setHorizontalGroup(
            pnlDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosFuncionarioLayout.createSequentialGroup()
                        .addGroup(pnlDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(lblCpf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDadosFuncionarioLayout.createSequentialGroup()
                        .addComponent(lblSalario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(pnlDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoFuncionario)
                    .addComponent(lblDataNascimento))
                .addGap(16, 16, 16)
                .addGroup(pnlDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
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
                            .addComponent(lblTipoFuncionario))
                        .addGap(18, 18, 18)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        lblNome.getAccessibleContext().setAccessibleDescription("Nome");
        txtNome.getAccessibleContext().setAccessibleName("Nome");
        txtNome.getAccessibleContext().setAccessibleDescription("Nome do funcionário");
        txtCpf.getAccessibleContext().setAccessibleDescription("CPF do funcionário");
        txtSalario.getAccessibleContext().setAccessibleDescription("Salário do funcionário");
        cmbTipoFuncionario.getAccessibleContext().setAccessibleDescription("Tipo de funcionário");
        txtDataNascimento.getAccessibleContext().setAccessibleDescription("Data de nascimento do funcionário");

        pnlHoraExtras.setBackground(new java.awt.Color(49, 77, 74));
        pnlHoraExtras.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Horas Extras Inscritas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(11, 135, 112))); // NOI18N

        lblMes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMes.setForeground(new java.awt.Color(23, 24, 31));
        lblMes.setText("Mês:");

        tblHorasExtras.setModel(dtmHorasExtras);
        scrHorasExtras.setViewportView(tblHorasExtras);

        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFiltrar.setMnemonic(KeyEvent.VK_F);
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        lblAno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAno.setForeground(new java.awt.Color(23, 24, 31));
        lblAno.setText("Ano:");

        cmbAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "2024", "2025" }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(23, 24, 31));
        jLabel1.setText("HE realizadas:");

        txtResposta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtResposta.setForeground(new java.awt.Color(11, 135, 112));
        txtResposta.setText("0h 0min");

        javax.swing.GroupLayout pnlHoraExtrasLayout = new javax.swing.GroupLayout(pnlHoraExtras);
        pnlHoraExtras.setLayout(pnlHoraExtrasLayout);
        pnlHoraExtrasLayout.setHorizontalGroup(
            pnlHoraExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoraExtrasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHoraExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrHorasExtras, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                    .addGroup(pnlHoraExtrasLayout.createSequentialGroup()
                        .addComponent(lblMes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtResposta)))
                .addContainerGap())
        );
        pnlHoraExtrasLayout.setVerticalGroup(
            pnlHoraExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHoraExtrasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHoraExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMes)
                    .addComponent(btnFiltrar)
                    .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAno)
                    .addComponent(cmbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtResposta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrHorasExtras, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
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
                        .addGap(0, 6, Short.MAX_VALUE))
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

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        // TODO add your handling code here:
                filtraLista();  
    }//GEN-LAST:event_btnFiltrarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaHoraExtrasInscrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
            TelaHoraExtrasInscrito dialog = new TelaHoraExtrasInscrito(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JComboBox<String> cmbAno;
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JComboBox cmbTipoFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNome;
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
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JLabel txtResposta;
    private javax.swing.JFormattedTextField txtSalario;
    // End of variables declaration//GEN-END:variables
        
    private void carregaFuncionario() {
        txtId.setVisible(false);
        txtNome.setText(TelaInicial.funcionario.getNome());
        txtDataNascimento.setText(TelaInicial.funcionario.getDataNascimento().format(dataFormatada));
        txtCpf.setText(TelaInicial.funcionario.getCpf());
        txtId.setText(TelaInicial.funcionario.getId()+"");
        
        DecimalFormat df = new DecimalFormat("#.00");
        String numeroFormatado = df.format(TelaInicial.funcionario.getSalario());
        txtSalario.setText(numeroFormatado);
        CargoDAO cargoDao = new CargoDAO();
        Cargo cargo = cargoDao.getCargo(TelaInicial.funcionario.getCargo().getId());
        cmbTipoFuncionario.setSelectedItem(cargo);
        
        atualizaLista();
    }
    
    
    
    private void carregaFuncionario(int idFuncionario) {
        FuncionarioDAO funcDao = new FuncionarioDAO();
        Funcionario funcionario = funcDao.getFuncionario(idFuncionario);
        txtId.setVisible(false);
        txtNome.setText(funcionario.getNome());
        txtDataNascimento.setText(funcionario.getDataNascimento().format(dataFormatada));
        txtCpf.setText(funcionario.getCpf());
        txtId.setText(funcionario.getId()+"");
        
        DecimalFormat df = new DecimalFormat("#.00");
        String numeroFormatado = df.format(funcionario.getSalario());
        txtSalario.setText(numeroFormatado);
        CargoDAO cargoDao = new CargoDAO();
        Cargo cargo = cargoDao.getCargo(funcionario.getCargo().getId());
        cmbTipoFuncionario.setSelectedItem(cargo);
        
       atualizaLista(idFuncionario);
    }

    private void atualizaLista() {
        dtmHorasExtras.setRowCount(0);
        tblHorasExtras.setRowSorter(new TableRowSorter(dtmHorasExtras));
        FuncHoraExtraDAO funcHeDao = new FuncHoraExtraDAO();
        List<FuncHoraExtra> listaHeFunc = funcHeDao.getFuncHoraExtraIdFunc(Integer.parseInt(txtId.getText()));
        for (FuncHoraExtra funcHe : listaHeFunc) {
            HoraExtraDAO horaExtraDao = new HoraExtraDAO();
            HoraExtra he = horaExtraDao.getHoraExtra(funcHe.getHeId());
      
            String aprovado = he.isVerificada()? he.isAprovada() ? "Sim" : "Não" :"Em andamento";
            
            FuncionarioDAO funcDao = new FuncionarioDAO();
            Funcionario func = funcDao.getFuncionario(he.getCriador().getId());
            Object[] linha = {funcHe.getHeId(), he.getData().format(dataFormatada), he.getHoraInicio(),
                              he.getHoraFim(), func.getNome(), aprovado};
            dtmHorasExtras.addRow(linha);
        }
    }
    
    private void atualizaLista(int idFunc) {
        dtmHorasExtras.setRowCount(0);
        FuncHoraExtraDAO funcHeDao = new FuncHoraExtraDAO();
        List<FuncHoraExtra> listaHeFunc = funcHeDao.getFuncHoraExtraIdFunc(idFunc);
        for (FuncHoraExtra funcHe : listaHeFunc) {
            HoraExtraDAO horaExtraDao = new HoraExtraDAO();
            HoraExtra he = horaExtraDao.getHoraExtra(funcHe.getHeId());
      
            String aprovado = he.isVerificada()? he.isAprovada() ? "Sim" : "Não" :"Em andamento";
            
            FuncionarioDAO funcDao = new FuncionarioDAO();
            Funcionario func = funcDao.getFuncionario(he.getCriador().getId());
            Object[] linha = {funcHe.getHeId(), he.getData().format(dataFormatada), he.getHoraInicio(),
                              he.getHoraFim(), func.getNome(), aprovado};
            dtmHorasExtras.addRow(linha);
        }
    }
    
    void montaTabela(List<HoraExtra> datasFiltradas) {
        for (HoraExtra he : datasFiltradas) {
            FuncionarioDAO funcDao = new FuncionarioDAO();
            Funcionario funCriador = funcDao.getFuncionario(he.getCriador().getId());
            
            String aprovado = he.isVerificada()? he.isAprovada() ? "Sim" : "Não" :"Em andamento";
            
            Object[] linha = {he.getId(), he.getData().format(dataFormatada), 
                                he.getHoraInicio(), he.getHoraFim(),
                                nomeSobrenome(funCriador.getNome()), aprovado};
            dtmHorasExtras.addRow(linha);
        }
    }
    
    private void filtraLista() {
        dtmHorasExtras.setRowCount(0);
        int mesFiltrar = cmbMes.getSelectedIndex();
        int anoFiltrar = cmbAno.getSelectedIndex();
        
        FuncHoraExtraDAO fheDao = new FuncHoraExtraDAO();
        List<FuncHoraExtra> fhe = fheDao.getFuncHoraExtraIdFunc(Integer.parseInt(txtId.getText()));
        
        HoraExtraDAO heDao = new HoraExtraDAO();
        
        List<HoraExtra> listaHe = new ArrayList<>();
        
        for(FuncHoraExtra fheFor: fhe) {
            HoraExtra he = heDao.getHoraExtra(fheFor.getHeId());
            listaHe.add(he);
        }

        List<HoraExtra> heFiltradas;
        
        if((mesFiltrar == 0) && (anoFiltrar == 0)){
            atualizaLista();
            carregaTotalHE();
        } else if((mesFiltrar != 0) && (anoFiltrar == 0)){
            heFiltradas = listaHe.stream()
                .filter(he -> he.getData().getMonthValue()== mesFiltrar)
                .sorted(Comparator.comparingInt(HoraExtra::getId).reversed()) // Ordena pelo ID
                .collect(Collectors.toList());
            montaTabela(heFiltradas);
            carregaTotalHE(mesFiltrar);
        } else if((mesFiltrar == 0) && (anoFiltrar != 0)){
            heFiltradas = listaHe.stream()
                .filter(he -> he.getData().getYear()== Integer.parseInt(cmbAno.getSelectedItem().toString()))
                .sorted(Comparator.comparingInt(HoraExtra::getId).reversed()) // Ordena pelo ID
                .collect(Collectors.toList());
            montaTabela(heFiltradas);
            carregaTotalHE(mesFiltrar, Integer.parseInt(cmbAno.getSelectedItem().toString()));
        } else { 
            heFiltradas = listaHe.stream()
                .filter(he -> he.getData().getMonthValue()== mesFiltrar)
                .filter(he -> he.getData().getYear()== Integer.parseInt(cmbAno.getSelectedItem().toString()))
                .sorted(Comparator.comparingInt(HoraExtra::getId).reversed()) // Ordena pelo ID
                .collect(Collectors.toList());
            montaTabela(heFiltradas);
            carregaTotalHE(mesFiltrar, Integer.parseInt(cmbAno.getSelectedItem().toString()));
        }
    }
    
    private void carregaTotalHE() {
        List<HoraExtra> listaHe = listaHeId(Integer.parseInt(txtId.getText()));

        Duration totalHorasExtras = listaHe.stream()
                        .filter(he -> he.isAprovada())
                        .map(HoraExtra::getDuracao)
                        .reduce(Duration.ZERO, Duration::plus); // Soma das durações
        String resp = totalHorasExtras.toHours() + "h " + totalHorasExtras.toMinutesPart() + "m";
        txtResposta.setText(resp);
    }
    
    private void carregaTotalHE(int mes) {
        List<HoraExtra> listaHe = listaHeId(Integer.parseInt(txtId.getText()));
        
        Duration totalHorasExtras = listaHe.stream()
                        .filter(he -> he.isAprovada())
                        .filter(he -> he.getData().getMonthValue() == mes)
                        .map(HoraExtra::getDuracao)
                        .reduce(Duration.ZERO, Duration::plus); // Soma das durações
        String resp = totalHorasExtras.toHours() + "h " + totalHorasExtras.toMinutesPart() + "m";
        txtResposta.setText(resp);
    }
    
    private void carregaTotalHE(int mes, int ano) {
        List<HoraExtra> listaHe = listaHeId(Integer.parseInt(txtId.getText()));
        if(mes == 0) {
            Duration totalHorasExtras = listaHe.stream()
                            .filter(he -> he.isAprovada())
                            .filter(he -> he.getData().getYear() == ano)
                            .map(HoraExtra::getDuracao)
                            .reduce(Duration.ZERO, Duration::plus); // Soma das durações
            String resp = totalHorasExtras.toHours() + "h " + totalHorasExtras.toMinutesPart() + "m";
            txtResposta.setText(resp);
        } else {
            Duration totalHorasExtras = listaHe.stream()
                            .filter(he -> he.isAprovada())
                            .filter(he -> he.getData().getYear() == ano)
                            .filter(he -> he.getData().getMonthValue() == mes)
                            .map(HoraExtra::getDuracao)
                            .reduce(Duration.ZERO, Duration::plus); // Soma das durações
            String resp = totalHorasExtras.toHours() + "h " + totalHorasExtras.toMinutesPart() + "m";
            txtResposta.setText(resp);
        }
    }
    
    private List<HoraExtra> listaHeId(int id) {
        FuncHoraExtraDAO fheDao = new FuncHoraExtraDAO();
        List<FuncHoraExtra> fheLista = fheDao.getFuncHoraExtraIdFunc(id);
        List<HoraExtra> listaHe = new ArrayList<>();
        
        HoraExtraDAO heDao = new HoraExtraDAO();
        
        for(FuncHoraExtra ff: fheLista) {
            listaHe.add(heDao.getHoraExtra(ff.getHeId()));
        }
        return listaHe;
    }
    
    private String nomeSobrenome(String nomeCompleto) {
       String[] partes = nomeCompleto.split("\\s+");
        String primeiroNome = partes.length > 0 ? partes[0] : "";
        String ultimoNome = partes.length > 1 ? partes[partes.length - 1] : "";
        
        return primeiroNome + " " + ultimoNome;
    }
    
    private void preencherComboCargo() {
        CargoDAO cargoDao = new CargoDAO();
        List<Cargo> lista = cargoDao.getCargo();
        
        for (Cargo c : lista){
            cmbTipoFuncionario.addItem(c);
        }
    }
}
