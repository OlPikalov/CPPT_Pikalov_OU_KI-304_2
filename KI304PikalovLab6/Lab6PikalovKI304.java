package KI304PikalovLab6;

/**
 * Головний клас лабораторної роботи №6.
 * <p>
 * Демонструє використання узагальненого класу {@link Basket},
 * який може містити об'єкти, що реалізують інтерфейс {@link InnerBasket}.
 * Виконується додавання, видалення та пошук найважчого елемента.
 * </p>
 *
 * @author Pikalov
 * @version 1.0
 */
public class Lab6PikalovKI304 {

    /**
     * Точка входу в програму.
     * <p>
     * Створює об’єкт кошика, додає до нього фрукти й овочі,
     * видаляє один елемент та знаходить найважчий.
     * </p>
     *
     * @param args Аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        // Створення узагальненого кошика для об'єктів, які реалізують InnerBasket
        Basket<InnerBasket> obj = new Basket<>();

        // Додавання елементів до кошика
        obj.addElement(new Fruits("Bannana", 1500));
        obj.addElement(new Vegies("Pikle", 3000));
        obj.addElement(new Fruits("Strawberry", 4200));
        obj.addElement(new Vegies("Onion",3100));
        obj.addElement(new Vegies("Carrot", 6000));

        // Видалення елемента з кошика
        obj.removeElement(new Vegies("Carrot", 6000));

        System.out.print(obj.Sum());
    }
}
