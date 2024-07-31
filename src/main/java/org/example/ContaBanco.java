package org.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContaBanco {
    private int numConta;
    private int tipo; // 1 = Conta Corrente, 2 = Conta Poupança
    private String dono;
    private float saldo;
    private boolean status;
    private List<String> extrato;

    public ContaBanco(int numConta, String dono, float saldo, boolean status) {
        this.numConta = numConta;
        this.dono = dono;
        this.saldo = saldo;
        this.status = status;
        this.extrato = new ArrayList<>();
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private void adicionarExtrato(String descricao) {
        String dataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        extrato.add(dataHora + " - " + descricao);
    }

    public void abrirConta() {
        this.status = true;
        if (tipo == 1) { // Conta Corrente
            this.saldo += 50.00;
            adicionarExtrato("Conta Corrente aberta com saldo inicial de R$50,00.");
        } else if (tipo == 2) { // Conta Poupança
            this.saldo += 150.00;
            adicionarExtrato("Conta Poupança aberta com saldo inicial de R$150,00.");
        } else {
            System.out.println("Tipo de conta inválido.");
            return;
        }

        System.out.println();
        System.out.println("Conta criada com sucesso!! ");
        System.out.println();
        System.out.println("Nome do titular: " + this.dono);
        System.out.println("Número da conta: " + this.numConta);
        System.out.println("Modalidade: " + (tipo == 1 ? "Conta Corrente" : "Conta Poupança"));
    }

    public void fecharConta() {
        if (this.saldo == 0.00f) {
            this.status = false;
            adicionarExtrato("Conta fechada.");
        } else {
            System.out.println("A conta ainda possui saldo. Não é possível fechá-la.");
        }
    }

    public void depositar(float valor) {
        if (this.status) {
            this.saldo += valor;
            adicionarExtrato("Depósito de R$" + valor + " realizado.");
        } else {
            System.out.println("Conta inativa. Não é possível realizar depósitos.");
        }
    }

    public void sacar(float valor) {
        if (this.status) {
            if (this.saldo >= valor) {
                this.saldo -= valor;
                adicionarExtrato("Saque de R$" + valor + " realizado.");
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("Conta inativa. Não é possível realizar saques.");
        }
    }

    public void pagarMensal() {
        if (this.status) {
            float valor = tipo == 1 ? 12.00f : 20.00f; // R$12 para Conta Corrente, R$20 para Conta Poupança VALOR TAXA
            if (this.saldo >= valor) {
                this.saldo -= valor;
                adicionarExtrato("Mensalidade de R$" + valor + " debitada.");
            } else {
                System.out.println("Saldo insuficiente para pagar a mensalidade.");
            }
        } else {
            System.out.println("Conta inativa. Não é possível pagar a mensalidade.");
        }
    }

    public void mostrarExtrato() {
        if (extrato.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
        } else {
            System.out.println("===== Extrato =====");
            for (String transacao : extrato) {
                System.out.println(transacao);
            }
            System.out.println("====================");
        }
    }
}
