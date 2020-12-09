public class TestClass {

    @Test(priority = 2)
    public static void metodOne(){
        System.out.println("Тест первого метода");
    }

    public static void metodTwo(){
        System.out.println("Тест второго метода");
    }
    @BeforeSuite
    public static void metodThree(){
        System.out.println("Тест третьего метода 'Before'");
    }
    @Test(priority = 10)
    public static void metodFour(){
        System.out.println("Тест четвёртого метода");
    }
    @Test
    public static void metodFive(){
        System.out.println("Тест пятого метода");
    }
}
