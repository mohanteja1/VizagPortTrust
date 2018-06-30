package com.example.mohanteja.vizagporttrust;

public class FcsEachCraftItem {

    private String SLNO;
    private String NAME_OF_THE_CRAFT;
    private String COMMISSION;
    private String SHUTDOWN;
    private String NO_OF_MOVEMENTS_SHIFT_1;
    private String NO_OF_MOVEMENTS_SHIFT_2;
    private String NO_OF_MOVEMENTS_SHIFT_3;
    private String NO_OF_MOVEMENTS_SHIFT_G;
    private String TOTAL_NO_OF_MOVEMENTS;

    public FcsEachCraftItem(String SLNO, String NAME_OF_THE_CRAFT, String COMMISSION, String SHUTDOWN, String NO_OF_MOVEMENTS_SHIFT_1, String NO_OF_MOVEMENTS_SHIFT_2, String NO_OF_MOVEMENTS_SHIFT_3, String NO_OF_MOVEMENTS_SHIFT_G, String TOTAL_NO_OF_MOVEMENTS) {
        this.SLNO = SLNO;
        this.NAME_OF_THE_CRAFT = NAME_OF_THE_CRAFT;
        this.COMMISSION = COMMISSION;
        this.SHUTDOWN = SHUTDOWN;
        this.NO_OF_MOVEMENTS_SHIFT_1 = NO_OF_MOVEMENTS_SHIFT_1;
        this.NO_OF_MOVEMENTS_SHIFT_2 = NO_OF_MOVEMENTS_SHIFT_2;
        this.NO_OF_MOVEMENTS_SHIFT_3 = NO_OF_MOVEMENTS_SHIFT_3;
        this.NO_OF_MOVEMENTS_SHIFT_G = NO_OF_MOVEMENTS_SHIFT_G;
        this.TOTAL_NO_OF_MOVEMENTS = TOTAL_NO_OF_MOVEMENTS;
    }


    public String getSLNO() {
        return SLNO;
    }

    public String getNAME_OF_THE_CRAFT() {
        return NAME_OF_THE_CRAFT;
    }

    public String getCOMMISSION() {
        return COMMISSION;
    }

    public String getSHUTDOWN() {
        return SHUTDOWN;
    }

    public String getNO_OF_MOVEMENTS_SHIFT_1() {
        return NO_OF_MOVEMENTS_SHIFT_1;
    }

    public String getNO_OF_MOVEMENTS_SHIFT_2() {
        return NO_OF_MOVEMENTS_SHIFT_2;
    }

    public String getNO_OF_MOVEMENTS_SHIFT_3() {
        return NO_OF_MOVEMENTS_SHIFT_3;
    }

    public String getNO_OF_MOVEMENTS_SHIFT_G() {
        return NO_OF_MOVEMENTS_SHIFT_G;
    }

    public String getTOTAL_NO_OF_MOVEMENTS() {
        return TOTAL_NO_OF_MOVEMENTS;
    }

    @Override
    public String toString() {
        return "FcsEachCraftItem{" +
                "SLNO='" + SLNO + '\'' +
                ", NAME_OF_THE_CRAFT='" + NAME_OF_THE_CRAFT + '\'' +
                ", COMMISSION='" + COMMISSION + '\'' +
                ", SHUTDOWN='" + SHUTDOWN + '\'' +
                ", NO_OF_MOVEMENTS_SHIFT_1='" + NO_OF_MOVEMENTS_SHIFT_1 + '\'' +
                ", NO_OF_MOVEMENTS_SHIFT_2='" + NO_OF_MOVEMENTS_SHIFT_2 + '\'' +
                ", NO_OF_MOVEMENTS_SHIFT_3='" + NO_OF_MOVEMENTS_SHIFT_3 + '\'' +
                ", NO_OF_MOVEMENTS_SHIFT_G='" + NO_OF_MOVEMENTS_SHIFT_G + '\'' +
                ", TOTAL_NO_OF_MOVEMENTS='" + TOTAL_NO_OF_MOVEMENTS + '\'' +
                '}';
    }
}
