package com.example.mohanteja.vizagporttrust;

public class CraneItem {

    private String SLNO;
    private String CRANE_TYPE;
    private String TOTAL_CRANES;
    private String AVAILABILITY;
    private String SHIFT_1;
    private String SHIFT_2;
    private String SHIFT_3;
    private String SHIFT_G;

    public CraneItem(String SLNO, String CRANE_TYPE, String TOTAL_CRANES, String AVAILABILITY, String SHIFT_1, String SHIFT_2, String SHIFT_3, String SHIFT_G) {
        this.SLNO = SLNO;
        this.CRANE_TYPE = CRANE_TYPE;
        this.TOTAL_CRANES = TOTAL_CRANES;
        this.AVAILABILITY = AVAILABILITY;
        this.SHIFT_1 = SHIFT_1;
        this.SHIFT_2 = SHIFT_2;
        this.SHIFT_3 = SHIFT_3;
        this.SHIFT_G = SHIFT_G;
    }

    public String getSLNO() {
        return SLNO;
    }

    public String getCRANE_TYPE() {
        return CRANE_TYPE;
    }

    public String getTOTAL_CRANES() {
        return TOTAL_CRANES;
    }

    public String getAVAILABILITY() {
        return AVAILABILITY;
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
        return "CraneItem{" +
                "SLNO='" + SLNO + '\'' +
                ", CRANE_TYPE='" + CRANE_TYPE + '\'' +
                ", TOTAL_CRANES='" + TOTAL_CRANES + '\'' +
                ", AVAILABILITY='" + AVAILABILITY + '\'' +
                ", SHIFT_1='" + SHIFT_1 + '\'' +
                ", SHIFT_2='" + SHIFT_2 + '\'' +
                ", SHIFT_3='" + SHIFT_3 + '\'' +
                ", SHIFT_G='" + SHIFT_G + '\'' +
                '}';
    }
}
