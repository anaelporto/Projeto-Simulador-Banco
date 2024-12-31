package br.unesp.rc.projeto1soo2023;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class LoginInterface extends Projeto1SOO2023{
    public static void Inicial() {

        final JFrame janela = new JFrame("Login");
        janela.setSize(300, 200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        JLabel labelUsuario = new JLabel("CPF:");
        JLabel labelSenha = new JLabel("Senha:");
        final JTextField campoUsuario = new JTextField(10);
        final JPasswordField campoSenha = new JPasswordField(10);
        JButton botaoEntrar = new JButton("Entrar");
        JButton botaoCadastrar = new JButton("Cadastrar");


        botaoEntrar.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String cpf = campoUsuario.getText();
                String senha = String.valueOf(campoSenha.getPassword());
                if (cpf.equals("admin") && senha.equals("admin")) {
                    abrirTelaBanco();
                    janela.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
                }
            } 
        });
        
        botaoCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                cadastrarConta();
            }
        });

        painel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        painel.add(labelUsuario, gbc);
        gbc.gridy = 1;
        painel.add(labelSenha, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel.add(campoUsuario, gbc);
        gbc.gridy = 1;
        painel.add(campoSenha, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        painel.add(botaoEntrar, gbc);
        gbc.gridy = 3;
        painel.add(botaoCadastrar, gbc);

        janela.add(painel);
        janela.setVisible(true);
    }

    public static void abrirTelaBanco() {

        JFrame janela = new JFrame("Conta Bancária");
        janela.setSize(400, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        JButton botaoSaldo = new JButton("Saldo");
        JButton botaoDepositar = new JButton("Depositar");
        JButton botaoSacar = new JButton("Sacar");
        JButton botaoExtrato = new JButton("Extrato");
        JButton botaoEncerrarConta = new JButton("Encerrar Conta");
        
        botaoExtrato.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                telaExtrato();
            }
        });

        botaoEncerrarConta.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente encerrar a conta?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    // implementação da lógica para encerrar a conta
                    JOptionPane.showMessageDialog(null, "Conta encerrada com sucesso!");
                    System.exit(0);
                }
            }
        });
        
        JButton botaoAlterarDados = new JButton("Alterar Dados");
        botaoAlterarDados.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                final JFrame janelaAlterarDados = new JFrame("Alterar Dados");
                janelaAlterarDados.setSize(400, 550);
                janelaAlterarDados.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel painel = new JPanel();
                JLabel labelCPF = new JLabel("CPF:");
                JLabel labelNome = new JLabel("Nome:");
                JLabel labelSobrenome = new JLabel("Sobrenome:");
                JLabel labelRG = new JLabel("RG:");
                JLabel labelEmail = new JLabel("Email:");
                JLabel labelTelefone = new JLabel("Telefone:");
                JLabel labelCelular = new JLabel("Celular:");
                JLabel labelCEP = new JLabel("CEP:");
                JLabel labelUF = new JLabel("UF:");
                JLabel labelCidade = new JLabel("Cidade:");
                JLabel labelBairro = new JLabel("Bairro:");
                JLabel labelRua = new JLabel("Rua:");
                JLabel labelNumero = new JLabel("Numero:");
                JLabel labelPontoDeReferencia = new JLabel("Ponto De Referencia:");
                final JTextField campoCPF = new JTextField(20);
                campoCPF.setText("123.456.789-0");
                campoCPF.setEditable(false);
                final JTextField campoNome = new JTextField(20);
                campoNome.setText("Andre");
                final JTextField campoSobrenome = new JTextField(20);
                campoSobrenome.setText("Silva");
                final JTextField campoRG = new JTextField(20);
                campoRG.setText("12345678-9");
                final JTextField campoEmail = new JTextField(20);
                campoEmail.setText("andre@bol.com");
                final JTextField campoTelefone = new JTextField(20);
                campoTelefone.setText("1133333333");
                final JTextField campoCelular = new JTextField(20);
                campoCelular.setText("11999999999");
                final JTextField campoCEP = new JTextField(20);
                campoCEP.setText("01234-567");
                final JTextField campoUF = new JTextField(20);
                campoUF.setText("SP");
                final JTextField campoCidade = new JTextField(20);
                campoCidade.setText("Sao Paulo");
                final JTextField campoBairro = new JTextField(20);
                campoBairro.setText("Limao");
                final JTextField campoRua = new JTextField(20);
                campoRua.setText("rua Dr. Pompeu");
                final JTextField campoNumero = new JTextField(20);
                campoNumero.setText("123");
                final JTextField campoPontoDeReferencia = new JTextField(20);
                campoPontoDeReferencia.setText("em frente ao MC");
                JButton botaoSalvar = new JButton("Salvar");
                botaoSalvar.addActionListener(new ActionListener() {
                    
                    public void actionPerformed(ActionEvent e) {
                        // implementação da lógica para salvar os dados alterados
                        JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
                        janelaAlterarDados.dispose();
                    }
                });
                
                

                painel.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.insets = new Insets(5, 5, 5, 5);
                painel.add(labelCPF, gbc);
                gbc.gridy = 1;
                painel.add(labelNome, gbc);
                gbc.gridy = 2;
                painel.add(labelSobrenome, gbc);
                gbc.gridy = 3;
                painel.add(labelRG, gbc);
                gbc.gridy = 4;
                painel.add(labelEmail, gbc);
                gbc.gridy = 5;
                painel.add(labelTelefone, gbc);
                gbc.gridy = 6;
                painel.add(labelCelular, gbc);
                gbc.gridy = 7;
                painel.add(labelCEP, gbc);
                gbc.gridy = 8;
                painel.add(labelUF, gbc);
                gbc.gridy = 9;
                painel.add(labelCidade, gbc);
                gbc.gridy = 10;
                painel.add(labelBairro, gbc);
                gbc.gridy = 11;
                painel.add(labelRua, gbc);
                gbc.gridy = 12;
                painel.add(labelNumero, gbc);
                gbc.gridy = 13;
                painel.add(labelPontoDeReferencia, gbc);
                gbc.gridx = 1;
                gbc.gridy = 0;
                painel.add(campoCPF, gbc);
                gbc.gridy = 1;
                painel.add(campoNome, gbc);
                gbc.gridy = 2;
                painel.add(campoSobrenome, gbc);
                gbc.gridy = 3;
                painel.add(campoRG, gbc);
                gbc.gridy = 4;
                painel.add(campoEmail, gbc);
                gbc.gridy = 5;
                painel.add(campoTelefone, gbc);
                gbc.gridy = 6;
                painel.add(campoCelular, gbc);
                gbc.gridy = 7;
                painel.add(campoCEP, gbc);
                gbc.gridy = 8;
                painel.add(campoUF, gbc);
                gbc.gridy = 9;
                painel.add(campoCidade, gbc);
                gbc.gridy = 10;
                painel.add(campoBairro, gbc);
                gbc.gridy = 11;
                painel.add(campoRua, gbc);
                gbc.gridy = 12;
                painel.add(campoNumero, gbc);
                gbc.gridy = 13;
                painel.add(campoPontoDeReferencia, gbc);
                gbc.gridx = 0;
                gbc.gridy = 14;
                gbc.gridwidth = 2;
                painel.add(botaoSalvar, gbc);

                janelaAlterarDados.add(painel);
                janelaAlterarDados.setVisible(true);
                
            }
        });

        botaoDepositar.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                final JFrame novaJanela = new JFrame("Depositar");
                novaJanela.setSize(300, 150);
                novaJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JPanel novoPainel = new JPanel();
                JLabel novoLabel = new JLabel("Valor a depositar:");
                final JTextField novoCampo = new JTextField(10);
                JButton novoBotao = new JButton("Depositar");
                novoBotao.addActionListener(new ActionListener() {
                    
                    public void actionPerformed(ActionEvent e) {
                        double valor = Double.parseDouble(novoCampo.getText());
                        depositar(valor);
                        novaJanela.dispose();
                    }
                });
                novoPainel.add(novoLabel);
                novoPainel.add(novoCampo);
                novoPainel.add(novoBotao);
                novaJanela.add(novoPainel);
                novaJanela.setVisible(true);
            }
        });

        botaoSacar.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                final JFrame novaJanela = new JFrame("Sacar");
                novaJanela.setSize(300, 150);
                novaJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JPanel novoPainel = new JPanel();
                JLabel novoLabel = new JLabel("Valor a sacar:");
                final JTextField novoCampo = new JTextField(10);
                JButton novoBotao = new JButton("Sacar");
                novoBotao.addActionListener(new ActionListener() {
                    
                    public void actionPerformed(ActionEvent e) {
                        double valor = Double.parseDouble(novoCampo.getText());
                        sacar(valor);
                        novaJanela.dispose();
                    }
                });
                novoPainel.add(novoLabel);
                novoPainel.add(novoCampo);
                novoPainel.add(novoBotao);
                novaJanela.add(novoPainel);
                novaJanela.setVisible(true);
            }
        });
        
        botaoSaldo.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                JFrame janela = new JFrame("Dados Bancários");
                JPanel painel = new JPanel(new GridBagLayout());
                
                JLabel labelConta = new JLabel("Conta: ");
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.LINE_END;
                gbc.insets = new Insets(10, 10, 10, 10);
                painel.add(labelConta, gbc);
                
                JTextField campoConta = new JTextField(10);
                campoConta.setText("xxxxxxxxx");
                campoConta.setEditable(false);
                gbc = new GridBagConstraints();
                gbc.gridx = 1;
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.LINE_START;
                gbc.insets = new Insets(10, 10, 10, 10);
                painel.add(campoConta, gbc);
                
                JLabel labelAgencia = new JLabel("Agência: ");
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.anchor = GridBagConstraints.LINE_END;
                gbc.insets = new Insets(10, 10, 10, 10);
                painel.add(labelAgencia, gbc);
                
                JTextField campoAgencia = new JTextField(10);
                campoAgencia.setText("yyyyy");
                campoAgencia.setEditable(false);
                gbc = new GridBagConstraints();
                gbc.gridx = 1;
                gbc.gridy = 1;
                gbc.anchor = GridBagConstraints.LINE_START;
                gbc.insets = new Insets(10, 10, 10, 10);
                painel.add(campoAgencia, gbc);
                
                JLabel labelSaldo = new JLabel("Saldo: ");
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.anchor = GridBagConstraints.LINE_END;
                gbc.insets = new Insets(10, 10, 10, 10);
                painel.add(labelSaldo, gbc);
                
                JTextField campoSaldo = new JTextField(10);
                campoSaldo.setText(String.format("R$ %.2f", getSaldo()));
                campoSaldo.setEditable(false);
                gbc = new GridBagConstraints();
                gbc.gridx = 1;
                gbc.gridy = 2;
                gbc.anchor = GridBagConstraints.LINE_START;
                gbc.insets = new Insets(10, 10, 10, 10);
                painel.add(campoSaldo, gbc);
                
                janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                janela.getContentPane().add(painel);
                janela.pack();
                janela.setLocationRelativeTo(null);
                janela.setVisible(true);
            }
        });

        painel.add(botaoSaldo);
        painel.add(botaoDepositar);
        painel.add(botaoSacar);
        painel.add(botaoExtrato);
        painel.add(botaoAlterarDados);
        painel.add(botaoEncerrarConta);
        

        janela.add(painel);
        janela.setVisible(true);
    }

    private static double saldo = 0;

    public static double getSaldo() {
        return saldo;
    }

    public static void depositar(double valor) {
        saldo += valor;
    }

    public static void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
        }
    }
    
    public static void cadastrarConta() {
        final JFrame janela = new JFrame("Cadastro de Conta");
        janela.setSize(400, 550);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel();
        JLabel labelCPF = new JLabel("CPF:");
        JLabel labelNome = new JLabel("Nome:");
        JLabel labelSobrenome = new JLabel("Sobrenome:");
        JLabel labelRG = new JLabel("RG:");
        JLabel labelNovaSenha = new JLabel("Nova Senha:");
        JLabel labelEmail = new JLabel("Email:");
        JLabel labelTelefone = new JLabel("Telefone:");
        JLabel labelCelular = new JLabel("Celular:");
        JLabel labelCEP = new JLabel("CEP:");
        JLabel labelUF = new JLabel("UF:");
        JLabel labelCidade = new JLabel("Cidade:");
        JLabel labelBairro = new JLabel("Bairro:");
        JLabel labelRua = new JLabel("Rua:");
        JLabel labelNumero = new JLabel("Numero:");
        JLabel labelPontoDeReferencia = new JLabel("Ponto De Referencia:");
        final JTextField campoCPF = new JTextField(20);
        final JTextField campoNome = new JTextField(20);
        final JTextField campoSobrenome = new JTextField(20);
        final JTextField campoRG = new JTextField(20);
        final JPasswordField campoNovaSenha = new JPasswordField(20);
        final JTextField campoEmail = new JTextField(20);
        final JTextField campoTelefone = new JTextField(20);
        final JTextField campoCelular = new JTextField(20);
        final JTextField campoCEP = new JTextField(20);
        final JTextField campoUF = new JTextField(20);
        final JTextField campoCidade = new JTextField(20);
        final JTextField campoBairro = new JTextField(20);
        final JTextField campoRua = new JTextField(20);
        final JTextField campoNumero = new JTextField(20);
        final JTextField campoPontoDeReferencia = new JTextField(20);
        JButton botaoCadastrar = new JButton("Cadastrar");

        botaoCadastrar.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	String cpf = campoCPF.getText();
                String nome = campoNome.getText();
                String sobrenome = campoSobrenome.getText();
                String rg = campoRG.getText();
                String novaSenha = String.valueOf(campoNovaSenha.getPassword());
                String email = campoEmail.getText();
                String telefone = campoTelefone.getText();
                String celular = campoCelular.getText();
                String cep = campoCEP.getText();
                String uf = campoUF.getText();
                String cidade = campoCidade.getText();
                String bairro = campoBairro.getText();
                String rua = campoRua.getText();
                String numero = campoNumero.getText();
                String pontoDeReferencia = campoPontoDeReferencia.getText();
                // implementação da lógica para cadastrar a nova conta
                JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso!");
                janela.dispose();
            }
        });
        
        

        painel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        painel.add(labelCPF, gbc);
        gbc.gridy = 1;
        painel.add(labelNome, gbc);
        gbc.gridy = 2;
        painel.add(labelSobrenome, gbc);
        gbc.gridy = 3;
        painel.add(labelRG, gbc);
        gbc.gridy = 4;
        painel.add(labelNovaSenha, gbc);
        gbc.gridy = 5;
        painel.add(labelEmail, gbc);
        gbc.gridy = 6;
        painel.add(labelTelefone, gbc);
        gbc.gridy = 7;
        painel.add(labelCelular, gbc);
        gbc.gridy = 8;
        painel.add(labelCEP, gbc);
        gbc.gridy = 9;
        painel.add(labelUF, gbc);
        gbc.gridy = 10;
        painel.add(labelCidade, gbc);
        gbc.gridy = 11;
        painel.add(labelBairro, gbc);
        gbc.gridy = 12;
        painel.add(labelRua, gbc);
        gbc.gridy = 13;
        painel.add(labelNumero, gbc);
        gbc.gridy = 14;
        painel.add(labelPontoDeReferencia, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel.add(campoCPF, gbc);
        gbc.gridy = 1;
        painel.add(campoNome, gbc);
        gbc.gridy = 2;
        painel.add(campoSobrenome, gbc);
        gbc.gridy = 3;
        painel.add(campoRG, gbc);
        gbc.gridy = 4;
        painel.add(campoNovaSenha, gbc);
        gbc.gridy = 5;
        painel.add(campoEmail, gbc);
        gbc.gridy = 6;
        painel.add(campoTelefone, gbc);
        gbc.gridy = 7;
        painel.add(campoCelular, gbc);
        gbc.gridy = 8;
        painel.add(campoCEP, gbc);
        gbc.gridy = 9;
        painel.add(campoUF, gbc);
        gbc.gridy = 10;
        painel.add(campoCidade, gbc);
        gbc.gridy = 11;
        painel.add(campoBairro, gbc);
        gbc.gridy = 12;
        painel.add(campoRua, gbc);
        gbc.gridy = 13;
        painel.add(campoNumero, gbc);
        gbc.gridy = 14;
        painel.add(campoPontoDeReferencia, gbc);
        gbc.gridx = 0;
        gbc.gridy = 15;
        gbc.gridwidth = 2;
        painel.add(botaoCadastrar, gbc);

        janela.add(painel);
        janela.setVisible(true);
    }
    
    public static void telaExtrato() {
    	final JFrame frame = new JFrame("Extrato");
    	frame.setVisible(true);
        frame.setBounds(100, 100, 500, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane);

        // Colunas da tabela
        String[] colunas = {"Data", "Descrição", "Valor"};

        // Cria o modelo da tabela
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        // Adiciona linhas de exemplo
        ArrayList<TransacaoInterface> transacoes = new ArrayList<TransacaoInterface>();
        transacoes.add(new TransacaoInterface(new Date(), "Depósito em dinheiro", 100.00));
        transacoes.add(new TransacaoInterface(new Date(), "Saque em caixa eletrônico", -50.00));
        transacoes.add(new TransacaoInterface(new Date(), "Pagamento de conta de luz", -80.00));
        transacoes.add(new TransacaoInterface(new Date(), "Transferência recebida", 200.00));
        transacoes.add(new TransacaoInterface(new Date(), "Transferência enviada", -150.00));

        for (TransacaoInterface t : transacoes) {
            model.addRow(new Object[] {t.getData(), t.getDescricao(), t.getValor()});
        }

        // Cria a tabela
        JTable table = new JTable(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(250);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        scrollPane.setViewportView(table);
    }

}

