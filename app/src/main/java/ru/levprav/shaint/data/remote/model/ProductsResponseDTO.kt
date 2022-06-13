package ru.levprav.shaint.data.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductsResponseDTO {
    @SerializedName("products")
    public List<ProductDTO> products;
}
