/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class Fornecedor implements Comparable<Fornecedor>{

    private long id;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;
    private String cpf;
    private String rg;
    private int fk_fabricante;
    private boolean ativo;

    public Fornecedor(long id, String nome, String sobrenome, String telefone, String email, String cpf, String rg, int fk_fabricante) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.fk_fabricante = fk_fabricante;
        this.ativo = true;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    
    
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getFk_fabricante() {
        return fk_fabricante;
    }

    public void setFk_fabricante(int fk_fabricante) {
        this.fk_fabricante = fk_fabricante;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "id=" + id + ", nome=" + nome + ", fk_fabricante=" + fk_fabricante + '}';
    }
    
    
    @Override
    public int compareTo(Fornecedor o) {
        return (int) (id - o.getId());
    }
    
}
