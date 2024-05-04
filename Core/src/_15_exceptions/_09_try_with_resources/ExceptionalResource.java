package _15_exceptions._09_try_with_resources;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;

public class ExceptionalResource implements AutoCloseable {

    public void processSomething() {
        throw new IllegalArgumentException("Thrown from processSomething()"); // this will be thrown
    }

    @Override
    public void close() throws Exception {
        throw new NullPointerException("Thrown from close()"); // suppressed
    }

    public static void demoExceptionalResource() throws Exception {
        try (ExceptionalResource exceptionalResource = new ExceptionalResource()) {
            exceptionalResource.processSomething();
        }
    }

    @Test
    public void whenUsingExceptionalResource_thenSuppressedExceptionAvailable() {
        try {
            demoExceptionalResource();
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
            assertEquals("Thrown from processSomething()", e.getMessage());
            assertEquals(1, e.getSuppressed().length);
            assertThat(e.getSuppressed()[0], instanceOf(NullPointerException.class));
            assertEquals("Thrown from close()", e.getSuppressed()[0].getMessage());
        }
    }
}