public class DateConverter {

	/**
	 * @param input "yyyy-mm-dd" as String
	 * @return output like "dd.mm.yyyy"as String
	 */
	public String toEuropeanFormat(String input) {
		
		String output = null;
		
		try {
			
			String[] tempStr = input.split("-");
			output = tempStr[2] + "." + tempStr[1] + "." + tempStr[0];
			return output;
			
		} catch(Exception ex) {
			
			return output;
		}
		
	}
	
	/**
	 * @param input "yyyy-mm-dd" as String
	 * @return output like "dd.mm.yyyy" as String
	 */
	public String toAmericanFormat(String input) {
		
		String output = null;
		
		try {
			
			String[] tempStr = input.split("\\.");
			output = tempStr[2] + "-" + tempStr[1] + "-" + tempStr[0];
			return output;
			
		} catch (Exception ex) {
			
			return output;
		}
		
	}
}
