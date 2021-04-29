package com.samsungcard.helloworld.sample.factorymethod.service;

public enum ExportType {
    GIF("gif"), PDF("pdf");

    private final String s;

    ExportType(String s) {
        this.s = s;
    }

    public static ExportType get(String s) {
        if (GIF.toString().equals(s))
            return GIF;
        if (PDF.toString().equals(s))
            return PDF;
        return null;
    }

    @Override
    public String toString() {
        return s;
    }
}
