package Task04;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

class CustomExecutorService implements ExecutorService {
    ExecutorService exec;
    public CustomExecutorService(int threads) {
        exec = Executors.newFixedThreadPool(threads);
    }

    @Override
    public void shutdown() {
        exec.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return exec.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return exec.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return exec.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return exec.awaitTermination(timeout, unit);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return exec.submit(task);
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return exec.submit(task, result);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return submit(task);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return exec.invokeAll(tasks);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return invokeAll(tasks, timeout, unit);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return exec.invokeAny(tasks);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
            throws InterruptedException, ExecutionException, TimeoutException {
        return exec.invokeAny(tasks, timeout, unit);
    }

    @Override
    public void execute(Runnable command) {
        exec.execute(command);
    }
}
