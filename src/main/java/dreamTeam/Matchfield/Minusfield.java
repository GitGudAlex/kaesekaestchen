package dreamTeam.Matchfield;

import dreamTeam.App;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Minusfield extends Field {

    private static final Logger logger = LogManager.getLogger(App.class);

    public Minusfield(int fieldIndex) {
        super(fieldIndex);
    }

    @Override
    public String getType() {
        logger.debug("Fieldtype: minus");
        return "minus";
    }

    @Override
    public String getTypeField() {
        logger.debug("Fieldtype: minus");
        return "-";
    }
}
