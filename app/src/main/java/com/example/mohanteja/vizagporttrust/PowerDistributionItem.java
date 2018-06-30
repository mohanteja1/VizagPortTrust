package com.example.mohanteja.vizagporttrust;

public class PowerDistributionItem {

    public String  SLNO;
    public String  PARAMETERS;
    public String  SHIFT_1;
    public String  SHIFT_2;
    public String  SHIFT_3;
    public String  SHIFT_G;

    public PowerDistributionItem(String SLNO, String PARAMETERS, String SHIFT_1, String SHIFT_2, String SHIFT_3, String SHIFT_G) {
        this.SLNO = SLNO;
        this.PARAMETERS = PARAMETERS;
        this.SHIFT_1 = SHIFT_1;
        this.SHIFT_2 = SHIFT_2;
        this.SHIFT_3 = SHIFT_3;
        this.SHIFT_G = SHIFT_G;
    }


    public String getSLNO() {
        return SLNO;
    }

    public String getPARAMETERS() {
        return PARAMETERS;
    }

    public String getSHIFT_1() {
        return SHIFT_1;
    }

    public String getSHIFT_2() {
        return SHIFT_2;
    }

    public String getSHIFT_3() {
        return SHIFT_3;
    }

    public String getSHIFT_G() {
        return SHIFT_G;
    }

    @Override
    public String toString() {
        return "PowerDistributionItem{" +
                "SLNO='" + SLNO + '\'' +
                ", PARAMETERS='" + PARAMETERS + '\'' +
                ", SHIFT_1='" + SHIFT_1 + '\'' +
                ", SHIFT_2='" + SHIFT_2 + '\'' +
                ", SHIFT_3='" + SHIFT_3 + '\'' +
                ", SHIFT_G='" + SHIFT_G + '\'' +
                '}';
    }
}
