import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Comprassion {
    static void TestAdd(int n, List<Integer> list)
    {
    System.out.printf("%-10s%-,20d","Add",n);

    long time = System.nanoTime();

    for(int i=0;i<n;i++)
        list.add(i);

    time = System.nanoTime() - time;
    System.out.printf("%-12.3f\n", time/1_000_000.0);
}
    private static void TestGet(int n, List<Integer> list)
    {
        System.out.printf("%-10s%-,20d","Get",n);

        long time = System.nanoTime();

        for(int i=0;i<n;i++)
            list.get(i);

        time = System.nanoTime() - time;
        System.out.printf("%-12.3f\n", time/1_000_000.0);
    }
    private static void TestDelete(int n, List<Integer> list)
    {
        System.out.printf("%-10s%-,20d","Delete",n);

        long time = System.nanoTime();

        for(int i=0;i<n;i++)
            list.remove(i);

        time = System.nanoTime() - time;
        System.out.printf("%-12.3f\n", time/1_000_000.0);
    }

    static void printListName(List<Integer> list)
    {
        if (list.getClass().toString().equals("class java.util.LinkedList"))
            System.out.printf("%-15s", "LinkedList");
        else
            System.out.printf("%-15s", "ArrayList");
    }
    static void Testing(List<Integer> list)
    {
        for(int i=1000;i<=100000;i=i*10) {
            printListName(list);
            TestAdd(i, list);
        }
        System.out.println();
        for(int i=1000;i<=20000;i=i*4) {
            printListName(list);
            TestGet(i, list);
        }
        System.out.println();
        for(int i=1000;i<=20000;i=i*4) {
            printListName(list);
            TestDelete(i, list);
        }
    }



    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> array = new ArrayList<>();
        System.out.printf("%-15s%-10s%-20s%-12s%n","Тип Списка","Метод","Кол-во операций","Время(ms)");
        Testing(list);
        System.out.println();
        Testing(array);
    }
}

