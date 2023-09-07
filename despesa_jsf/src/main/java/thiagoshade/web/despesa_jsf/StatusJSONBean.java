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
public class StatusJSONBean {
    private List<String> status = new ArrayList<>();
    private final String JSON_FILE_PATH = "C:\\Users\\ADMIN\\Desktop\\code\\POO\\despesa_jsf\\src\\main\\webapp\\resources\\data\\status.JSON";

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }

    public void salvarStatus() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(JSON_FILE_PATH), status);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> carregarStatus() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            status = objectMapper.readValue(new File(JSON_FILE_PATH), new TypeReference<List<String>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return status;
    }
}
