package com.felipe.solidgof.notification;

public final class ConsoleNotifier implements Notifier {
    @Override
    public void notify(String message) {
        System.out.println("[NOTIFY] " + message);
    }
}
