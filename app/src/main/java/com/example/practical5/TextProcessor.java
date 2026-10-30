package com.example.practical5;

public final class TextProcessor {
    private TextProcessor() {}

    public static String processMunicipality(String municipality) {
        if (municipality == null) return null;
        String trimmed = municipality.trim();
        if (trimmed.isEmpty()) return null;

        if (trimmed.equalsIgnoreCase("Beijing")) return "Beijing";
        if (trimmed.equalsIgnoreCase("Shanghai")) return "Shanghai";
        if (trimmed.equalsIgnoreCase("Tianjin")) return "Tianjin";
        if (trimmed.equalsIgnoreCase("Chongqing")) return "Chongqing";

        return null;
    }
}