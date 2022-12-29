package com.smartgeek.business.adapter.driven.restful.orgmng;

import com.smartgeek.business.app.orgmng.OrgDto;
import com.smartgeek.business.app.orgmng.OrgService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrgController {
    private final OrgService orgService;

    @PostMapping("/api/organizations")
    public OrgDto addOrg(@RequestBody OrgDto request){
       return orgService.addOrg(request);
    }




}
