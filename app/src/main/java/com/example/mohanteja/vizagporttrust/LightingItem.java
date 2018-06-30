package com.example.mohanteja.vizagporttrust;

public class LightingItem {
    private String  SLNO;
    private String  LOCATION;
    private String  NO_OF_HIGH_MASTS;
    private String  FITTING_X_H_M_A;
    private String  FITTING_X_H_M_B;
    private String  FITTING_X_H_M_C;
    private String  FITTING_X_H_M_D;
    private String  TOTAL_FITTINGS;
    private String  GLOWING;
    private String  NON_GLOWING;

    public LightingItem(String SLNO, String LOCATION, String NO_OF_HIGH_MASTS, String FITTING_X_H_M_A, String FITTING_X_H_M_B, String FITTING_X_H_M_C, String FITTING_X_H_M_D, String TOTAL_FITTINGS, String GLOWING, String NON_GLOWING) {
        this.SLNO = SLNO;
        this.LOCATION = LOCATION;
        this.NO_OF_HIGH_MASTS = NO_OF_HIGH_MASTS;
        this.FITTING_X_H_M_A = FITTING_X_H_M_A;
        this.FITTING_X_H_M_B = FITTING_X_H_M_B;
        this.FITTING_X_H_M_C = FITTING_X_H_M_C;
        this.FITTING_X_H_M_D = FITTING_X_H_M_D;
        this.TOTAL_FITTINGS = TOTAL_FITTINGS;
        this.GLOWING = GLOWING;
        this.NON_GLOWING = NON_GLOWING;
    }


    public String getSLNO() {
        return SLNO;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public String getNO_OF_HIGH_MASTS() {
        return NO_OF_HIGH_MASTS;
    }

    public String getFITTING_X_H_M_A() {
        return FITTING_X_H_M_A;
    }

    public String getFITTING_X_H_M_B() {
        return FITTING_X_H_M_B;
    }

    public String getFITTING_X_H_M_C() {
        return FITTING_X_H_M_C;
    }

    public String getFITTING_X_H_M_D() {
        return FITTING_X_H_M_D;
    }

    public String getTOTAL_FITTINGS() {
        return TOTAL_FITTINGS;
    }

    public String getGLOWING() {
        return GLOWING;
    }

    public String getNON_GLOWING() {
        return NON_GLOWING;
    }

    @Override
    public String toString() {
        return "LightingItem{" +
                "SLNO='" + SLNO + '\'' +
                ", LOCATION='" + LOCATION + '\'' +
                ", NO_OF_HIGH_MASTS='" + NO_OF_HIGH_MASTS + '\'' +
                ", FITTING_X_H_M_A='" + FITTING_X_H_M_A + '\'' +
                ", FITTING_X_H_M_B='" + FITTING_X_H_M_B + '\'' +
                ", FITTING_X_H_M_C='" + FITTING_X_H_M_C + '\'' +
                ", FITTING_X_H_M_D='" + FITTING_X_H_M_D + '\'' +
                ", TOTAL_FITTINGS='" + TOTAL_FITTINGS + '\'' +
                ", GLOWING='" + GLOWING + '\'' +
                ", NON_GLOWING='" + NON_GLOWING + '\'' +
                '}';
    }
}
