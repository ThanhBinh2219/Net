package fileclass;

import java.io.File;

/*Hiện thực hàm boolean findFirst(String path, String pattern)
tìm và hiển thị đường dẫn đầy đủ file/folder chỉ định bởi path
có chứa chuỗi quy định bởi pattern; trả về true nếu tìm thấy,
false nếu không tìm thấy */
public class Bai2 {
    public boolean findFirst(String path, String pattern) {
        File file = new File(path);
        if (!file.exists()) {
            return false;
        } else {
            if (file.isFile()) {
                if (file.getName().contains(pattern)) {
                    return true;
                }
            } else {
                File[] lFile = file.listFiles();
                for (File f : lFile) {
                    findFirst(f.getAbsolutePath(), pattern);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Bai2().findFirst("D:\\Test\\file1", "test");
    }
}
