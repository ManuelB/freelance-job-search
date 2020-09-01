package de.incentery.matrix.connector.services;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.enterprise.concurrent.ManagedExecutorService;

class MockedManagedExecutorService implements ManagedExecutorService {
	ExecutorService executorService = Executors.newFixedThreadPool(1);

	public void execute(Runnable command) {
		executorService.execute(command);
	}

	public void shutdown() {
		executorService.shutdown();
	}

	public List<Runnable> shutdownNow() {
		return executorService.shutdownNow();
	}

	public boolean isShutdown() {
		return executorService.isShutdown();
	}

	public boolean isTerminated() {
		return executorService.isTerminated();
	}

	public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
		return executorService.awaitTermination(timeout, unit);
	}

	public <T> Future<T> submit(Callable<T> task) {
		return executorService.submit(task);
	}

	public <T> Future<T> submit(Runnable task, T result) {
		return executorService.submit(task, result);
	}

	public Future<?> submit(Runnable task) {
		return executorService.submit(task);
	}

	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
		return executorService.invokeAll(tasks);
	}

	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
			throws InterruptedException {
		return executorService.invokeAll(tasks, timeout, unit);
	}

	public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
		return executorService.invokeAny(tasks);
	}

	public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
			throws InterruptedException, ExecutionException, TimeoutException {
		return executorService.invokeAny(tasks, timeout, unit);
	}
}