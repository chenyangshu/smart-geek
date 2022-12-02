package com.smartgeek.component.demo.start.web;

import com.alibaba.cola.dto.SingleResponse;
import com.smartgeek.component.demo.app.command.TestExtensionCmdExe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cys
 */
@RestController
@RequestMapping("/extension")
public class TestExtensionController {

    @Resource
    private TestExtensionCmdExe testExtensionCmdExe;

    @GetMapping("/test")
    public SingleResponse<String> testFlow() {
        return testExtensionCmdExe.execute();

    }

}
