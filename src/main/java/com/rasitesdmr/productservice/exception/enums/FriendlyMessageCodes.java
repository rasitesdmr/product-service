package com.rasitesdmr.productservice.exception.enums;

public enum FriendlyMessageCodes implements FriendlyMessageCode {
    OK(1000);

    private final int value;

    FriendlyMessageCodes(int value){
        this.value = value;
    }


    @Override
    public int getFriendlyMessageCode() {
        return value;
    }
}
