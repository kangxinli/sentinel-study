package com.sample.sentinel.demo.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRuleManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;


@Controller
public class ParamFlowController {

    /**
     * 热点限流的资源名
      */
    private String resourceName = "freqParam";

    public ParamFlowController(){
        // 定义热点限流的规则，对第一个参数设置 qps 限流模式，阈值为5
        ParamFlowRule rule = new ParamFlowRule(resourceName)
                .setParamIdx(0)
                .setGrade(RuleConstant.FLOW_GRADE_QPS)
                .setCount(5);
        ParamFlowRuleManager.loadRules(Collections.singletonList(rule));
    }

    /**
     * 热点参数限流
     * 构造不同的uid的值，并且以不同的频率来请求该方法，查看效果
     */
    @GetMapping("/freqParamFlow")
    @ResponseBody
    public String freqParamFlow(@RequestParam("uid") Long uid,@RequestParam("ip") Long ip) {
        Entry entry = null;
        String retVal;
        try{
            // 只对参数 uid 的值进行限流，参数 ip 的值不进行限制
            entry = SphU.entry(resourceName, EntryType.IN, 1, uid);
            retVal = "passed";
        }catch(BlockException e){
            retVal = "blocked";
        }finally {
            if(entry!=null){
                entry.exit();
            }
        }
        return retVal;
    }


    /**
     * 热点参数限流
     */
    @GetMapping("/freqParamFlowWithoutParam")
    @ResponseBody
    public String freqParamFlowWithoutParam(@RequestParam("uid") Long uid,@RequestParam("ip") Long ip) {
        Entry entry = null;
        String retVal;
        try{
            // 如果不传入任何参数，来查询热点参数限流的效果
            entry = SphU.entry(resourceName, EntryType.IN, 1);
            retVal = "passed";
        }catch(BlockException e){
            retVal = "blocked";
        }finally {
            if(entry!=null){
                entry.exit();
            }
        }
        return retVal;
    }
}
