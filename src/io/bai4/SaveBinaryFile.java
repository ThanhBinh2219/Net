package io.bai4;
/*Viết CT lưu/Đọc danh sách sinh viên xuống file nhị phân (Lưu từng thuộc tính):
Danh sách sinh viên bất kỳ; mỗi sinh viên có danh sách điểm bất kỳ*/
import java.io.*;
import java.util.ArrayList;

public class SaveBinaryFile {
    public void saveFile(String dFile, ArrayList<SinhVien> dssv) throws IOException {
        File destFile = new File(dFile);
        if (!destFile.exists()) {
            System.out.println("No exist!");
        } else if(destFile.isDirectory()){
            return;
        }else {
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(destFile))) {
                for (SinhVien sv : dssv) {
                    dos.writeUTF(sv.getId());
                    dos.writeUTF(sv.getName());
                    dos.writeDouble(sv.getScore());

                }
                System.out.println("File saved successfully!");
            }
        }
    }
    public ArrayList<SinhVien> readFile(String filePath) throws IOException {
        ArrayList<SinhVien> dssv = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            while (dis.available() > 0) {
                String id = dis.readUTF();
                String name = dis.readUTF();
                double score = dis.readDouble();
                dis.readChar(); // Đọc dấu xuống dòng

                SinhVien sv = new SinhVien(id, name, score);
                dssv.add(sv);
            }
        }

        return dssv;
    }

    public static void main(String[] args) throws IOException {
//        ArrayList<SinhVien> dssv = new ArrayList<>();
//        SinhVien sv1 = new SinhVien("213", "Nguyễn Thanh Bình", 6.7);
//        SinhVien sv2 = new SinhVien("214", "Nguyễn Lê Hưng", 3.5);
//        SinhVien sv3 = new SinhVien("243", "Nguyễn Thanh Biên", 9.1);
//        SinhVien sv4 = new SinhVien("287", "Nguyễn Thái Minh", 2.8);
//        SinhVien sv5 = new SinhVien("249", "Lê Minh Mẫn", 7.4);
//        dssv.add(sv1);
//        dssv.add(sv2);
//        dssv.add(sv3);
//        dssv.add(sv4);
//        dssv.add(sv5);
        //new SaveBinaryFile().saveFile("D:\\Test\\Student.txt", dssv);
        SaveBinaryFile readBinary = new SaveBinaryFile();
        ArrayList<SinhVien> ds = readBinary.readFile("D:\\Test\\Student.txt");
        for (SinhVien sv: ds
             ) {
            System.out.println(sv);
        }
    }
}
