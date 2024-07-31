package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBanco conta = null;
        boolean exit = false;

        while (!exit) {
            System.out.println();
            System.out.println("===== Seu Banco Digital  =====");
            System.out.println();
            System.out.println("1. Abrir conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Pagar mensalidade");
            System.out.println("5. Fechar conta");
            System.out.println("6. Ver saldo");
            System.out.println("7. Mostrar extrato");
            System.out.println("8. Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");
            System.out.println();

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (conta == null) {
                        System.out.print("Digite o número da conta: ");
                        int numConta = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Digite o nome do titular: ");
                        String dono = scanner.nextLine();

                        System.out.print("Tipo de conta (1 para Corrente, 2 para Poupança): ");
                        int tipo = scanner.nextInt();

                        conta = new ContaBanco(numConta, dono, 0.0f, false);
                        conta.setTipo(tipo);
                        conta.abrirConta();
                    } else {
                        System.out.println("Conta já existente.");
                    }
                    break;
                case 2:
                    if (conta != null && conta.isStatus()) {
                        System.out.print("Digite o valor do depósito: ");
                        float valorDeposito = scanner.nextFloat();
                        conta.depositar(valorDeposito);
                    } else {
                        System.out.println("É necessário criar uma conta primeiro.");
                    }
                    break;
                case 3:
                    if (conta != null && conta.isStatus()) {
                        System.out.print("Digite o valor do saque: ");
                        float valorSaque = scanner.nextFloat();
                        conta.sacar(valorSaque);
                    } else {
                        System.out.println("É necessário criar uma conta primeiro.");
                    }
                    break;
                case 4:
                    if (conta != null && conta.isStatus()) {
                        conta.pagarMensal();
                    } else {
                        System.out.println("É necessário criar uma conta primeiro.");
                    }
                    break;
                case 5:
                    if (conta != null && conta.isStatus()) {
                        conta.fecharConta();
                    } else {
                        System.out.println("É necessário criar uma conta primeiro.");
                    }
                    break;
                case 6:
                    if (conta != null) {
                        System.out.println("Saldo atual: R$" + conta.getSaldo());
                    } else {
                        System.out.println("É necessário criar uma conta primeiro.");
                    }
                    break;
                case 7:
                    if (conta != null) {
                        conta.mostrarExtrato();
                    } else {
                        System.out.println("É necessário criar uma conta primeiro.");
                    }
                    break;
                case 8:
                    exit = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }
}
