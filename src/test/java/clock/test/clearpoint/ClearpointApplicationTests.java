package clock.test.clearpoint;

import clock.test.clearpoint.clock.Clocke;
import clock.test.clearpoint.exception.ClockException;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ClearpointApplicationTests {

    @Test
    void testInvalidInput() throws ClockException {
        Clocke clocke = new Clocke();
        Throwable exception = assertThrows(ClockException.class, () -> clocke.Clocke("2501"));
        assertEquals("The time input is not in range!", exception.getMessage());
    }

    @Test
    void testValidInput() throws ClockException {
        Clocke clocke = new Clocke();
        assertEquals(Double.valueOf(165), clocke.Clocke("1230"));
    }

    @Test
    void testValidInputWithOverlapCase() throws ClockException {
        Clocke clocke = new Clocke();
        assertEquals(Double.valueOf(0), clocke.Clocke("2400"));
    }

    @Test
    void testCalculateResultMin() throws ClockException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Clocke clocke = new Clocke();
        Method method = clocke.getClass().getDeclaredMethod("calculateHandleAngle", String.class, Integer[].class);
        method.setAccessible(true);
        assertEquals(Double.valueOf(180), method.invoke(clocke,"MIN", new Integer[]{30}));
    }

    @Test
    void testCalculateResultHour() throws ClockException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Clocke clocke = new Clocke();
        Method method = clocke.getClass().getDeclaredMethod("calculateHandleAngle", String.class, Integer[].class);
        method.setAccessible(true);
        assertEquals(Double.valueOf(370), method.invoke(clocke,"HOUR", new Integer[]{12, 20}));
    }
}
