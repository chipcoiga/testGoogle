package hellocontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hellocontroller {
	@RequestMapping("hello")
	public String helloHeroku(){
		return "hello";
	}
}
