package log;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;
public class LoggingTest {
	final static Logger log = Logger.getGlobal();
	public static void main(String... args) throws IOException {
		XMLFormatter formatter = new XMLFormatter();
		FileHandler handle = new FileHandler("Test.txt");
		handle.setFormatter(formatter);
		log.addHandler(handle);
		log.setLevel(Level.ALL);
		log.entering(LoggingTest.class.getName(), "testLogging");
		testLogging();
		log.exiting(LoggingTest.class.getName(), "testLogging");
	}
	public static void testLogging() throws IOException {
		File f = new File("HELPPPP.txt");
		if(!f.exists()) {
			log.log(Level.SEVERE, "FILE={0} does not exist!", new Object[] {"HELPPPP.txt"});
		}
	}
}
