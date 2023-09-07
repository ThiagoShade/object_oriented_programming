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
public class MoedaJSONBean {
    private List<String> moedas = new ArrayList<>();
    private final String JSON_FILE_PATH = "C:\\Users\\ADMIN\\Desktop\\code\\POO\\despesa_jsf\\src\\main\\webapp\\resources\\data\\moedas.JSON";

    public List<String> getMoedas() {
        return moedas;
    }

    public void setMoedas(List<String> moedas) {
        this.moedas = moedas;
    }

    public void salvarMoedas() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(JSON_FILE_PATH), moedas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> carregarMoedas() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            moedas = objectMapper.readValue(new File(JSON_FILE_PATH), new TypeReference<List<String>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return moedas;
    }
}
