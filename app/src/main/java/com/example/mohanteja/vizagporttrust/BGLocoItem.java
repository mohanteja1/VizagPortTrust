package com.example.mohanteja.vizagporttrust;

public class BGLocoItem {
    private String NO_L_OPorD;//'NO.OF LOCOMOTIVES PROVIDED FOR OPERATION PER DAY'
    private String NO_L_A_M;//'NO.OF LOCOMOTIVES UNDER ANNUAL MAINTENANCE'
    private String NO_L_POH;// 'NO.OF LOCOMOTIVES UNDER POH'
    private String NO_L_PM;//'NO.OF LOCOMOTIVES UNDER PREVENTIVE MAINTENANCE',
    private String NO_L_BD;//'NO.OF LOCOMOTIVES UNDER BREAKDOWN',
    private String INCOMING_RAKES; //'INSPECTION OF INCOMING RAKES FOR DAMAGE & DEFICIENCIES PER DAY '
    private String OUTGOING_RAKES;//'INSPECTION OF OUTGOING RAKES FOR DAMAGE & DEFICIENCIES PER DAY ',
    private String NO_RorD;//'NO OF DRAWN OUT RAKES PER DAY',

    public BGLocoItem(String NO_L_OPorD, String NO_L_A_M, String NO_L_POH, String NO_L_PM, String NO_L_BD, String INCOMING_RAKES, String OUTGOING_RAKES, String NO_RorD) {
        this.NO_L_OPorD = NO_L_OPorD;
        this.NO_L_A_M = NO_L_A_M;
        this.NO_L_POH = NO_L_POH;
        this.NO_L_PM = NO_L_PM;
        this.NO_L_BD = NO_L_BD;
        this.INCOMING_RAKES = INCOMING_RAKES;
        this.OUTGOING_RAKES = OUTGOING_RAKES;
        this.NO_RorD = NO_RorD;
    }

    public String getNO_L_OPorD() {
        return NO_L_OPorD;
    }

    public String getNO_L_A_M() {
        return NO_L_A_M;
    }

    public String getNO_L_POH() {
        return NO_L_POH;
    }

    public String getNO_L_PM() {
        return NO_L_PM;
    }

    public String getNO_L_BD() {
        return NO_L_BD;
    }

    public String getINCOMING_RAKES() {
        return INCOMING_RAKES;
    }

    public String getOUTGOING_RAKES() {
        return OUTGOING_RAKES;
    }

    public String getNO_RorD() {
        return NO_RorD;
    }

    @Override
    public String toString() {
        return "BGLocoItem{" +
                "NO_L_OPorD='" + NO_L_OPorD + '\'' +
                ", NO_L_A_M='" + NO_L_A_M + '\'' +
                ", NO_L_POH='" + NO_L_POH + '\'' +
                ", NO_L_PM='" + NO_L_PM + '\'' +
                ", NO_L_BD='" + NO_L_BD + '\'' +
                ", INCOMING_RAKES='" + INCOMING_RAKES + '\'' +
                ", OUTGOING_RAKES='" + OUTGOING_RAKES + '\'' +
                ", NO_RorD='" + NO_RorD + '\'' +
                '}';
    }
}
