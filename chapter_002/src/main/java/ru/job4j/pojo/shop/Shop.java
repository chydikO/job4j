package ru.job4j.pojo.shop;

public class Shop {

    /**
     * методы должен заменить ячейку с индексом index на нулевую ссылку. а потом сместить все элементы на одну позицию
     * влево, чтобы в массиве не было дырки.
     * Для того, чтобы сместить все элементы влево на одну позицию нужно использовать цикл for + index.
     * products[index] = products[index + 1];
     * @param products
     * @param index
     * @return
     */
    public static Product[] delete(Product[] products, int index) {
        if (products == null || index < 0 || index > products.length - 1) {
            System.out.println("index not valid");
            return products;
        }
        int numElements = products.length - ( index + 1 ) ;
        System.arraycopy( products, index + 1, products, index, numElements);
        return products;
    }

    public static void main(String[] args) {
        Product products[] = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        //products[4] = new Product("Egg44", 999);

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            //проверяем, что объект не равен null. тк у нас массив не заполнен целиком.
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println();
        System.out.println("Удаляем значение из ячейки с индексом 1");
        //удаляем значение из ячейки с индексом 1
        products[1] = null;

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            //проверяем, что объект не равен null. тк у нас массив не заполнен целиком.
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println();
        System.out.println("Записываем  в ячейку с индексом 1 значение ячейки с индексом 2 и удаляем значение из ячейки с индексом 2");
        //записываем в ячейку с индексом 1 значение ячейки с индексом 2.
        products[1] = products[2];
        //удаляем значение из ячейки с индексом 2.
        products[2] = null;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            //проверяем, что объект не равен null. так как  у нас массив не заполнен целиком.
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println("---------------");
        System.out.println("заменить ячейку с индексом index на нулевую ссылку. а потом сместить все элементы на одну позицию\n" +
                "     * влево, чтобы в массиве не было дырки.");
        products = delete(products, 0);
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            //проверяем, что объект не равен null. так как  у нас массив не заполнен целиком.
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }
}
