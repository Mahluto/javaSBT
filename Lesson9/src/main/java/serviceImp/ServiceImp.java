package serviceImp;


import service.Service;

import java.io.*;
import java.util.ArrayList;


public class ServiceImp implements Service {

    private String cacheDir;

    private ArrayList<CacheClass> cacheList;


    public ServiceImp() throws IOException, ClassNotFoundException {
        this.cacheDir = System.getProperty("user.dir") + "/cacheDir/";

        cacheList =  new ArrayList<CacheClass>();
        this.loadingCache();

    }


    private void loadingCache() throws IOException, ClassNotFoundException {
        File folder = new File(this.cacheDir);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            cacheList.add(this.deserialize(this.cacheDir + file.getName()));
        }
    }

    private CacheClass deserialize (String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fis))
        {
            return (CacheClass) in.readObject();
        }
    }

    public double doHardWork(String argOne, Integer argTwo, String fileName) {

        double resultOfHardWork;

        resultOfHardWork = searchInCache(argOne, argTwo);
        if (resultOfHardWork == 0) {

            resultOfHardWork = argTwo + argOne.length() * 0.1;
            this.addToCache(argOne, argTwo, fileName, resultOfHardWork);
        }

        return resultOfHardWork;
    }

    private double searchInCache(String argOne, Integer argTwo) {

        double res = 0;

        for (CacheClass i : this.cacheList) {
            if (i.stringArg.equals(argOne)) {
                if (i.intArg.equals(argTwo)) {
                    res = i.result;
                }
            }
        }

        return res;
    }

    private void addToCache(String st, Integer num, String fileName, double resultOfHardWork) {

        if (fileName.length() == 0) {
            fileName = this.getClass().getEnclosingMethod().getName();
        }

        CacheClass cache = new CacheClass(st, num, resultOfHardWork, fileName);
        try (FileOutputStream fos = new FileOutputStream(cacheDir + fileName);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(cache);
            cacheList.add(cache);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


class CacheClass implements Serializable{

    public String stringArg;

    public Integer intArg;

    public double result;

    public String fileName;

    public CacheClass(String stringArg, Integer intArg, double result, String fileName) {

        this.stringArg = stringArg;

        this.intArg = intArg;

        this.result = result;

    }


}
