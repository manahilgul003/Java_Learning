import java.util.logging.Logger;
import java.util.logging.Level;
public class Logg{
private static final Logger logger = Logger.getLogger(Logg.class.getName());
public static void main (String[]args){
logger.severe("Severe message");
logger.warning("Warning message");
logger.info("Info message");
logger.config("Config message");
logger.fine("Fine message");
logger.finer("Finer message");
logger.finest("Finest message");
}
