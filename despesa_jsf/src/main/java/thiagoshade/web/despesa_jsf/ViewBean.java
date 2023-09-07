package thiagoshade.web.despesa_jsf;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.mvc.View;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@Named
@ViewScoped
public class ViewBean implements Serializable {

    private String selectedFormat = ".,"; // Guarda na ordem: Decimal separator, Group Separator. Feito dessa forma pois itemValue não aceita mais de um valor.

    public String getSelectedFormat() {
        return selectedFormat;
    }

    public void setSelectedFormat(String selectedFormat) {
        this.selectedFormat = selectedFormat;
    }


    public String formatarValor(Double valor) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(selectedFormat.charAt(0)); // Primeiro char do selectedFormat : Decimal separator
        symbols.setGroupingSeparator(selectedFormat.charAt(1)); // Segundo char do selectedFormat : Group separator

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);
        return decimalFormat.format(valor);
    }


}
