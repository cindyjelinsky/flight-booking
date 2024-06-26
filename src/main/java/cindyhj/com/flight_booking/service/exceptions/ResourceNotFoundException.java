package cindyhj.com.flight_booking.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id){
        super("Resource Not Found. ID: " + id);
    }

}
