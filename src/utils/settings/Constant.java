package utils.settings;

public class Constant {
	
	public static Constant newConstant(String line) {
		
		String[] fields=getField(line);
		if(fields==null) return null;
		//if(fields.length!=3)return null;
		
		return newConstant(fields[0], fields[1], fields[2]);
	}
	public static String[] getField(String line) {
		//Devide "normally illegal text" ->must be odd 
		//because n of " is even 
		String[] textAndNot =line.split("\"");
		if(textAndNot.length%2!=1) return null;
		
		//Getting data
		String ris[]={"","",""};
		int fieldIndex=0;
		boolean isCommentedAfter=false;
		for(int i=0; i<textAndNot.length&&!isCommentedAfter; i++) {
			if(fieldIndex>=3) {
				return null;
			}
			else if(i%2==0) {
				//CHECK FOR COMMENT
				String[] devidedByComment=textAndNot[i].split("#");
				if(devidedByComment.length>1) {
					isCommentedAfter=true;
				}
				
				//CHECK FOR SPLIT FIELD
				String[] differentField=devidedByComment[0].split(":");
				for(int i2=0; i2<differentField.length; i2++) {
					ris[fieldIndex]+=differentField[i2].trim();
					if(i2 != (differentField.length-1)) fieldIndex++;
				}
				
			}
			else{
				ris[fieldIndex]+=textAndNot[i];
			}
		}
		
		
		//IF right return
		if((fieldIndex+1) != 3) return null;
		return ris;
	}
 	public static Constant newConstant(String name, String value, String type) {
		try {
			return new Constant(name, value, type);
		} catch (ConstantNullException e) {}
		
		return null;
	}
	
	
	private Constant(String name, String value, String type) throws ConstantNullException{
		if(name==null || value==null || type==null ) throw new ConstantNullException();
		
		this.name=lrTrim(name);
		this.value=lrTrim(value);
		this.type=lrTrim(type);
	}

	//GETTER AND TO_STRING ----------------------------------------------
	private String name, value, type;
	public String getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return "Name: \""+name+"\", Value: \""+value+"\", Type: \""+type+"\".";
	}

	public String getStringValue() {
		return value;
	}
	public Integer getIntegerValue() {
		return Integer.valueOf(value);
	}
	public Boolean getBooleanValue() {
		return Boolean.valueOf(value);
	}
	
	//UTILS
	private static String lrTrim(String str) {
		String temp=str.replaceAll("^\\s+", "");  //Left trim
        return temp.replaceAll("\\s+$", "");     //Rigth trim
    }
}
