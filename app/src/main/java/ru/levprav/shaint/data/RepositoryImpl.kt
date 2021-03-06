package ru.levprav.shaint.data

import android.util.Log
import ru.levprav.shaint.data.local.ProductDao
import ru.levprav.shaint.data.local.model.ProductEntity
import ru.levprav.shaint.data.remote.OnLoadListener
import ru.levprav.shaint.data.remote.RemoteDataSource
import ru.levprav.shaint.data.remote.model.ProductDTO
import ru.levprav.shaint.data.remote.model.ProductsResponseDTO
import ru.levprav.shaint.domain.Repository
import ru.levprav.shaint.domain.model.Product

class RepositoryImpl(
        private val productDao: ProductDao,
        private val remoteDataSource: RemoteDataSource
) : Repository {

    override fun getAllProducts(onLoadListener: OnLoadListener<List<Product>>) {
        val products = productDao.allProducts.let { list ->
            list.map { movieEntity ->
                movieEntity.toUI()
            }
        }

        products.let {
            if (it.isNotEmpty()) {
                onLoadListener.onLoadSuccess(it)
            } else {
                remoteDataSource.fetchAllProducts(object : OnLoadListener<ProductsResponseDTO> {
                    override fun onLoadSuccess(response: ProductsResponseDTO) {
                        val products = response.let { productsResponse ->
                            Log.e("Test", "PRODUCTS: ${productsResponse}")
                            productsResponse.products?.map { movieDTO ->
                                movieDTO.toUI()
                            }
                        }

                        val moviesEntity = products
                            ?.map { movie ->
                                movie.toEntity()
                            }


                        if (moviesEntity != null) {
                            productDao.insertAllProducts(moviesEntity)
                        }
                        if (products != null) {
                            onLoadListener.onLoadSuccess(products)
                        }
                    }

                    override fun onLoadFailure(errorMsg: String) {
                        onLoadListener.onLoadFailure(errorMsg)
                    }
                })
            }
        }
    }

    override fun getProductById(id: Int) =
        productDao.getProductById(id).toUI()

    override fun getProductsByCategory(category: String): List<Product> {
        return productDao.getProductsByCategory(category).map {
            it.toUI()
        }
    }

    override fun getCategories(): List<String> {
        val genres = HashSet<String>()
        productDao.allProducts.forEach { product ->
            product.categories.forEach {
                if (it.isNotEmpty()) {
                    genres.add(it)
                }
            }
        }

        return ArrayList(genres)
    }

    override fun getYourPopularProducts(): List<Product> {
        val products = productDao.yourPopularProducts.let { list ->
            list.map { movieEntity ->
                movieEntity.type = "your"
                movieEntity.toUI()
            }
        }

        return products
    }
}

private fun ProductEntity.toUI() = Product(
        id = this.id,
        name = this.name,
        details = this.details,
        imageUri = this.imageUri,
        categories = this.categories,
        type = this.type
    )

private fun ProductDTO.toUI() =
        Product(
                this.id,
                this.name,
                this.details,
                this.imageUrl,
                this.categories,
                this.type,
        )

private fun Product.toEntity() = ProductEntity(
        this.id,
        this.name,
        this.details,
        this.imageUri,
        this.categories,
        this.type,
)
