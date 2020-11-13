package com.example.demo.core.data_structure;

public class HuiWenShu {

    public static boolean isHuiWenShu(String num) {

        int i = 0;
        int j = num.length() - 1;

        for (int k = 0; k < num.length(); k++) {
            if (i >= j) {
                return true;
            }

            if (num.charAt(i) != num.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isHuiWenShu(int num) {

        return true;
    }


    public static void main(String[] args) {
        String num = "-1";
        System.out.println(isHuiWenShu(num));

        int a = 10;

        try {
            a = Integer.parseInt("ss");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(a);
    }
}
