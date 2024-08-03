package swagger.petStore.exception;

public class PetStoreException extends RuntimeException {

    public PetStoreException(String message) {
        super(message);
    }

    public PetStoreException(String message, Throwable cause) {
        super(message, cause);
    }

}
