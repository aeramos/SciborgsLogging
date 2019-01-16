package log;
import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class LoggingTest {
    private final static Logger logger = Logger.getGlobal();

    public static void main(String... args) throws IOException {
        Handler files = new FileHandler("Test.xml");
        files.setFormatter(new XMLFormatter());

        Handler console = new ConsoleHandler();

        console.setLevel(Level.ALL);
        files.setLevel(Level.ALL);

        // add the handler to output to file and to output to console
        logger.addHandler(files);
        logger.addHandler(console);

        logger.setLevel(Level.ALL); // log everything
        logger.setUseParentHandlers(false); // we made the handlers already

        logger.entering(LoggingTest.class.getName(), "method"); // report that the program entered/exited a method
        method();
        logger.exiting(LoggingTest.class.getName(), "method");

        testLogging();
    }

    public static void testLogging() throws IOException {
        File f = new File("HELPPPP.txt");
        if (!f.exists()) {
            logger.log(Level.SEVERE, "FILE={0} does not exist!", new Object[]{f.getName()});
            if (f.createNewFile()) {
                logger.log(Level.CONFIG, "Created new file {0}", new Object[]{f.getName()});
            }
        } else {
            logger.log(Level.FINE, "File exists");
        }
    }

    public static void method() {
        return;
    }
}