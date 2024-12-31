/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.rc.projeto1soo2023;

import java.util.Date;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author anael
 */
public class Transacao extends Projeto1SOO2023{
    private int idTransacao;
    private int idAgencia;
    private int idConta;
    private byte tipoTransacao;
    private double valorTransacao;
    private final Date dataUtil = new java.util.Date();
    private java.sql.Date dataTransacao = new java.sql.Date(dataUtil.getTime());

    //private int idConta;
    //private int idAgencia;
    private String documentoAcesso;
    private String codigoSeguranca;
    private double saldo;
    private byte cadBiometria;

    Scanner ler = new Scanner(System.in);
    
    private static final String InsereT = "insert into transacao values(?, ?, ?, ?, ?, ?)";
    private static final String InsereC = "insert into conta values(?, ?, ?, ?, ?, ?)";
    private static final String BuscaT = "select idTransacao, idAgencia, idConta, tipoTransacao,"
            + " valorTransacao from transacao where idTransacao =?";
    private static final String BuscaC = "select idConta, idAgencia, documentoAcesso, "
            + "codigoSeguranca, saldo, cadBiometria from conta where idConta =?";
    private static final String RemoveT = "delete from transacao where idTransacao = (?)";
    private static final String RemoveC = "delete from conta where idConta = (?)";    
    
    public int CriarTransacao(int IDt){
        this.idTransacao = (IDt / 43) + 4;
        
        this.idAgencia = (this.idConta * 7) / 43;
        
        this.idConta = (IDt / 43) + 1;

        System.out.print("Tipo de Transação (0 = Depósito | 1 = Saque):");
        this.tipoTransacao = ler.nextByte();
        
        System.out.print("Valor da Transação:");
        this.valorTransacao = ler.nextDouble();
        
        ler.nextLine();
        
        CriarTransacao(idTransacao, idAgencia, idConta, tipoTransacao, valorTransacao);
        
        if(this.tipoTransacao == 0){
            return contaDeposito + 1;
        }else{
            return contaDeposito;
        }
    }
    
    private void CriarTransacao(int IDt, int IDa, int IDc, byte Tt, double Vt){
        this.idTransacao = IDt;
        this.idAgencia = IDa;
        this.idConta = IDc;
        this.tipoTransacao = Tt;
        this.valorTransacao = Vt;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/projeto1",
            "root",
            "");
            {
                PreparedStatement buscaC = conexao.prepareStatement(BuscaC);
                buscaC.setInt(1, idConta);
                //System.out.println(preparedStatement);
                ResultSet ResultadoC = buscaC.executeQuery();
                
                if(!ResultadoC.next()){
                    System.out.println("Erro na busca: Cliente não encontrado");
                }
                else{
                    System.out.println("\nResultado da busca:");

                    this.idConta = ResultadoC.getInt("idConta");
                    this.idAgencia = ResultadoC.getInt("idAgencia");
                    this.documentoAcesso = ResultadoC.getString("documentoAcesso");
                    this.codigoSeguranca = ResultadoC.getString("codigoSeguranca");
                    this.saldo = ResultadoC.getDouble("saldo");
                    this.cadBiometria = ResultadoC.getByte("cadBiometria");
                    
                    System.out.println("\nCódigo da Conta: " + idConta);
                    System.out.println("Código de Agência: " + idAgencia);

                    if(this.tipoTransacao == 0){
                        System.out.println("\nInsira o Código de Segurança: ");
                        String teste = ler.nextLine();
                        
                        if(teste.equals(this.codigoSeguranca)){
                            System.out.println("Depósito de R$" + this.valorTransacao + " em andamento");

                            PreparedStatement removeConta = conexao.prepareStatement(RemoveC);
                            removeConta.setInt(1, idConta);
                            removeConta.executeUpdate();

                            this.saldo += valorTransacao;

                            PreparedStatement insereConta = conexao.prepareStatement(InsereC);
                            insereConta.setInt(1, idConta);
                            insereConta.setInt(2, idAgencia);
                            insereConta.setString(3, documentoAcesso);
                            insereConta.setString(4, codigoSeguranca);
                            insereConta.setDouble(5, saldo);
                            insereConta.setByte(6, cadBiometria);
                            insereConta.executeUpdate();

                            PreparedStatement buscaT = conexao.prepareStatement(BuscaT);
                            buscaT.setInt(1, idTransacao);
                            //System.out.println(preparedStatement);
                            ResultSet ResultadoT = buscaT.executeQuery();

                            while(ResultadoT.next()){
                                idTransacao = ResultadoT.getInt("idTransacao") + 1;
                            }
                            
                            PreparedStatement insereTransacao = conexao.prepareStatement(InsereT);
                            insereTransacao.setInt(1, idTransacao);
                            insereTransacao.setInt(2, idAgencia);
                            insereTransacao.setInt(3, idConta);
                            insereTransacao.setByte(4, tipoTransacao);
                            insereTransacao.setDouble(5, valorTransacao);
                            insereTransacao.setDate(6, dataTransacao);
                            insereTransacao.executeUpdate();

                            System.out.println("Operação efetuada com sucesso!");
                        }
                        else{
                            System.out.println("Erro: Código Inválido");
                        } 
                    }
                    else if(this.tipoTransacao == 1 && this.valorTransacao < this.saldo){
                        System.out.println("Saque de R$" + this.valorTransacao + " em andamento");

                        PreparedStatement removeConta = conexao.prepareStatement(RemoveC);
                        removeConta.setInt(1, idConta);
                        removeConta.executeUpdate();

                        this.saldo -= valorTransacao;

                        PreparedStatement insereConta = conexao.prepareStatement(InsereC);
                        insereConta.setInt(1, idConta);
                        insereConta.setInt(2, idAgencia);
                        insereConta.setString(3, documentoAcesso);
                        insereConta.setString(4, codigoSeguranca);
                        insereConta.setDouble(5, saldo);
                        insereConta.setByte(6, cadBiometria);
                        insereConta.executeUpdate();

                        PreparedStatement buscaT = conexao.prepareStatement(BuscaT);
                        buscaT.setInt(1, idTransacao);
                        //System.out.println(preparedStatement);
                        ResultSet ResultadoT = buscaT.executeQuery();
                        
                        while(ResultadoT.next()){
                            idTransacao = ResultadoT.getInt("idTransacao") + 1;
                        }
                        
                        PreparedStatement insereTransacao = conexao.prepareStatement(InsereT);
                        insereTransacao.setInt(1, idTransacao);
                        insereTransacao.setInt(2, idAgencia);
                        insereTransacao.setInt(3, idConta);
                        insereTransacao.setByte(4, tipoTransacao);
                        insereTransacao.setDouble(5, valorTransacao);
                        insereTransacao.setDate(6, dataTransacao);
                        insereTransacao.executeUpdate();

                        System.out.println("Operação efetuada com sucesso!");
                    }
                    else{
                        System.out.println("Erro ao fazer o saque: saldo insuficiente");
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
    
    protected void BuscarTransacao(int IDt){
        this.idTransacao = (IDt / 43) + 4;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/projeto1",
            "root",
            "");
            {
                PreparedStatement busca = conexao.prepareStatement(BuscaT);
                busca.setInt(1, idTransacao);
                //System.out.println(preparedStatement);
                ResultSet Resultado = busca.executeQuery();
                
                System.out.println("Resultado da busca:");
                
                while(Resultado.next()){
                    this.idTransacao = Resultado.getInt("idTransacao");
                    this.idAgencia = Resultado.getInt("idAgencia");
                    this.idConta = Resultado.getInt("idConta");
                    this.tipoTransacao = Resultado.getByte("tipoTransacao");
                    this.valorTransacao = Resultado.getDouble("valorTransacao");
                    //this.dataTransacao = Resultado.getDate("dataTransacao");

                    System.out.println("\nCódigo da Transação: " + idTransacao);
                    System.out.println("Código da Agência: " + idAgencia);
                    System.out.println("Código da Conta: " + idConta);

                    if(tipoTransacao == 0){
                        System.out.println("Tipo de Transação: Depósito");
                    }else if(tipoTransacao == 1){
                        System.out.println("Tipo de Transação: Saque");
                    }

                    System.out.println("Valor da Transação: " + valorTransacao);
                    //System.out.println("Data da Transação: " + (java.util.Date) dataTransacao);
                    
                    this.idTransacao += 1;
                    
                    busca = conexao.prepareStatement(BuscaT);
                    busca.setInt(1, idTransacao);
                    //System.out.println(preparedStatement);
                    Resultado = busca.executeQuery();
                }
            }
        }catch(SQLException e1){
            System.err.println("Erro na execução: " + e1.getMessage());
        }catch(Exception e2){
            System.err.print("Erro: ");
            e2.printStackTrace(System.err);
        }
    }
    
    protected void DeletarTransacao(int IDt){
        this.idTransacao = (IDt / 43) + 4;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/projeto1",
            "root",
            "");
            {
                PreparedStatement removeTransacao = conexao.prepareStatement(RemoveT);
                removeTransacao.setInt(1, idTransacao);
                removeTransacao.executeUpdate();
            }
            
        }catch(SQLException e1){
            System.err.println("Erro na execução: " + e1.getMessage());
        }catch(Exception e2){
            System.err.print("Erro: ");
            e2.printStackTrace(System.err);
        }
    }
}
