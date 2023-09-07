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
public class CategoriaJSONBean {
    private List<String> categorias = new ArrayList<>();
    private final String JSON_FILE_PATH = "C:\\Users\\ADMIN\\Desktop\\code\\POO\\despesa_jsf\\src\\main\\webapp\\resources\\data\\categorias.JSON";

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    public void salvarCategorias() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(JSON_FILE_PATH), categorias);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> carregarCategorias() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            categorias = objectMapper.readValue(new File(JSON_FILE_PATH), new TypeReference<List<String>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return categorias;
    }
}
