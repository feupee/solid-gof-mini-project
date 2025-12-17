package com.felipe.solidgof;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.felipe.solidgof.config.AppConfig;

class AppConfigSingletonTest {

    @Test
    void returnsSameInstance() {
        var a = AppConfig.getInstance();
        var b = AppConfig.getInstance();
        assertSame(a, b);
        assertNotNull(a.environment());
    }
}
