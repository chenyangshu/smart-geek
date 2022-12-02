package com.smartgeek.component.demo.start.web;

import com.alibaba.cola.dto.SingleResponse;
import com.smartgeek.component.demo.app.command.TestFlowCmdExe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cys
 */
@RestController
@RequestMapping("/flow")
public class TestFlowController {

    @Resource
    private TestFlowCmdExe testFlowCmdExe;

    @GetMapping("/test")
    public SingleResponse<String> testFlow() {
        return testFlowCmdExe.execute();

    }
}
