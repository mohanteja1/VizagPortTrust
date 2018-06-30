package com.example.mohanteja.vizagporttrust;

public class FcsDeploymentItems {

    private String SLNO;
    private String CRAFT_TYPE;
    private String TOTAL_CRAFTS;
    private String AVAILABLE_CRAFTS;
    private String SHIFT1;
    private String SHIFT2;
    private String SHIFT3;
    private String SHIFTG;


    public String getSLNO() {
        return SLNO;
    }

    public String getCRAFT_TYPE() {
        return CRAFT_TYPE;
    }

    public String getTOTAL_CRAFTS() {
        return TOTAL_CRAFTS;
    }

    public String getAVAILABLE_CRAFTS() {
        return AVAILABLE_CRAFTS;
    }

    public String getSHIFT1() {
        return SHIFT1;
    }

    public String getSHIFT2() {
        return SHIFT2;
    }

    public String getSHIFT3() {
        return SHIFT3;
    }

    public String getSHIFTG() {
        return SHIFTG;
    }

    public FcsDeploymentItems(String SLNO, String CRAFT_TYPE, String TOTAL_CRAFTS, String AVAILABLE_CRAFTS, String SHIFT1, String SHIFT2, String SHIFT3, String SHIFTG) {
        this.SLNO = SLNO;
        this.CRAFT_TYPE = CRAFT_TYPE;
        this.TOTAL_CRAFTS = TOTAL_CRAFTS;
        this.AVAILABLE_CRAFTS = AVAILABLE_CRAFTS;
        this.SHIFT1 = SHIFT1;
        this.SHIFT2 = SHIFT2;
        this.SHIFT3 = SHIFT3;
        this.SHIFTG = SHIFTG;
    }

    @Override
    public String toString() {
        return "FcsDeploymentItems{" +
                "SLNO='" + SLNO + '\'' +
                ", CRAFT_TYPE='" + CRAFT_TYPE + '\'' +
                ", TOTAL_CRAFTS='" + TOTAL_CRAFTS + '\'' +
                ", AVAILABLE_CRAFTS='" + AVAILABLE_CRAFTS + '\'' +
                ", SHIFT1='" + SHIFT1 + '\'' +
                ", SHIFT2='" + SHIFT2 + '\'' +
                ", SHIFT3='" + SHIFT3 + '\'' +
                ", SHIFTG='" + SHIFTG + '\'' +
                '}';
    }
}
