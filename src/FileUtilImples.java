import java.io.*;

public class FileUtilImples implements IFileUtil {

	private BufferedReader fi;
	private FileWriter  fo;

	@Override
	public String getContenutoFile(String percorso){
		StringBuffer s=new StringBuffer();
		try {
			String c;
			c=percorso.substring(percorso.length()-4);

			if(c.equals(".txt")) {
				
				fi=new BufferedReader(new FileReader(new File(percorso)));
				
		    	
		    	String t;
		    	do {
		    	   t=fi.readLine();
		    	   if(t!=null) {
		    		   s.append(t);
		    		   s.append('\r');
		    		   s.append('\n');
		    	   }
		    	   
			    }while(t!=null);
			    
			}
			
		}catch(Exception e) {
		//	e.printStackTrace();
			System.out.print("Errore in lettura");
		}

		try {
			if(fi!=null)
			fi.close();
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.print("Errore in chiusura lettura");
		}
		if(s.toString().equals("")) return null;
		return s.toString();
	
		
		
	}

	@Override
	public void saveContenutoFile(String percorso, String contenuto, boolean append) throws Exception {
		try {
			String c;
			c=percorso.substring(percorso.length()-4);
			
			if(c.equals(".txt")) {
				fo=new FileWriter(new File(percorso), append);
				fo.write(contenuto);
				
				
		    	fo.close();
			}
		}catch(Exception e) {
			System.out.print("Errore in Scrittura");
		}
		
	}
	
	public static void main(String arg[]) throws Exception {
		FileUtilImples f=new FileUtilImples();
		System.out.print(f.getContenutoFile("D:\\Home\\Documents\\Nuovo documento di teso.txt"));
		//do {
		String s=f.getContenutoFile("D:\\Home\\Documents\\Nuovo documento di teso.txt");
			f.saveContenutoFile("D:\\Home\\Documents\\Nuovo documento di teso.txt", s, false);

			System.out.print(f.getContenutoFile("D:\\Home\\Documents\\Nuovo documento di teso.txt"));
		//}while(true);
			
		
	}
}
