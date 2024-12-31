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
public class Conta extends Projeto1SOO2023{
    private int idConta;
    private int idAgencia;
    private String documentoAcesso;
    private String codigoSeguranca;
    private double saldo;
    private byte cadBiometria;
    
    Scanner ler = new Scanner(System.in);
    
    private static final String Insere = "insert into conta values(?, ?, ?, ?, ?, ?)";
    private static final String Busca = "select idConta, idAgencia, documentoAcesso, "
            + "codigoSeguranca, saldo, cadBiometria from conta where idConta =?";
    private static final String Remove = "delete from conta where idConta =?";
    
    public void InserirConta(int IDc){
        this.idConta = (IDc / 43) + 1;

        this.idAgencia = (this.idConta * 7) / 43;
        
        System.out.print("RG: ");
        this.documentoAcesso = ler.nextLine();
        
        System.out.print("Código de Segurança (até 20 caracteres): ");
        this.codigoSeguranca = ler.nextLine();

        this.saldo = 50;

        System.out.print("Biometria (0 = Não | Sim = 1): ");
        this.cadBiometria = ler.nextByte();
        
        InserirConta(idConta, idAgencia, documentoAcesso, codigoSeguranca, saldo, cadBiometria);
    }
    
    private void InserirConta(int IDc, int IDa, String Da, String Cs, double S, byte Cb){
        this.idConta = IDc;
        this.idAgencia = IDa;
        this.documentoAcesso = Da;
        this.codigoSeguranca = Cs;
        this.saldo = S;
        this.cadBiometria = Cb;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/projeto1",
            "root",
            "");
            {   
                PreparedStatement insereConta = conexao.prepareStatement(Insere);
                insereConta.setInt(1, idConta);
                insereConta.setInt(2, idAgencia);
                insereConta.setString(3, documentoAcesso);
                insereConta.setString(4, codigoSeguranca);
                insereConta.setDouble(5, saldo);
                insereConta.setByte(6, cadBiometria);
                insereConta.executeUpdate();
            }
            
        }catch(SQLException e1){
            System.err.println("Erro na execução: " + e1.getMessage());
        }catch(Exception e2){
            System.err.print("Erro: ");
            e2.printStackTrace(System.err);
        }
    }
    
    protected void BuscarSaldo(int IDc){
        this.idConta = (IDc / 43) + 1;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/projeto1",
            "root",
            "");
            {
                PreparedStatement busca = conexao.prepareStatement(Busca);
                busca.setInt(1, idConta);
                //System.out.println(preparedStatement);
                ResultSet Resultado = busca.executeQuery();
                
                if(!Resultado.next()){
                    System.out.println("Erro na busca: Cliente não encontrado");
                }else{
                    System.out.println("Resultado da busca:");

                    if(userToken == 1 || userToken == idConta){  
                        this.idConta = Resultado.getInt("idConta");
                        this.idAgencia = Resultado.getInt("idAgencia");
                        this.saldo = Resultado.getDouble("saldo");

                        System.out.println("\nCódigo da Conta: " + idConta);
                        System.out.println("Código de Agência: " + idAgencia);
                        System.out.println("Saldo da Conta: R$" + saldo);
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
    
    protected void BuscarConta(int IDc){
        this.idConta = (IDc / 43) + 1;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/projeto1",
            "root",
            "");
            {
                PreparedStatement busca = conexao.prepareStatement(Busca);
                busca.setInt(1, idConta);
                //System.out.println(preparedStatement);
                ResultSet Resultado = busca.executeQuery();
                
                if(!Resultado.next()){
                    System.out.println("Erro na busca: Cliente não encontrado");
                }else{
                    System.out.println("Resultado da busca:");
                    
                    if(userToken == 1 || userToken == idConta){  
                        this.idConta = Resultado.getInt("idConta");
                        this.idAgencia = Resultado.getInt("idAgencia");
                        this.documentoAcesso = Resultado.getString("documentoAcesso");
                        this.codigoSeguranca = Resultado.getString("codigoSeguranca");
                        this.saldo = Resultado.getDouble("saldo");
                        this.cadBiometria = Resultado.getByte("cadBiometria");

                        System.out.println("\nCódigo da Conta: " + idConta);
                        System.out.println("Código de Agência: " + idAgencia);
                        System.out.println("Documento de Acesso: " + documentoAcesso);
                        System.out.println("Código de Segurança: " + codigoSeguranca);
                        System.out.println("Saldo da Conta: R$" + saldo);

                        if(cadBiometria == 0){
                            System.out.println("Cadastro Biométrico ausente");
                        }
                        else if(cadBiometria == 1){
                            System.out.println("Cadastro Biométrico presente");
                        }
                    }
                    else{
                        this.idConta = Resultado.getInt("idConta");
                        this.idAgencia = Resultado.getInt("idAgencia");
                        this.cadBiometria = Resultado.getByte("cadBiometria");

                        System.out.println("\nCódigo da Conta: " + idConta);
                        System.out.println("Código de Agência: " + idAgencia);

                        if(cadBiometria == 0){
                            System.out.println("Cadastro Biométrico ausente");
                        }
                        else if(cadBiometria == 1){
                            System.out.println("Cadastro Biométrico presente");
                        }
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
    
    protected void AlterarConta(int IDc){
        this.idConta = (IDc / 43) + 1;
        
        Scanner ler = new Scanner(System.in);
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/projeto1",
            "root",
            "");
            {
                PreparedStatement busca = conexao.prepareStatement(Busca);
                busca.setInt(1, idConta);
                //System.out.println(preparedStatement);
                ResultSet Resultado = busca.executeQuery();
                
                this.saldo = Resultado.getDouble("saldo");
                
                PreparedStatement removeConta = conexao.prepareStatement(Remove);
                removeConta.setInt(1, idConta);
                removeConta.executeUpdate();
                
                System.out.println("Insira os novos dados:");
                
                System.out.print("Nova Agência:");
                this.idAgencia = ler.nextInt();
                
                ler.nextLine();
                
                System.out.print("\nNovo Documento de Acesso: ");
                this.documentoAcesso = ler.nextLine();
                
                System.out.print("\nNovo Código de Segurança: ");
                this.codigoSeguranca = ler.nextLine();
                
                System.out.print("\nNovo Cadastro Biométrico (0 = ausente | 1 = presente): ");
                this.cadBiometria = ler.nextByte();
                
                PreparedStatement insereConta = conexao.prepareStatement(Insere);
                insereConta.setInt(1, idConta);
                insereConta.setInt(2, idAgencia);
                insereConta.setString(3, documentoAcesso);
                insereConta.setString(4, codigoSeguranca);
                insereConta.setDouble(5, saldo);
                insereConta.setByte(6, cadBiometria);
                insereConta.executeUpdate();
            }
            
        }catch(SQLException e1){
            System.err.println("Erro na execução: " + e1.getMessage());
        }catch(Exception e2){
            System.err.print("Erro: ");
            e2.printStackTrace(System.err);
        }
    }
    
    protected void DeletarConta(int IDc){
        this.idConta = (IDc / 43) + 1;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/projeto1",
            "root",
            "");
            {
                PreparedStatement removeConta = conexao.prepareStatement(Remove);
                removeConta.setInt(1, idConta);
                removeConta.executeUpdate();
            }
            
            
        }catch(SQLException e1){
            System.err.println("Erro na execução: " + e1.getMessage());
        }catch(Exception e2){
            System.err.print("Erro: ");
            e2.printStackTrace(System.err);
        }
    }
}
