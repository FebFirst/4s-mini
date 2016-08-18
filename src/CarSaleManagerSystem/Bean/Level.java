package CarSaleManagerSystem.Bean;

/**
 * Created by HFQ on 2016/8/17.
 */
public class Level {
    private String level;
    private String valid;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return level;
    }
}
