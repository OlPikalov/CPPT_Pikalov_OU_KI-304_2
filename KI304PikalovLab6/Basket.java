package KI304PikalovLab6;

import java.util.*;

/**
 * Узагальнений клас {@code Basket}, який зберігає колекцію об’єктів,
 * що реалізують інтерфейс {@link InnerBasket}.
 *
 * @param <T> тип елементів кошика, який має реалізовувати {@link InnerBasket}
 * @author 
 * @version 1.0
 */
public class Basket<T extends InnerBasket> {
    /** Список елементів у кошику */
    private ArrayList<T> arr;

    /**
     * Конструктор за замовчуванням.
     * Ініціалізує порожній список.
     */
    public Basket(){
        arr = new ArrayList<T>();
    }

    /**
     * Знаходить елемент з максимальною вагою у кошику.
     *
     * @return елемент з найбільшою вагою або {@code null}, якщо кошик порожній
     */
    public T findMax(){
        if (arr.isEmpty()) return null;
        T max = arr.get(0);
        for (T item : arr) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    /**
     * Додає елемент до кошика.
     *
     * @param obj об’єкт, який додається у кошик
     */
    public void addElement(T obj) {
        arr.add(obj);
        System.out.print("Element added: ");
        obj.print();
    }

    /**
     * Видаляє елемент з кошика за назвою та вагою.
     * Якщо об’єкт знайдено — він видаляється, і виводиться повідомлення.
     * Якщо не знайдено — виводиться повідомлення про відсутність елемента.
     *
     * @param obj об’єкт, який потрібно видалити
     */
    public void removeElement(T obj) {
        T remove = null;
        for (T item : arr) {
            if (item.getWeight() == obj.getWeight() && item.getName() == obj.getName()) {
                remove = item;
                break;
            }
        }
        if (remove != null) {
            arr.remove(remove);
            System.out.print("Element removed: ");
            remove.print();
        } else {
            System.out.print("Element not found: ");
            obj.print();
        }
    }

    public int Sum(){
        int res = 0;
        for (T item : arr) {
            res += item.getWeight();
        }
        return res;
    }
}

/**
 * Інтерфейс {@code InnerBasket}, який описує спільну структуру для об’єктів,
 * що можуть зберігатися у {@link Basket}.
 */
interface InnerBasket extends Comparable<InnerBasket> {
    /**
     * Повертає вагу елемента.
     *
     * @return вага елемента
     */
    public int getWeight();

    /**
     * Повертає назву елемента.
     *
     * @return назва елемента
     */
    public String getName();

    /**
     * Виводить інформацію про елемент у консоль.
     */
    public void print();
}
