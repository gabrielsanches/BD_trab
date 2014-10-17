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
public class Caixa implements Comparable<Caixa>{

    private long id;
    private float saldo_incial;
    private float saldo_aplicado;
    private float saldo_final;
    private Date data;
    private Date data_f;
    private boolean ativo;

    public Caixa(long id, float saldo_final, Date data_f,float saldo_incial, float saldo_aplicado, Date data) {
        this.id = id;
        this.saldo_incial = saldo_incial;
        this.saldo_aplicado = saldo_aplicado;
        this.saldo_final = saldo_final;
        this.data = data;
        this.data_f = data_f;
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

    public float getSaldo_incial() {
        return saldo_incial;
    }

    public void setSaldo_incial(float saldo_incial) {
        this.saldo_incial = saldo_incial;
    }

    public float getSaldo_aplicado() {
        return saldo_aplicado;
    }

    public void setSaldo_aplicado(float saldo_aplicado) {
        this.saldo_aplicado = saldo_aplicado;
    }

    public float getSaldo_final() {
        return saldo_final;
    }

    public void setSaldo_final(float saldo_final) {
        this.saldo_final = saldo_final;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData_f() {
        return data_f;
    }

    public void setData_f(Date data_f) {
        this.data_f = data_f;
    }

    @Override
    public String toString() {
        return "Caixa{" + "id=" + id + ", saldo_incial=" + saldo_incial + ", saldo_aplicado=" + saldo_aplicado + ", saldo_final=" + saldo_final + ", data=" + data + ", data_f=" + data_f + ", ativo = "+ativo+'}';
    }
    
    @Override
    public int compareTo(Caixa o) {
        return (int) (id - o.getId());
    }
    
}
