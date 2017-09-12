import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class InHandler implements InvocationHandler {

    private Object obj;
    private String resource;
    private File file;
    private Map<String, Double> cache = new HashMap<String, Double>();



    public void writeInFile(String data) {
        file = new File(resource + "/CalculationResultFile.txt");
        try(FileWriter writer = new FileWriter(file, false)) {
            writer.write(data);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String readFromFile() {
        String resultString = "";
        File file = new File(resource + "/CalculationResultFile.txt");
        try(FileReader reader = new FileReader(file)) {
            int c;
            while((c=reader.read())!= -1){

                resultString = resultString + (char)c;
            }
        }
        catch(IOException ex) {

            System.out.println(ex.getMessage());
        }
        return resultString;

    }



    public InHandler(Object f1){

        obj = f1;

        String[] stArr;
        this.resource = System.getProperty("user.dir") + "/res";
        if (cache.isEmpty()) {
            File file = new File(resource + "/CalculationResultFile.txt");
            if(file.exists()) {
                String st = readFromFile();
                if (st != "") {

                    stArr = st.split("=");
                    Double doubleValue = Double.parseDouble(stArr[1]);
                    cache.put(stArr[0], doubleValue);
                    System.out.println("Cache ok");
                }

            } else {
                cache = new HashMap <String, Double>();
                try {
                    file.createNewFile();
                }
                catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("InHandler invoke : " + method.getName());
        if (args[1] == "=") {
            return method.invoke(obj, args);
        }
        String argsStr =  args[2].toString() + args[1] + args[0].toString();

        if (cache.containsKey(argsStr)) {
            return cache.get(argsStr);
        } else {
            Object res = method.invoke(obj, args);
            String toWrite = argsStr + "=" + res.toString();
            cache.put(argsStr, new Double(res.toString()));

            this.writeInFile(toWrite);

            return res;
        }

    }


}
