package com.svastrad.adEnhancer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "pct_female",
        "pct_age_0_to_3",
        "pct_age_4_to_9",
        "pct_age_10_to_19",
        "pct_age_20_to_29",
        "pct_age_30_to_39",
        "pct_age_40_to_49",
        "pct_age_50_to_59",
        "pct_age_60_to_79",
        "pct_age_80_to_99"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Demographics {

    @JsonProperty("pct_female")
    private Integer pctFemale;
    @JsonProperty("pct_age_0_to_3")
    private Integer pctAge0To3;
    @JsonProperty("pct_age_4_to_9")
    private Integer pctAge4To9;
    @JsonProperty("pct_age_10_to_19")
    private Integer pctAge10To19;
    @JsonProperty("pct_age_20_to_29")
    private Integer pctAge20To29;
    @JsonProperty("pct_age_30_to_39")
    private Integer pctAge30To39;
    @JsonProperty("pct_age_40_to_49")
    private Integer pctAge40To49;
    @JsonProperty("pct_age_50_to_59")
    private Integer pctAge50To59;
    @JsonProperty("pct_age_60_to_79")
    private Integer pctAge60To79;
    @JsonProperty("pct_age_80_to_99")
    private Integer pctAge80To99;

    @JsonProperty("pct_female")
    public Integer getPctFemale() {
        return pctFemale;
    }

    @JsonProperty("pct_female")
    public void setPctFemale(Integer pctFemale) {
        this.pctFemale = pctFemale;
    }

    @JsonProperty("pct_age_0_to_3")
    public Integer getPctAge0To3() {
        return pctAge0To3;
    }

    @JsonProperty("pct_age_0_to_3")
    public void setPctAge0To3(Integer pctAge0To3) {
        this.pctAge0To3 = pctAge0To3;
    }

    @JsonProperty("pct_age_4_to_9")
    public Integer getPctAge4To9() {
        return pctAge4To9;
    }

    @JsonProperty("pct_age_4_to_9")
    public void setPctAge4To9(Integer pctAge4To9) {
        this.pctAge4To9 = pctAge4To9;
    }

    @JsonProperty("pct_age_10_to_19")
    public Integer getPctAge10To19() {
        return pctAge10To19;
    }

    @JsonProperty("pct_age_10_to_19")
    public void setPctAge10To19(Integer pctAge10To19) {
        this.pctAge10To19 = pctAge10To19;
    }

    @JsonProperty("pct_age_20_to_29")
    public Integer getPctAge20To29() {
        return pctAge20To29;
    }

    @JsonProperty("pct_age_20_to_29")
    public void setPctAge20To29(Integer pctAge20To29) {
        this.pctAge20To29 = pctAge20To29;
    }

    @JsonProperty("pct_age_30_to_39")
    public Integer getPctAge30To39() {
        return pctAge30To39;
    }

    @JsonProperty("pct_age_30_to_39")
    public void setPctAge30To39(Integer pctAge30To39) {
        this.pctAge30To39 = pctAge30To39;
    }

    @JsonProperty("pct_age_40_to_49")
    public Integer getPctAge40To49() {
        return pctAge40To49;
    }

    @JsonProperty("pct_age_40_to_49")
    public void setPctAge40To49(Integer pctAge40To49) {
        this.pctAge40To49 = pctAge40To49;
    }

    @JsonProperty("pct_age_50_to_59")
    public Integer getPctAge50To59() {
        return pctAge50To59;
    }

    @JsonProperty("pct_age_50_to_59")
    public void setPctAge50To59(Integer pctAge50To59) {
        this.pctAge50To59 = pctAge50To59;
    }

    @JsonProperty("pct_age_60_to_79")
    public Integer getPctAge60To79() {
        return pctAge60To79;
    }

    @JsonProperty("pct_age_60_to_79")
    public void setPctAge60To79(Integer pctAge60To79) {
        this.pctAge60To79 = pctAge60To79;
    }

    @JsonProperty("pct_age_80_to_99")
    public Integer getPctAge80To99() {
        return pctAge80To99;
    }

    @JsonProperty("pct_age_80_to_99")
    public void setPctAge80To99(Integer pctAge80To99) {
        this.pctAge80To99 = pctAge80To99;
    }

}
