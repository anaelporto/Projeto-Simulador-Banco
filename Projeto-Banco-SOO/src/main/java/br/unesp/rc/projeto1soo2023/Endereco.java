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
public class Endereco extends Projeto1SOO2023{
    private int idEndereco;
    private String cepEnd;
    private String ufEnd;
    private String cidadeEnd;
    private String bairroEnd;
    private String ruaEnd;
    private int numeroEnd;
    private String referenciaEnd;
    
    Scanner ler = new Scanner(System.in);
    
    private static final String Insere = "insert into endereco values(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String Busca = "select idEndereco, cepEnd, ufEnd, cidadeEnd, bairroEnd,"
            + " ruaEnd, numeroEnd, referenciaEnd from endereco where idEndereco =?";
    private static final String Remove = "delete from endereco where idEndereco =?";
    
    public void InserirEndereco(int IDe){
        this.idEndereco = (IDe / 43) + 3;

        System.out.print("CEP: ");
        this.cepEnd = ler.nextLine();

        System.out.print("UF (Sigla do Estado): ");
        this.ufEnd = ler.nextLine();

        System.out.print("Cidade: ");
        this.cidadeEnd = ler.nextLine();

        System.out.print("Bairro: ");
        this.bairroEnd = ler.nextLine();

        System.out.print("Rua: ");
        this.ruaEnd = ler.nextLine();

        System.out.print("Número: ");
        this.numeroEnd = ler.nextInt();

        System.out.print("Ponto de Referência: ");
        this.referenciaEnd = ler.nextLine();
        
        InserirEndereco(idEndereco, cepEnd, ufEnd, cidadeEnd, bairroEnd, ruaEnd, numeroEnd, referenciaEnd);
    }
    
    private void InserirEndereco(int IDe, String Ce, String Ue, String Cie, String Be, String Re, int Ne, String Rfe){
        this.idEndereco = IDe;
        this.cepEnd = Ce;
        this.ufEnd = Ue;
        this.cidadeEnd = Cie;
        this.bairroEnd = Be;
        this.ruaEnd = Re;
        this.numeroEnd = Ne;
        this.referenciaEnd = Rfe;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/projeto1",
            "root",
            "");
            {
                PreparedStatement insereEndereco = conexao.prepareStatement(Insere);
                insereEndereco.setInt(1, idEndereco);
                insereEndereco.setString(2, cepEnd);
                insereEndereco.setString(3, ufEnd);
                insereEndereco.setString(4, cidadeEnd);
                insereEndereco.setString(5, bairroEnd);
                insereEndereco.setString(6, ruaEnd);
                insereEndereco.setInt(7, numeroEnd);
                insereEndereco.setString(8, referenciaEnd);
                insereEndereco.executeUpdate();
            }
            
        }catch(SQLException e1){
            System.err.println("Erro na execução: " + e1.getMessage());
        }catch(Exception e2){
            System.err.print("Erro: ");
            e2.printStackTrace(System.err);
        }
    }
    
    protected void BuscarEndereco(int IDe){
        this.idEndereco = (IDe / 43) + 3;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/projeto1",
            "root",
            "");
            {
                PreparedStatement insereEndereco = conexao.prepareStatement(Busca);
                insereEndereco.setInt(1, idEndereco);
                //System.out.println(preparedStatement);
                ResultSet Resultado = insereEndereco.executeQuery();
                
                if(!Resultado.next()){
                    System.out.println("Erro na busca: Cliente não encontrado");
                }else{
                    System.out.println("Resultado da busca:");
                
                    this.idEndereco = Resultado.getInt("idEndereco");
                    this.cepEnd = Resultado.getString("cepEnd");
                    this.ufEnd = Resultado.getString("ufEnd");
                    this.cidadeEnd = Resultado.getString("cidadeEnd");
                    this.bairroEnd = Resultado.getString("bairroEnd");
                    this.ruaEnd = Resultado.getString("ruaEnd");
                    this.numeroEnd = Resultado.getInt("numeroEnd");
                    this.referenciaEnd = Resultado.getString("referenciaEnd");

                    System.out.println("\nCódigo do Endereço: " + idEndereco);
                    System.out.println("CEP: " + cepEnd);
                    System.out.println("UF: " + ufEnd);
                    System.out.println("Cidade: " + cidadeEnd);
                    System.out.println("Bairro: " + bairroEnd);
                    System.out.println("Rua: " + ruaEnd);
                    System.out.println("Nº: " + numeroEnd);
                    System.out.println("Ponto de Referência: " + referenciaEnd);
                }   
            }
            
        }catch(SQLException e1){
            System.err.println("Erro na execução: " + e1.getMessage());
        }catch(Exception e2){
            System.err.print("Erro: ");
            e2.printStackTrace(System.err);
        }
    }
    
    protected void AlterarEndereco(int IDe){
        this.idEndereco = (IDe / 43) + 3;
        
        Scanner ler = new Scanner(System.in);
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/projeto1",
            "root",
            "");
            {
                PreparedStatement removeEndereco = conexao.prepareStatement(Remove);
                removeEndereco.setInt(1, idEndereco);
                removeEndereco.executeUpdate();
                
                System.out.println("Insira os novos dados:");
                
                System.out.print("Novo CEP: ");
                this.cepEnd = ler.nextLine();
                
                System.out.print("\nNova UF (Sigla do Estado): ");
                this.ufEnd = ler.nextLine();
                
                System.out.print("\nNova Cidade: ");
                this.cidadeEnd = ler.nextLine();
                
                System.out.print("\nNovo Bairro: ");
                this.bairroEnd = ler.nextLine();
                
                System.out.print("\nNova Rua: ");
                this.ruaEnd = ler.nextLine();
                
                System.out.print("\nNovo Número: ");
                this.numeroEnd = ler.nextInt();
                
                ler.nextLine();
                
                System.out.print("\nNovo Ponto de Referência: ");
                this.referenciaEnd = ler.nextLine();
                
                PreparedStatement insereEndereco = conexao.prepareStatement(Insere);
                insereEndereco.setInt(1, idEndereco);
                insereEndereco.setString(2, cepEnd);
                insereEndereco.setString(3, ufEnd);
                insereEndereco.setString(4, cidadeEnd);
                insereEndereco.setString(5, bairroEnd);
                insereEndereco.setString(6, ruaEnd);
                insereEndereco.setInt(7, numeroEnd);
                insereEndereco.setString(8, referenciaEnd);
                insereEndereco.executeUpdate();
            }
            
        }catch(SQLException e1){
            System.err.println("Erro na execução: " + e1.getMessage());
        }catch(Exception e2){
            System.err.print("Erro: ");
            e2.printStackTrace(System.err);
        }
    } 
    
    public void DeletarEndereco(int IDe){
        this.idEndereco = (IDe / 43) + 3;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/projeto1",
            "root",
            "");
            {
                PreparedStatement removeEndereco = conexao.prepareStatement(Remove);
                removeEndereco.setInt(1, idEndereco);
                removeEndereco.executeUpdate();
            }
            
        }catch(SQLException e1){
            System.err.println("Erro na execução: " + e1.getMessage());
        }catch(Exception e2){
            System.err.print("Erro: ");
            e2.printStackTrace(System.err);
        }
    }
}
