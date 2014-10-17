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
public class Despesa implements Comparable<Despesa>{
    
    private long id;
    private String descricao;
    private float multa;
    private float taxas;
    private boolean fixa;
    private String forma;
    private Date data_venc;
    private Date data_pagamento;    
    private float valor_pagar;    
    private int n_parcelas;
    private boolean ativo;

    public Despesa(long id, String descricao, float multa, float taxas, boolean fixa, String forma, Date data_venc, Date data_pagamento, float valor_pagar, int n_parcelas) {
        this.id = id;
        this.descricao = descricao;
        this.multa = multa;
        this.taxas = taxas;
        this.fixa = fixa;
        this.forma = forma;
        this.data_venc = data_venc;
        this.data_pagamento = data_pagamento;
        this.valor_pagar = valor_pagar;
        this.n_parcelas = n_parcelas;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }

    public float getTaxas() {
        return taxas;
    }

    public void setTaxas(float taxas) {
        this.taxas = taxas;
    }

    public boolean isFixa() {
        return fixa;
    }

    public void setFixa(boolean fixa) {
        this.fixa = fixa;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public Date getData_venc() {
        return data_venc;
    }

    public void setData_venc(Date data_venc) {
        this.data_venc = data_venc;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public float getValor_pagar() {
        return valor_pagar;
    }

    public void setValor_pagar(float valor_pagar) {
        this.valor_pagar = valor_pagar;
    }

    public int getN_parcelas() {
        return n_parcelas;
    }

    public void setN_parcelas(int n_parcelas) {
        this.n_parcelas = n_parcelas;
    }

    @Override
    public String toString() {
        return "Despesa{" + "id=" + id + ", descricao=" + descricao + '}';
    }
    
    @Override
    public int compareTo(Despesa o) {
        return (int) (id - o.getId());
    }
    
}
