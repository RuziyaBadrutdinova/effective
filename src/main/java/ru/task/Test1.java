package ru.task;

/**
 * @author RuziyaBadrutdinova
 * @since 17.03.2024
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(new StringConverter().convertObjects("."));
        System.out.println(new StringConverter().convertObjects("-",0, 1));
        System.out.println(new StringConverter().convertObjects("-",7L));
        System.out.println(new StringConverter().convertObjects("/",false, true));
        System.out.println(new StringConverter().convertObjects(";","q", "er", "uy", "h g"));
        System.out.println(new StringConverter().convertObjects(";","x", "c", "", "k"));
        System.out.println(new StringConverter().convertObjects("<>", "adg", "kkj", "5", 8, 4));
        System.out.println(new StringConverter().convertObjects("<>", null, "kkj", "5"));
    }

}
