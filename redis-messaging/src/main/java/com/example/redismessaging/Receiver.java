package com.example.redismessaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private AtomicInteger counter = new AtomicInteger();

    public void receiveMessage(String message) {
        LOGGER.info("Received {}", message);
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }
}
