package com.test.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * 零件扩展表 2019年3月22日11:06:20 zhoutian update
 */
public class SPartsXm extends HeaderEntity implements Serializable {
    private String id;
    private String name;
    private String type;
    private String parRowId;
    private String partsId;
    private String partsNo;
    private String partsName;
    private String corporationId;
    private String corporationCode;
    private String corporationName;
    private Integer roqCodeCd;
    private Integer isAbcInvol;
    private Integer abcCodeCd;
    private Integer amsQty;
    private Integer amcQty;
    private Integer bkAdCd;
    private Integer adMax;
    private Integer adMin;
    private Short adjustFlg;
    private Integer adjustMax;
    private Integer adjustMin;
    private Integer ppremaxQty;
    private Integer premaxQty;
    private Integer benchmarkAm;
    private Integer benchmarkDay;
    private Integer monthA;
    private Integer monthB;
    private Integer monthC;
    private Integer monthD;
    private Integer monthE;
    private Integer monthF;
    private Integer maxQty;
    private Integer minQty;
    private Integer bkAdP;
    private Integer isHq;
    private String dataSource;
    private String importComment;
    private Integer preminQty;
    private Integer ppreminQty;
    private Integer handFlg;
    private Integer isRcmdStock;
    private Integer isLock;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParRowId() {
        return parRowId;
    }

    public void setParRowId(String parRowId) {
        this.parRowId = parRowId;
    }

    public String getPartsId() {
        return partsId;
    }

    public void setPartsId(String partsId) {
        this.partsId = partsId;
    }

    public String getPartsNo() {
        return partsNo;
    }

    public void setPartsNo(String partsNo) {
        this.partsNo = partsNo;
    }

    public String getPartsName() {
        return partsName;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName;
    }

    public String getCorporationId() {
        return this.corporationId;
    }

    public void setCorporationId(String corporationId) {
        this.corporationId = corporationId;
    }

    public String getCorporationCode() {
        return this.corporationCode;
    }

    public void setCorporationCode(String corporationCode) {
        this.corporationCode = corporationCode;
    }

    public String getCorporationName() {
        return this.corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    public Integer getRoqCodeCd() {
        return roqCodeCd;
    }

    public void setRoqCodeCd(Integer roqCodeCd) {
        this.roqCodeCd = roqCodeCd;
    }

    public Integer getIsAbcInvol() {
        return isAbcInvol;
    }

    public void setIsAbcInvol(Integer isAbcInvol) {
        this.isAbcInvol = isAbcInvol;
    }

    public Integer getAbcCodeCd() {
        return abcCodeCd;
    }

    public void setAbcCodeCd(Integer abcCodeCd) {
        this.abcCodeCd = abcCodeCd;
    }

    public Integer getAmsQty() {
        return amsQty;
    }

    public void setAmsQty(Integer amsQty) {
        this.amsQty = amsQty;
    }

    public Integer getAmcQty() {
        return amcQty;
    }

    public void setAmcQty(Integer amcQty) {
        this.amcQty = amcQty;
    }

    public Integer getBkAdCd() {
        return bkAdCd;
    }

    public void setBkAdCd(Integer bkAdCd) {
        this.bkAdCd = bkAdCd;
    }

    public Integer getAdMax() {
        return adMax;
    }

    public void setAdMax(Integer adMax) {
        this.adMax = adMax;
    }

    public Integer getAdMin() {
        return adMin;
    }

    public void setAdMin(Integer adMin) {
        this.adMin = adMin;
    }

    public Short getAdjustFlg() {
        return adjustFlg;
    }

    public void setAdjustFlg(Short adjustFlg) {
        this.adjustFlg = adjustFlg;
    }

    public Integer getAdjustMax() {
        return adjustMax;
    }

    public void setAdjustMax(Integer adjustMax) {
        this.adjustMax = adjustMax;
    }

    public Integer getAdjustMin() {
        return adjustMin;
    }

    public void setAdjustMin(Integer adjustMin) {
        this.adjustMin = adjustMin;
    }

    public Integer getPpremaxQty() {
        return ppremaxQty;
    }

    public void setPpremaxQty(Integer ppremaxQty) {
        this.ppremaxQty = ppremaxQty;
    }

    public Integer getPremaxQty() {
        return premaxQty;
    }

    public void setPremaxQty(Integer premaxQty) {
        this.premaxQty = premaxQty;
    }

    public Integer getBenchmarkAm() {
        return benchmarkAm;
    }

    public void setBenchmarkAm(Integer benchmarkAm) {
        this.benchmarkAm = benchmarkAm;
    }

    public Integer getBenchmarkDay() {
        return benchmarkDay;
    }

    public void setBenchmarkDay(Integer benchmarkDay) {
        this.benchmarkDay = benchmarkDay;
    }

    public Integer getMonthA() {
        return monthA;
    }

    public void setMonthA(Integer monthA) {
        this.monthA = monthA;
    }

    public Integer getMonthB() {
        return monthB;
    }

    public void setMonthB(Integer monthB) {
        this.monthB = monthB;
    }

    public Integer getMonthC() {
        return monthC;
    }

    public void setMonthC(Integer monthC) {
        this.monthC = monthC;
    }

    public Integer getMonthD() {
        return monthD;
    }

    public void setMonthD(Integer monthD) {
        this.monthD = monthD;
    }

    public Integer getMonthE() {
        return monthE;
    }

    public void setMonthE(Integer monthE) {
        this.monthE = monthE;
    }

    public Integer getMonthF() {
        return monthF;
    }

    public void setMonthF(Integer monthF) {
        this.monthF = monthF;
    }

    public Integer getMaxQty() {
        return maxQty;
    }

    public void setMaxQty(Integer maxQty) {
        this.maxQty = maxQty;
    }

    public Integer getMinQty() {
        return minQty;
    }

    public void setMinQty(Integer minQty) {
        this.minQty = minQty;
    }

    public Integer getBkAdP() {
        return bkAdP;
    }

    public void setBkAdP(Integer bkAdP) {
        this.bkAdP = bkAdP;
    }

    public Integer getIsHq() {
        return isHq;
    }

    public void setIsHq(Integer isHq) {
        this.isHq = isHq;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getImportComment() {
        return importComment;
    }

    public void setImportComment(String importComment) {
        this.importComment = importComment;
    }

    public Integer getPreminQty() {
        return preminQty;
    }

    public void setPreminQty(Integer preminQty) {
        this.preminQty = preminQty;
    }

    public Integer getPpreminQty() {
        return ppreminQty;
    }

    public void setPpreminQty(Integer ppreminQty) {
        this.ppreminQty = ppreminQty;
    }

    public Integer getHandFlg() {
        return handFlg;
    }

    public void setHandFlg(Integer handFlg) {
        this.handFlg = handFlg;
    }

    public Integer getIsRcmdStock() {
        return isRcmdStock;
    }

    public void setIsRcmdStock(Integer isRcmdStock) {
        this.isRcmdStock = isRcmdStock;
    }

    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SPartsXm sPartsXm = (SPartsXm) o;
        return Objects.equals(id, sPartsXm.id) && Objects.equals(name, sPartsXm.name)
                && Objects.equals(type, sPartsXm.type) && Objects.equals(parRowId, sPartsXm.parRowId)
                && Objects.equals(partsId, sPartsXm.partsId) && Objects.equals(partsNo, sPartsXm.partsNo)
                && Objects.equals(partsName, sPartsXm.partsName)
                && Objects.equals(corporationId, sPartsXm.corporationId)
                && Objects.equals(corporationCode, sPartsXm.corporationCode)
                && Objects.equals(corporationName, sPartsXm.corporationName)
                && Objects.equals(roqCodeCd, sPartsXm.roqCodeCd) && Objects.equals(isAbcInvol, sPartsXm.isAbcInvol)
                && Objects.equals(abcCodeCd, sPartsXm.abcCodeCd) && Objects.equals(amsQty, sPartsXm.amsQty)
                && Objects.equals(amcQty, sPartsXm.amcQty) && Objects.equals(bkAdCd, sPartsXm.bkAdCd)
                && Objects.equals(adMax, sPartsXm.adMax) && Objects.equals(adMin, sPartsXm.adMin)
                && Objects.equals(adjustFlg, sPartsXm.adjustFlg) && Objects.equals(adjustMax, sPartsXm.adjustMax)
                && Objects.equals(adjustMin, sPartsXm.adjustMin) && Objects.equals(ppremaxQty, sPartsXm.ppremaxQty)
                && Objects.equals(premaxQty, sPartsXm.premaxQty) && Objects.equals(benchmarkAm, sPartsXm.benchmarkAm)
                && Objects.equals(benchmarkDay, sPartsXm.benchmarkDay) && Objects.equals(monthA, sPartsXm.monthA)
                && Objects.equals(monthB, sPartsXm.monthB) && Objects.equals(monthC, sPartsXm.monthC)
                && Objects.equals(monthD, sPartsXm.monthD) && Objects.equals(monthE, sPartsXm.monthE)
                && Objects.equals(monthF, sPartsXm.monthF) && Objects.equals(maxQty, sPartsXm.maxQty)
                && Objects.equals(minQty, sPartsXm.minQty) && Objects.equals(bkAdP, sPartsXm.bkAdP)
                && Objects.equals(isHq, sPartsXm.isHq) && Objects.equals(dataSource, sPartsXm.dataSource)
                && Objects.equals(importComment, sPartsXm.importComment)
                && Objects.equals(preminQty, sPartsXm.preminQty) && Objects.equals(ppreminQty, sPartsXm.ppreminQty)
                && Objects.equals(handFlg, sPartsXm.handFlg) && Objects.equals(isRcmdStock, sPartsXm.isRcmdStock)
                && Objects.equals(isLock, sPartsXm.isLock);
    }
}
