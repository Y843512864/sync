package com.dodo.sync.vo;

public class SParts {
    private String id;
    private String partsNo;
    private String repNewPartsno;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPartsNo() {
        return partsNo;
    }

    public void setPartsNo(String partsNo) {
        this.partsNo = partsNo;
    }

    public String getRepNewPartsno() {
        return repNewPartsno;
    }

    public void setRepNewPartsno(String repNewPartsno) {
        this.repNewPartsno = repNewPartsno;
    }

    public boolean equals(SParts sp) {
        return partsNo.equals(sp.getPartsNo()) && repNewPartsno.equals(sp.getRepNewPartsno());
    }

    @Override
    public String toString() {
        return "SParts [id=" + id + ", partsNo=" + partsNo + ", repNewPartsno=" + repNewPartsno + "]";
    }

}
