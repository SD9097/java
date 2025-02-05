public class BitwiseOperator {


    public static void main(String[] args) {
        int x = 3, y = 6;
        System.out.println(x & y); // 2
        System.out.println(x | y); // 7
        System.out.println(x ^ y); // 5
        System.out.println(~x); // -4

        //Left Shift Operator
        System.out.println(x << 1); // 6
        System.out.println(x << 2); // 12
        System.out.println(x << 3); // 24

        //Right Shift Operator
        System.out.println(x >> 1); // 1
        System.out.println(x >> 2); // 0

        //Unsigned Right Shift Operator. It will not consider the sign bit. It will give positive value
        System.out.println(x >>> 1); // 1

    }

}
