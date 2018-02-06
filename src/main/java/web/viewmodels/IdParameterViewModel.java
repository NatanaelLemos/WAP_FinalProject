package web.viewmodels;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

public class IdParameterViewModel {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static IdParameterViewModel getIdFromRequest(HttpServletRequest request){
        StringBuffer jb = new StringBuffer();
        String line = null;

        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            return new IdParameterViewModel();
        }

        try {
            String json = jb.toString();
            Gson gson = new Gson();
            IdParameterViewModel parameter = gson.fromJson(json, IdParameterViewModel.class);
            return parameter;
        } catch (Exception e) {
            return new IdParameterViewModel();
        }
    }
}
