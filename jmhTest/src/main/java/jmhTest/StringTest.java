package jmhTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StringTest {

    private static String[] list = {"a","b","c","d","e","f","g","h","i", "j"};

    public static void main(String... args) {

//        String[] val = {"", "a", "1", "あ"};
//        for(String str : val) {
//            checkCoder(str);
//        }

        test1StringLine();

    }

    private static void checkCoder(String str) {

        System.out.println("------");

        Class<String> c = String.class;
        try {

            Method m = c.getDeclaredMethod("coder");
            m.setAccessible(true);

            byte b = (byte)m.invoke(str);
            System.out.println(str + " coder(): "+b);

            Field f = c.getDeclaredField("coder");
            f.setAccessible(true);
            byte b1 = f.getByte(str);

            System.out.println(str + " coder: "+b1);


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }


    public static void test1StringLine() {

        int i = 0;
        String str0 = list[i];
        checkCoder(str0);

        i++;
        String str1 = list[i];
        checkCoder(str1);
        i++;
        String str2 = list[i];
        checkCoder(str2);
        i++;
        String str3 = list[i];
        checkCoder(str3);
        i++;
        String str4 = list[i];
        checkCoder(str4);
        i++;
        String str5 = list[i];
        checkCoder(str5);
        i++;
        String str6 = list[i];
        checkCoder(str6);
        i++;
        String str7 = list[i];
        checkCoder(str7);
        i++;
        String str8 = list[i];
        checkCoder(str8);
        i++;
        String str9 = list[i];
        checkCoder(str9);

        String str = str0 + str1 + str2 + str3 + str4 + str5 + str6 + str7 + str8 + str9;

        checkCoder(str);
    }

}
