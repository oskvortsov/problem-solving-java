package others;

public class SqrtX {
    public int mySqrt(int x) {
        int l = 1;
        int r = x;

        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (x / mid == mid) {
                return mid;
            }

            if (mid > x / mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }

//    public static void main(String[] args) {
//        SqrtX obj = new SqrtX();
//
//        System.out.println(obj.mySqrt(4)); // 2
//        System.out.println(obj.mySqrt(8)); // 2
//        System.out.println(obj.mySqrt(1)); // 2
//        System.out.println(obj.mySqrt(9)); // 3
//        System.out.println(obj.mySqrt(1024)); // 32
//        System.out.println(obj.mySqrt(2147395600)); // 46340
//        System.out.println(obj.mySqrt(2147395599)); // 46339
//    }
}
