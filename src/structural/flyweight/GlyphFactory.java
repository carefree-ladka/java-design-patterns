package structural.flyweight;

import module java.base;

public class GlyphFactory {
    private final Map<String, Glyph> cache = new ConcurrentHashMap<>();

    private String key(char symbol, String font) {
        return symbol + "#" + font;
    }

    public Glyph getGlyph(char symbol, String font) {
        return cache.computeIfAbsent(key(symbol, font), k -> new ConcreteGlyph(symbol, font));
    }

    public int totalGlyphs() {
        return cache.size();
    }
}
