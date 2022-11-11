package com.ryan.mmaccountserver.pojo;

import lombok.Data;

import java.util.List;

public class Consumption {
    private String consumptionName;
    private String consumptionNum;
    private List<String> consumptionCategory;
    private String consumptionTime;
    private String consumptionRemark;

    public String getConsumptionName() {
        return consumptionName;
    }

    public void setConsumptionName(String consumptionName) {
        this.consumptionName = consumptionName;
    }

    public String getConsumptionNum() {
        return consumptionNum;
    }

    public void setConsumptionNum(String consumptionNum) {
        this.consumptionNum = consumptionNum;
    }

    public List<String> getConsumptionCategory() {
        return consumptionCategory;
    }

    public void setConsumptionCategory(List<String> consumptionCategory) {
        this.consumptionCategory = consumptionCategory;
    }

    public String getConsumptionTime() {
        return consumptionTime;
    }

    public void setConsumptionTime(String consumptionTime) {
        this.consumptionTime = consumptionTime;
    }

    public String getConsumptionRemark() {
        return consumptionRemark;
    }

    public void setConsumptionRemark(String consumptionRemark) {
        this.consumptionRemark = consumptionRemark;
    }
}
