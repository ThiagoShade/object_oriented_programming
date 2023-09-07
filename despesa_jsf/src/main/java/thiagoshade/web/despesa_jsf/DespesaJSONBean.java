package thiagoshade.web.despesa_jsf;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import jakarta.annotation.PostConstruct;

@Named
@ApplicationScoped
public class DespesaJSONBean {

    private List<Despesa> listaDespesas = new ArrayList<>();
    private final String JSON_FILE_PATH = "C:\\Users\\ADMIN\\Desktop\\code\\POO\\despesa_jsf\\src\\main\\webapp\\resources\\data\\despesas.JSON";


    public List<Despesa> getListaDespesas() {
        return listaDespesas;
    }

    public void setListaDespesas(List<Despesa> listaDespesas) {
        this.listaDespesas = listaDespesas;
    }

    public String getJSON_FILE_PATH() {
        return JSON_FILE_PATH;
    }

    public void salvarDespesas() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(JSON_FILE_PATH), listaDespesas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Despesa> carregarDespesas() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            listaDespesas = objectMapper.readValue(new File(JSON_FILE_PATH), new TypeReference<List<Despesa>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return listaDespesas;
    }

}