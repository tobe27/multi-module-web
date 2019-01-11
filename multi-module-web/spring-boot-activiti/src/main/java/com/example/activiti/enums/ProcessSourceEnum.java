package com.example.activiti.enums;

/**
 * @author Created by L.C.Y on 2018-11-30
 */
public enum ProcessSourceEnum {
    LEAVE_XML("processes/leave.bpmn20.xml"),
    LEAVE_PNG("processes/leave.png");

    private String source;
    ProcessSourceEnum(String source) {
        this.source =source;
    }

    public String getSource() {
        return source;
    }
}
