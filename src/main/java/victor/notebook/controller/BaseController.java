package victor.notebook.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public abstract class BaseController {

	abstract class SaveOrUpdateObject<T>{
		private HttpServletRequest req;
		private T vo;
		private Object[] obj;
		
		SaveOrUpdateObject(HttpServletRequest request, T vo, Object... objects) {
			this.req = request;
			this.vo = vo;
			this.obj = objects;
		}
		
		public abstract void doSaveOrUpdate(HttpServletRequest request, T vo, Object...objects) throws Exception;

		@Override
		public String toString() {
			RequestContext requestContext = new RequestContext(req);
			String result = null;
			Map<String,String> jsonMap = new HashMap<>();
			String message = "fail to save or update objects";
			String status = "fail";
			
			try {
				doSaveOrUpdate(req,vo,obj);
				status = "ok";
				message = "success to save or update objects";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message = e.getMessage();
			}
			jsonMap.put("status", status);
			jsonMap.put("message", message);

			ObjectMapper mapper = new ObjectMapper();
			try {
				result = mapper.writeValueAsString(jsonMap);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

			return result;			
		}
		
		
	}
}
