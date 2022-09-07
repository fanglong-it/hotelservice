package fiveman.hotelservice.controller;

import fiveman.hotelservice.entities.Brand;
import fiveman.hotelservice.service.BrandService;
import fiveman.hotelservice.utils.Common;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "brand")
@RequestMapping("api/v1/")
public class BrandController {
    @Autowired
    BrandService brandService;

    @GetMapping("/brands")
    public ResponseEntity<List<Brand>> getAllBrands(@RequestParam("index") int index, @RequestParam("page") int page){
        return new ResponseEntity<>(brandService.findAllProduct(index, page), HttpStatus.OK);
    }

}
