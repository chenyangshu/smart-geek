package com.smartgeek.component.demo.app.context;

import com.smartgeek.component.demo.domain.product.SupplierItem;
import lombok.Data;

/**
 * @author cys
 */
@Data
public class OnSaleContext {
   private SupplierItem supplierItem;
   private String offerId;
}
