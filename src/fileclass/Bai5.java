package fileclass;

import java.io.File;

/*Hiện thực hàm void findAll(String path, String ext1, String ext2, …)
tìm và hiển thị đường dẫn đầy đủ file trong thư mục path có phần mở rộng
quy định bởi ext1, ext2,…, extn;  */
public class Bai5 {
    public void findAll(String path, String... exts) {
        File file = new File(path);
        if (!file.exists()) {
            return;
        } else {
            if (file.isFile()) {
                for (String ext : exts) {
                    if (file.getName().endsWith(ext)) {
                        System.out.println(file.getName() + ": " + file.getAbsolutePath());
                        break; // Stop checking other extensions for this file
                    }
                }
            } else {
                File[] files = file.listFiles();
                for (File f : files) {
                    findAll(f.getAbsolutePath(), exts);
                }
            }
        }
    }
    public static void main(String[] args) {
        new Bai5().findAll("D:\\Test\\file1", "txt", "docx");
    }
}
