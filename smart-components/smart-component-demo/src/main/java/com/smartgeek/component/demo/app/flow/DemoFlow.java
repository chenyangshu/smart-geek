package com.smartgeek.component.demo.app.flow;

import com.smartgeek.component.flow.annotation.flow.Flow;
import com.smartgeek.component.flow.annotation.node.EndNode;
import com.smartgeek.component.flow.annotation.node.NextNodeRoute;
import com.smartgeek.component.flow.annotation.node.ProcessNode;
import com.smartgeek.component.flow.annotation.node.StartNode;
import com.smartgeek.component.flow.engine.WorkContext;
import com.smartgeek.component.flow.work.Work;

@Flow(name = "demoFlow", desc = "演示流程")
public class DemoFlow {

    @StartNode(nextNodeRoute = {@NextNodeRoute(key = "success", nodeName = "runFirstNode")})
    public String start() {
        System.out.println("-----启动节点-------");
        return "success";
    }

    @ProcessNode(nextNodeRoute = {@NextNodeRoute(key = "success", nodeName = "runSecondNode")},
    name = "runFirstNode", handler = "firstStepProcessor", desc = "第一个节点")
    public String runFirstNode(WorkContext<String> workContext) {
        System.out.println("-----第一个节点执行完毕-------");
        return "success";
    }

    @ProcessNode(nextNodeRoute = {@NextNodeRoute(key = "success", nodeName = "end")},
    name = "runSecondNode", handler = "secondStepProcessor", desc = "第二个节点")
    public String runSecondNode(WorkContext<String> workContext) {
        System.out.println("-----第二个节点执行完毕-------");
        return "success";
    }

    /**
    * 结束节点
    */
    @EndNode
    public void end() {
    }

}