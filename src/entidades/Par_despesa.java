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
public class Par_despesa implements Comparable<Par_despesa>{

    private long id;
    private Date data_venc;
    private Date data_pag;    
    private int n_parcela;
    private String status;
    private float valor_parce;
    private int fk_despesa;
    private boolean ativo;

    public Par_despesa(long id, Date data_venc, Date data_pag, int n_partes, String status, float valor_parce, int fk_despesa) {
        this.id = id;
        this.data_venc = data_venc;
        this.data_pag = data_pag;
        this.n_parcela = n_partes;
        this.status = status;
        this.valor_parce = valor_parce;
        this.fk_despesa = fk_despesa;
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

    public Date getData_venc() {
        return data_venc;
    }

    public void setData_venc(Date data_venc) {
        this.data_venc = data_venc;
    }

    public Date getData_pag() {
        return data_pag;
    }

    public void setData_pag(Date data_pag) {
        this.data_pag = data_pag;
    }

    public int getN_parcela() {
        return n_parcela;
    }

    public void setN_parcela(int n_parcela) {
        this.n_parcela = n_parcela;
    }
    
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getValor_parce() {
        return valor_parce;
    }

    public void setValor_parce(float valor_parce) {
        this.valor_parce = valor_parce;
    }

    public int getFk_despesa() {
        return fk_despesa;
    }

    public void setFk_despesa(int fk_despesa) {
        this.fk_despesa = fk_despesa;
    }

    @Override
    public String toString() {
        return "Par_despesa{" + "id=" + id + ", data_venc=" + data_venc + ", data_pag=" + data_pag + ", n_parcela=" + n_parcela + ", status=" + status + ", valor_parce=" + valor_parce + ", fk_despesa=" + fk_despesa + '}';
    }
    
    
    @Override
    public int compareTo(Par_despesa o) {
        return (int) (id - o.getId());
    }
    
}
