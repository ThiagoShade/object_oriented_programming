package thiagoshade.web.despesa_jsf;


import jakarta.faces.view.ViewScoped;

import jakarta.faces.context.FacesContext;
import jakarta.faces.application.FacesMessage;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.faces.context.ExternalContext;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class AddDespesaBean implements Serializable {

    @Inject
    private DespesaBean despesaBean;
    @Inject
    private DespesaJSONBean despesaJSONBean;
    @Inject
    private CategoriaJSONBean categoriaJSONBean;
    @Inject
    private MetodoPagamentoJSONBean metodoPagamentoJSONBean;
    @Inject
    private MoedaJSONBean moedaJSONBean;

    private Despesa novaDespesa = new Despesa();
    private String selectedCategoria; // Usado tanto para adicionar quanto para remover uma categoria
    private String selectedMetodoPagamento;
    private String selectedMoeda;

    public Despesa getNovaDespesa() {
        return novaDespesa;
    }

    public void setNovaDespesa(Despesa novaDespesa) {
        this.novaDespesa = novaDespesa;
    }

    public String getSelectedCategoria() {
        return selectedCategoria;
    }

    public void setSelectedCategoria(String selectedCategoria) {
        this.selectedCategoria = selectedCategoria;
    }

    public String getSelectedMetodoPagamento() {
        return selectedMetodoPagamento;
    }

    public void setSelectedMetodoPagamento(String selectedMetodoPagamento) {
        this.selectedMetodoPagamento = selectedMetodoPagamento;
    }

    public String getSelectedMoeda() {
        return selectedMoeda;
    }

    public void setSelectedMoeda(String selectedMoeda) {
        this.selectedMoeda = selectedMoeda;
    }

    public void addDespesa() {
        despesaBean.adicionarDespesa(novaDespesa.getDescricao(),novaDespesa.getValor(), novaDespesa.getData(), novaDespesa.getCategoria(), novaDespesa.getMetodoPagamento(), novaDespesa.getMoeda(), novaDespesa.getStatus());
        despesaJSONBean.salvarDespesas();
        FacesContext.getCurrentInstance().addMessage("mensagemSucesso", new FacesMessage(FacesMessage.SEVERITY_INFO, "Despesa adicionada com sucesso!", "Despesa adicionada com sucesso."));
        novaDespesa = new Despesa();
    }

    public void addCategoria() {
        List<String> categorias = despesaBean.getCategorias();
        categorias.add(selectedCategoria);
        despesaBean.setCategorias(categorias);
        categoriaJSONBean.salvarCategorias();
        selectedCategoria = null;
    }

    public void rmCategoria() {
        List<String> categorias = despesaBean.getCategorias();
        categorias.remove(selectedCategoria);
        despesaBean.setCategorias(categorias);
        categoriaJSONBean.salvarCategorias();
        selectedCategoria = null;
    }

    public void addMetodoPagamento() {
        List<String> metodosPagamento = despesaBean.getMetodosPagamento();
        metodosPagamento.add(selectedMetodoPagamento);
        despesaBean.setMetodosPagamento(metodosPagamento);
        metodoPagamentoJSONBean.salvarMetodosPagamento();
        selectedMetodoPagamento = null;
    }

    public void rmMetodoPagamento() {
        List<String> metodosPagamento = despesaBean.getMetodosPagamento();
        metodosPagamento.remove(selectedMetodoPagamento);
        despesaBean.setMetodosPagamento(metodosPagamento);
        metodoPagamentoJSONBean.salvarMetodosPagamento();
        selectedMetodoPagamento = null;
    }


    public void addMoeda() {
        List<String> moedas = despesaBean.getMoedas();
        moedas.add(selectedMoeda);
        despesaBean.setMoedas(moedas);
        moedaJSONBean.salvarMoedas();
        selectedMoeda = null;
    }

    public void rmMoeda() {
        List<String> moedas = despesaBean.getMoedas();
        moedas.remove(selectedMoeda);
        despesaBean.setMoedas(moedas);
        moedaJSONBean.salvarMoedas();
        selectedMoeda = null;
    }

    public void redirecionarParaAddDespesa() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();

        try {
            externalContext.redirect("addDespesa2.xhtml");
        } catch (IOException e) {
            // Lidar com exceções, se necessário
            e.printStackTrace();
        }
    }

    public void voltarParaDespesas() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();

        try {
            externalContext.redirect("viewDespesas2.xhtml");
        } catch (IOException e) {
            // Lidar com exceções, se necessário
            e.printStackTrace();
        }
    }
}
