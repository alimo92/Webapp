package org.ws.test;

import org.hornetq.utils.json.JSONException;
import org.springframework.stereotype.Controller;
import org.ws.core.json.impl.HeaderImpl;
@Controller
public class Teste {

	public static void main(String[] args) throws JSONException {
		HeaderImpl header = new HeaderImpl("SUCCESS", "COMMANDE DE TESTE", 200);
		header.getJsonHeader().toString();
		
	}

}
