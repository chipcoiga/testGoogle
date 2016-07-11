package hellocontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hellocontroller {
	@RequestMapping("hello")
	public String helloHeroku(){
		return "hello";
	}
	@ResponseBody
	@RequestMapping("user")
	public String helloHeroku() throws ConnectException{
		JSONObject json = new JSONObject();
		UserDao administratorService = new UserDao();
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
