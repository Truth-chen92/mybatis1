package cn.tedu.mybatis1;

public class ParamDemo {
    public static void main(String[] args) {
        System.out.println(add(1));
        System.out.println(add(1));
        System.out.println(add(2,3));
        System.out.println(add(4,5,6));
        System.out.println(add("123"));
        System.out.println(add("123","456"));
        System.out.println(add("123","456","789"));

    }
    public static int add(int... n) {
        int sum=0;
        for(int i:n){
            sum+=i;
        }
        return sum;
    }
    public static String add(String... n){
        String sum="";
        for (String i : n) {
            sum+=i;
        }
        return sum;
    }
}
