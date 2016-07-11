
package hellocontroller;

import java.io.IOException;
import java.net.ConnectException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hellocontroller {
    @Autowired
    private UserDao administratorService;

    @RequestMapping("hello")
    public String helloHeroku() {
        return "hello";
    }

    @ResponseBody
    @RequestMapping("user")
    public String getUser() throws ConnectException {
        JSONObject json = new JSONObject();
        List<UserModel> lstUser = administratorService.getUser(2);
        json.put("hihi", lstUser);
        return Hellocontroller.parseToJsonString(json);
    }

    public static String parseToJsonString(JSONObject js) throws ConnectException {
        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            // You need to turn off the serialization feature
            // FAIL_ON_EMPTY_BEANS. You can do that by setting the following on
            // your ObjectMapper:
            mapper.disable(Feature.FAIL_ON_EMPTY_BEANS);
            json = mapper.writeValueAsString(js);
        } catch (JsonGenerationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return json;
    }
}
