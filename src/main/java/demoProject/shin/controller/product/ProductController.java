package demoProject.shin.controller.product;

import demoProject.shin.dto.product.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/list")
    // Model에 데이터 (값)을 담아 전달한다.
    public String productList(Model model){
        List<ProductDto> productsList =;
        model.addAttribute("productsList", productsList);

        return "product/list";
    }

    @GetMapping("/create")
    public String productCreate(Model model){

        return "product/create";
    }

    @PostMapping("/create")
    /**
     * BindingResult = 값을 검증할수 있는 Spring이 제공해주는 인터페이스
     */
    public String writeProduct(BindingResult bindingResult){
        // Error가 발생하면
        if(bindingResult.hasErrors()){

        }
    }

    // /{} = 변수명을 @PathVariable 어노테이션을 통해 속성의 값을 받는다.
    @GetMapping("/{id}")
    public String productDetail(Model model, @PathVariable Long id){

        return "product/detail";
    }

    @GetMapping("/{id}/delete")
    public String productDelete(@PathVariable Long id){


    }

    @GetMapping("/{id}/modify")
    public String productDetailModify(Model model, @PathVariable Long id){

        return "product/modify";
    }

    @PostMapping("/{id}/modify")
    public String productModify(@PathVariable Long id){

    }

}
