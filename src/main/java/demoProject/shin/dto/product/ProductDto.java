package demoProject.shin.dto.product;


import demoProject.shin.entity.Member;
import demoProject.shin.entity.Product;
import lombok.*;


@Data
@Builder
@Getter
@Setter
public class ProductDto {

    private Member author;
    private String title;
    private int price;


    public ProductDto (Product product){
        this.author = product.getAuthor();
        this.title = product.getTitle();
        this.price = product.getPrice();
    }

    public Product toEntity(){
        return Product.builder()
                .author(author)
                .title(title)
                .price(price)
                .build();
    }

}
