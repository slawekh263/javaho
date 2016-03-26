package org.j45.nursery.payinfo;


public class PayInfo {
    private String fieldIdTag;
    private String linkSubkey;
    private String nameNumber;
    private String passengerName;
    private SectionId sectionId;
    private String value;

    public PayInfo(String fieldIdTag, String linkSubkey, String nameNumber, String passengerName, SectionId sectionId, String ffAcountNumber) {
        this.fieldIdTag = fieldIdTag;
        this.linkSubkey = linkSubkey;
        this.nameNumber = nameNumber;
        this.passengerName = passengerName;
        this.sectionId = sectionId;
        this.value = ffAcountNumber;
    }

    public String getFieldIdTag() {
        return fieldIdTag;
    }

    public void setFieldIdTag(String fieldIdTag) {
        this.fieldIdTag = fieldIdTag;
    }

    public String getLinkSubkey() {
        return linkSubkey;
    }

    public void setLinkSubkey(String linkSubkey) {
        this.linkSubkey = linkSubkey;
    }

    public String getNameNumber() {
        return nameNumber;
    }

    public void setNameNumber(String nameNumber) {
        this.nameNumber = nameNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public SectionId getSectionId() {
        return sectionId;
    }

    public void setSectionId(SectionId sectionId) {
        this.sectionId = sectionId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
