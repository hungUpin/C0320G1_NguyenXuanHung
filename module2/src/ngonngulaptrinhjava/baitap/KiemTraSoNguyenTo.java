package ngonngulaptrinhjava.baitap;

public class KiemTraSoNguyenTo {
    public static Boolean KiemTraSoNguyenTo(int num){
        boolean flag = true;
        if(num<2){
            flag = false;
        }
        if(num>2){
            for( int i=2;i<Math.sqrt(num);i++){
                if(num%i==0){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int i=0;
        String result="";
        while (i<=100){
            if(KiemTraSoNguyenTo(i)){
                result += i +" ";
            }
            i++;
        }
        System.out.print("Các số nguyên tố bé 100 là: "+result);
    }

}
