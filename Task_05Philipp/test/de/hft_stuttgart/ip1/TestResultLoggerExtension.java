package de.hft_stuttgart.ip1;


import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.lang.reflect.Method;
import java.util.Optional;

public class TestResultLoggerExtension implements TestWatcher, AfterAllCallback {
    private int points = 0;
    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        String student = System.getProperty("STUDENT");
        System.out.printf("AfterAll: %s %s %s %n", student, extensionContext.getDisplayName(), points);
    }

    @Override
    public void testDisabled(ExtensionContext extensionContext, Optional<String> optional) {
        output("Disabled", extensionContext);
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        output("Successful", extensionContext);
    }

    @Override
    public void testAborted(ExtensionContext extensionContext, Throwable throwable) {
        output("Aborted", extensionContext);
    }

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable) {
        output("Failed", extensionContext);
    }

    public void output(String header, ExtensionContext extensionContext) {
        Method meth = extensionContext.getTestMethod().get();
        TestValue testValue = meth.getAnnotation(TestValue.class);
        if ( testValue != null && header.equals("Successful") ) {
            points = points+testValue.value();
        }
        System.out.printf("%s: %s %d %n", header, extensionContext.getDisplayName(), testValue.value());
    }
}
