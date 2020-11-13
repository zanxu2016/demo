package com.example.demo.core.javacore.basic_type;

public class ShowMeBug {

    public static void main(String[] args) {
        String str = " the sky  is  blue ";
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String s) {
        //todo 完成编码
        // if(s == null || s.length() == 0) return "";


        String[] words = s.split(" ");

        StringBuilder sb = new StringBuilder();

        int p = 0;

        for(int i = words.length - 1; i >= 0; i--) {

            if(" ".equals(words[i]) || "".equals(words[i])) {
                continue;
            }
            sb.append(words[i]);
            if (i != 0 && !" ".equals(words[i])) {
                sb.append(" ");
            }
        }
        return sb.toString();

    }

}
