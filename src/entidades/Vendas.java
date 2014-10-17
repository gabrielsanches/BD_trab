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
public class Vendas implements Comparable<Vendas>{

    private long id;
    private String forma;
    private Date data;    
    private float multa;
    private int n_parcela;
    private float valor_total;
    private int fk_cliente;    
    private boolean ativo;    

    public Vendas(long id, String forma, Date data, float multa, int n_parcela, float valor_total, int fk_cliente) {
        this.id = id;
        this.forma = forma;
        this.data = data;
        this.multa = multa;
        this.n_parcela = n_parcela;
        this.valor_total = valor_total;
        this.fk_cliente = fk_cliente;
        ativo = true;
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

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }

    public int getN_parcela() {
        return n_parcela;
    }

    public void setN_parcela(int n_parcela) {
        this.n_parcela = n_parcela;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public int getFk_cliente() {
        return fk_cliente;
    }

    public void setFk_cliente(int fk_cliente) {
        this.fk_cliente = fk_cliente;
    }

    @Override
    public String toString() {
        return "Vendas{" + "id=" + id + ", forma=" + forma + ", data=" + data + ", multa=" + multa + ", n_parcela=" + n_parcela + ", valor_total=" + valor_total + ", fk_cliente=" + fk_cliente + '}';
    }
    
    @Override
    public int compareTo(Vendas o) {
        return (int) (id - o.getId());
    }
    
}
