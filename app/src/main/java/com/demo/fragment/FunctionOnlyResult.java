package com.demo.fragment;

/**
 * 只包含结果
 */
public abstract class FunctionOnlyResult<Result> extends Function {

    public FunctionOnlyResult(String functionName) {
        super(functionName);
    }

    abstract Result function();
}
