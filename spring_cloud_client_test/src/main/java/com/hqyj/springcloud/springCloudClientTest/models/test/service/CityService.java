package com.hqyj.springcloud.springCloudClientTest.models.test.service;

import com.github.pagehelper.PageInfo;
import com.hqyj.springcloud.springCloudClientTest.models.common.vo.Result;
import com.hqyj.springcloud.springCloudClientTest.models.common.vo.SearchVo;
import com.hqyj.springcloud.springCloudClientTest.models.test.entity.City;


import java.util.List;


public interface CityService {

    List<City> getCitiesByCountryId(int countryId);

    PageInfo<City> getCitiesBySearchVo(int countryId, SearchVo searchVo);

    PageInfo<City> getCitiesBySearchVo(SearchVo searchVo);

    Result<City> insertCity(City city);

    Result<City> updateCity(City city);

    Result<Object> deleteCity(int cityId);
}
