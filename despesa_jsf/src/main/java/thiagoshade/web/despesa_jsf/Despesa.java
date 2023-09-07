package thiagoshade.web.despesa_jsf;

import java.util.Date;
import java.util.UUID;
public class Despesa {

    private UUID id;
    private String descricao;
    private Double valor;
    private Date data;
    private String categoria;
    private String metodoPagamento;
    private String moeda;
    private String status;

    public Despesa(UUID id, String descricao, Double valor, Date data, String categoria, String metodoPagamento, String moeda, String status) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
        this.metodoPagamento = metodoPagamento;
        this.moeda = moeda;
        this.status = status;

    }

    public Despesa() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
