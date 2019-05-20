package com.brother.common.utils.lock;

public interface AquiredLockWorker<T> {
    T invokeAfterLockAquire() throws Exception;
}
