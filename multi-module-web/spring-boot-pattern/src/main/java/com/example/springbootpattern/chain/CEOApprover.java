package com.example.springbootpattern.chain;

/**
 * @author CREATED BY L.C.Y on 2019-3-6
 */
public class CEOApprover extends AbstractApprover {
    public CEOApprover(String name) {
        super(name);
    }

    /**
     * 审批方法
     *
     * @param amount
     */
    @Override
    public void approve(int amount) {
        if (amount <= 10000) {
            System.out.println("【CEO:" + name + "】" + "审批通过" );
            System.out.println("===================================");
        } else {
            System.out.println("【CEO:" + name + "】" + "驳回申请。");
        }
    }
}
