package fileclass;

import java.io.File;

public class Bai1 {
    public boolean deleteFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return false;
        } else {
            if (file.isFile()) {
                return file.delete();
            } else if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    deleteFile(f.getAbsolutePath());
                }
                return file.delete();
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(new Bai1().deleteFile("D:\\Test\\file1"));
    }
}
