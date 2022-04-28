package Task04;

public class Main {
    public static void main(String[] args) {
        CustomExecutorService myExecutor = new CustomExecutorService(2);

        Thread th1 = new Thread(() -> {
            System.out.println("Thread start " + Thread.currentThread().getName() );
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread finished " + Thread.currentThread().getName() );
        });



        for (int i = 0; i < 10; i++) {
            myExecutor.submit(th1);
        }

        myExecutor.shutdown();
    }
}
