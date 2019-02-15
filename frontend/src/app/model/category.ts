export class Category {
  categoryId: string;
  categoryName: string;

  static cloneBase(category: Category): Category {
    let clonedCategory: Category = new Category();
    clonedCategory.categoryId = category.categoryId;
    clonedCategory.categoryName = category.categoryName;
    return clonedCategory;
  }
}
