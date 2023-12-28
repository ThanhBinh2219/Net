package io;

import java.io.*;

/*Viết CT copy/move thư mục dùng byte array kết hợp với BIS, BOS:
boolean folderCopy(String sFolder, String destFolder, boolean moved);
*/
public class Bai2 {
    public boolean folderCopy(String sFolder, String dFolder, boolean moved) throws IOException {
        File sourceFolder = new File(sFolder);
        File destFolder = new File(dFolder);
        if (!sourceFolder.exists()) {
            return false;
        } else {
            File[] files = sourceFolder.listFiles();
            for (File f : files) {
                if (f.isFile()) {
                    File newFolder = new File(destFolder.getAbsolutePath() + "\\" + f.getName());

                    fileCopy(f.getAbsolutePath(), newFolder.getAbsolutePath(), false);
                } else {
                    File newFolder = new File(destFolder.getAbsolutePath() + "\\" + f.getName());
                    newFolder.mkdirs();
                    folderCopy(f.getAbsolutePath(), newFolder.getAbsolutePath(), false);
                }
            }
            return true;
        }
    }
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
        System.out.println(new Bai2().folderCopy("D:\\Test\\file1", "D:\\Test\\file2", false));
    }
}
