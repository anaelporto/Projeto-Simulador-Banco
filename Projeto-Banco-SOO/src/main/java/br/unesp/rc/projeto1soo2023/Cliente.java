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
public class Cliente extends Projeto1SOO2023{
    private int idCliente;
    private String nomeCliente;
    private int idConta;
    private int idContato;
    private int idEndereco;
    
    Scanner ler = new Scanner(System.in);
    
    private static final String Insere = "insert into cliente values(?, ?, ?, ?, ?)";
    private static final String Busca = "select idCliente, nomeCliente, idConta, idContato,"
            + " idEndereco from cliente where idCliente =?";
    private static final String Altera = "select idCliente from cliente where idCliente =?";
    private static final String Remove = "delete from cliente where idCliente = (?)";
    
    public void InserirCliente(int IDcl){
        System.out.println("Insira os novos dados:");
                
        this.idCliente = IDcl;

        System.out.print("Nome:");
        this.nomeCliente = ler.nextLine();

        this.idConta = idCliente;

        this.idContato = idCliente;

        this.idEndereco = idCliente;
        
        InserirCliente(idCliente, nomeCliente, idConta, idContato, idEndereco);
    }
    
    private void InserirCliente(int IDcl, String Nc, int IDca, int IDco, int IDe){
        this.idCliente = IDcl;
        this.nomeCliente = Nc;
        this.idConta = IDca;
        this.idContato = IDco;
        this.idEndereco = IDe;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto1","root","");
            {
                PreparedStatement insereCliente = conexao.prepareStatement(Insere);
                insereCliente.setInt(1, idCliente);
                insereCliente.setString(2, nomeCliente);
                insereCliente.setInt(3, idConta);
                insereCliente.setInt(4, idContato);
                insereCliente.setInt(5, idEndereco);
                insereCliente.executeUpdate();
            }
            
        }catch(SQLException e1){
            System.err.println("Erro na execução: " + e1.getMessage());
        }catch(Exception e2){
            System.err.print("Erro: ");
            e2.printStackTrace(System.err);
        }
    }
    
    protected void BuscarCliente(int ID){
        this.idCliente = ID;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/projeto1",
            "root",
            "");
            {
                PreparedStatement buscaCliente = conexao.prepareStatement(Busca);
                buscaCliente.setInt(1, idCliente);
                //System.out.println(preparedStatement);
                ResultSet Resultado = buscaCliente.executeQuery();
                 
                if(Resultado.next()){
                    System.out.println("Resultado da busca:");
                    
                    this.idCliente = Resultado.getInt("idCliente");
                    this.nomeCliente = Resultado.getString("nomeCliente");
                    this.idConta = Resultado.getInt("idConta");
                    this.idContato = Resultado.getInt("idContato");
                    this.idEndereco = Resultado.getInt("idEndereco");
                    
                    System.out.println("\nCódigo do Cliente" + idCliente);
                    System.out.println("Nome do Cliente: " + nomeCliente);
                    System.out.println("Código de Conta: " + idConta);
                    System.out.println("Código de Contato: " + idContato);
                    System.out.println("Código de Endereço: " + idEndereco);
                }
                else{
                    System.out.println("Erro na busca: cliente não encontrado");
                }
            }
        }catch(SQLException e1){
            System.err.println("Erro na execução: " + e1.getMessage());
        }catch(Exception e2){
            System.err.print("Erro: ");
            e2.printStackTrace(System.err);
        }
    }
    
    protected void AlterarCliente(int ID){
        this.idCliente = ID;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/projeto1",
            "root",
            "");
            {
                PreparedStatement removeCliente = conexao.prepareStatement(Remove);
                removeCliente.setInt(1, idCliente);
                removeCliente.executeUpdate();
                
                System.out.println("Insira os novos dados:");
                
                System.out.print("Novo Nome:");
                this.nomeCliente = ler.nextLine();
                
                System.out.print("\nNova Conta: ");
                this.idConta = ler.nextInt();
                
                System.out.print("\nNovo Contato: ");
                this.idContato = ler.nextInt();
                
                System.out.print("\nNovo Endereço: ");
                this.idEndereco = ler.nextInt();
                
                ler.nextLine();
                
                PreparedStatement insereCliente = conexao.prepareStatement(Insere);
                insereCliente.setInt(1, idCliente);
                insereCliente.setString(2, nomeCliente);
                insereCliente.setInt(3, idConta);
                insereCliente.setInt(4, idContato);
                insereCliente.setInt(5, idEndereco);
                insereCliente.executeUpdate();
            }
            
        }catch(SQLException e1){
            System.err.println("Erro na execução: " + e1.getMessage());
        }catch(Exception e2){
            System.err.print("Erro: ");
            e2.printStackTrace(System.err);
        } 
    }  
    
    protected void DeletarCliente(int ID){
        this.idCliente = ID;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/projeto1",
            "root",
            "");
            {
                PreparedStatement removeCliente = conexao.prepareStatement(Remove);
                removeCliente.setInt(1, idCliente);
                removeCliente.executeUpdate();
            }
            
        }catch(SQLException e1){
            System.err.println("Erro na execução: " + e1.getMessage());
        }catch(Exception e2){
            System.err.print("Erro: ");
            e2.printStackTrace(System.err);
        }
    }
}
