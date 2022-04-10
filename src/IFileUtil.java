
public interface IFileUtil {
	public String getContenutoFile(String percorco) throws Exception;
	
	public void saveContenutoFile(String percorco, String contenuto, boolean append) throws Exception;
}
