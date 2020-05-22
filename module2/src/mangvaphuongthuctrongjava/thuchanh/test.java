package mangvaphuongthuctrongjava.thuchanh;

public class test {
    public static class NhanVien {
        public void getThuNhap() {
            System.out.println("Nhân viên");
        }
        public void hello(){
            System.out.println("Hello");
        }
    }

    public static class TruongPhong extends NhanVien {
        public void getThuNhap() {
            System.out.println("Trưởng phòng");
        }
        public void hi(){
            System.out.println("hi");
        }
    }


    public static void main(String[] args) {
        NhanVien nv1 = new NhanVien();
        NhanVien nv2 = new TruongPhong();
        TruongPhong nv3 = new TruongPhong();
        nv1.getThuNhap();
    }
}

