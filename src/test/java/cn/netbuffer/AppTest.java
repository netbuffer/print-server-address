package cn.netbuffer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testGetHostAddress() throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost().getHostAddress());
    }
}
