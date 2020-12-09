import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception{
        process(TestClass.class);


    }

    public static void process(Class xz) throws Exception{
        ArrayList<Method> methods = new ArrayList<Method>();
        for (Method m : xz.getDeclaredMethods()){
            if (m.isAnnotationPresent(Test.class)){
                if (m.getAnnotation(Test.class).priority() < 1 || m.getAnnotation(Test.class).priority() > 10)
                    throw new RuntimeException("Не верные приоритеты");
                methods.add(m);
            }
        }
        methods.sort((o1, o2) -> -o1.getAnnotation(Test.class).priority() - o2.getAnnotation(Test.class).priority());
        for (Method m : xz.getDeclaredMethods()){
            if (m.isAnnotationPresent(BeforeSuite.class)){
                if (methods.size() > 0 && methods.get(0).isAnnotationPresent(BeforeSuite.class))
                    throw new RuntimeException("Метод Before уже есть");
                methods.add(0,m);
            }

            if (m.isAnnotationPresent(AfterSuite.class)){
                if (methods.size() > 0 && methods.get(methods.size() - 1).isAnnotationPresent(AfterSuite.class))
                    throw new RuntimeException("Метод After уже есть");
                methods.add(m);
            }
        }
        for (int i = 0; i < methods.size(); i++) {
            methods.get(i).invoke(null);

        }

    }

}
