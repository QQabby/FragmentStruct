package com.demo.fragment;

/**
 * 只包含参数
 */
public abstract class FunctionOnlyParam<Param> extends Function {


    public FunctionOnlyParam(String functionName) {
        super(functionName);
    }

    abstract void function(Param param);
}
