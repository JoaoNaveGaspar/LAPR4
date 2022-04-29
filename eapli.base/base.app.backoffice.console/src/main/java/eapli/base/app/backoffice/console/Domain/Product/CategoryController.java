package eapli.base.app.backoffice.console.Domain.Product;
import eapli.base.app.backoffice.console.Persistence.CategoryPersist;
import eapli.base.productmanagement.Product.domain.Category;


public class CategoryController {

    public void createnewcategory(int category_id, String description){
        CategoryPersist categoryPersist = new CategoryPersist();
        Category category = new Category(category_id, description);
        category.setDescription(description);

        categoryPersist.createcategorypersist(category);
    }
}
