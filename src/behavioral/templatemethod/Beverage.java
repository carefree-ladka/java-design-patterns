package behavioral.templatemethod;

public abstract class Beverage {

    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    private void pourInCup() {
        System.out.println("Pouring in cup");
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    protected abstract void addCondiments();

    protected abstract void brew();
}
