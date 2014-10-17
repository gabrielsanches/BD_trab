/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Gabriel
 */
public class Produto implements Comparable<Produto>{

    private long id;
    private String nome;
    private String descricao;
    private int quantidade;
    private float valor_venda;
    private float valor_compra;
    private int fk_fabricante;
    private boolean ativo;

    public Produto(long id, String nome, String descricao, int quantidade, float valor_venda, float valor_compra, int fk_fabricante) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor_venda = valor_venda;
        this.valor_compra = valor_compra;
        this.fk_fabricante = fk_fabricante;
        this.ativo = true;
    }   

    public int getFk_fabricante() {
        return fk_fabricante;
    }

    public void setFk_fabricante(int fk_fabricante) {
        this.fk_fabricante = fk_fabricante;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(float valor_venda) {
        this.valor_venda = valor_venda;
    }

    public float getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(float valor_compra) {
        this.valor_compra = valor_compra;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", quantidade=" + quantidade + ", valor_venda=" + valor_venda + ", valor_compra=" + valor_compra + '}';
    }
    
    @Override
    public int compareTo(Produto o) {
        return (int) (id - o.getId());
    }
    
}
