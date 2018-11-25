import java.io.*;

public class SimpleWriter{
    private Writer output;
    
    public void constructNewFile(String line, String fileName) throws IOException{
		File file;
		file = new File(fileName);
        output = new BufferedWriter(new FileWriter(file, true));
        writeToFile(line);
        output.flush();
        output.close();     
    }
    private void writeToFile(final String word) throws IOException{	
        output.write(word);
        output.write(System.getProperty("line.separator"));
    }
}