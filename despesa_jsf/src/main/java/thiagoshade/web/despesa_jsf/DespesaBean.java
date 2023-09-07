package thiagoshade.web.despesa_jsf;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.UUID;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ejb.Startup;
import org.primefaces.model.FilterMeta;

@Named
@ApplicationScoped
public class DespesaBean {

    @Inject
    private DespesaJSONBean despesaJSONBean;

    @Inject
    private CategoriaJSONBean categoriaJSONBean;

    @Inject
    private MetodoPagamentoJSONBean metodoPagamentoJSONBean;

    @Inject
    private MoedaJSONBean moedaJSONBean;

    @Inject
    private StatusJSONBean statusJSONBean;

    private List<Despesa> listaDespesas;
    private List<String> categorias;
    private List<String> metodosPagamento;
    private List<String> moedas;
    private List<String> status;
    private List<Despesa> filteredDespesas;
    private List<FilterMeta> filterBy;

    public DespesaJSONBean getDespesaJSONBean() {
        return despesaJSONBean;
    }

    public void setDespesaJSONBean(DespesaJSONBean despesaJSONBean) {
        this.despesaJSONBean = despesaJSONBean;
    }

    public CategoriaJSONBean getCategoriaJSONBean() {
        return categoriaJSONBean;
    }

    public void setCategoriaJSONBean(CategoriaJSONBean categoriaJSONBean) {
        this.categoriaJSONBean = categoriaJSONBean;
    }

    public MetodoPagamentoJSONBean getMetodoPagamentoJSONBean() {
        return metodoPagamentoJSONBean;
    }

    public void setMetodoPagamentoJSONBean(MetodoPagamentoJSONBean metodoPagamentoJSONBean) {
        this.metodoPagamentoJSONBean = metodoPagamentoJSONBean;
    }

    public MoedaJSONBean getMoedaJSONBean() {
        return moedaJSONBean;
    }

    public void setMoedaJSONBean(MoedaJSONBean moedaJSONBean) {
        this.moedaJSONBean = moedaJSONBean;
    }

    public StatusJSONBean getStatusJSONBean() {
        return statusJSONBean;
    }

    public void setStatusJSONBean(StatusJSONBean statusJSONBean) {
        this.statusJSONBean = statusJSONBean;
    }



    public List<Despesa> getListaDespesas() {
        return listaDespesas;
    }

    public void setListaDespesas(List<Despesa> listaDespesas) { // Método usado pelo método abaixo.
        this.listaDespesas = listaDespesas;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    public List<String> getMetodosPagamento() {
        return metodosPagamento;
    }

    public void setMetodosPagamento(List<String> metodosPagamento) {
        this.metodosPagamento = metodosPagamento;
    }

    public List<String> getMoedas() {
        return moedas;
    }

    public void setMoedas(List<String> moedas) {
        this.moedas = moedas;
    }

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }

    public List<Despesa> getFilteredDespesas() {
        return filteredDespesas;
    }

    public void setFilteredDespesas(List<Despesa> filteredDespesas) {
        this.filteredDespesas = filteredDespesas;
    }

    public List<FilterMeta> getFilterBy() {
        return filterBy;
    }

    public void setFilterBy(List<FilterMeta> filterBy) {
        this.filterBy = filterBy;
    }

    @PostConstruct
    public void init() { // Método que é executado logo após a construção do Bean, tem como objetivo carregar todas as listas necessárias dos arquivos JSON.
        this.setListaDespesas(despesaJSONBean.carregarDespesas());
        this.setCategorias(categoriaJSONBean.carregarCategorias());
        this.setMetodosPagamento(metodoPagamentoJSONBean.carregarMetodosPagamento());
        this.setMoedas(moedaJSONBean.carregarMoedas());
        this.setStatus(statusJSONBean.carregarStatus());
    }

    // Método para adicionar uma nova despesa
    public void adicionarDespesa(String descricao, Double valor, Date data, String categoria, String metodoPagamento, String moeda, String status) {
        UUID id = UUID.randomUUID(); // Gere um ID único
        Despesa novaDespesa = new Despesa(id, descricao, valor, data, categoria, metodoPagamento, moeda, status); // Chama o construtor de Despesa com todos os dados que o usuário colocou
        listaDespesas.add(novaDespesa); // Adiciona a despesa na lista
    }

    // Método para excluir uma despesa
    public void excluirDespesa(Despesa despesa) { // Será necessário tomar cuidado em como virá a informação de excluir do usuário e se será possível conseguir o objeto despesa selecionado
        listaDespesas.remove(despesa); // Funciona por igualdade de objeto, ou seja, o objeto que se deseja excluir da lista é o que deve ser passado como parâmetro.
    }

    public void limparDespesas() {
        listaDespesas.clear();
    }

}
