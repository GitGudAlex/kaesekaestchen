package dreamTeam.Matchfield;

import dreamTeam.App;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bonusfield extends Field {

    private static final Logger logger = LogManager.getLogger(App.class);

    public Bonusfield(int fieldIndex) {
        super(fieldIndex);
    }

    @Override
    public String getType() {
        logger.debug("Fieldtype: bonus");
        return "bonus";
    }

    @Override
    public String getTypeField() {
        logger.debug("Fieldtype: bonus");
        return "+";
    }
}
