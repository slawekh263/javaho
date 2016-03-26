package org.j45.nursery.lang;

import java.util.HashMap;
import java.util.Map;

public enum AirlineIataCode {

    VIRGIN_AUSTRALIA("VA"),
    ETIHAD_AIRWAYS("EY"),
    AIR_BERLIN("AB"),
    AEROMEXICO("AM");

    private static final Map<String, AirlineIataCode> codes = new HashMap<>();

    static
    {
        for (AirlineIataCode codeEnum : AirlineIataCode.values())
        {
            codes.put(codeEnum.getCode(), codeEnum);
        }
    }

    private String code;

    AirlineIataCode(String label)
    {
        this.code = label;
    }

    public static AirlineIataCode get(String label)
    {
        return codes.get(label);
    }

    public String getCode()
    {
        return this.code;
    }

    @Override
    public String toString()
    {
        return this.getCode();
    }

}