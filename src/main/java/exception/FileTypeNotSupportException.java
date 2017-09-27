package exception;

/**
 * Created by fangiming on 2017/9/27.
 */
public class FileTypeNotSupportException extends RuntimeException {

    public FileTypeNotSupportException() {
    }

    public FileTypeNotSupportException(String message) {
        super(message);
    }
}
