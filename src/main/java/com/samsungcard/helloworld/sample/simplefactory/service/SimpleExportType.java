package com.samsungcard.helloworld.sample.simplefactory.service;

public enum SimpleExportType {
    MAIL("mail"), FAX("fax");

    private final String s;

    SimpleExportType(String s) {
        this.s = s;
    }

    public static SimpleExportType get(String s) {
        if (MAIL.toString().equals(s))
            return SimpleExportType.MAIL;
        if (FAX.toString().equals(s))
            return SimpleExportType.FAX;
        return null;
    }

    @Override
    public String toString() {
        return s;
    }
}
