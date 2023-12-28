package io;

import java.io.*;
import java.sql.SQLOutput;

/*Viết CT copy/move file dùng byte array kết hợp với BIS, BOS:
boolean fileCopy(String sFile, String destFile, boolean moved);
*/
public class Bai1 {
    public boolean fileCopy(String sFile, String dFile, boolean moved) throws IOException {
        File sourceFile = new File(sFile);
        File destFile = new File(dFile);
        if (!sourceFile.exists()) {
            return false;
        } else {
            InputStream is = new BufferedInputStream(new FileInputStream(sourceFile));
            OutputStream os = new BufferedOutputStream(new FileOutputStream(destFile));
            int data;
            byte[] arr = new byte[1024];
            while ((data = is.read(arr)) != -1) {
                os.write(arr, 0, data);
            }
            is.close();
            os.close();
            if (moved == true) {
                sourceFile.delete();
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Bai1().fileCopy("D:\\Test\\LSD.docx", "D:\\Test\\LSD2.docx", false));
    }
}
