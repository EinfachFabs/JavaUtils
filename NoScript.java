public class NoScript {

	/**
	 * @param input as String
	 * @return output as String without scripting
	 */
	public String removeXSS(String input) {
		
		//Def inputString
		String output = "";
		
		//Loop over input String
		for(int i = 0; i < input.length(); i++) {
			
			Character ch = input.charAt(i);
			
			switch(ch) {
				case '<':
					output += "&lt;";
					break;
					
				case '>':
					output += "&gt;";
					break;
				
				case '&':
					output += "&amp;";
					break;
					
				case '"':
					output += "&quot;";
					break;
					
				case '\'':
					output += "&#x27;";
					break;
					
				case '/':
					output += "&#x2F";
					break;
					
				default:
					output += ch.toString();
			}
		}
		
		
		return output;
	}
	
}
