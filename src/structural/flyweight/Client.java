package structural.flyweight;

public class Client {
    void main() {
        GlyphFactory factory = new GlyphFactory();
        String text = "HELLO HELLO";
        String font = "Arial-12";

        int x = 0;
        int y = 0;

        for (char c : text.toCharArray()) {
            Glyph glyph = factory.getGlyph(c, font);
            glyph.draw(x, y);
            x += 10;
        }

        IO.println("Glyphs created: " + factory.totalGlyphs());
    }
}
