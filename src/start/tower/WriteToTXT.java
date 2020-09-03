package start.tower;

import java.io.*;

public class WriteToTXT {

    private static WriteToTXT writeToTXT = null;
    private static BufferedWriter bufferedWriter = null;
    private static File file = null;
    private static FileWriter fileWriter = null;

    private WriteToTXT(){}

    public static WriteToTXT getWriteToTXT()
    {
        if(writeToTXT == null)
        {
            try{
                writeToTXT = new WriteToTXT();
                file = new File("simulator.txt");
                fileWriter = new FileWriter(file);
                bufferedWriter = new BufferedWriter(fileWriter);
            } catch(IOException e){}
        }
        return writeToTXT;
    }

    public void writeTXT(String str)
    {
        try{
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void close()
    {
        try{
            if(bufferedWriter != null)
            {
                bufferedWriter.close();
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error closing file"+ex);
        }
    }
}
