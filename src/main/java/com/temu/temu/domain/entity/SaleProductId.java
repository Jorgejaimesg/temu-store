package com.temu.temu.domain.entity;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Embeddable
@Data
@AllArgsConstructor
public class SaleProductId implements Serializable {
    private Long saleId;
    private Long productId;

}
