package com.felipe.solidgof.notification;

/**
 * DIP: high-level modules depend on this abstraction.
 * ISP: keep the interface small and focused.
 */
public interface Notifier {
    void notify(String message);
}
