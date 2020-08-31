package com.hqyj.springcloud.springCloudClientAccount.models.account.service.impl;

import com.hqyj.springcloud.springCloudClientAccount.models.account.entity.City;
import com.hqyj.springcloud.springCloudClientAccount.models.account.service.TestFeignClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class TestFeignClientFallback implements TestFeignClient {

    @Override
    public List<City> getCitiesByCountryId(int countryId) {
        return new ArrayList<>();
    }
}
