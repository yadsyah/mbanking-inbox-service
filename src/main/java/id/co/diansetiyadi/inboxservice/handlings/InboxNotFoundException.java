package id.co.diansetiyadi.inboxservice.handlings;

public class InboxNotFoundException extends RuntimeException {

    public InboxNotFoundException(String message) {
        super(message);
    }
}
