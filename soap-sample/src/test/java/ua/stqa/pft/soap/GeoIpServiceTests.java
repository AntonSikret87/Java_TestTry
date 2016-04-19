package ua.stqa.pft.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by sikretSSD on 19.04.2016.
 */
public class GeoIpServiceTests {

    @Test
    public void testMyIp(){
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("95.134.33.90");
        assertEquals(geoIP.getCountryCode(), "UKR");

    }

    @Test
    public void testInvalidIp(){
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("95.134.33.xx");
        assertEquals(geoIP.getCountryCode(), "UKR");

    }
}
