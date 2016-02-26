
package mx.antonioyee.pueblosmagicos.responses.venue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Price {

    @SerializedName("tier")
    @Expose
    private int tier;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("currency")
    @Expose
    private String currency;

    /**
     * 
     * @return
     *     The tier
     */
    public int getTier() {
        return tier;
    }

    /**
     * 
     * @param tier
     *     The tier
     */
    public void setTier(int tier) {
        this.tier = tier;
    }

    /**
     * 
     * @return
     *     The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 
     * @param message
     *     The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 
     * @return
     *     The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 
     * @param currency
     *     The currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
