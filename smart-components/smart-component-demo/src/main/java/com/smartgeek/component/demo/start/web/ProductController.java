package com.smartgeek.component.demo.start.web;

import com.alibaba.cola.dto.Response;
import com.smartgeek.component.demo.app.command.OnSaleCommandExe;
import com.smartgeek.component.demo.client.dto.OnSaleNormalItemCmd;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cys
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private OnSaleCommandExe onSaleCommandExe;

    @PostMapping("/test")
    public Response onSale(@RequestBody @Validated OnSaleNormalItemCmd cmd) {
        //复杂业务代码要怎么写？
        return onSaleCommandExe.execute(cmd);

    }
}
