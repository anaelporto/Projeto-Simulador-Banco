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
public class Contato extends Projeto1SOO2023{
    private int idContato;
    private String emailCliente;
    private String telefoneLocal;
    private String telefoneCelular;
    
    Scanner ler = new Scanner(System.in);
    
    private static final String Insere = "insert into contato values(?, ?, ?, ?)";
    private static final String Busca = "select idContato, emailCliente, telefoneLocal,"
            + " telefoneCelular from contato where idContato =?";
    private static final String Altera = "";
    private static final String Remove = "delete from contato where idContato =?";
    
    public void InserirContato(int IDc){       
        this.idContato = (IDc / 43) + 2;

        System.out.print("Email do Cliente:");
        this.emailCliente = ler.nextLine();

        System.out.print("Telefone Local:");
        this.telefoneLocal = ler.nextLine();

        System.out.print("Telefoe Celular:");
        this.telefoneCelular = ler.nextLine();
        
        InserirContato(idContato, emailCliente, telefoneLocal, telefoneCelular);
    }
    
    private void InserirContato(int IDc, String Ec, String Tl, String Tc){
        this.idContato = IDc;
        this.emailCliente = Ec;
        this.telefoneLocal = Tl;
        this.telefoneCelular = Tc;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/projeto1",
            "root",
            "");
            {
                PreparedStatement insereContato = conexao.prepareStatement(Insere);
                insereContato.setInt(1, idContato);
                insereContato.setString(2, emailCliente);
                insereContato.setString(3, telefoneLocal);
                insereContato.setString(4, telefoneCelular);
                insereContato.executeUpdate();
            }
            
        }catch(SQLException e1){
            System.err.println("Erro na execução: " + e1.getMessage());
        }catch(Exception e2){
            System.err.print("Erro: ");
            e2.printStackTrace(System.err);
        }
    }
    
    protected void BuscarContato(int IDc){
        this.idContato = (IDc / 43) + 2;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/projeto1",
            "root",
            "");
            {
                PreparedStatement busca = conexao.prepareStatement(Busca);
                busca.setInt(1, idContato);
                //System.out.println(preparedStatement);
                ResultSet Resultado = busca.executeQuery();
                
                if(!Resultado.next()){
                    System.out.println("Erro na busca: Cliente não encontrado");
                }else{
                    System.out.println("Resultado da busca:");

                    this.idContato = Resultado.getInt("idContato");
                    this.emailCliente = Resultado.getString("emailCliente");
                    this.telefoneLocal = Resultado.getString("telefoneLocal");
                    this.telefoneCelular = Resultado.getString("telefoneCelular");

                    System.out.println("\nCódigo do Contato: " + idContato);
                    System.out.println("Email do Cliente: " + emailCliente);
                    System.out.println("Telefone Local: " + telefoneLocal);
                    System.out.println("Telefone Celular: " + telefoneCelular);
                }
            }
            
        }catch(SQLException e1){
            System.err.println("Erro na execução: " + e1.getMessage());
        }catch(Exception e2){
            System.err.print("Erro: ");
            e2.printStackTrace(System.err);
        }
    }
    
    protected void AlterarContato(int IDc){
        this.idContato = (IDc / 43) + 2;
        
        Scanner ler = new Scanner(System.in);
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/projeto1",
            "root",
            "");
            {
                PreparedStatement removeContato = conexao.prepareStatement(Remove);
                removeContato.setInt(1, idContato);
                removeContato.executeUpdate();
                
                System.out.println("Insira os novos dados:");
                
                System.out.print("Novo Email: ");
                this.emailCliente = ler.nextLine();
                
                System.out.print("\nNovo Telefone Local: ");
                this.telefoneLocal = ler.nextLine();
                
                System.out.print("\nNovo Telefone Celular: ");
                this.telefoneCelular = ler.nextLine();
                
                PreparedStatement insereContato = conexao.prepareStatement(Insere);
                insereContato.setInt(1, idContato);
                insereContato.setString(2, emailCliente);
                insereContato.setString(3, telefoneLocal);
                insereContato.setString(4, telefoneCelular);
                insereContato.executeUpdate();
            }
            
        }catch(SQLException e1){
            System.err.println("Erro na execução: " + e1.getMessage());
        }catch(Exception e2){
            System.err.print("Erro: ");
            e2.printStackTrace(System.err);
        }
    }
    
    protected void DeletarContato(int IDc){
        this.idContato = (IDc / 43) + 2;
        
        try{
            Connection conexao  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/projeto1",
            "root",
            "");
            {
                PreparedStatement removeContato = conexao.prepareStatement(Remove);
                removeContato.setInt(1, idContato);
                removeContato.executeUpdate();
            }
            
        }catch(SQLException e1){
            System.err.println("Erro na execução: " + e1.getMessage());
        }catch(Exception e2){
            System.err.print("Erro: ");
            e2.printStackTrace(System.err);
        }
    }
}
