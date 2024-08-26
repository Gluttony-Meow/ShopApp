package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailDTO {
    @JsonProperty("order_id")
    @Min(value = 1, message = "OrderID must be > 0")
    private Long orderID;

    @JsonProperty("product_id")
    @Min(value = 1, message = "ProductID must be > 0")
    private Long productID;

    @Min(value = 0, message = "Price must be >= 0")
    private  Long price;

    @Min(value = 1, message = "Number of product must be >= 1")
    @JsonProperty("number_of_product")
    private int numberOfProduct;

    @Min(value = 0, message = "Total money must be >= 0")
    @JsonProperty("total_money")
    private int totalMoney;

    private String color;
}
