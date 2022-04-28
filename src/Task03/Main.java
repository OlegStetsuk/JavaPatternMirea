package Task03;

public class Main {
    public static void main(String[] args) {

        ListLock<Integer> listLock = new ListLock<>();

        Thread th1 = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                listLock.put(i);
            }
        });

        Thread th2 = new Thread(() -> {
            for (int i = 10; i < 20; i++) {
                listLock.put(i);
            }
        });

        th1.start();
        th2.start();

        try{
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(listLock);
        System.out.println(listLock.size());
    }
}
