package com.svastrad.adEnhancer.security;

import java.io.IOException;
import java.net.InetAddress;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.google.common.base.Strings;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.AddressNotFoundException;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


import static java.util.Objects.nonNull;


public class AuthorizedIpSecurity
{
    private final String UNKNOWN = "UNKNOWN";
    private final String allowedLocation = "US";
    private final static Logger logger = LoggerFactory.getLogger(AuthorizedIpSecurity.class);

    @Autowired
    private DatabaseReader databaseReader;

    public boolean check(Authentication authentication, HttpServletRequest request)
    {
        String requestIP = extractIp(request);
        String requestLocation= null;
        try {
            requestLocation = getIpLocation(requestIP);
        } catch (IOException | GeoIp2Exception e) {
            e.printStackTrace();
        }
        return allowedLocation.equals(requestLocation);
    }
    private String extractIp(HttpServletRequest request) {
        String clientIp;
        String clientXForwardedForIp = request.getHeader("x-forwarded-for");
        if (nonNull(clientXForwardedForIp)) {
            clientIp = parseXForwardedHeader(clientXForwardedForIp);
        } else {
            clientIp = request.getRemoteAddr();
        }

        return clientIp;
    }
    private String parseXForwardedHeader(String header) {
        return header.split(" *, *")[0];
    }
    private String getIpLocation(String ip) throws IOException, GeoIp2Exception, AddressNotFoundException {

        String location = UNKNOWN;
        if("127.0.0.1".equals(ip)) {
            return "US";
        }

        InetAddress ipAddress = InetAddress.getByName(ip);

        CountryResponse countryResponse = databaseReader.country(ipAddress);
        if (Objects.nonNull(countryResponse) &&
                Objects.nonNull(countryResponse.getCountry()) &&
                !Strings.isNullOrEmpty(countryResponse.getCountry().getName())) {

            location = countryResponse.getCountry().getIsoCode();
        }

        return location;
    }

}
