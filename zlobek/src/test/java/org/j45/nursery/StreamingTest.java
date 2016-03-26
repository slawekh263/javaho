package org.j45.nursery;

import org.j45.nursery.payinfo.PayInfo;
import org.j45.nursery.payinfo.SectionId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class StreamingTest {

    private static List<PayInfo> payInfos = new LinkedList<>();
    static {
        payInfos.add(new PayInfo("AWARD-NUMBER", "0002", "01.01", "Ms Yasmine Lee", SectionId.TRN, "1038641173"));
        payInfos.add(new PayInfo("FOP-TYPE1", "0002", "01.01", "Ms Yasmine Lee", SectionId.TRN, "LP"));
        payInfos.add(new PayInfo("APPROVAL-AMNT1", "0002", "01.01", "Ms Yasmine Lee", SectionId.TRN, "35.00"));
        payInfos.add(new PayInfo("AWARD-NUMBER", "0002", "01.01", "Ms Yasmine Lee", SectionId.TRN, "1038641195"));
        payInfos.add(new PayInfo("LOCATION", "0001", "01.01", "Ms Yasmine Lee", SectionId.TRN, "MELSYD13APR"));
        payInfos.add(new PayInfo("BLAVKA", "0001", "01.01", "Ms Yasmine Lee", SectionId.SSH_COSTAM, "uwauwa"));
        payInfos.add(new PayInfo("ANCILA", "0001", "01.01", "Mr Johny Goodman", SectionId.SSH_COSTAM, "412394839"));
        payInfos.add(new PayInfo("SITY", "0001", "01.01", "Mr Johny Goodman", SectionId.SSH_COSTAM, "uwauwa"));
        payInfos.add(new PayInfo("BAGAZE", "0001", "01.01", "Mr Johny Goodman", SectionId.TRN, "bagazowka"));
    }


    @Test
    public void testGetFfAccountNumbers() {
        Streaming s = new Streaming();
        Set<String> accountNumbers = s.getFfAccountNumbers(payInfos);
        assertEquals(2, accountNumbers.size());
        assertTrue(accountNumbers.contains("1038641173"));
    }


    @Test
    public void getValuesByPerson() {
        Streaming s = new Streaming();
        Map<String, List<PayInfo>> map = s.getValuesByPerson(payInfos);
        assertNotNull(map);
        assertEquals(map.size(), 2);

        List<PayInfo> mrList = map.get("Mr Johny Goodman");
        assertEquals(mrList.size(), 3);
    }

    @Test
    public void testAreAllPayInfosAwardNumber2() {

        Streaming s = new Streaming();
        PayInfo payInfo1 = mock(PayInfo.class);
        given(payInfo1.getFieldIdTag()).willReturn("AWARD-NUMBER");
        PayInfo payInfo2 = mock(PayInfo.class);
        given(payInfo2.getFieldIdTag()).willReturn("AWARD-NUMBER");

        List<PayInfo> payInfos = new LinkedList<>();
        payInfos.add(payInfo1);
        payInfos.add(payInfo2);

        assertTrue(s.areAllPayInfosAwardNumber(payInfos));

    }

}
