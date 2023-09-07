package thiagoshade.web.despesa_jsf;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class MetodoPagamentoJSONBean {
    private List<String> metodosPagamento = new ArrayList<>();
    private final String JSON_FILE_PATH = "C:\\Users\\ADMIN\\Desktop\\code\\POO\\despesa_jsf\\src\\main\\webapp\\resources\\data\\metodosPagamento.JSON";

    public List<String> getMetodosPagamento() {
        return metodosPagamento;
    }

    public void setMetodosPagamento(List<String> metodosPagamento) {
        this.metodosPagamento = metodosPagamento;
    }

    public void salvarMetodosPagamento() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(JSON_FILE_PATH), metodosPagamento);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> carregarMetodosPagamento() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            metodosPagamento = objectMapper.readValue(new File(JSON_FILE_PATH), new TypeReference<List<String>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return metodosPagamento;
    }
}
