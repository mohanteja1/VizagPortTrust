package com.example.mohanteja.vizagporttrust;

public class PumpHouseItem {
    private String SLNO;
    private String PUMP_HOUSES;
    private String TOTAL_PUMPS_MOTORS;
    private String SHIFT_1;
    private String SHIFT_2;
    private String SHIFT_3;
    private String SHIFT_G;


    public PumpHouseItem(String SLNO, String PUMP_HOUSES, String TOTAL_PUMPS_MOTORS, String SHIFT_1, String SHIFT_2, String SHIFT_3, String SHIFT_G) {
        this.SLNO = SLNO;
        this.PUMP_HOUSES = PUMP_HOUSES;
        this.TOTAL_PUMPS_MOTORS = TOTAL_PUMPS_MOTORS;
        this.SHIFT_1 = SHIFT_1;
        this.SHIFT_2 = SHIFT_2;
        this.SHIFT_3 = SHIFT_3;
        this.SHIFT_G = SHIFT_G;
    }

    public String getSLNO() {
        return SLNO;
    }

    public String getPUMP_HOUSES() {
        return PUMP_HOUSES;
    }

    public String getTOTAL_PUMPS_MOTORS() {
        return TOTAL_PUMPS_MOTORS;
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
        return "PumpHouseItem{" +
                "SLNO='" + SLNO + '\'' +
                ", PUMP_HOUSES='" + PUMP_HOUSES + '\'' +
                ", TOTAL_PUMPS_MOTORS='" + TOTAL_PUMPS_MOTORS + '\'' +
                ", SHIFT_1='" + SHIFT_1 + '\'' +
                ", SHIFT_2='" + SHIFT_2 + '\'' +
                ", SHIFT_3='" + SHIFT_3 + '\'' +
                ", SHIFT_G='" + SHIFT_G + '\'' +
                '}';
    }
}
