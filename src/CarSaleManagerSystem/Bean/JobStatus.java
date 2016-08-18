package CarSaleManagerSystem.Bean;

/**
 * Created by HFQ on 2016/8/17.
 */
public class JobStatus {
    private String jobStatus;
    private String valid;

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    @Override
    public String toString() {
        return jobStatus;
    }
}
