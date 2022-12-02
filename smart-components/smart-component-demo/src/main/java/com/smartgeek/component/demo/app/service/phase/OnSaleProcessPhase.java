package com.smartgeek.component.demo.app.service.phase;

import com.smartgeek.component.annotation.app.Phase;
import com.smartgeek.component.demo.app.context.OnSaleContext;
import com.smartgeek.component.demo.app.service.step.BackOfferBindStep;
import com.smartgeek.component.demo.app.service.step.PublishOfferStep;
import com.smartgeek.component.demo.domain.product.SupplierItem;

import javax.annotation.Resource;

/**
 * @author cys
 */
@Phase
public class OnSaleProcessPhase {

    @Resource
    private PublishOfferStep publishOfferStep;
    @Resource
    private BackOfferBindStep backOfferBindStep;
    //省略其它step

    public void process(OnSaleContext onSaleContext) {
        SupplierItem supplierItem = onSaleContext.getSupplierItem();

        // 生成OfferGroupNo
        generateOfferGroupNo(supplierItem);

        // 发布商品
        publishOffer(supplierItem);

        // 前后端库存绑定 backoffer域
        bindBackOfferStock(supplierItem);

        // 同步库存路由 backoffer域
        syncStockRoute(supplierItem);

        // 设置虚拟商品拓展字段
        setVirtualProductExtension(supplierItem);

        // 发货保障打标 offer域
        markSendProtection(supplierItem);

        // 记录变更内容ChangeDetail
        recordChangeDetail(supplierItem);

        // 同步供货价到BackOffer
        syncSupplyPriceToBackOffer(supplierItem);

        // 如果是组合商品打标，写扩展信息
        setCombineProductExtension(supplierItem);

        // 去售罄标
        removeSellOutTag(onSaleContext.getOfferId());

        // 发送领域事件
        fireDomainEvent(supplierItem);

        // 关闭关联的待办事项
        closeIssues(supplierItem);
    }

    private void closeIssues(SupplierItem supplierItem) {

    }

    private void fireDomainEvent(SupplierItem supplierItem) {

    }

    private void removeSellOutTag(String offerId) {

    }

    private void setCombineProductExtension(SupplierItem supplierItem) {

    }

    private void syncSupplyPriceToBackOffer(SupplierItem supplierItem) {

    }

    private void recordChangeDetail(SupplierItem supplierItem) {

    }

    private void markSendProtection(SupplierItem supplierItem) {

    }

    private void setVirtualProductExtension(SupplierItem supplierItem) {

    }

    private void syncStockRoute(SupplierItem supplierItem) {

    }

    private void bindBackOfferStock(SupplierItem supplierItem) {
    }

    private void publishOffer(SupplierItem supplierItem) {

    }

    private void generateOfferGroupNo(SupplierItem supplierItem) {
    }

}
