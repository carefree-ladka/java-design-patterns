package creational.builder;

public class House {
    private String foundation;
    private String structure;
    private String roof;
    private boolean furnished;

    public House(HouseBuilder builder) {
        this.foundation = builder.foundation;
        this.structure = builder.structure;
        this.roof = builder.roof;
        this.furnished = builder.furnished;
    }

    public void showHouse() {
        System.out.println("House [foundation=" + foundation + ", structure=" + structure
                                   + ", roof=" + roof + ", furnished=" + furnished + "]");
    }

    public static class HouseBuilder {
        private String foundation;
        private String structure;
        private String roof;
        private boolean furnished;

        public HouseBuilder setFoundation(String foundation) {
            this.foundation = foundation;
            return this;
        }

        public HouseBuilder setStructure(String structure) {
            this.structure = structure;
            return this;
        }

        public HouseBuilder setRoof(String roof) {
            this.roof = roof;
            return this;
        }

        public HouseBuilder setFurnished(boolean furnished) {
            this.furnished = furnished;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }

    static void main() {
        House house = new House.HouseBuilder()
                              .setFoundation("Concrete")
                              .setStructure("Brick")
                              .setRoof("Concrete roof")
                              .setFurnished(true)
                              .build();
        house.showHouse(); // House [foundation=Concrete, structure=Brick, roof=Concrete roof, furnished=true]

        House simpleHouse = new House.HouseBuilder()
                                    .setFoundation("Wood")
                                    .setStructure("Wood")
                                    .setRoof("Thatch")
                                    .build();
        simpleHouse.showHouse(); // House [foundation=Wood, structure=Wood, roof=Thatch, furnished=false]
    }
}
