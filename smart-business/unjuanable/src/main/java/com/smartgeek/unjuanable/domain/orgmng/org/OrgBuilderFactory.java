package com.smartgeek.unjuanable.domain.orgmng.org;

import com.smartgeek.unjuanable.domain.orgmng.org.validator.CommonValidator;
import com.smartgeek.unjuanable.domain.orgmng.org.validator.SuperiorValidator;
import com.smartgeek.unjuanable.domain.orgmng.org.validator.OrgLeaderValidator;
import com.smartgeek.unjuanable.domain.orgmng.org.validator.OrgNameValidator;
import com.smartgeek.unjuanable.domain.orgmng.org.validator.OrgTypeValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 组织建设者工厂
 *
 * @author chenyangshu
 * @date 2022/12/29
 */
@Component
@RequiredArgsConstructor
public class OrgBuilderFactory {
    private final CommonValidator commonValidator;
    private final OrgTypeValidator orgTypeValidator;
    private final SuperiorValidator superiorValidator;
    private final OrgNameValidator orgNameValidator;
    private final OrgLeaderValidator orgLeaderValidator;


    //每次调用都创建一个新的 OrgBuilder
    public OrgBuilder create() {
        return new OrgBuilder(commonValidator
                , orgTypeValidator
                , superiorValidator
                , orgNameValidator
                , orgLeaderValidator);
    }
}
