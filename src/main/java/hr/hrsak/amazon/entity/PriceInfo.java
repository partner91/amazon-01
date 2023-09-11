package hr.hrsak.amazon.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceInfo {
    @JsonProperty("showFractionalPartIfEmpty")
    private boolean showFractionalPartIfEmpty;

    @JsonProperty("symbolPosition")
    private String symbolPosition;

    @JsonProperty("fractionalValue")
    private String fractionalValue;

    @JsonProperty("decimalSeparator")
    private String decimalSeparator;

    @JsonProperty("currencySymbol")
    private String currencySymbol;

    @JsonProperty("aapiBuyingOptionIndex")
    private int aapiBuyingOptionIndex;

    @JsonProperty("locale")
    private String locale;

    @JsonProperty("buyingOptionType")
    private String buyingOptionType;

    @JsonProperty("displayPrice")
    private String displayPrice;

    @JsonProperty("hasSpace")
    private boolean hasSpace;

    @JsonProperty("integerValue")
    private String integerValue;

    @JsonProperty("priceAmount")
    private double priceAmount;

    @JsonProperty("offerListingId")
    private String offerListingId;

    public String getDisplayPrice() {
        return displayPrice;
    }
}