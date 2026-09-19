/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.commission.controller;

import cn.zhuatech.commission.common.ApiResponse;
import cn.zhuatech.commission.model.CommissionRun;
import cn.zhuatech.commission.model.CommissionAllocation;
import cn.zhuatech.commission.service.CommissionCalculationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/commission/runs")
public class CommissionRunController {
    private final CommissionCalculationService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public CommissionRunController(CommissionCalculationService service){this.service=service;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @GetMapping ApiResponse<List<CommissionRun>> list(){return ApiResponse.ok(service.list());}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping ApiResponse<CommissionRun> create(@Valid @RequestBody CommissionCalculationService.CreateRequest request){return ApiResponse.ok(service.create(request));}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/{id}/calculate") ApiResponse<CommissionCalculationService.CalculationResult> calculate(@PathVariable Long id){return ApiResponse.ok(service.calculate(id));}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @GetMapping("/{id}/allocations") ApiResponse<List<CommissionAllocation>> allocations(@PathVariable Long id){return ApiResponse.ok(service.allocations(id));}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PutMapping("/{id}/allocations") ApiResponse<List<CommissionAllocation>> allocate(@PathVariable Long id,
        @Valid @RequestBody CommissionCalculationService.AllocationRequest request){return ApiResponse.ok(service.allocate(id,request));}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/{id}/submit") ApiResponse<CommissionRun> submit(@PathVariable Long id){return ApiResponse.ok(service.submit(id));}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/{id}/payout") ApiResponse<CommissionRun> payout(@PathVariable Long id,@RequestParam String paymentReference){return ApiResponse.ok(service.payout(id,paymentReference));}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/{id}/clawback") ApiResponse<CommissionRun> clawback(@PathVariable Long id,@Valid @RequestBody CommissionCalculationService.ClawbackRequest request){return ApiResponse.ok(service.clawback(id,request));}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @GetMapping("/dashboard") ApiResponse<CommissionCalculationService.Dashboard> dashboard(){return ApiResponse.ok(service.dashboard());}
}
