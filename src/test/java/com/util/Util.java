package com.util;

import com.emun.StructureType;

import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class Util {

    public static void finishTheTime(long startTime, StructureType structureType ) {
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("Execution " + structureType.description + " structure time is "
                + formatter.format((System.nanoTime() - startTime) / 100000000d) + " seconds");
        System.out.println();
    }

    public static String randomStringCreator() {
        byte[] array = new byte[3];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }
}
