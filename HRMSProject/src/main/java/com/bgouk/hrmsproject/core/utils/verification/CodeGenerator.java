package com.bgouk.hrmsproject.core.utils.verification;

import java.util.UUID;

public class CodeGenerator {

    public static String generateUUIDCode() {
        return UUID.randomUUID().toString();
    }
}
