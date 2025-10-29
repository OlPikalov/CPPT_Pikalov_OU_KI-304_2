package KI304PikalovLab6;

/**
 * Клас {@code Fruits} представляє фрукт у кошику.
 * Реалізує інтерфейс {@link InnerBasket}.
 * <p>
 * Кожен фрукт має назву та вагу, може порівнюватися за вагою
 * та виводити інформацію про себе.
 * </p>
 * 
 * @author 
 * @version 1.0
 */
public class Fruits implements InnerBasket {
    /** Назва фрукта */
    private String name;

    /** Вага фрукта */
    private int weight;

    /**
     * Конструктор для створення об’єкта фрукту.
     *
     * @param name назва фрукта
     * @param weight вага фрукта
     */
    public Fruits(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    /**
     * Повертає назву фрукту.
     *
     * @return назва фрукту
     */
    public String getName() { return name; }

    /**
     * Встановлює нову назву фрукту.
     *
     * @param name нова назва фрукту
     */
    public void SetName(String name) { this.name = name; }

    /**
     * Повертає вагу фрукту.
     *
     * @return вага фрукту
     */
    public int getWeight() { return weight; }

    /**
     * Встановлює нову вагу фрукту.
     *
     * @param weight нова вага фрукту
     */
    public void SetWeight(int weight) { this.weight = weight; }

    /**
     * Порівнює фрукт з іншим об’єктом {@link InnerBasket} за вагою.
     *
     * @param obj інший об’єкт для порівняння
     * @return від’ємне число, нуль або додатнє число, залежно від порівняння
     */
    public int compareTo(InnerBasket obj){
        return Integer.compare(this.getWeight(), obj.getWeight());
    }

    /**
     * Виводить інформацію про фрукт у консоль.
     */
    public void print(){
        System.out.print("Basket with " + name + ", Weight: " + weight + "\n");
    }
}
