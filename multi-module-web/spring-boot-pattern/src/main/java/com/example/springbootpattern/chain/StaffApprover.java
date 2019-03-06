package com.example.springbootpattern.chain;

/**
 * @author CREATED BY L.C.Y on 2019-3-6
 */
public class StaffApprover extends AbstractApprover {
    public StaffApprover(String name) {
        super(name);
    }

    /**
     * 审批方法
     *
     * @param amount
     */
    @Override
    public void approve(int amount) {
        if (amount <= 1000) {
            System.out.println("【员工:" + name + "】" + "审批通过。");
            System.out.println("===================================");
        } else {
            System.out.println("【员工:" + name + "】" + "无权审批，升级处理。");
            this.nextApprover.approve(amount);
        }
    }
}
