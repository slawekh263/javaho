package org.j45.nursery;


import org.j45.nursery.payinfo.PayInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Streaming {

    public Set<String> getFfAccountNumbers(List<PayInfo> payInfos) {
        if(payInfos != null) {
            return payInfos.stream()
                    .filter(pi -> "AWARD-NUMBER".equals(pi.getFieldIdTag()))
                    .map(PayInfo::getValue).collect(Collectors.toSet());
        }
        return null;
    }

    public boolean areAllPayInfosAwardNumber(List<PayInfo> payInfos) {
        if(payInfos != null) {
            return payInfos.stream().allMatch(payInfo -> "AWARD-NUMBER".equals(payInfo.getFieldIdTag()));
        }
        return false;
    }

    public Map<String, List<PayInfo>> getValuesByPerson(List<PayInfo> payInfos) {
        Map<String, List<PayInfo>> map = payInfos.stream().collect(Collectors.groupingBy(PayInfo::getPassengerName));
        return map;
/*
                return payInfos.stream()
                .collect(Collectors.groupingBy(
                        PayInfo::getPassengerName,
                        Collectors.mapping(
                                PayInfo::getValue,
                                Collectors.toList())));
         */

    }
}
