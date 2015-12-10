import me.zebmccorkle.uilpractice.twothousandfourteen.january.BaseCon;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;

public class BaseConTest {
    @Test
    public void sampleTestCase() throws Exception {
        PipedOutputStream outputStream = new PipedOutputStream();
        PipedInputStream inputStream = new PipedInputStream();
        outputStream.connect(inputStream);
        BaseCon.algo(new FileInputStream(new File("basecon.in")), outputStream);
        Scanner scanner = new Scanner(inputStream);
        assertEquals("34", scanner.next());
        assertEquals("22", scanner.next());
        assertEquals("42", scanner.next());
        assertEquals("100010", scanner.next());

        assertEquals("142", scanner.next());
        assertEquals("8e", scanner.next());
        assertEquals("216", scanner.next());
        assertEquals("10001110", scanner.next());

        assertEquals("-60", scanner.next());
        assertEquals("ffffffc4", scanner.next());
        assertEquals("37777777704", scanner.next());
        assertEquals("11111111111111111111111111000100", scanner.next());

        assertEquals("3", scanner.next());
        assertEquals("3", scanner.next());
        assertEquals("3", scanner.next());
        assertEquals("11", scanner.next());

        assertEquals("-1", scanner.next());
        assertEquals("ffffffff", scanner.next());
        assertEquals("37777777777", scanner.next());
        assertEquals("11111111111111111111111111111111", scanner.next());

        assertEquals("3855", scanner.next());
        assertEquals("f0f", scanner.next());
        assertEquals("7417", scanner.next());
        assertEquals("111100001111", scanner.next());
    }
}
