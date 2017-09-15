package ru.sbt.module.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ModuleLoader extends ClassLoader {


    private String pathtobin;
    private int key;

    public ModuleLoader(String pathtobin, ClassLoader parent, String key) {
        super(parent);
        this.pathtobin = pathtobin;
        this.key = Integer.parseInt(key);
    }

    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            byte b[] = fetchClassFromFS(pathtobin + className + ".class");
            return defineClass(className, b, 0, b.length);
        } catch (FileNotFoundException ex) {
            return super.findClass(className);
        } catch (IOException ex) {
            return super.findClass(className);
        }

    }


    private byte[] fetchClassFromFS(String path) throws FileNotFoundException, IOException {
        InputStream is = new FileInputStream(new File(path));

        long length = new File(path).length();

        if (length > Integer.MAX_VALUE) {
            throw new IndexOutOfBoundsException("File is too large");
        }

        byte[] bytes = new byte[(int)length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {

//            numRead -= this.key;
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+path);
        }

        is.close();
        return bytes;

    }
}