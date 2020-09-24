package W6;

public class SinhVien {
    private int maSinhVien;
    private String hoten=null;
    private double diem=0;
    private String xeploai=null;

    public SinhVien(int maSinhVien, String hoten, double diem, String xeploai) {
        this.maSinhVien = maSinhVien;
        this.hoten = hoten;
        this.diem = diem;
        this.xeploai = xeploai;
    }

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getXeploai() {
        return xeploai;
    }

    public void setXeploai(String xeploai) {
        this.xeploai = xeploai;
    }

    @Override
    public String toString() {
       String result= "ID: "+this.maSinhVien+"\nName: "+hoten+"\nGrade: "+diem+"\nXeploai: "+xeploai;
       return result;
    }
}
