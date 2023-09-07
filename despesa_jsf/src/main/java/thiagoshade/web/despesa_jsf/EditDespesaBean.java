package thiagoshade.web.despesa_jsf;

import org.jboss.logging.Logger;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import org.primefaces.event.CellEditEvent;

@Named
@ViewScoped
public class EditDespesaBean implements Serializable {

    private static final Logger log = Logger.getLogger(EditDespesaBean.class);

    @Inject
    private DespesaBean despesaBean;
    @Inject
    private DespesaJSONBean despesaJSONBean;

    private Despesa selectedDespesa;

    private static Despesa dlgDespesa = new Despesa();
    private List<Despesa> selectedDespesas;


    public List<Despesa> getSelectedDespesas() {
        return selectedDespesas;
    }

    public void setSelectedDespesa(Despesa selectedDespesa) {
        this.selectedDespesa = selectedDespesa;
    }

    public Despesa getSelectedDespesa() {
        return selectedDespesa;
    }

    public void setSelectedDespesas(List<Despesa> selectedDespesas) {
        this.selectedDespesas = selectedDespesas;
    }

    public Despesa getDlgDespesa() {
        return dlgDespesa;
    }

    public void setDlgDespesa(Despesa dlgDespesa) {
        this.dlgDespesa = dlgDespesa;
    }

    public void editDespesa() {
        dlgDespesa.setDescricao(selectedDespesa.getDescricao());
        dlgDespesa.setValor(selectedDespesa.getValor());
        dlgDespesa.setData(selectedDespesa.getData());
        dlgDespesa.setCategoria(selectedDespesa.getCategoria());
        dlgDespesa.setMetodoPagamento(selectedDespesa.getMetodoPagamento());
        dlgDespesa.setMoeda(selectedDespesa.getMoeda());
        dlgDespesa.setStatus(selectedDespesa.getStatus());
        log.info("Valor da descrição do dlgDespesa: " + dlgDespesa.getDescricao());
        log.info("Valor do valor do dlgDespesa: " + dlgDespesa.getValor());
        log.info("Valor da data do dlgDespesa: " + dlgDespesa.getData());
        log.info("Valor da categoria do dlgDespesa: " + dlgDespesa.getCategoria());
        log.info("Valor do método do dlgDespesa: " + dlgDespesa.getMetodoPagamento());
        log.info("Valor da moeda do dlgDespesa: " + dlgDespesa.getMoeda());
        log.info("Valor do status do dlgDespesa: " + dlgDespesa.getStatus());


    }
    public void deleteDespesa() {
        despesaBean.excluirDespesa(selectedDespesa);
        despesaJSONBean.salvarDespesas();
        selectedDespesa = null;
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
