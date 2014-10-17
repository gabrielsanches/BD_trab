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
public class Solicitacao implements Comparable<Solicitacao>{

    private long id;
    private Date data;    
    private float multa;
    private float valor_total;
    private int fk_fornecedor;
    private boolean ativo;

    public Solicitacao(long id, Date data, float multa, float valor_total, int fk_fornecedor) {
        this.id = id;
        this.data = data;
        this.multa = multa;
        this.valor_total = valor_total;
        this.fk_fornecedor = fk_fornecedor;
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

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public int getFk_fornecedor() {
        return fk_fornecedor;
    }

    public void setFk_fornecedor(int fk_fornecedor) {
        this.fk_fornecedor = fk_fornecedor;
    }

    @Override
    public String toString() {
        return "Solicitacao{" + "id=" + id + ", data=" + data + ", multa=" + multa + ", valor_total=" + valor_total + ", fk_fornecedor=" + fk_fornecedor + '}';
    }
    
    
    @Override
    public int compareTo(Solicitacao o) {
        return (int) (id - o.getId());
    }
    
}
