package structural.flyweight;

public class ConcreteGlyph implements Glyph {
    private final char symbol;
    private final String font;

    public ConcreteGlyph(char symbol, String font) {
        this.symbol = symbol;
        this.font = font;
    }

    @Override
    public void draw(int x, int y) {
        System.out.printf("Draw '%c' with font=%s at (%d,%d)%n", symbol, font, x, y);
    }

    public char getSymbol() {
        return symbol;
    }

    public String getFont() {
        return font;
    }
}
