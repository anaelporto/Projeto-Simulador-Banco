/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unesp.rc.projeto1soo2023;

import java.util.Scanner;

/**
 *
 * @author anael
 */
public class Projeto1SOO2023 {
    protected static int contaDeposito = 0;
    protected static int userToken = -1;
    protected static String nomeAtual;
    
    private static int idCliente;
    private static int idConta;
    private static int idContato;
    private static int idEndereco;
    private static int idTransacao;
    
    public static void LoadDriver(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e2){
        System.err.print("Erro: ");
        e2.printStackTrace(System.err);
        }
    }
    
    public static void MenuCliente(){     
        Cliente operaCliente = new Cliente();

        Scanner lerCliente = new Scanner(System.in);

        System.out.println("Menu de Operações para Clientes");
        System.out.println("1 - Buscar Cliente");
        System.out.println("2 - Alterar Cliente");
        System.out.println("3 - Excluir Cliente");
        System.out.println("4 - Corrigir Operação");
        
        System.out.print("Opção: ");
        int opCli = lerCliente.nextInt();
        
        if(opCli != 4){
            System.out.print("\nCPF: ");
            idCliente = lerCliente.nextInt();
        }

        lerCliente.nextLine();
        
        switch(opCli){
            case 1 -> operaCliente.BuscarCliente(idCliente);
            case 2 -> operaCliente.AlterarCliente(idCliente);
            case 3 -> operaCliente.DeletarCliente(idCliente);
            case 4 -> {
                break;
            }
            default -> System.out.println("Opção inválida!");
        }
    }

    public static void MenuConta(){
        Conta operaConta = new Conta();
        
        Scanner lerConta = new Scanner(System.in);
        
        System.out.println("\tMenu de Operações para Contas:");
        System.out.println("1 - Buscar Conta");
        System.out.println("2 - Conferir Saldo");
        System.out.println("3 - Alterar Conta");
        System.out.println("4 - Excluir Conta");
        System.out.println("5 - Corrigir Operação");
        
        System.out.print("Opção: ");
        int opCon = lerConta.nextInt();
        
        if(opCon != 5){
            System.out.print("\nCPF: ");
            idConta = lerConta.nextInt();
        }

        lerConta.nextLine();
        
        switch(opCon){
            case 1 -> operaConta.BuscarConta(idConta);
            case 2 -> operaConta.BuscarSaldo(idConta);
            case 3 -> operaConta.AlterarConta(idConta);
            case 4 -> operaConta.DeletarConta(idConta);
            case 5 -> {
                break;
            }
            default -> System.out.println("Opção inválida!");
        }
    }

    public static void MenuContato(){
        Contato operaContato = new Contato();

        Scanner lerContato = new Scanner(System.in);
        
        System.out.println("\tMenu de Operações para Contatos:");
        System.out.println("1 - Inserir Contato");
        System.out.println("2 - Buscar Contato");
        System.out.println("3 - Alterar Contato");
        System.out.println("4 - Excluir Contato");
        System.out.println("5 - Corrigir Operação");
        
        System.out.print("Opção: ");
        int opCto = lerContato.nextInt();
        
        if(opCto != 5){
            System.out.print("\nCPF: ");
            idContato = lerContato.nextInt();
        }

        lerContato.nextLine();
        
        switch(opCto){
            case 1 -> operaContato.InserirContato(idContato);
            case 2 -> operaContato.BuscarContato(idContato);
            case 3 -> operaContato.AlterarContato(idContato);
            case 4 -> operaContato.DeletarContato(idContato);
            case 5 -> {
                break;
            }
            default -> System.out.println("Opção inválida!");
        }
    }

    public static void MenuEndereco(){
        Endereco operaEnd = new Endereco();

        Scanner lerEndereco = new Scanner(System.in);
        
        System.out.println("\tMenu de Operações para Endereços:");
        System.out.println("1 - Inserir Endereço");
        System.out.println("2 - Buscar Endereço");
        System.out.println("3 - Alterar Endereço");
        System.out.println("4 - Excluir Endereços");
        System.out.println("5 - Corrigir Operação");
        
        System.out.print("Opção: ");
        int opEnd = lerEndereco.nextInt();
        
        if(opEnd != 5){
            System.out.print("\nCPF: ");
            idEndereco = lerEndereco.nextInt();
        }

        lerEndereco.nextLine();
        
        switch(opEnd){
            case 1 -> operaEnd.InserirEndereco(idEndereco);
            case 2 -> operaEnd.BuscarEndereco(idEndereco);
            case 3 -> operaEnd.AlterarEndereco(idEndereco);
            case 4 -> operaEnd.DeletarEndereco(idEndereco);
            case 5 -> {
                break;
            }
            default -> System.out.println("Opção inválida!");
        }
    }

    public static void MenuTransacao(){
        Transacao operaTra = new Transacao();

        Scanner lerTra = new Scanner(System.in);
        
        System.out.println("\tMenu de Operações para Transações:");
        System.out.println("1 - Efetuar Transação");
        System.out.println("2 - Histórico de Transações");
        System.out.println("3 - Excluir Transações");
        System.out.println("4 - Corrigir Operação");
        
        System.out.print("Opção: ");
        int opTra = lerTra.nextInt();
        
        if(opTra != 4){
            System.out.print("\nCPF: ");
            idTransacao = lerTra.nextInt();
        }
        
        lerTra.nextLine();
        
        switch(opTra){
            case 1 -> {
                if(contaDeposito < 5){
                    contaDeposito = operaTra.CriarTransacao(idTransacao);
                }else{
                    System.out.println("Limite de Depósitos nesta sessão excedido.");
                    System.out.println("Inicie uma nova sessão e tente novamente.");
                }
            }
            case 2 -> operaTra.BuscarTransacao(idTransacao);
            case 3 -> operaTra.DeletarTransacao(idTransacao);
            case 4 -> {
                break;
            }
            default -> System.out.println("Opção inválida!");
        }
    }

    public static void MenuInicial(){
        System.out.println("\tMenu Principal:");
        System.out.println("1 - Clientes");
        System.out.println("2 - Contas");
        System.out.println("3 - Contatos");
        System.out.println("4 - Endereços");
        System.out.println("5 - Transações");
        System.out.println("6 - Sair");
        System.out.print("Selecione: ");
    }
    
    public static void main(String[] args) {
        int op;
        
        Login operaLogin = new Login();
        
        Scanner ler = new Scanner(System.in);
        
        do{
            operaLogin.MenuLogin();
        }while(userToken == -1);
        
        
        System.out.println("Olá " + nomeAtual + "!");
        
        do{
            MenuInicial();
            
            op = ler.nextInt();
            
            switch(op){
                case 1 -> MenuCliente();

                case 2 -> MenuConta();

                case 3 -> MenuContato();

                case 4 -> MenuEndereco();

                case 5 -> MenuTransacao();

                case 6 -> System.out.println("Saindo!");
                default -> System.out.println("Erro na operação: Opção Inválida");
            }
        }while(op != 6);
        
        operaLogin.FazerLogout();
    }
}