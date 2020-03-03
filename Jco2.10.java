import java.util.Map;

import com.sap.mw.jco.JCO;
import com.sap.mw.jco.JCO.ParameterList;

public class ERPService {
	
	//Defaults
	private String SID = "R4"; // Alias for this pool
	private int MAX_CONNECTIONS = 10; // Max. number of connections
	private String SAP_CLIENT = "800"; // SAP client / Mandant
	private String LANGUAGE = "DE"; // language
	private String SYSTEM_NUMBER = "01";
	private String REPOSITORY = "MYRepository";
	
	//User login
	private String USER_ID = ""; // username
	private String PASSWORD = ""; // password
	private String HOST_NAME = ""; // host name
	
	public ERPService() {

	}
	
	/**
	 * @param FunctionModule (name of functionmodule to call)
	 * @param inputs as Map<String, Object>
	 * @return JCO.Parameterlist
	 */
	@SuppressWarnings("deprecation")
	public ParameterList call(String FunctionModule, Map<String, Object> inputs) {
		
		try {
			
			//Remove SID from pool if there is any
			try { JCO.removeClientPool(SID); } catch(Exception ex) { }

			//Erstelle JCO connection
			JCO.addClientPool(SID,
									MAX_CONNECTIONS,
									SAP_CLIENT,
									USER_ID, 
									PASSWORD, 
									LANGUAGE, 
									HOST_NAME, 
									SYSTEM_NUMBER);

			//Get Function Module
			JCO.Function function = JCO.createRepository(REPOSITORY, SID).getFunctionTemplate(FunctionModule).getFunction();

			//IMPORTPARAMETER
			ParameterList input = function.getImportParameterList();
			if(inputs != null) {
				for(Map.Entry<String, Object> entry : inputs.entrySet()) {
					input.setValue(entry.getValue(), entry.getKey());
				}
			}
			
			//Exec Function Module
			JCO.getClient(SID).execute(function);

			//EXPORTPARAMETER
			return function.getExportParameterList();
			
		} catch(Exception ex) {
			
			ex.printStackTrace();
			return null;
		}
		
	}
}
