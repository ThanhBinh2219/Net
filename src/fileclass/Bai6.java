package fileclass;

import java.io.File;

/*Hiện thực hàm void deleteAll(String path, String ext1, String ext2, …)
tìm và xóa tất cả các file trong thư 	mục path có phần mở rộng quy định bởi
ext1, ext2,…, extn; */
public class Bai6 {
    public void deleteAll(String path, String... exts) {
        File file = new File(path);
        if (!file.exists()) {
            return;
        } else {
            if (file.isFile()) {
                for (String e : exts) {
                    if (file.getName().endsWith(e)) {
                        file.delete();
                    }
                }
            } else {
                if (file.isDirectory()) {
                    File[] listFile = file.listFiles();
                    for (File f : listFile) {
                        deleteAll(f.getAbsolutePath(), exts);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        new Bai6().deleteAll("D:\\Test\\file1", "txt", "rtf");
    }
}
