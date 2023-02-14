package com.volvo.ohs;

import java.time.Instant;

public class ServiceContext {

    public static final String COMMIT_ID = System.getenv("PARAM_COMMIT_ID");
    private ServiceContext() {
    }

    public static String epochString() {
        return String.valueOf(Instant.now().toEpochMilli());
    }
}
