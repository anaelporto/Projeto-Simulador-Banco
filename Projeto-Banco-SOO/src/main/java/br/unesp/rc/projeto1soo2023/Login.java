/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.rc.projeto1soo2023;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author anael
 */
public class Login extends Projeto1SOO2023{
    private int idConta;
    private int idAgencia;
    private String documentoAcesso;
    private String codigoSeguranca;
    private String testeA;
    private String testeS;
    
    private int idCliente;
    private String nomeCliente;
    private int idCliCon;
    
    private int op;
    
    Scanner ler = new Scanner(System.in);
    
    private static final String BuscaCon = "select idConta, idAgencia, documentoAcesso,"
            + " codigoSeguranca from conta where idConta =?";
    private static final String BuscaCli = "select idCliente, nomeCliente,"
            + " idConta from cliente where idCliente =?";
    
    public void MenuLogin(){
        Cliente operaCliente = new Cliente();
        Conta operaConta = new Conta();
        Contato operaContato = new Contato();
        Endereco operaEnd = new Endereco();
        
        System.out.println("Bem-vindo(a) ao sistema!");
        System.out.println("Por favor, selecione uma opção:");
        System.out.println("1 - Novo cadastro.");
        System.out.println("2 - Login.");
        this.op = ler.nextInt();

        System.out.println("Por favor, insira seu CPF:");
        this.idCliente = ler.nextInt();
        
        ler.nextLine();
        
        if(this.op == 1){
            operaCliente.InserirCliente(idCliente);
            
            operaConta.InserirConta(idCliente);

            operaContato.InserirContato(idCliente);

            operaEnd.InserirEndereco(idCliente);

            System.out.println("Cadastro efetuado com sucesso!");

            FazerLogin(idCliente);         
        }else if(this.op == 2){
            FazerLogin(idCliente);
        }
    }
    
    private void FazerLogin(int IDc){
        this.idConta = (IDc / 43) + 1;
        
        System.out.println("Por favor, faça o login.");
        System.out.print("Insira o RG: ");
        this.documentoAcesso = ler.nextLine();
        
        System.out.print("Insira o Código de Segurança: ");
        this.codigoSeguranca = ler.nextLine();
        
        FazerLogin(idConta, documentoAcesso, codigoSeguranca);
    }
    
    private void FazerLogin(int IDc, String Da, String Cs){
        this.idConta = IDc;
        this.documentoAcesso = Da;
        this.codigoSeguranca = Cs;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/projeto1",
                "root",
                "");
                {
                    PreparedStatement buscacon = conexao.prepareStatement(BuscaCon);
                    buscacon.setInt(1, idConta);
                    //System.out.println(preparedStatement);
                    ResultSet ResultadoCon = buscacon.executeQuery();

                    if(!ResultadoCon.next()){
                        System.out.println("Erro no login: Cliente não encontrado");
                    }else{
                        System.out.println("Conta Encontrada! Efetuando Login.");
                        this.idConta = ResultadoCon.getInt("idConta");
                        this.idAgencia = ResultadoCon.getInt("idAgencia");
                        this.testeA = ResultadoCon.getString("documentoAcesso");
                        this.testeS = ResultadoCon.getString("codigoSeguranca");

                        if(testeA.equals(documentoAcesso) && testeS.equals(codigoSeguranca)){
                            System.out.println("\nCódigo da Conta: " + idConta);
                            System.out.println("Código de Agência: " + idAgencia);

                            userToken = idConta;

                            System.out.println("Login efetuado com sucesso!");
                        }
                        else{
                            System.out.println("Erro no login: Dados inseridos inválidos");
                        }
                        
                        PreparedStatement buscacli = conexao.prepareStatement(BuscaCli);
                        buscacli.setInt(1, idCliente);
                        //System.out.println(preparedStatement);
                        ResultSet ResultadoCli = buscacli.executeQuery();

                        if(!ResultadoCli.next()){
                            System.out.println("Erro no login: Dados inseridos inválidos");
                        }else{ 
                            this.nomeCliente = ResultadoCli.getString("nomeCliente");
                            this.idCliCon = ResultadoCli.getInt("idConta");
                        }

                        if(this.idConta == this.idCliCon){
                            if(idConta == 1){
                                nomeAtual = "Admin " + this.nomeCliente;
                            }
                            else{
                                nomeAtual = this.nomeCliente;
                            }
                        }
                        else{
                            System.out.println("Erro na busca: Dados incompatíveis");
                        }
                    }
                }
                
        }catch(SQLException e1){
            System.err.println("Erro na execução: " + e1.getMessage());
        }catch(Exception e2){
            System.err.print("Erro: ");
            e2.printStackTrace(System.err);
        }
    }
    
    protected void FazerLogout(){
        System.out.println("Efetuando Logout.");
        
        userToken = -1;
        nomeAtual = "";
        
        System.out.println("Logout efetuado com sucesso. Volte sempre!");
    }
}
