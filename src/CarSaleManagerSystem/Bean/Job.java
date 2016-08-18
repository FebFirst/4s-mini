package CarSaleManagerSystem.Bean;

/**
 * Created by HFQ on 2016/8/17.
 */
public class Job {
    private String job;
    private String valid;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return job;
    }
}
