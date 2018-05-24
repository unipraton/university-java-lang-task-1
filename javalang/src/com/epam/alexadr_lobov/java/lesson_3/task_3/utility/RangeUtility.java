package com.epam.alexadr_lobov.java.lesson_3.task_3.utility;

public class RangeUtility {

    private RangeUtility() {

    }

    public static Long getActivePartOfRangeLength(
            Long blockLength,
            Long activePartOffset,
            Long activePartLength,
            Long point) {
        Long blockCount = point / blockLength;
        Long cutActivePart = Math.min(Math.max(point % blockLength - activePartOffset, 0), activePartLength);
        return blockCount * activePartLength + cutActivePart;
    }

    public static Long getPointByActivePartOfRange(
            Long blockLength,
            Long activePartOffset,
            Long activePartLength,
            Long length) {
        if (length == 0L) {
            return 0L;
        }
        Long blockCount = (length - 1) / activePartLength;
        length %= activePartLength;
        if (length > 0) {
            return blockCount * blockLength + activePartOffset + length;
        } else {
            return blockCount * blockLength + activePartOffset + activePartLength;
        }
    }


}
