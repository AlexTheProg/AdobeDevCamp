package com.turbodriver.employee.model;

public enum Job {
    DRIVER("Driver"),
    CLEANER("Cleaner"),
    DETAILER("Detailer"),
    SUPPORT_AGENT("Support Agent"),
    IT("IT Specialist"),
    ACCOUNTING("Accounting specialist"),
    LEGAL("Legal specialist"),
    HR("HR specialist");

    private final String value;

    Job(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
