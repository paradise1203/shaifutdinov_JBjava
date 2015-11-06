package task_3;

import java.lang.reflect.Constructor;
import java.lang.reflect.*;

public class ReflectionTask {

    public static void main(String[] args) throws Throwable {
        Class source = Class.forName("Task10");
        Object o = source.newInstance();

        Field[] fields = source.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        Field fld = source.getDeclaredFields()[0];
        fld.setAccessible(true);
        System.out.println(fld.getInt(o));

        Constructor[] constructors = source.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }

        Method[] methods = source.getDeclaredMethods();
        for (Method m : methods) {
            try {
                System.out.println("" + m.getReturnType() + " " + m.getParameterTypes() + " " + m.getParameterCount());
                m.invoke(o);
            } catch (Exception ex) {
                System.out.println("" + m.getReturnType() + " " + m.getParameterTypes()[0] + " " + m.getParameterCount());
                m.invoke(o, 10);
                System.out.println(fld.getInt(o));
                System.out.println(ex);
            }
        }

        Method writer, setter;
        if (methods[0].getParameterTypes().length == 0) {
            writer = methods[0];
            setter = methods[1];
        } else {
            setter = methods[0];
            writer = methods[1];
        }
        System.out.println(writer.invoke(o));
    }

}
