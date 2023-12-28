package io;

import java.io.*;

/*Viết CT File Spliter chia 1 file thành nhiều phần theo dung lượng hoặc số lượng.
Viết CT File Joiner ghép các file thành phần thành file ban đầu.*/
public class Bai3 {
    public boolean fileSplit(String sFile, String dFolder, int len) {
        //Kiểm tra file nguồn có tồn tại hay không, nếu không trả về false
        File sourceFile = new File(sFile);
        if (!sourceFile.exists()) {
            System.out.println("File don't exist");
            return false;
        }
        // Kiểm tra thư mục đích có hay không, nếu chưa có thì tạo thư mục đích
        File destinationFolder = new File(dFolder);
        if (!destinationFolder.exists()) {
            destinationFolder.mkdirs();
        }
        /*Tạo InputStream để đọc dữ liệu đầu vào*/
        try (InputStream is = new BufferedInputStream(new FileInputStream(sourceFile))) {
            int data;
            int count = 1;
            byte[] arr = new byte[len];

            while ((data = is.read(arr)) != -1) {
                //File.separator <=> \\
                String destFilePath = destinationFolder.getAbsolutePath() +
                        File.separator + sourceFile.getName() + count;
                File destFile = new File(destFilePath);
                try (OutputStream os = new BufferedOutputStream(new FileOutputStream(destFile))) {
                    os.write(arr, 0, data);
                }
                count++;
            }
            System.out.println("Success");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed");
            return false;
        }
    }

    public boolean fileJoin(String sFolder, String dFile) throws IOException {
        File sourceFolder = new File(sFolder);

        if (!sourceFolder.exists() || !sourceFolder.isDirectory()) {
            return false;
        } else {
            File[] files = sourceFolder.listFiles();

            if (files == null || files.length == 0) {
                System.out.println("folder does not contain any files");
                return false;
            }
            File destinationFile = new File(dFile);
            try (OutputStream os = new BufferedOutputStream(new FileOutputStream(destinationFile))) {
                for (File file : files) {
                    try (InputStream is = new BufferedInputStream(new FileInputStream(file))) {
                        byte[] arr = new byte[1024];
                        int data;
                        while ((data = is.read(arr)) != -1) {
                            os.write(arr, 0, data);
                        }
                    }
                }

                System.out.println("Success");
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed");
                return false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //new Bai3().fileSplit("D:\\Test\\LSD.txt", "D:\\Test\\abc", 1024);
        System.out.println(new Bai3().fileJoin("D:\\Test\\abc", "D:\\Test\\LSD2.txt"));
    }
}
