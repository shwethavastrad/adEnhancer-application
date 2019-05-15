package com.svastrad.adEnhancer.service;

import com.google.common.base.Strings;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.AddressNotFoundException;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;
import com.svastrad.adEnhancer.model.DemographicsResponse;
import com.svastrad.adEnhancer.model.Device;
import com.svastrad.adEnhancer.model.Geo;
import com.svastrad.adEnhancer.model.GeoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Service("geoService")
public class GeoService {
    private final String UNKNOWN = "UNKNOWN";
    private final RestTemplate restTemplate;

    @Autowired
    private DatabaseReader databaseReader;

    public GeoService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    @Async
    public CompletableFuture<Geo> injectCountry(@Valid Device device) {
        String ipUrl = "http://api.ipstack.com/";
        String urlSuffix = "?access_key=00dc507bb26434f855d15c790dc841ea";

        final String uri = ipUrl+device.getIp()+urlSuffix;

        GeoResponse result = null;
        Geo geo = null;

        try {
            //result = this.restTemplate.getForObject(uri, GeoResponse.class);

            if( result != null) {
                geo = new Geo();
                geo.setCountry(getIpLocation(device.getIp()));
            }
        } catch (Exception e) {

        }


        return CompletableFuture.completedFuture(geo);
    }

    private String getIpLocation(String ip) throws IOException, GeoIp2Exception, AddressNotFoundException {

        String location = UNKNOWN;

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
