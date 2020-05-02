package victor.notebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/test")
public class SampleController {

	@RequestMapping(value="/testPage",method=RequestMethod.GET)
	public String getTest() {
		System.out.println("fia.content");
		return "fia.content" ;
	}
}
