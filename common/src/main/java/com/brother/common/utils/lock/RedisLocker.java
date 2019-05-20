package com.brother.common.utils.lock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisLocker implements DistributedLocker {
    private final static String LOCKER_PREFIX = "lock:";

    private RedissonConnector connector;

    public void init(int database, String redisHost, String port, String password){
        connector = RedissonConnector.options().setDatabase(database)
                .setHost(redisHost).setPort(port).setPassword(password).build();

    }

    @Override
    public <T> T lock(String resourceName, AquiredLockWorker<T> worker) throws UnableToAquireLockException, Exception {

        return lock(resourceName, worker, 100);
    }

    @Override
    public <T> T lock(String resourceName, AquiredLockWorker<T> worker, int lockTime) throws UnableToAquireLockException, Exception {
        if(connector == null){
            throw new UnableToAquireLockException("RedissonConnector 初始化失败，请检查redis配置信息！！！");
        }
        RedissonClient redissonClient = connector.getClient();
        RLock lock = redissonClient.getLock(LOCKER_PREFIX + resourceName);

        boolean success = lock.tryLock(100, lockTime, TimeUnit.SECONDS);
        if(success){
            try {
                return worker.invokeAfterLockAquire();
            }finally {
                lock.unlock();
            }

        }
        throw new UnableToAquireLockException();
    }
}
