package de.alectogmbh.friendsurance.automation.data;

public class SearchResult {

    private Boolean provider;
    private String providerAndTariff;
    private String services;
    private String maxRefund;
    private String maxRefundText;
    private Double annualContribution;

    /**
     * Gets maxRefund.
     * @return Value of maxRefund.
     */
    public String getMaxRefund() {
        return maxRefund;
    }

    /**
     * Sets new maxRefund.
     * @param maxRefund New value of maxRefund.
     */
    public void setMaxRefund(String maxRefund) {
        this.maxRefund = maxRefund;
    }

    /**
     * Gets services.
     * @return Value of services.
     */
    public String getServices() {
        return services;
    }

    /**
     * Sets new services.
     * @param services New value of services.
     */
    public void setServices(String services) {
        this.services = services;
    }

    /**
     * Gets providerAndTariff.
     * @return Value of providerAndTariff.
     */
    public String getProviderAndTariff() {
        return providerAndTariff;
    }

    /**
     * Sets new providerAndTariff.
     * @param providerAndTariff New value of providerAndTariff.
     */
    public void setProviderAndTariff(String providerAndTariff) {
        this.providerAndTariff = providerAndTariff;
    }

    /**
     * Gets annualContribution.
     * @return Value of annualContribution.
     */
    public Double getAnnualContribution() {
        return annualContribution;
    }

    /**
     * Sets new annualContribution.
     * @param annualContribution New value of annualContribution.
     */
    public void setAnnualContribution(Double annualContribution) {
        this.annualContribution = annualContribution;
    }

    /**
     * Gets provider.
     * @return Value of provider.
     */
    public Boolean getProvider() {
        return provider;
    }

    /**
     * Sets new provider.
     * @param provider New value of provider.
     */
    public void setProvider(Boolean provider) {
        this.provider = provider;
    }

    /**
     * Gets maxRefundText.
     * @return Value of maxRefundText.
     */
    public String getMaxRefundText() {
        return maxRefundText;
    }

    /**
     * Sets new maxRefundText.
     * @param maxRefundText New value of maxRefundText.
     */
    public void setMaxRefundText(String maxRefundText) {
        this.maxRefundText = maxRefundText;
    }
}
