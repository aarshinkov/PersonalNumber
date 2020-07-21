package com.aarshinkov.projects.pn;

public final class NumberRegion {

    private final int start;
    private final int end;

    public NumberRegion(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean isInRegion(Integer number) {
        return number >= start && number <= end;
    }

}
