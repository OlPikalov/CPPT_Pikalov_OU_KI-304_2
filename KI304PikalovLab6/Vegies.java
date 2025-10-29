package KI304PikalovLab6;

/**
 * Клас {@code Vegies} представляє овоч у кошику.
 * Реалізує інтерфейс {@link InnerBasket}.
 * <p>
 * Кожен овоч має назву та вагу, може порівнюватися за вагою
 * та виводити інформацію про себе.
 * </p>
 * 
 * @author 
 * @version 1.0
 */
public class Vegies implements InnerBasket {
    /** Назва овочу */
    private String name;

    /** Вага овочу */
    private int weight;

    /**
     * Конструктор для створення об’єкта овочу.
     *
     * @param name назва овочу
     * @param weight вага овочу
     */
    public Vegies(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    /**
     * Повертає назву овочу.
     *
     * @return назва овочу
     */
    public String getName() { return name; }

    /**
     * Встановлює нову назву овочу.
     *
     * @param name нова назва овочу
     */
    public void SetName(String name) { this.name = name; }

    /**
     * Повертає вагу овочу.
     *
     * @return вага овочу
     */
    public int getWeight() { return weight; }

    /**
     * Встановлює нову вагу овочу.
     *
     * @param weight нова вага овочу
     */
    public void SetWeight(int weight) { this.weight = weight; }

    /**
     * Порівнює овоч з іншим об’єктом {@link InnerBasket} за вагою.
     *
     * @param obj інший об’єкт для порівняння
     * @return від’ємне число, нуль або додатнє число, залежно від порівняння
     */
    public int compareTo(InnerBasket obj){return Integer.compare(this.getWeight(), obj.getWeight());}
    /**
     * Виводить інформацію про овоч у консоль.
     */
    public void print(){
        System.out.print("Basket with " + name + ", Weight: " + weight + "\n");
    }
}
