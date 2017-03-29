package com.bootcamp.controllers;

import com.bootcamp.entities.LookupMaster;
import com.bootcamp.repositories.LookupMasterRepository;
import com.bootcamp.repositories.LookupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Fathoni on 3/27/2017.
 */
@RestController
public class LookupMasterController {
    @Autowired
    private LookupMasterRepository lookupMasterRepository;

    @RequestMapping(value = "/api/lookupmaster", method = RequestMethod.GET)
    public ResponseEntity<Page> lookupFindAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable pageRequest = new PageRequest(page, size);
        List<LookupMaster> lookups = (List<LookupMaster>)lookupMasterRepository.findAll();
        Page<LookupMaster> lookupPage = getLookupPage(lookups, pageRequest);
        return new ResponseEntity<>(lookupPage, HttpStatus.OK);
    }

    private Page<LookupMaster> getLookupPage(List<LookupMaster> lookups, Pageable pageRequest){
        PagedListHolder<LookupMaster> pageList = new PagedListHolder<>(lookups);
        pageList.setPage(pageRequest.getPageNumber());
        pageList.setPageSize(pageRequest.getPageSize());

        return new PageImpl<>(pageList.getPageList(), pageRequest, lookups.size());
    }
}
