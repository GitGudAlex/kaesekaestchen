package dreamTeam.CustomExceptions;

public class IncorrectInput extends RuntimeException {
    public IncorrectInput (String errorMessage, Throwable err){
        super(errorMessage, err);
    }
}
